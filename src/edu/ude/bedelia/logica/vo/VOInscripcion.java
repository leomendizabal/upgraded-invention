package edu.ude.bedelia.logica.vo;

public class VOInscripcion {
	
	private Integer numero;
	private String nombre;
	private int anio;
	private int calificacion;
	
	
	
	VOInscripcion(Integer numero, String nombre, int anio, int calificacion) {
	
		this.numero = numero;
		this.nombre = nombre;
		this.anio = anio;
		this.calificacion = calificacion;
	}

	public Integer getNumero() {
		return numero;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getAnio() {
		return anio;
	}
	
	public int getCalificacion() {
		return calificacion;
	}
	
	
	
	

}
