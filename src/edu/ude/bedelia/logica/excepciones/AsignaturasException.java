package edu.ude.bedelia.logica.excepciones;

public class AsignaturasException extends Exception {

	/**
	 * 
	 */

	private String mensaje;
	//TODO: Esto no es necesario la clase ya implementa este constructor.
	public AsignaturasException(String msg) {
		this.mensaje = msg;
	}

	public String getMensaje() {
		return this.mensaje;
	}

}
