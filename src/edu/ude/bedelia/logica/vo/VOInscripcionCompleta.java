package edu.ude.bedelia.logica.vo;

import java.util.ArrayList;
import java.util.List;

import edu.ude.bedelia.logica.entidades.Inscripcion;

public class VOInscripcionCompleta extends VOInscripcion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float montoBase;
	public final static List<String> attrsCompleto = new ArrayList<String>() {

		private static final long serialVersionUID = 1L;

		{
			add("número de inscripción");
			add("asignatura");
			add("año lectivo");
			add("calificación");
			add("monto base");
		}
	};

	public VOInscripcionCompleta(Integer numero, int anio, float montoBase, int calificacion) {
		super(numero, anio, montoBase, calificacion);
		this.montoBase = montoBase;
	}

	public VOInscripcionCompleta(Inscripcion i) {
		super(i);
		this.montoBase = i.getMontoBase();
	}

	public float getMontoBase() {
		return montoBase;
	}

}
