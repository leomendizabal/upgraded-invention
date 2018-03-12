package edu.ude.bedelia.logica.colecciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.ude.bedelia.logica.entidades.Asignatura;
import edu.ude.bedelia.logica.entidades.Inscripcion;
import edu.ude.bedelia.logica.vo.VOInscripcion;

public class Inscripciones extends SecuenciaArrayList<Inscripcion> {

	private static final long serialVersionUID = 1L;

	public Inscripciones() {
		super();
	}

	public Inscripciones(int count) {
		super(count);
	}

	public List<VOInscripcion> listarInscripciones(final boolean esCompleto) {
		Iterator<Inscripcion> iterator = this.iterator();
		final List<VOInscripcion> listaVOInscripciones = new ArrayList<>(this.size());
		while (iterator.hasNext()) {
			listaVOInscripciones.add(iterator.next().toVO(esCompleto));
		}
		return listaVOInscripciones;
	}

	public boolean asignaturaAprobada(String cod) {
		boolean aprobada = false;

		int indice = 0;
		while ((indice < secuencia.size()) && (!aprobada)) {
			Inscripcion ins = secuencia.get(indice);
			Asignatura asi = ins.getAsignatura();
			if (cod.equals(asi.getCodigo()) && (ins.esAprobada())) {
				aprobada = true;
			} else {
				indice++;
			}
		}
		return aprobada;
	}

	public boolean inscriptoEnAnioLectivo(String cod, int anio) {
		Inscripcion ins;
		Asignatura asi;
		boolean esta = false;
		int indice = 0, cantidad = secuencia.size();
		while ((indice < cantidad) && (!esta)) {
			ins = secuencia.get(indice);
			asi = ins.getAsignatura();
			if (cod.equals(asi.getCodigo()) && (anio == ins.getAnio())) {
				esta = true;
			} else {
				indice++;
			}
		}
		return esta;
	}

	public boolean anioLectivoMayorIgualUltimaInscripcion(int anio) {
		boolean mayorIgual = true;
		int cantidad = secuencia.size();
		if (cantidad > 0) {
			Inscripcion ins = secuencia.get(cantidad - 1);
			mayorIgual = anio >= ins.getAnio();
		}

		return mayorIgual;
	}

	// TODO: metodos que se usan localmente declararlo como privado, si es posible
	// hace javadoc para entender que hace
	public Integer numeroUltimaInscripcionMasUno() {
		Integer num = 1;
		if (!secuencia.isEmpty()) {
			Inscripcion ins = secuencia.get(secuencia.size() - 1);
			num = ins.getNumero();
			num++;
		}
		return num;
	}

}
