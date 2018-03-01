package edu.ude.bedelia.logica.vo;

import edu.ude.bedelia.logica.entidades.Asignatura;
import java.io.Serializable;

public class VOAsignatura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private String nombre;
	private String descripcion;

	public VOAsignatura(String codigo, String nombre, String descripcion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public VOAsignatura(Asignatura a) {
		this.codigo = a.getCodigo();
		this.nombre = a.getNombre();
		this.descripcion = a.getDescripcion();
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String toString() {
		return "Codigo: " + this.codigo + " Nombre: " + this.nombre + " Nombre: " + this.descripcion;
	}

}
