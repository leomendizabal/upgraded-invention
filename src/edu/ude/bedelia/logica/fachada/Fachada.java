package edu.ude.bedelia.logica.fachada;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.ude.bedelia.logica.colecciones.Alumnos;
import edu.ude.bedelia.logica.colecciones.Asignaturas;
import edu.ude.bedelia.logica.entidades.Alumno;
import edu.ude.bedelia.logica.entidades.Asignatura;
import edu.ude.bedelia.logica.entidades.Inscripcion;
import edu.ude.bedelia.logica.excepciones.AlumnosException;
import edu.ude.bedelia.logica.excepciones.AsignaturasException;
import edu.ude.bedelia.logica.excepciones.InscripcionesException;
import edu.ude.bedelia.logica.excepciones.SistemaException;
import edu.ude.bedelia.logica.utiles.Monitor;
import edu.ude.bedelia.logica.vo.VOAlumno;
import edu.ude.bedelia.logica.vo.VOAlumnoCompleto;
import edu.ude.bedelia.logica.vo.VOAsignatura;
import edu.ude.bedelia.logica.vo.VOEgresado;
import edu.ude.bedelia.logica.vo.VOInscripcion;
import edu.ude.bedelia.persistencia.excepciones.PersistenciaException;
import edu.ude.bedelia.persistencia.fachada.FachadaPersistencia;
import edu.ude.bedelia.persistencia.fachada.Respaldo;
import edu.ude.bedelia.persistencia.vo.VODato;
import edu.ude.bedelia.test.DataClass;

public class Fachada extends UnicastRemoteObject implements IFachada {

	private static final long serialVersionUID = 1L;

	private Alumnos alumnos;
	private Asignaturas asignaturas;
	private static Fachada instancia;
	private final FachadaPersistencia fachadaPersistencia;

	private Monitor monitor;

	private Fachada() throws RemoteException {
		
		this.fachadaPersistencia = FachadaPersistencia.getInstance();
		this.alumnos = DataClass.ALUMNOS;// new Alumnos();
		this.asignaturas = DataClass.ASIGNATURA;// new Asignaturas();
		//TODO: Esto funciona si en la primera ves se reinicia el server
		if (fachadaPersistencia.existeRespaldo()) {
			fachadaPersistencia.recuperarDatos();
		}
		
		monitor = new Monitor();
	}

	public static Fachada getInstancia() throws RemoteException {
		if (instancia == null) {
			instancia = new Fachada();
		}

		return instancia;
	}

	public void registrarAsignatura(VOAsignatura a) {

	}

	public void registrarAlumno(VOAlumno a) {

	}

	public void modificarAlumno(VOAlumno a) throws AlumnosException {

		String ced = a.getCedula();
		if (alumnos.member(ced)) {
			Alumno alu = alumnos.find(ced);
			alumnos.modify(ced, alu);
		} else {
			throw new AlumnosException("El alumno no existe en el sistema");
		}

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

	public void inscribirAlumno(String ci, String codigo, int anio, float montoBase)
			throws AlumnosException, AsignaturasException, InscripcionesException {

		if (alumnos.member(ci)) {

			if (asignaturas.pertenece(codigo)) {

				if (alumnos.find(ci).getInscripciones().asignaturaAprobada(codigo)) {
					throw new InscripcionesException("El alumno ya aprob� la asignatura");
				} else {
					if (alumnos.find(ci).getInscripciones().inscriptoEnAnioLectivo(codigo)) {
						throw new InscripcionesException("El alumno ya est� inscripto a esta asignatura");
					} else {
						if (alumnos.find(ci).getInscripciones().anioLectivoMayorIgualUltimaInscripcion()) {
							Asignatura asig = asignaturas.devolverAsignatura(codigo);
							Alumno alu = alumnos.find(ci);
							Integer num = alumnos.find(ci).getInscripciones().numeroUltimaInscripcionMasUno();
							Inscripcion ins = new Inscripcion(num, anio, montoBase, 0, asig);
							alumnos.find(ci).registrarInscripcion(ins);
						} else {
							throw new InscripcionesException("El a�o lectivo no coincide con el actual");
						}
					}
				}
			} else {
				throw new AsignaturasException("La asignatura con dicho c�digo no existe");
			}
		} else {
			throw new AlumnosException("El alumno con dicha c�dula no existe");
		}

	}

	public void registrarResultado(String ci, int nota, Integer codigo) {

	}

	public float montoRecaudadoPorAlumno(int anio, String ci) throws AlumnosException {

		float monto = 0;
		if (alumnos.member(ci)) {
			Alumno alu = alumnos.find(ci);
			monto = alu.calcularMontoCobrado(anio);

		} else {
			throw new AlumnosException("No existe un alumno con esa c�dula");
		}
		return monto;
	}

	@Override
	public void respaldarDatos() throws RemoteException, SistemaException, PersistenciaException {

		System.out.println("paso 2");
		monitor.comienzoEscritura();
		try {
			System.out.println("paso 3");
			fachadaPersistencia.respaldarDatos(alumnos, asignaturas);
		} catch (PersistenciaException e) {
			throw new PersistenciaException("Ver el mensaje");
		}
		monitor.terminoEscritura();
	}

	public ArrayList<VOInscripcion> listarEscolaridad(String ci, boolean esCompleta) {
		return null;
	}

	public ArrayList<VOEgresado> listarEgresados(boolean completo) {
		return null;
	}

	@Override
	public int suma(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a + b;
	}

}
