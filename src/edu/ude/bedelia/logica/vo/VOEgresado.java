package edu.ude.bedelia.logica.vo;

public class VOEgresado {
	
	private String cedula;
	private String nombre;
	private String apellido;
	
	
	
	VOEgresado(String cedula, String nombre, String apellido) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
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
	
	
    

}