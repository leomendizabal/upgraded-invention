package edu.ude.bedelia.logica.excepciones;

public class AsignaturasException extends Exception{
	
	
	/**
	 * 
	 */
	
	private String mensaje;
	
	public AsignaturasException(String msg) {
		this.mensaje = msg;
	}
	
	public String getMensaje() {
		return this.mensaje;
	}

}
