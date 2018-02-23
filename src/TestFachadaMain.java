import java.util.ArrayList;

import edu.ude.bedelia.logica.entidades.Alumno;
import edu.ude.bedelia.logica.entidades.Asignatura;
import edu.ude.bedelia.logica.fachada.Fachada;
import edu.ude.bedelia.logica.vo.VOAlumno;
import edu.ude.bedelia.logica.vo.VOAlumnoCompleto;
import edu.ude.bedelia.logica.vo.VOAsignatura;
import edu.ude.bedelia.test.DataClass;

public class TestFachadaMain {

	public static void main(String[] args) {
		try {
			Alumno santi = new Alumno("52813398", "Santiago", "Mattiauda", "asdfasd", "asdfasd", "asdfasd@gmail.com");
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
			
			fac.respaldarDatos();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}

	}

}
