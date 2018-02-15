package edu.ude.bedelia.logica.vo;

import edu.ude.bedelia.logica.entidades.Inscripcion;

public class VOInscripcionCompleta extends VOInscripcion {
	
	private float montoBase;

    public VOInscripcionCompleta(Integer numero, int anio, float montoBase, int calificacion) {
		super(numero, anio, montoBase, calificacion);
		this.montoBase = montoBase;
	}

    public VOInscripcionCompleta(Inscripcion i) {
    	super(i);
    	this.montoBase = i.getMontoBase();
    }
    
	public float getMontoBase() {
		return montoBase;
	}
}
