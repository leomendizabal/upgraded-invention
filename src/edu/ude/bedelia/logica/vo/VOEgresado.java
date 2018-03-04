package edu.ude.bedelia.logica.vo;

import java.io.Serializable;

import edu.ude.bedelia.logica.entidades.Alumno;

public class VOEgresado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cedula;
	private String nombre;
	private String apellido;

	public VOEgresado(String cedula, String nombre, String apellido) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public VOEgresado(Alumno a) {
		this.cedula = a.getCedula();
		this.nombre = a.getNombre();
		this.apellido = a.getApellido();
	}

	public String getCedula() {
		return cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

    public String toString () {
    	
    	return " Cedula: " + this.cedula + " Nombre: " + this.nombre + " Apellido:" + this.apellido;
    }
}
