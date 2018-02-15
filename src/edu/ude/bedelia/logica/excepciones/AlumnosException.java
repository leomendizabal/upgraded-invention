package edu.ude.bedelia.logica.excepciones;

public class AlumnosException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6685554341167258042L;
	private String mensaje;
	
	public AlumnosException(String msg) {
		this.mensaje = msg;
	}
	
	public String getMensaje() {
		return this.mensaje;
	}
}
