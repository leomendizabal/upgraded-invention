package edu.ude.bedelia.logica.colecciones;

import java.util.Collection;
import java.util.Iterator;

public interface ISecuencia<T> {

	/**
	 * Inserta un elemento en la secuencia en la primera posicion.
	 * 
	 * @param elemento
	 * @return void
	 */
	public void insertFront(T element) throws ArrayIndexOutOfBoundsException;

	/**
	 * Inserta un elemento en la secuencia en un posicion dada
	 * 
	 * @param elemento
	 * @param indice
	 * @return void
	 */
	public void insert(T element, int index) throws ArrayIndexOutOfBoundsException;

	/**
	 * Inserta un elemento en la secuencia.
	 * 
	 * @param elemento
	 * @return void
	 */
	public void insert(T element) throws ArrayIndexOutOfBoundsException;

	/**
	 * Determina si una secuencia es vacia o no
	 * 
	 * @return boolean
	 */
	public boolean isEmpty();

	/**
	 * Retorna el primer elemento de la secuencia.
	 * 
	 * @return elemento
	 */
	public T first() throws ArrayIndexOutOfBoundsException;

	/**
	 * Retorna el tamano de la secuencia.
	 * 
	 * @return int
	 */

	public Collection<T> rest() throws ArrayIndexOutOfBoundsException;

	/**
	 * Retorna el tamano de la secuencia.
	 * 
	 * @return int
	 */

	public int size();

	/**
	 * Retorna un elemento dada un posicion.
	 * 
	 * @param indice
	 * @return element
	 */
	public T get(int index) throws ArrayIndexOutOfBoundsException;

	/**
	 * Retorna un iterador.
	 * 
	 * @return iterator
	 */
	public Iterator<T> iterator();

}
