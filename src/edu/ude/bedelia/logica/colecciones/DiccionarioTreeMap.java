package edu.ude.bedelia.logica.colecciones;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class DiccionarioTreeMap<K, T> implements IDiccionario<K, T>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TreeMap<K, T> diccio;

	public DiccionarioTreeMap() {
		this.diccio = new TreeMap<K, T>();
	}

	public boolean member(K clave) {
		return this.diccio.containsKey(clave);
	}

	public T find(String clave) {
		return this.diccio.get(clave);
	}

	public void insert(K clave, T objeto) {
		this.diccio.put(clave, objeto);
	}

	public void delete(K clave) {
		this.diccio.remove(clave);
	}

	public void modify(K clave, T objeto) {
		this.diccio.put(clave, objeto);
	}

	public Set<K> keys() {
		return diccio.keySet();
	}

	public Collection<T> values() {
		return diccio.values();
	}

	public Iterator<T> getIterator() {
		return this.diccio.values().iterator();
	}

}
