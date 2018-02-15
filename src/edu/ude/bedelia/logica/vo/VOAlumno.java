package edu.ude.bedelia.logica.vo;

import edu.ude.bedelia.logica.entidades.Alumno;
import edu.ude.bedelia.logica.entidades.Becado;

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

	public VOAlumno(Alumno a) {
		this.cedula = a.getCedula();
		this.nombre = a.getNombre();
		this.apellido = a.getApellido();
		this.tipo = a instanceof Becado ? TipoAlumno.BECADO : TipoAlumno.COMUN;
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
