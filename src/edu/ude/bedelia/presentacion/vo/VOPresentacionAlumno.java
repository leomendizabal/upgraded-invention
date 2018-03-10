package edu.ude.bedelia.presentacion.vo;

import edu.ude.bedelia.logica.vo.VOAlumnoCompleto;
import edu.ude.bedelia.logica.vo.VOBecadoCompleto;

public class VOPresentacionAlumno {

	private static final String EMPTY = "";

	private String cedula;
	private String nombre;
	private String apellido;
	private String domicilio;
	private String telefono;
	private String email;
	private float monto;
	private float porcentaje;
	private String descripcion = EMPTY;
	private boolean esBecado = false;

	public VOPresentacionAlumno(VOAlumnoCompleto alumno) {
		cedula = alumno.getCedula();
		nombre = alumno.getNombre();
		apellido = alumno.getApellido();
		domicilio = alumno.getDomicilio();
		telefono = alumno.getTelefono();
		email = alumno.getEmail();
		if (alumno instanceof VOBecadoCompleto) {
			VOBecadoCompleto becado = (VOBecadoCompleto) alumno;
			esBecado = true;
			porcentaje = becado.getPorcentaje();
			descripcion = becado.getDescripcion();
		}

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

	public float getPorcentaje() {
		return porcentaje;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getStrPorcentaje() {
		return String.valueOf(porcentaje);
	}

	public boolean esBecado() {
		return esBecado;
	}

}
