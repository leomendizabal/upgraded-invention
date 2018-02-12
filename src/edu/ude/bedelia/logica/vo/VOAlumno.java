package edu.ude.bedelia.logica.vo;

public class VOAlumno {
	
	private String cedula;
	private String nombre;
	private String apellido;
	private TipoAlumno tipo;
	
	
	
	public VOAlumno(String cedula, String nombre, String apellido, TipoAlumno tipo) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipo = tipo;
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
	
	public TipoAlumno getTipo() {
		return tipo;
	}
	

	

}
