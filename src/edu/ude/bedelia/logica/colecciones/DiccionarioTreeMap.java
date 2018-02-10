package edu.ude.bedelia.logica.colecciones;

import java.util.TreeMap;

public class DiccionarioTreeMap<K,T> implements IDiccionario<K,T> {
	
	private TreeMap<K, T> diccio;
	
	public DiccionarioTreeMap() {
		this.diccio = new TreeMap<K,T>();
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

}
