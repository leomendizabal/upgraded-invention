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

	public void registrarAsignatura(VOAsignatura a) throws AsignaturasException {
		    
		    if (asignaturas.pertenece(a.getCodigo())) {
		    	throw new AsignaturasException(Mensajes.MSG_YA_EXISTE_ASIGNATURA);
		    }else {
		    	String cod=a.getCodigo();
		    	String nom=a.getNombre();
		    	String desc=a.getDescripcion();
		    	Asignatura asi =new Asignatura(cod,nom,desc);
		    	asignaturas.insert(asi);
		    }
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

	@Override
	public void modificarAlumno(VOAlumnoCompleto a) throws AlumnosException {

		String ced = a.getCedula();
		if (alumnos.member(ced)) {
			String nom = a.getNombre();
			String ape = a.getApellido();
			String dom = a.getDomicilio();
			String tel = a.getTelefono();
			String mail = a.getEmail();
			Alumno alu = new Alumno(ced, nom, ape, dom, tel, mail);
			alumnos.modify(ced, alu);
		} else {
			throw new AlumnosException(Mensajes.MSG_ALUMNO_NO_EXISTE);
		}

	}

	public ArrayList<VOAsignatura> listarAsignaturas() throws AsignaturasException {
		try {
			return this.asignaturas.listarAsignaturas();
		} catch(AsignaturasException e) {
			throw e;
		}
	}

	public ArrayList<VOAlumno> listarAlumnosApellido(String apellido) throws AlumnosException {
		
		try {
			ArrayList<VOAlumno> resultado = this.alumnos.listarAlumnosApellido(apellido);
			return resultado;
		} catch(AlumnosException e) {
			throw e;
		}
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
					throw new InscripcionesException(Mensajes.MSG_ALUMNO_YA_APROBO_ASIGNATURA);
				} else {
					if (alumnos.find(ci).getInscripciones().inscriptoEnAnioLectivo(codigo)) {
						throw new InscripcionesException(Mensajes.MSG_ALUMNO_YA_ESTA_INSCRIPTO_ASIGANTURA);
					} else {
						if (alumnos.find(ci).getInscripciones().anioLectivoMayorIgualUltimaInscripcion()) {
							Asignatura asig = asignaturas.devolverAsignatura(codigo);
							Alumno alu = alumnos.find(ci);
							Integer num = alumnos.find(ci).getInscripciones().numeroUltimaInscripcionMasUno();
							Inscripcion ins = new Inscripcion(num, anio, montoBase, 0, asig);
							alumnos.find(ci).registrarInscripcion(ins);
						} else {
							throw new InscripcionesException(Mensajes.MSG_ANO_NO_COINCIDE_CON_ACTUAL);
						}
					}
				}
			} else {
				throw new AsignaturasException(Mensajes.MSG_ASIGNATURA_NO_EXISTE);
			}
		} else {
			throw new AlumnosException(Mensajes.MSG_ALUMNO_NO_EXISTE);
		}

	}

	public void registrarResultado(String ci, int nota, String codigo, int anio) throws AlumnosException {

		if (alumnos.member(ci)) {
			Alumno a = alumnos.find(ci);
			if(a.esInscripto(codigo, anio)) {
				a.registrarCalificacion(codigo, nota);
			} else {
				throw new AlumnosException(Mensajes.ALUMNO_NO_INSCRIPTO);
			}
		} else {
			throw new AlumnosException(Mensajes.MSG_ALUMNO_NO_EXISTE);
		}
	}

	public float montoRecaudadoPorAlumno(int anio, String ci) throws AlumnosException {

		float monto = 0;
		if (alumnos.member(ci)) {
			Alumno alu = alumnos.find(ci);
			monto = alu.calcularMontoCobrado(anio);

		} else {
			throw new AlumnosException(Mensajes.MSG_ALUMNO_NO_EXISTE);
		}
		return monto;
	}

	public void respaldarDatos() {

	}

	public ArrayList<VOInscripcion> listarEscolaridad(String ci, boolean esCompleta) {
		return null;
	}

	public ArrayList<VOEgresado> listarEgresados(boolean esCompleto) throws AlumnosException {
		try {
			return this.alumnos.listarEgresados(esCompleto);
		} catch(AlumnosException e) {
			throw e;
		}
	}

}
