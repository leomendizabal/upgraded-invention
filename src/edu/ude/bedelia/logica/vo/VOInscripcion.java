package edu.ude.bedelia.logica.vo;

import edu.ude.bedelia.logica.entidades.Inscripcion;

public class VOInscripcion {
	
	private Integer numero;
	private int anio;
	private float montoBase;
	private int calificacion;
	private VOAsignatura asignatura;
	
	public VOInscripcion(Integer numero, int anio, float montoBase, int calificacion) {
		this.numero = numero;		
		this.anio = anio;
		this.montoBase = montoBase;
		this.calificacion = calificacion;
	}

	public VOInscripcion(Inscripcion i) {
		this.numero = i.getNumero();
		this.anio = i.getAnio();
		this.montoBase = i.getMontoBase();
		this.calificacion = i.getCalificacion();
		this.asignatura = i.getAsignatura().toVO();
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public int getAnio() {
		return anio;
	}
	
	public float getMontoBase() {
		return this.montoBase;
	}
	
	public int getCalificacion() {
		return calificacion;
	}

	public VOAsignatura getAsignatura() {
		return asignatura;
	}
	
	
}
