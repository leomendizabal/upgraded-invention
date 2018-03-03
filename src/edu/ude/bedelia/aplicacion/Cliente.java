package edu.ude.bedelia.aplicacion;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import edu.ude.bedelia.logica.entidades.Alumno;
import edu.ude.bedelia.logica.entidades.Asignatura;
import edu.ude.bedelia.logica.entidades.Becado;
import edu.ude.bedelia.logica.fachada.Fachada;
import edu.ude.bedelia.logica.fachada.IFachada;
import edu.ude.bedelia.logica.vo.VOAlumno;
import edu.ude.bedelia.logica.vo.VOAlumnoCompleto;
import edu.ude.bedelia.logica.vo.VOAsignatura;
import edu.ude.bedelia.logica.vo.VOEgresado;
import edu.ude.bedelia.logica.vo.VOEgresadoCompleto;
import edu.ude.bedelia.logica.vo.VOInscripcion;

public class Cliente {

	public static void main(String[] args) {
		try {
			correrPruebas(Fachada.getInstancia());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void correrPruebas(IFachada bedelia) {
		try {
			int anio = Calendar.getInstance().get(Calendar.YEAR);

			Asignatura cocina = new Asignatura("CDOCOC12", "Cocina", "Cocina clasica");
			Asignatura frances = new Asignatura("CDOCOC13", "Frances", "Idioma frances");

			Alumno alumno1 = new Alumno("1111111", "NombreAlumno1", "ApellidoAlumno1", "DomicilioAlumno1", "443111111",
					"alumno1@test.com");
			Alumno becado = new Becado("2222222", "NombreBecado", "ApellidoBecado", "DomicilioBecado", "3400900",
					"elbecado@test.com", 10, "descuento por ser pobre");

			// Requerimiento 1
			System.out.println("******* Requerimiento 1 ********");
			bedelia.registrarAsignatura(cocina.toVO());
			bedelia.registrarAsignatura(frances.toVO());
			System.out.println("-> Asignaturas ingresadas con exito");

			// Requerimiento 2
			System.out.println("******* Requerimiento 2 ********");
			bedelia.registrarAlumno((VOAlumnoCompleto) alumno1.toVO(true));
			bedelia.registrarAlumno(((Becado) becado).toVO());
			System.out.println("-> Alumnos ingresados con exito");
			
			// Requerimiento 3
			System.out.println("******* Requerimiento 3 ********");
			alumno1.setNombre("Alumno");
			bedelia.modificarAlumno((VOAlumnoCompleto) alumno1.toVO(true));
			System.out.println("-> Alumno modificado con exito");
			
			// Requerimiento 4
			System.out.println("******* Requerimiento 4 ********");
			ArrayList<VOAsignatura> asignaturas = bedelia.listarAsignaturas();
			for (VOAsignatura vo : asignaturas) {
				System.out.println(String.format(vo.toString()));
			}

			// Requerimiento 5
			System.out.println("******* Requerimiento 5 ********");
			ArrayList<VOAlumno> alumnos = bedelia.listarAlumnosApellido("Ape");
			for (VOAlumno vo : alumnos) {
				System.out.println(String.format("Nombre Alumno %s", vo.getNombre()));
			}

			// Requerimiento 6
			System.out.println("******* Requerimiento 6 ********");
			VOAlumno alumnoModificado = (VOAlumnoCompleto) bedelia.listarDatosAlumno("1111111");
			System.out.println("-> Datos del alumno: " + alumnoModificado.toString());

			// Requerimiento 7
			System.out.println("******* Requerimiento 7 ********");
			bedelia.inscribirAlumno(alumno1.getCedula(), cocina.getCodigo(), anio, 1200);
			bedelia.inscribirAlumno(alumno1.getCedula(), frances.getCodigo(), anio, 100);
			bedelia.inscribirAlumno(becado.getCedula(), cocina.getCodigo(), anio, 1000);
			System.out.println("-> Alumnos inscriptos con exito");
			
			// Requerimiento 8
			System.out.println("******* Requerimiento 8 ********");
			bedelia.registrarResultado(alumno1.getCedula(), 12, cocina.getCodigo(), anio);
			bedelia.registrarResultado(alumno1.getCedula(), 10, frances.getCodigo(), anio);
			bedelia.registrarResultado(becado.getCedula(), 7, cocina.getCodigo(), anio);
			System.out.println("-> Resultado ingresado con exito");
			
			
			// Inscripciones inscripciones =
			// bedelia.getAlumnoCI(alumno1.getCedula()).getInscripciones();
			// for(Inscripcion i: inscripciones) {
			// System.out.println("Inscripcion: "+i.toString());
			// }

			System.out.println("******* Requerimiento 9 ********");
			float montoRecaudado = bedelia.montoRecaudadoPorAlumno(anio, becado.getCedula());
			System.out.println("-> Monto recaudado: " + montoRecaudado);

			System.out.println("******* Requerimiento 10 ********");
			// bedelia.respaldarDatos();
			System.out.println("Para respaldar datos DESCOMENTE la linea 99 del archivo TestMain y vuelva a ejecutar");
			System.out.println("NOTA: Si respalda los datos, para volver a ejecutar debe eliminar previamente el archivo config/respaldo.dat");

			System.out.println("******* Requerimiento 11 (modo parcial)********");
			ArrayList<VOInscripcion> escolaridad = bedelia.listarEscolaridad(alumno1.getCedula(), false);
			
			for (VOInscripcion i : escolaridad) {
				System.out.println("Inscripcion: numero " + i.getNumero() + " calificacion: " + i.getCalificacion());
			}
			
			System.out.println("******* Requerimiento 11 (modo completo)********");
			ArrayList<VOInscripcion> escolaridadCompleta = bedelia.listarEscolaridad(alumno1.getCedula(), true);
			
			for (VOInscripcion i : escolaridad) {
				System.out.println("Inscripcion: numero " + i.getNumero() + " calificacion: " + i.getCalificacion());
			}
			
			System.out.println("******* Requerimiento 12 ********");
			
			Alumno egresado = new Alumno("22222222", "Egresado", "ApellidoEgresado", "DomicilioEgresado", "55555555",
					"egresado@test.com");
			bedelia.registrarAlumno((VOAlumnoCompleto) egresado.toVO(true));
			for (VOAsignatura asig : asignaturas) {
				bedelia.inscribirAlumno(egresado.getCedula(), asig.getCodigo(), anio, 1000);
				bedelia.registrarResultado(egresado.getCedula(), 7, asig.getCodigo(), anio);
				
			}
			
			ArrayList<VOEgresado> egresados = bedelia.listarEgresados(true);
			System.out.println("Egresados: ");
			for (VOEgresado e : egresados) {
				System.out.println(e.toString());
			} 

		} catch (Exception e) {
			System.out.print("Excepcion " + e.getMessage());
		}
	}
}
