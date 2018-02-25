package edu.ude.bedelia.logica.colecciones;

import java.util.ArrayList;
import java.util.Iterator;

import edu.ude.bedelia.logica.entidades.Asignatura;
import edu.ude.bedelia.logica.excepciones.AsignaturasException;
import edu.ude.bedelia.logica.utiles.Constantes;
import edu.ude.bedelia.logica.utiles.Mensajes;
import edu.ude.bedelia.logica.vo.VOAsignatura;

public class Asignaturas extends SecuenciaArrayList<Asignatura> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Asignaturas() {
		super(Constantes.CANTIDAD_MATERIAS);
	}

	public Asignaturas(int count) {
		super(count);
	}

	@Override
	public void insert(Asignatura element) throws ArrayIndexOutOfBoundsException {
		if (this.size() == Constantes.CANTIDAD_MATERIAS) {
			throw new ArrayIndexOutOfBoundsException(
					String.format(Mensajes.MSG_MAXIMO_MATERIAS_SUPERADO, Constantes.CANTIDAD_MATERIAS));
		} else {
			super.insert(element);
		}
	}

	public ArrayList<VOAsignatura> listarAsignaturas() {
		Iterator<Asignatura> it = this.iterator();
		ArrayList<VOAsignatura> resultado = new ArrayList<VOAsignatura>();
		Asignatura current;

		while (it.hasNext()) {
			current = (Asignatura) it.next();
			resultado.add(current.toVO());
		}
		return resultado;
	}

	public boolean pertenece(String cod) {
		boolean esta = false;
		int indice = 0, cantidad = secuencia.size();
		while ((indice < cantidad) && (!esta)) {
			Asignatura as = secuencia.get(indice);
			if (cod.equals(as.getCodigo())) {
				esta = true;
			} else {
				indice++;
			}
		}

		return esta;
	}

	public Asignatura devolverAsignatura(String codigo) throws AsignaturasException {

		int indice = 0, cantidad = secuencia.size();
		boolean existe = false;
		while ((indice < cantidad) && !existe) {
			final Asignatura asignaturaActual = secuencia.get(indice);
			if (asignaturaActual.getCodigo().equals(codigo)) {
				existe = true;
			} else {
				indice += 1;
			}
		}
		if (existe) {
			return secuencia.get(indice);
		} else {
			throw new AsignaturasException(Mensajes.mensaje(Mensajes.MSG_ASIGNATURA_NO_EXISTE, codigo));
		}
	}

}
