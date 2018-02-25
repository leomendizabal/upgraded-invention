package edu.ude.bedelia.logica.colecciones;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public interface IDiccionario<K, T> {

	public boolean member(K clave);

	public T find(String clave);

	public void insert(K clave, T objeto);

	public void delete(K clave);

	public void modify(K clave, T objeto);

	public Set<K> keys();

	public Collection<T> values();

	public Iterator<T> getIterator();

}
