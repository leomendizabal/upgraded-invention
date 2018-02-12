package edu.ude.bedelia.logica.entidades;

public class Inscripcion {
	private Integer numero;
	private int anio;
	private float montoBase;
	private int calificacion;
	private Asignatura asignatura;

	public Inscripcion(Integer numero, int anio, float montoBase, int calificacion, Asignatura asignatura) {
		this.numero = numero;
		this.anio = anio;
		this.montoBase = montoBase;
		this.calificacion = calificacion;
		this.asignatura = asignatura;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public float getMontoBase() {
		return montoBase;
	}

	public void setMontoBase(float montoBase) {
		this.montoBase = montoBase;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	boolean esAprobada() {
		return this.calificacion >= 6;
	}
	
    public String toString() {
		
		return ("\n Numero:" + this.numero + "\n Año:" + this.anio + "\n Monto base:" + this.montoBase + "\n Calificacion:" + this.calificacion);
		
	}
	
}
