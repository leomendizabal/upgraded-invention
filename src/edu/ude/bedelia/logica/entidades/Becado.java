package edu.ude.bedelia.logica.entidades;

public class Becado extends Alumno {
	
	private float porcentaje;
	private String descripcion;
	
	public Becado(String cedula, String nombre, String apellido, String domicilio, String telefono, String email,
			float porcentaje, String descripcion) {
		super(cedula, nombre, apellido, domicilio, telefono, email);
		this.porcentaje = porcentaje;
		this.descripcion = descripcion;
	}

	public float getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
    public String toString() {
		return (super.toString() + "\n Porcentaje:" + this.porcentaje + "\n Raz�n de beca:" + this.descripcion);	
	}
}
