package edu.ude.bedelia.logica.vo;

import java.util.ArrayList;
import java.util.List;

import edu.ude.bedelia.logica.entidades.Alumno;

public class VOEgresadoCompleto extends VOEgresado {

	private static final long serialVersionUID = 1L;
	
	private float promedioTotal;
	private int promedioAprobaciones;

	public final static  List<String> attrCompleto = new ArrayList<String>() {
		private static final long serialVersionUID = 1L;
		{
			add("Apellido");
			add("Nombre");
			add("Cedula");
			add("Promedio Total");
			add("Promedio Aprobaciones");
		}
	};
	
	
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
