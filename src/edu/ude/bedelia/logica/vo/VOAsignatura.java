package edu.ude.bedelia.logica.vo;

public class VOAsignatura {
	
	private String codigo;
	private String nombre;
	private String descripcion;
	
	

	public VOAsignatura(String codigo, String nombre, String descripcion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	
}

