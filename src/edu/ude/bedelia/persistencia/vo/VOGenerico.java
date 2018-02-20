package edu.ude.bedelia.persistencia.vo;

import java.io.Serializable;

public abstract class VOGenerico<T> implements Serializable {

	/**
	 * Default UID
	 */
	private static final long serialVersionUID = 1L;

	private final T mObjeto;

	public VOGenerico(final T objeto) {
		super();
		this.mObjeto = objeto;
	}

	public T getObjeto() {
		return mObjeto;
	}

}
