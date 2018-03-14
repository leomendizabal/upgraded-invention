package edu.ude.bedelia.logica.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import edu.ude.bedelia.logica.entidades.Inscripcion;

public class VOInscripcion implements Serializable, Comparable<VOInscripcion> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer numero;
	private int anio;
	private int calificacion;
	private VOAsignatura asignatura;

	public final static List<String> attrs = new ArrayList<String>() {

		private static final long serialVersionUID = 1L;

		{
			add("número de inscripción");
			add("asignatura");
			add("año lectivo");
			add("calificación");
		}
	};

	public VOInscripcion(Integer numero, int anio, float montoBase, int calificacion) {
		this.numero = numero;
		this.anio = anio;
		this.calificacion = calificacion;
	}

	public VOInscripcion(Inscripcion i) {
		this.numero = i.getNumero();
		this.anio = i.getAnio();
		this.calificacion = i.getCalificacion();
		this.asignatura = i.getAsignatura().toVO();
	}

	public Integer getNumero() {
		return numero;
	}

	public int getAnio() {
		return anio;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public VOAsignatura getAsignatura() {
		return asignatura;
	}

	public String toString() {
		return "Numero: " + this.numero + " Ano: " + this.anio + " Calificacion: "
				+ this.calificacion;
	}

	public List<String> getAttr() {

		return attrs;
	}

	@Override
	public int compareTo(VOInscripcion o) {
		// TODO Auto-generated method stub
		return numero.compareTo(o.numero);
	}

}
