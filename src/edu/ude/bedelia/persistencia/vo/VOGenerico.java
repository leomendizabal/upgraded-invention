package edu.ude.bedelia.persistencia.vo;

import java.io.Serializable;

public abstract class VOGenerico<T1, T2> implements Serializable {

	private static final long serialVersionUID = 1L;

	private final T1 diccionario;
	private final T2 secuencia;

	public VOGenerico(final T1 obj1, final T2 obj2) {
		super();
		this.diccionario = obj1;
		this.secuencia = obj2;
	}

	public T1 getDiccionario() {
		return diccionario;
	}

	public T2 getSecuencia() {
		return secuencia;
	}

}
