import java.util.ArrayList;

import edu.ude.bedelia.logica.colecciones.Asignaturas;
import edu.ude.bedelia.logica.colecciones.DiccionarioAlumnos;
import edu.ude.bedelia.logica.entidades.Alumno;
import edu.ude.bedelia.logica.entidades.Asignatura;
import edu.ude.bedelia.logica.excepciones.AlumnosException;
import edu.ude.bedelia.logica.utiles.Constantes;
import edu.ude.bedelia.logica.vo.VOAlumno;
import edu.ude.bedelia.logica.vo.VOAsignatura;

public class Main {

	public static void main(String[] args) {
		Alumno a = new Alumno("1234", "asdf", "asdf", "asdfasd", "asdfasd", "asdfasd@gmail.com");
		DiccionarioAlumnos diccionario = new DiccionarioAlumnos();
		diccionario.insert(a.getCedula(), a);
		Asignaturas as = new Asignaturas();

		for (int i = 0; i < Constantes.CANTIDAD_MATERIAS; i++) {
			String key = String.format("MAT%s", String.valueOf(i));
			as.insert(new Asignatura(key, "Materia", "Descripcion"));
		}

		for (VOAsignatura asig : as.listarAsignaturas()) {
			System.out.println(String.format(" clave %s", asig.getCodigo()));
		}
		
		try {
			ArrayList<VOAlumno> alumnosApellidos = diccionario.listarAlumnosApellido("asdf");
			System.out.println(String.format("cantidad de alumnos: %s", alumnosApellidos.size()));
		} catch(AlumnosException e) {
			System.out.println("Error: " + e.getMensaje());
		}
		
		
	}

}
