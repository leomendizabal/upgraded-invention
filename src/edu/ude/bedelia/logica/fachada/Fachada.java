package edu.ude.bedelia.logica.fachada;

import java.util.ArrayList;

import edu.ude.bedelia.logica.colecciones.Alumnos;
import edu.ude.bedelia.logica.colecciones.Asignaturas;
import edu.ude.bedelia.logica.vo.VOAlumno;
import edu.ude.bedelia.logica.vo.VOAlumnoCompleto;
import edu.ude.bedelia.logica.vo.VOAsignatura;
import edu.ude.bedelia.logica.vo.VOEgresado;
import edu.ude.bedelia.logica.vo.VOInscripcion;

public class Fachada implements IFachada{
	
	private Alumnos alumnos;
	private Asignaturas asignaturas;
	private static Fachada instancia;
	
	private Fachada() {
		this.alumnos = new Alumnos();
		this.asignaturas = new Asignaturas();
	}
	
	public static Fachada getInstancia() {
		if (instancia == null) {
			instancia = new Fachada();
		}
		
		return instancia;
	}
	
	public void registrarAsignatura(VOAsignatura a) {
		
	}

	public void registrarAlumno(VOAlumno a) {
		
	}

	public void modificarAlumno(VOAlumno a) {
		
	}

	public ArrayList<VOAsignatura> listarAsignaturas() {
		return null;
	}

	public ArrayList<VOAlumno> listarAlumnosApellido(String apellido) {
		return null;
	}

	public VOAlumnoCompleto listarDatosAlumno(String ci) {
		return null;
	}

	public void inscribirAlumno(String ci, Integer codigo) {
		
	}

	public void registrarResultado(String ci, int nota, Integer codigo) {
		
	}

	public float montoRecaudadoPorAlumno(int anio, String ci) {
		return 0;
	}

	public void respaldarDatos() {
		
	}

	public ArrayList<VOInscripcion> listarEscolaridad(String ci, boolean esCompleta) {
		return null;
	}

	public ArrayList<VOEgresado> listarEgresados(boolean completo) {
		return null;
	}

}
