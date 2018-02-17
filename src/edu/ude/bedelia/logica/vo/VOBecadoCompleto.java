package edu.ude.bedelia.logica.vo;

import edu.ude.bedelia.logica.entidades.Alumno;

public class VOBecadoCompleto extends VOAlumnoCompleto {
	
	
	private float porcentaje;
	private String descripcion;
	
	
	public VOBecadoCompleto(String cedula, String nombre, String apellido, TipoAlumno tipo, String domicilio,
			String telefono, String email, float monto, float porcentaje, String descripcion) {
		super(cedula, nombre, apellido, tipo, domicilio, telefono, email, monto);
		this.porcentaje = porcentaje;
		this.descripcion = descripcion;
	}
	
	public VOBecadoCompleto(Alumno a) {
		
		super(a);
		this.porcentaje=porcentaje;
		this.descripcion=descripcion;
	}

	public float getPorcentaje() {
		return porcentaje;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	

}
