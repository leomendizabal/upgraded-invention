package edu.ude.bedelia.logica.fachada;

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
import edu.ude.bedelia.logica.utiles.Mensajes;
import edu.ude.bedelia.logica.vo.TipoAlumno;
import edu.ude.bedelia.logica.vo.VOAlumno;
import edu.ude.bedelia.logica.vo.VOAlumnoCompleto;
import edu.ude.bedelia.logica.vo.VOAsignatura;
import edu.ude.bedelia.logica.vo.VOBecadoCompleto;
import edu.ude.bedelia.logica.vo.VOEgresado;
import edu.ude.bedelia.logica.vo.VOInscripcion;

public class Fachada implements IFachada {

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

	//TODO: falta confirmacion
	@Override
	public void registrarAlumno(VOAlumnoCompleto vo) throws AlumnosException {

		final String cedula = vo.getCedula();
		if (alumnos.member(cedula)) {
			throw new AlumnosException(String.format(Mensajes.MSG_EXISTE_ALUMNO, cedula));
		} else {
			Alumno alumno = new Alumno(vo);
			if (vo instanceof VOBecadoCompleto) {
				VOBecadoCompleto becadoCompleto = (VOBecadoCompleto) vo;
				alumno = new Becado(becadoCompleto);
			}
			alumnos.insert(cedula, alumno);
			
		}

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

	public VOAlumno listarDatosAlumno(String cedula) throws AlumnosException {
		
		if(alumnos.member(cedula)) {
			Alumno alumno = alumnos.find(cedula);
			VOAlumno vo = alumno.toVO(true);
			if(alumno instanceof Becado) {
				Becado alumnoBecado = (Becado)alumno;
				vo = alumnoBecado.toVO();
			}
			return vo;
			
		} else {
			throw new AlumnosException(String.format(Mensajes.MSG_NO_EXISTE_ALUMNO, cedula));
		}
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

	public void respaldarDatos() {

	}

	public ArrayList<VOInscripcion> listarEscolaridad(String ci, boolean esCompleta) {
		return null;
	}

	public ArrayList<VOEgresado> listarEgresados(boolean completo) {
		return null;
	}

}
