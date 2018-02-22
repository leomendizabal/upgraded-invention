package edu.ude.bedelia.logica.fachada;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.ude.bedelia.logica.excepciones.AlumnosException;
import edu.ude.bedelia.logica.excepciones.AsignaturasException;
import edu.ude.bedelia.logica.excepciones.InscripcionesException;
import edu.ude.bedelia.logica.excepciones.SistemaException;
import edu.ude.bedelia.logica.vo.VOAlumno;
import edu.ude.bedelia.logica.vo.VOAlumnoCompleto;
import edu.ude.bedelia.logica.vo.VOAsignatura;
import edu.ude.bedelia.logica.vo.VOEgresado;
import edu.ude.bedelia.logica.vo.VOInscripcion;
import edu.ude.bedelia.persistencia.excepciones.PersistenciaException;

public interface IFachada extends Remote {

	public void registrarAsignatura(VOAsignatura a) throws AsignaturasException, RemoteException;

	public void registrarAlumno(VOAlumnoCompleto vo) throws RemoteException, AlumnosException;

	public void modificarAlumno(VOAlumnoCompleto a) throws RemoteException, AlumnosException;

	public ArrayList<VOAsignatura> listarAsignaturas() throws AsignaturasException, RemoteException;
	
	public ArrayList<VOAlumno> listarAlumnosApellido(String apellido) throws AlumnosException, RemoteException;
	
	public void registrarResultado(String ci, int nota, String codigo, int anio) throws AlumnosException, RemoteException;
	
	public VOAlumno listarDatosAlumno(String ci) throws RemoteException, AlumnosException;

	public void inscribirAlumno(String ci, String codigo, int anio, float montoBase)
			throws RemoteException, AlumnosException, AsignaturasException, InscripcionesException;

	public float montoRecaudadoPorAlumno(int anio, String ci) throws RemoteException, AlumnosException;

	public void respaldarDatos() throws RemoteException, SistemaException, PersistenciaException;

	public ArrayList<VOInscripcion> listarEscolaridad(String ci, boolean esCompleta) throws RemoteException;

	public ArrayList<VOEgresado> listarEgresados(boolean esCompleto) throws AlumnosException, RemoteException;

	public int suma(int a, int b) throws RemoteException;
}
