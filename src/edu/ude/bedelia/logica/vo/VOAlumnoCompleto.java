package edu.ude.bedelia.logica.vo;

import java.util.ArrayList;
import java.util.List;

import edu.ude.bedelia.logica.entidades.Alumno;

public class VOAlumnoCompleto extends VOAlumno {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8382306334842343985L;
	private String domicilio;
	private String telefono;
	private String email;

	public final static List<String> attrAlumnoCompleto = new ArrayList<String>() {
		private static final long serialVersionUID = 1L;
		{
			addAll(0, attrAlumno);
			add("Domicilio");
			add("Telefono");
			add("Email");
		}
	};

	public VOAlumnoCompleto(String cedula, String nombre, String apellido, TipoAlumno tipo, String domicilio,
			String telefono, String email) {
		super(cedula, nombre, apellido, tipo);
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.email = email;
	}

	public VOAlumnoCompleto(Alumno a) {
		super(a);
		this.domicilio = a.getDomicilio();
		this.telefono = a.getTelefono();
		this.email = a.getEmail();
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

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return super.toString() + " Domicilio: " + this.domicilio + " Telefono: " + this.telefono + " Email: "
				+ this.email ;
	}
}
