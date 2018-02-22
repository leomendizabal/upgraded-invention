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

	@Override
	public void insert(Asignatura element) throws ArrayIndexOutOfBoundsException {
		if (this.size() == Constantes.CANTIDAD_MATERIAS) {
			throw new ArrayIndexOutOfBoundsException(
					String.format(Mensajes.MSG_MAXIMO_MATERIAS_SUPERADO, Constantes.CANTIDAD_MATERIAS));
		} else {
			super.insert(element);
		}
	}
	//TODO: ver si se retorna lista vacia o una excepcion.
	public ArrayList<VOAsignatura> listarAsignaturas() throws AsignaturasException {
		Iterator<Asignatura> it = this.iterator();
		ArrayList<VOAsignatura> resultado = new ArrayList<VOAsignatura>();
		Asignatura current;
		
		while(it.hasNext()) {
			current = (Asignatura) it.next();
			resultado.add(current.toVO());
		}
		
		if(resultado.size() == 0) {
			throw new AsignaturasException(Mensajes.MSG_NO_EXISTEN_ASIGNATURAS);
		}
		
		return resultado;
	}

	public boolean pertenece(String cod) {
		boolean esta = false;
		int indice = 0;
		while ((indice < secuencia.size()) && (!esta)) {
			Asignatura as = secuencia.get(indice);
			if (cod.equals(as.getCodigo())) {
				esta = true;
			}else {
				indice++;
			}
		}

		return esta;
	}

	public Asignatura devolverAsignatura(String cod) {

		int indice = 0;
		Asignatura as = secuencia.get(indice);
		while (!(cod.equals(as.getCodigo()))) {
			indice++;
			as = secuencia.get(indice);

		}

		return as;
	}

}
