package edu.ude.bedelia.logica.fachada;

import java.util.ArrayList;

import edu.ude.bedelia.logica.excepciones.AlumnosException;
import edu.ude.bedelia.logica.excepciones.AsignaturasException;
import edu.ude.bedelia.logica.excepciones.InscripcionesException;
import edu.ude.bedelia.logica.vo.VOAlumno;
import edu.ude.bedelia.logica.vo.VOAlumnoCompleto;
import edu.ude.bedelia.logica.vo.VOAsignatura;
import edu.ude.bedelia.logica.vo.VOEgresado;
import edu.ude.bedelia.logica.vo.VOInscripcion;

public interface IFachada {
	
	
	public void registrarAlumno(VOAlumnoCompleto vo)throws AlumnosException;
	
	public void registrarAsignatura(VOAsignatura a) throws AsignaturasException;
	
	public void modificarAlumno(VOAlumnoCompleto a) throws AlumnosException;

	public ArrayList<VOAsignatura> listarAsignaturas();
	
	public ArrayList<VOAlumno> listarAlumnosApellido(String apellido);
	
	public VOAlumno listarDatosAlumno(String ci) throws AlumnosException;
	
	public void inscribirAlumno(String ci, String codigo,int anio,float montoBase) throws AlumnosException, AsignaturasException, InscripcionesException;
	
	public void registrarResultado(String ci, int nota, Integer codigo);
	
	public float montoRecaudadoPorAlumno(int anio, String ci) throws AlumnosException;
	
	public void respaldarDatos();
	
	public ArrayList<VOInscripcion> listarEscolaridad(String ci, boolean esCompleta);
	
	public ArrayList<VOEgresado> listarEgresados(boolean completo);
	
}
