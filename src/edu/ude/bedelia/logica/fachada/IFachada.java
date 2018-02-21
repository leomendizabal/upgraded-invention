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

	public void registrarAsignatura(VOAsignatura a) throws RemoteException;

	public void registrarAlumno(VOAlumno a) throws RemoteException;

	public void modificarAlumno(VOAlumno a) throws RemoteException, AlumnosException;

	public ArrayList<VOAsignatura> listarAsignaturas() throws RemoteException;

	public ArrayList<VOAlumno> listarAlumnosApellido(String apellido) throws RemoteException;

	public VOAlumnoCompleto listarDatosAlumno(String ci) throws RemoteException;

	public void inscribirAlumno(String ci, String codigo, int anio, float montoBase)
			throws RemoteException, AlumnosException, AsignaturasException, InscripcionesException;

	public void registrarResultado(String ci, int nota, Integer codigo) throws RemoteException;

	public float montoRecaudadoPorAlumno(int anio, String ci) throws RemoteException, AlumnosException;

	public void respaldarDatos() throws RemoteException, SistemaException, PersistenciaException;

	public ArrayList<VOInscripcion> listarEscolaridad(String ci, boolean esCompleta) throws RemoteException;

	public ArrayList<VOEgresado> listarEgresados(boolean completo) throws RemoteException;

	public int suma(int a, int b) throws RemoteException;

}
