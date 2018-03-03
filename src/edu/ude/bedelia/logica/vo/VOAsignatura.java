package edu.ude.bedelia.logica.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import edu.ude.bedelia.logica.entidades.Asignatura;

public class VOAsignatura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String codigo;
	private String nombre;
	private String descripcion;

	public final static List<String> attr = new ArrayList<String>() {
		private static final long serialVersionUID = 1L;
		{
			add("Codigo");
			add("Nombre");
			add("Descripcion");
		}
	};

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
