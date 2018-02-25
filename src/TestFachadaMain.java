import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import edu.ude.bedelia.logica.colecciones.Inscripciones;
import edu.ude.bedelia.logica.entidades.Alumno;
import edu.ude.bedelia.logica.entidades.Asignatura;
import edu.ude.bedelia.logica.entidades.Becado;
import edu.ude.bedelia.logica.entidades.Inscripcion;
import edu.ude.bedelia.logica.excepciones.AlumnosException;
import edu.ude.bedelia.logica.excepciones.AsignaturasException;
import edu.ude.bedelia.logica.excepciones.InscripcionesException;
import edu.ude.bedelia.logica.excepciones.SistemaException;
import edu.ude.bedelia.logica.fachada.Fachada;
import edu.ude.bedelia.logica.vo.VOAlumno;
import edu.ude.bedelia.logica.vo.VOAlumnoCompleto;
import edu.ude.bedelia.logica.vo.VOAsignatura;
import edu.ude.bedelia.logica.vo.VOBecadoCompleto;
import edu.ude.bedelia.logica.vo.VOInscripcion;
import edu.ude.bedelia.persistencia.excepciones.PersistenciaException;
import edu.ude.bedelia.test.DataClass;

public class TestFachadaMain {

	public static void main(String[] args) {
			/*Alumno santi = new Alumno("52813398", "Santiago", "Mattiauda", "asdfasd", "asdfasd", "asdfasd@gmail.com");
			Alumno alumnoTest = new Alumno("12345678", "SANTI", "TEST", "asdfasd", "asdfasd", "asdfasd@gmail.com");
			Fachada fac = Fachada.getInstancia();

			// inscribirAlumno
			fac.inscribirAlumno(santi.getCedula(), DataClass.admMarkGast1.getCodigo(), 2018, 100);
			//listar asignatura
			ArrayList<VOAsignatura> lista = fac.listarAsignaturas();

			fac.registrarAsignatura(new VOAsignatura(new Asignatura("MAT!12", "Materia", "Descripcion")));
			for (VOAsignatura vo : lista) {
				System.out.println(String.format("Nombre %s", vo.getNombre()));
			}

			//Registrar alumno
			fac.registrarAlumno(new VOAlumnoCompleto(alumnoTest));
			//Listar alumno por apellidos
			ArrayList<VOAlumno> porApellido = fac.listarAlumnosApellido("TEST");
			for (VOAlumno vo : porApellido) {
				System.out.println(String.format("Nombre Alumno %s", vo.getNombre()));
			}
			
			//fac.respaldarDatos();
			*/
		try {
			int anio = Calendar.getInstance().get(Calendar.YEAR);
			Fachada bedelia = Fachada.getInstancia();

			Asignatura cocina = new Asignatura("CDOCOC12", "Cocina", "Cocina clasica");
			Asignatura frances = new Asignatura("CDOCOC13", "Frances", "Idioma frances");
			
			Alumno alumno1 = new Alumno("1111111", "NombreAlumno1", "ApellidoAlumno1", "DomicilioAlumno1", "443111111", "alumno1@test.com");
			Alumno becado = new Becado("2222222", "NombreBecado", "ApellidoBecado", "DomicilioBecado", "3400900", "elbecado@test.com", 10, "descuento por ser pobre");
		
			//Requerimiento 1
			System.out.println("******* Requerimiento 1 ********");
			bedelia.registrarAsignatura(cocina.toVO());
			bedelia.registrarAsignatura(frances.toVO());
			
			//Requerimiento 2
			System.out.println("******* Requerimiento 2 ********");
			bedelia.registrarAlumno((VOAlumnoCompleto) alumno1.toVO(true));
			bedelia.registrarAlumno(((Becado) becado).toVO());
			
			//Requerimiento 3
			System.out.println("******* Requerimiento 3 ********");
			//alumno1.setNombre("Alumno");
			//bedelia.modificarAlumno((VOAlumnoCompleto) alumno1.toVO(true));			
			
			//Requerimiento 4
			System.out.println("******* Requerimiento 4 ********");
			ArrayList<VOAsignatura> asignaturas = bedelia.listarAsignaturas();
			for (VOAsignatura vo : asignaturas) {
				System.out.println(String.format(vo.toString()));
			}
			
			//Requerimiento 5
			System.out.println("******* Requerimiento 5 ********");
			ArrayList<VOAlumno> alumnos = bedelia.listarAlumnosApellido("Ape");			
			for (VOAlumno vo : alumnos) {
				System.out.println(String.format("Nombre Alumno %s", vo.getNombre()));
			}
			
			//Requerimiento 6
			System.out.println("******* Requerimiento 6 ********");
			VOAlumno alumnoModificado = (VOAlumnoCompleto) bedelia.listarDatosAlumno("1111111");
			System.out.println("Datos del alumno modificados: "+alumnoModificado.toString());
			
			//Requerimiento 7
			System.out.println("******* Requerimiento 7 ********");
			bedelia.inscribirAlumno(alumno1.getCedula(), cocina.getCodigo(), anio, 1200);
			bedelia.inscribirAlumno(alumno1.getCedula(), frances.getCodigo(), anio, 100);
			bedelia.inscribirAlumno(becado.getCedula(), cocina.getCodigo(), anio, 1000);
			
			//Requerimiento 8
			System.out.println("******* Requerimiento 8 ********");
			bedelia.registrarResultado(alumno1.getCedula(), 10, cocina.getCodigo(), anio);
			
//			Inscripciones inscripciones = bedelia.getAlumnoCI(alumno1.getCedula()).getInscripciones();
//			for(Inscripcion i: inscripciones) {
//				System.out.println("Inscripcion: "+i.toString());
//			}
			
			System.out.println("******* Requerimiento 9 ********");
			float montoRecaudado = bedelia.montoRecaudadoPorAlumno(anio, becado.getCedula());
			System.out.println("Monto recaudado: "+montoRecaudado);
			
			System.out.println("******* Requerimiento 10 ********");
			//bedelia.respaldarDatos();			
			
			System.out.println("******* Requerimiento 11 ********");
			ArrayList<VOInscripcion> escolaridad = bedelia.listarEscolaridad(alumno1.getCedula(), false);
			for(VOInscripcion i: escolaridad) {
				System.out.println("Inscripcion: numero "+i.getNumero() + " calificacion: " + i.getCalificacion());
			}
			
		} catch(Exception e) {
			System.out.print("Excepcion "+e.getMessage());
		}	
	}

}
