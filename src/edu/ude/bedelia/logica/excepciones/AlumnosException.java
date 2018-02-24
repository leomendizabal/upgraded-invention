package edu.ude.bedelia.logica.excepciones;

public class AlumnosException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6685554341167258042L;
	private String mensaje;

	//TODO: Esto no es necesario la clase ya implementa este constructor.
	public AlumnosException(String msg) {
		super(msg);
	}

	public String getMensaje() {
		return this.mensaje;
	}
}
