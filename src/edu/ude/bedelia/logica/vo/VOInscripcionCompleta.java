package edu.ude.bedelia.logica.vo;

public class VOInscripcionCompleta extends VOInscripcion {
	
	private float montoBase;

    VOInscripcionCompleta(Integer numero, String nombre, int anio, int calificacion, float montoBase) {
		super(numero, nombre, anio, calificacion);
		this.montoBase = montoBase;
	}

	public float getMontoBase() {
		return montoBase;
	}

	
	

}
