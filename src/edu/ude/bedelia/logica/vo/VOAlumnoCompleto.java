package edu.ude.bedelia.logica.vo;

import edu.ude.bedelia.logica.entidades.Alumno;

public class VOAlumnoCompleto extends VOAlumno{
	
	private String domicilio;
	private String telefono;
	private String email;
	private float monto;
	
	public VOAlumnoCompleto(String cedula, String nombre, String apellido, TipoAlumno tipo, String domicilio,
			String telefono, String email, float monto) {
		super(cedula, nombre, apellido, tipo);
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.email = email;
		this.monto = monto;
	}

	public VOAlumnoCompleto(Alumno a) {
		super(a);
		this.domicilio = a.getDomicilio();
		this.telefono = a.getTelefono();
		this.email = a.getEmail();
		this.monto = 0; //TODO: corregir el monto
	}
	
	public String getDomicilio() {
		return domicilio;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public String getEmail() {
		return email;
	}
	
	public float getMonto() {
		return monto;
	}
}
