package edu.ude.bedelia.logica.colecciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.ude.bedelia.logica.entidades.Inscripcion;
import edu.ude.bedelia.logica.vo.VOInscripcion;

public class Inscripciones extends SecuenciaArrayList<Inscripcion> {

	public Inscripciones() {
		super();
	}

	public List<VOInscripcion> listarInscripciones(final boolean esCompleto) {
		Iterator<Inscripcion> iterator = this.iterator();
		final List<VOInscripcion> listaVOInscripciones = new ArrayList<>(this.size());
		while(iterator.hasNext()) {
			listaVOInscripciones.add(iterator.next().toVO(esCompleto));
		}
		return listaVOInscripciones;
	}
}
