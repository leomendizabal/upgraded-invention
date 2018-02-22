package edu.ude.bedelia.logica.entidades;

import edu.ude.bedelia.logica.vo.VOBecadoCompleto;

public class Becado extends Alumno {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float porcentaje;
	private String descripcion;

	public Becado(String cedula, String nombre, String apellido, String domicilio, String telefono, String email,
			float porcentaje, String descripcion) {
		super(cedula, nombre, apellido, domicilio, telefono, email);
		this.porcentaje = porcentaje;
		this.descripcion = descripcion;
	}
	
	public Becado(VOBecadoCompleto vo) {
		super(vo);
		this.porcentaje = vo.getPorcentaje();
		this.descripcion = vo.getDescripcion();
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
	//TODO: siempre que se hace override llamar al super, para no repetir logica.
	public float calcularMontoCobrado(int anio) {
		float total = super.calcularMontoCobrado(anio);
		return total - (total * this.porcentaje) / 100;
	}

	public String toString() {
		return (super.toString() + "\n Porcentaje:" + this.porcentaje + "\n Raz�n de beca:" + this.descripcion);
	}

	public VOBecadoCompleto toVO() {

		return new VOBecadoCompleto(this);

	}

}
