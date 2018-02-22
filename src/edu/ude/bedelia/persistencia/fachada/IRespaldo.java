package edu.ude.bedelia.persistencia.fachada;

import edu.ude.bedelia.persistencia.excepciones.PersistenciaException;

public interface IRespaldo<T> {

	public void respaldar(final String nombreArchivo, T objeto) throws PersistenciaException;

	public T recuperar(final String nombreArchivo) throws PersistenciaException;
}
