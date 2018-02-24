package edu.ude.bedelia.persistencia.vo;

import java.io.Serializable;

import edu.ude.bedelia.logica.colecciones.Alumnos;
import edu.ude.bedelia.logica.colecciones.Asignaturas;

public class VODato extends VOGenerico<Alumnos, Asignaturas> implements Serializable {

	private static final long serialVersionUID = 8431243251301227202L;

	public VODato(Alumnos alumnos, Asignaturas asignaturas) {
		super(alumnos, asignaturas);
	}

}
