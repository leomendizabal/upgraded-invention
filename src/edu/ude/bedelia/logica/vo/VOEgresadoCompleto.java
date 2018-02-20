package edu.ude.bedelia.logica.vo;

public class VOEgresadoCompleto extends VOEgresado {

	private float promedioTotal;
	private int promedioAprobaciones;

	public VOEgresadoCompleto(String cedula, String nombre, String apellido, float promedioTotal,
			int promedioAprobaciones) {
		super(cedula, nombre, apellido);
		this.promedioTotal = promedioTotal;
		this.promedioAprobaciones = promedioAprobaciones;
	}

	public float getPromedioTotal() {
		return promedioTotal;
	}

	public int getPromedioAprobaciones() {
		return promedioAprobaciones;
	}

}
