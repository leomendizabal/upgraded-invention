package edu.ude.bedelia.logica.fachada;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.ude.bedelia.logica.colecciones.Alumnos;
import edu.ude.bedelia.logica.colecciones.Asignaturas;
import edu.ude.bedelia.logica.colecciones.Inscripciones;
import edu.ude.bedelia.logica.entidades.Alumno;
import edu.ude.bedelia.logica.entidades.Asignatura;
import edu.ude.bedelia.logica.entidades.Becado;
import edu.ude.bedelia.logica.entidades.Inscripcion;
import edu.ude.bedelia.logica.excepciones.AlumnosException;
import edu.ude.bedelia.logica.excepciones.AsignaturasException;
import edu.ude.bedelia.logica.excepciones.InscripcionesException;
import edu.ude.bedelia.logica.excepciones.SistemaException;
import edu.ude.bedelia.logica.utiles.Helper;
import edu.ude.bedelia.logica.utiles.Mensajes;
import edu.ude.bedelia.logica.utiles.Monitor;
import edu.ude.bedelia.logica.vo.VOAlumno;
import edu.ude.bedelia.logica.vo.VOAlumnoCompleto;
import edu.ude.bedelia.logica.vo.VOAsignatura;
import edu.ude.bedelia.logica.vo.VOBecadoCompleto;
import edu.ude.bedelia.logica.vo.VOEgresado;
import edu.ude.bedelia.logica.vo.VOInscripcion;
import edu.ude.bedelia.persistencia.excepciones.PersistenciaException;
import edu.ude.bedelia.persistencia.fachada.FachadaPersistencia;
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
		monitor = new Monitor();
		this.levantarRespaldo();
		this.mockearDatos();
	}

	public static Fachada getInstancia() throws RemoteException {
		if (instancia == null) {
			instancia = new Fachada();
		}

		return instancia;
	}

	@Override
	public void registrarAsignatura(VOAsignatura a) throws RemoteException, AsignaturasException {
		monitor.comienzoEscritura();
		if (asignaturas.pertenece(a.getCodigo())) {
			monitor.terminoEscritura();
			throw new AsignaturasException(Mensajes.MSG_YA_EXISTE_ASIGNATURA);
		} else {
			Asignatura asi = new Asignatura(a);
			asignaturas.insert(asi);
		}
		monitor.terminoEscritura();
	}

	@Override
	public void registrarAlumno(VOAlumnoCompleto vo) throws RemoteException, AlumnosException {

		final String cedula = vo.getCedula();
		monitor.comienzoEscritura();
		if (alumnos.member(cedula)) {
			monitor.terminoEscritura();
			throw new AlumnosException(String.format(Mensajes.MSG_EXISTE_ALUMNO, cedula));
		} else {
			Alumno alumno = new Alumno(vo);
			if (vo instanceof VOBecadoCompleto) {
				VOBecadoCompleto becadoCompleto = (VOBecadoCompleto) vo;
				alumno = new Becado(becadoCompleto);
			}
			alumnos.insert(cedula, alumno);
		}
		monitor.terminoEscritura();
	}

	@Override
	public void modificarAlumno(VOAlumnoCompleto a) throws RemoteException, AlumnosException {

		String ced = a.getCedula();
		monitor.comienzoEscritura();
		if (alumnos.member(ced)) {
			Alumno alu = new Alumno(a);
			alumnos.modify(ced, alu);
		} else {
			monitor.terminoEscritura();
			throw new AlumnosException(Mensajes.MSG_ALUMNO_NO_EXISTE);
		}
		monitor.terminoEscritura();

	}

	@Override
	public ArrayList<VOAsignatura> listarAsignaturas() throws RemoteException {

		monitor.comienzoLectura();
		ArrayList<VOAsignatura> listado = asignaturas.listarAsignaturas();
		monitor.terminoLectura();

		return listado;
	}

	@Override
	public ArrayList<VOAlumno> listarAlumnosApellido(String apellido) throws RemoteException {
		monitor.comienzoLectura();
		ArrayList<VOAlumno> listado = alumnos.listarAlumnosApellido(apellido);
		
		monitor.terminoLectura();
		return listado;
	}

	public VOAlumno listarDatosAlumno(String cedula) throws RemoteException, AlumnosException {
		monitor.comienzoLectura();
		if (alumnos.member(cedula)) {
			Alumno alumno = alumnos.find(cedula);
			VOAlumno vo = alumno.toVO(true);
			if (alumno instanceof Becado) {
				Becado alumnoBecado = (Becado) alumno;
				vo = alumnoBecado.toVO();
			}
			monitor.terminoLectura();
			return vo;
		} else {
			monitor.terminoLectura();
			throw new AlumnosException(String.format(Mensajes.MSG_NO_EXISTE_ALUMNO, cedula));
		}
	}

	@Override
	public void inscribirAlumno(String ci, String codigo, int anio, float montoBase)
			throws RemoteException, AlumnosException, AsignaturasException, InscripcionesException {
		monitor.comienzoEscritura();
		if (alumnos.member(ci)) {
			Alumno alumno = alumnos.find(ci);
			if (asignaturas.pertenece(codigo)) {
				final Asignatura asig = asignaturas.devolverAsignatura(codigo);
				if (alumno.tieneIncripciones()) {
					Inscripciones inscripciones = alumno.getInscripciones();
					if (inscripciones.asignaturaAprobada(codigo)) {
						monitor.terminoEscritura();
						throw new InscripcionesException(Mensajes.MSG_ALUMNO_YA_APROBO_ASIGNATURA);
					} else {
						if (inscripciones.inscriptoEnAnioLectivo(codigo)) {
							monitor.terminoEscritura();
							throw new InscripcionesException(Mensajes.MSG_ALUMNO_YA_ESTA_INSCRIPTO_ASIGANTURA);
						} else {
							if (alumno.getInscripciones().anioLectivoMayorIgualUltimaInscripcion()) {
								alumno.registrarInscripcion(anio, montoBase, asig);								
							} else {
								monitor.terminoEscritura();
								throw new InscripcionesException(Mensajes.MSG_ANO_NO_COINCIDE_CON_ACTUAL);
							}
						}
					}
				} else {
					alumno.registrarInscripcion(anio, montoBase, asig);
				}
			} else {
				monitor.terminoEscritura();
				throw new AsignaturasException(Mensajes.mensaje(Mensajes.MSG_ASIGNATURA_NO_EXISTE, codigo));
			}
		} else {
			monitor.terminoEscritura();
			throw new AlumnosException(Mensajes.MSG_ALUMNO_NO_EXISTE);
		}
		monitor.terminoEscritura();
	}

	@Override
	public float montoRecaudadoPorAlumno(int anio, String ci) throws RemoteException, AlumnosException {

		float monto = 0;
		monitor.comienzoLectura();
		if (alumnos.member(ci)) {
			Alumno alu = alumnos.find(ci);
			monto = alu.calcularMontoCobrado(anio);

			if (alu instanceof Becado) {
				monto = ((Becado) alu).calcularMontoCobrado(anio);
			}
		} else {
			monitor.terminoLectura();
			throw new AlumnosException(Mensajes.MSG_ALUMNO_NO_EXISTE);
		}
		monitor.terminoLectura();
		return monto;
	}

	@Override
	public void respaldarDatos() throws RemoteException, SistemaException, PersistenciaException {

		try {
			monitor.comienzoEscritura();
			fachadaPersistencia.respaldarDatos(alumnos, asignaturas);
		} catch (PersistenciaException exception) {
			// TODO: Ver si se pone el monitor
			throw exception;
		} finally {
			monitor.terminoEscritura();
		}

	}

	// TODO:Falta implemetar
	@Override
	public ArrayList<VOInscripcion> listarEscolaridad(String ci, boolean esCompleta)
			throws AlumnosException, RemoteException {

		monitor.comienzoLectura();
		if (alumnos.member(ci)) {
			ArrayList<VOInscripcion> escolaridad = new ArrayList<VOInscripcion>();
			Alumno a = alumnos.find(ci);
			Inscripciones inscripciones = a.getInscripciones();

			for (Inscripcion i : inscripciones) {
				if (esCompleta) {
					escolaridad.add(i.toVO(true));
				} else {
					if (i.getCalificacion() != 0) {
						escolaridad.add(i.toVO(true));
					}
				}
			}
			monitor.terminoLectura();
			return escolaridad;
		} else {
			monitor.terminoLectura();
			throw new AlumnosException(Mensajes.MSG_ALUMNO_NO_EXISTE);
		}
	}

	public ArrayList<VOEgresado> listarEgresados(boolean esCompleto) {
		monitor.comienzoLectura();
		ArrayList<VOEgresado> listado = alumnos.listarEgresados(esCompleto);
		monitor.terminoLectura();
		return listado;
	}

	@Override
	public void registrarResultado(String ci, int nota, String codigo, int anio)
			throws RemoteException, AlumnosException {
		monitor.comienzoEscritura();
		if (alumnos.member(ci)) {
			Alumno a = alumnos.find(ci);
			if (a.esInscripto(codigo, anio) && !a.asignaturaCalificada(codigo, anio)) {
				if (Helper.calificacionEsValida(nota)) {
					a.registrarCalificacion(codigo, nota);
				} else {
					throw new AlumnosException(Mensajes.MSG_CALIF_INVALIDA);
				}
			} else {
				monitor.terminoEscritura();
				throw new AlumnosException(Mensajes.ALUMNO_NO_INSCRIPTO);
			}
		} else {
			monitor.terminoEscritura();
			throw new AlumnosException(Mensajes.MSG_ALUMNO_NO_EXISTE);
		}
		monitor.terminoEscritura();
	}

	public void mockearDatos() throws RemoteException {
		this.alumnos = DataClass.ALUMNOS;
		this.asignaturas = DataClass.ASIGNATURA;
	}

	public void levantarRespaldo() throws RemoteException {
		if (fachadaPersistencia.existeRespaldo()) {
			try {
				VODato respaldos = fachadaPersistencia.recuperarDatos();
				this.alumnos = respaldos.getDiccionario();
				this.asignaturas = respaldos.getSecuencia();
			} catch (PersistenciaException e) {
				this.alumnos = new Alumnos();
				this.asignaturas = new Asignaturas(0);
			}
		} else {
			this.alumnos = new Alumnos();
			this.asignaturas = new Asignaturas(0);
		}
	}

}
