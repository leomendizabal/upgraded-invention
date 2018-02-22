package edu.ude.bedelia.logica.excepciones;

public class InscripcionesException extends Exception {

	/**
	 * 
	 */

	private String mensaje;

	public InscripcionesException(String msg) {
		this.mensaje = msg;
	}

	public String getMensaje() {
		return this.mensaje;
	}

}
