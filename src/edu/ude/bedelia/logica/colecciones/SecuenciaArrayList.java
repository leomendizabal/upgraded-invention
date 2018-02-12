package edu.ude.bedelia.logica.colecciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;


public class SecuenciaArrayList<T> implements ISecuencia<T> {

	private final static int FIRST_INDEX = 1;
	
	private ArrayList<T> secuencia;
	
	
	public SecuenciaArrayList() {
		super();
		this.secuencia = new ArrayList<T>();
	}
	
	public SecuenciaArrayList(int size) {
		super();
		this.secuencia = new ArrayList<T>(size);
	}
	
	@Override
	public void insertFront(T element) throws ArrayIndexOutOfBoundsException {
		if(secuencia.isEmpty()) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			secuencia.add(FIRST_INDEX,element);
		}
		
	}

	@Override
	public void insert(T element, int index) throws ArrayIndexOutOfBoundsException {
		
		if(secuencia.isEmpty() || index >= secuencia.size()) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			secuencia.add(index, element);
		}
		
		
	}

	@Override
	public void insert(T element) {
		secuencia.add(element);
		
	}

	@Override
	public boolean isEmpty() {
		return secuencia.isEmpty();
	}

	@Override
	public T first() {
		if(secuencia.isEmpty()) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			return secuencia.get(FIRST_INDEX);
		}
	}
	
	@Override
	public ArrayList<T> rest() {
		Optional<T> object = Optional.of(secuencia.remove(FIRST_INDEX));
		if(object.isPresent()) {
			return secuencia;
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	@Override
	public int size() {
		return secuencia.size();
	}

	@Override
	public T get(int index) throws ArrayIndexOutOfBoundsException{
		if(secuencia.isEmpty() || index >= secuencia.size()) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			return secuencia.get(index);
		}
	}

	@Override
	public Iterator<T> iterator() {
		return secuencia.iterator();
	}

	

	

}
