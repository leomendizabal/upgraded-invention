package edu.ude.bedelia.logica.colecciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.ude.bedelia.logica.entidades.Asignatura;
import edu.ude.bedelia.logica.entidades.Inscripcion;
import edu.ude.bedelia.logica.vo.VOInscripcion;

public class Inscripciones extends SecuenciaArrayList<Inscripcion> {

	public Inscripciones() {
		super();
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
			if (cod.equals(asi.getCodigo()) && (ins.esAprobada()))
				aprobada = true;
			else
				indice++;
		}
		return aprobada;
	}

	public boolean inscriptoEnAnioLectivo(String cod) {
		boolean esta = false;

		int indice = 0;
		while ((indice < secuencia.size()) && (!esta)) {
			Inscripcion ins = secuencia.get(indice);
			Asignatura asi = ins.getAsignatura();
			if (cod.equals(asi.getCodigo()) && (ins.getAnio() == 2018))
				esta = true;
			else
				indice++;
		}
		return esta;
	}

	public boolean anioLectivoMayorIgualUltimaInscripcion() {
		boolean MayorIgual = false;

		if (!secuencia.isEmpty()) {

			Inscripcion ins = secuencia.get(secuencia.size() - 1);
			if (2018 >= ins.getAnio())
				MayorIgual = true;
		}

		return MayorIgual;
	}

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
