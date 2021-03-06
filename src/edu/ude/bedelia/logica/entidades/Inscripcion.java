package edu.ude.bedelia.logica.entidades;

import java.io.Serializable;
import java.util.Calendar;

import edu.ude.bedelia.logica.utiles.Constantes;
import edu.ude.bedelia.logica.vo.VOInscripcion;
import edu.ude.bedelia.logica.vo.VOInscripcionCompleta;

public class Inscripcion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer numero;
	private int anio;
	private float montoBase;
	private int calificacion;
	private Asignatura asignatura;

	public Inscripcion(Integer numero, int anio, float montoBase, Asignatura asignatura) {
		this.numero = numero;
		this.anio = anio;
		this.montoBase = montoBase;
		this.calificacion = 0;
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

	public boolean esAprobada() {
		return this.calificacion >= Constantes.NOTA_MINIMA_APROBACION;
	}

	public boolean esAnioMayorIgualActual() {
		final Calendar calendar = Calendar.getInstance();
		return this.anio >= calendar.get(Calendar.YEAR);

	}

	public boolean esActual() {
		final Calendar calendar = Calendar.getInstance();
		return this.anio == calendar.get(Calendar.YEAR);

	}

	public String toString() {

		return ("\n Numero:" + this.numero + "\n A�o:" + this.anio + "\n Monto base:" + this.montoBase
				+ "\n Calificacion:" + this.calificacion);

	}

	public VOInscripcion toVO(boolean esCompleto) {
		if (esCompleto) {
			return new VOInscripcionCompleta(this);
		} else {
			return new VOInscripcion(this);
		}
	}

}
