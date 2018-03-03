package edu.ude.bedelia.logica.vo;

import edu.ude.bedelia.logica.entidades.Alumno;

public class VOEgresadoCompleto extends VOEgresado {

	private float promedioTotal;
	private int promedioAprobaciones;

	public VOEgresadoCompleto(String cedula, String nombre, String apellido, float promedioTotal,
			int promedioAprobaciones) {
		super(cedula, nombre, apellido);
		this.promedioTotal = promedioTotal;
		this.promedioAprobaciones = promedioAprobaciones;
	}

	public VOEgresadoCompleto(Alumno a, float promedio, int promedioAprobaciones) {
		super(a);
		this.promedioTotal = promedio;
		this.promedioAprobaciones = promedioAprobaciones;
	}

	public float getPromedioTotal() {
		return promedioTotal;
	}

	public int getPromedioAprobaciones() {
		return promedioAprobaciones;
	}
    public String toString () {
    	
    	return super.toString() + " Promedio total: " + this.promedioTotal + " Promedio aprobaciones: " + this.promedioAprobaciones + "%";
    }
}
