package edu.ude.bedelia.logica.vo;

import java.util.ArrayList;
import java.util.List;

import edu.ude.bedelia.logica.entidades.Alumno;

public class VOBecadoCompleto extends VOAlumnoCompleto {

	private static final long serialVersionUID = -2376862426936443L;
	private float porcentaje;
	private String descripcion;

	public final static List<String> attrBecadoCompleto = new ArrayList<String>() {
		private static final long serialVersionUID = 1L;
		{
			addAll(0, attrAlumnoCompleto);
			add("Porcentaje");
			add("Descripcion");
		}
	};

	public VOBecadoCompleto(String cedula, String nombre, String apellido, TipoAlumno tipo, String domicilio,
			String telefono, String email, float monto, float porcentaje, String descripcion) {
		super(cedula, nombre, apellido, tipo, domicilio, telefono, email);
		this.porcentaje = porcentaje;
		this.descripcion = descripcion;
	}

	public VOBecadoCompleto(String cedula, String nombre, String apellido, TipoAlumno tipo, String domicilio,
			String telefono, String email, float porcentaje, String descripcion) {
		super(cedula, nombre, apellido, tipo, domicilio, telefono, email);
		this.porcentaje = porcentaje;
		this.descripcion = descripcion;
	}

	public VOBecadoCompleto(Alumno a, float porcentaje, String descripcion) {
		super(a);
		this.porcentaje = porcentaje;
		this.descripcion = descripcion;
	}

	public float getPorcentaje() {
		return porcentaje;
	}

	public String getStrPorcentaje() {
		return String.valueOf(porcentaje);
	}

	public String getDescripcion() {
		return descripcion;
	}

}
