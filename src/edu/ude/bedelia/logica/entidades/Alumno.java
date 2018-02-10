package edu.ude.bedelia.logica.entidades;

import java.util.Iterator;

import edu.ude.bedelia.logica.constantes.Constantes;
import edu.ude.bedelia.logica.colecciones.Inscripciones;

public class Alumno {
	private String cedula;
	private String nombre;
	private String apellido;
	private String domicilio;
	private String telefono;
	private String email;
	private Inscripciones inscripciones;
	
	public Alumno(String cedula, String nombre, String apellido, String domicilio, String telefono, String email) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.email = email;
		
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean esMateriaAprobada(String codigo) {
		Iterator iterador = this.inscripciones.getIterator();		
		boolean estaAprobada = false;
		Inscripcion inscripcion;
		
		while(iterador.hasNext() && !estaAprobada) {
			inscripcion = (Inscripcion)iterador.next();
			if(inscripcion.getAsignatura().getCodigo() == codigo) {				
				estaAprobada = inscripcion.getCalificacion() >= Constantes.NOTA_MINIMA_APROBACION;
			}
		}
		
		return estaAprobada;
	}
	
	public boolean esInscripto(String codigo, int anio) {
		Iterator iterador = this.inscripciones.getIterator();
		Inscripcion inscripcion;
		boolean estaInscripto = false;
		boolean esMateria = false;
		
		while(iterador.hasNext() && !esMateria) {
			inscripcion = (Inscripcion)iterador.next();
			if(inscripcion.getAsignatura().getCodigo() == codigo) {				
				estaInscripto = inscripcion.getAnio() == anio;
			}
		}
		
		return estaInscripto;
	}
	
	public void registrarInscripcion(Inscripcion inscripcion) {
		this.inscripciones.insert(inscripcion.getNumero(), inscripcion);
	}
	
	public void registrarCalificacion(String codigo, int calificacion) {
		Iterator iterador = this.inscripciones.getIterator();
		Inscripcion inscripcion;
		boolean esMateria = false;
		
		while(iterador.hasNext() && !esMateria) {
			inscripcion = (Inscripcion)iterador.next();
			if(inscripcion.getAsignatura().getCodigo() == codigo) {				
				inscripcion.setCalificacion(calificacion);
			}
		}		
	}
}
