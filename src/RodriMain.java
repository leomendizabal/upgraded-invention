
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import edu.ude.bedelia.logica.colecciones.Asignaturas;
import edu.ude.bedelia.logica.colecciones.Alumnos;
import edu.ude.bedelia.logica.entidades.Alumno;
import edu.ude.bedelia.logica.entidades.Asignatura;
import edu.ude.bedelia.logica.excepciones.AlumnosException;
import edu.ude.bedelia.logica.utiles.Constantes;
import edu.ude.bedelia.logica.vo.VOAlumno;
import edu.ude.bedelia.logica.vo.VOAlumnoCompleto;
import edu.ude.bedelia.logica.vo.VOAsignatura;
import edu.ude.bedelia.logica.vo.TipoAlumno;

public class RodriMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hola");

		Alumno elviejo = new Alumno("90000", "Rodri", "Gordano", "asdfasd", "asdfasd", "asdfasd@gmail.com");
		Alumno rodri = new Alumno("42587357", "Rodri", "Gordano", "asdfasd", "asdfasd", "asdfasd@gmail.com");
		Alumno leo = new Alumno("4387792", "Leo", "Mendizabal", "asdfasd", "asdfasd", "asdfasd@gmail.com");
		Alumno santi = new Alumno("52813398", "Santiago", "Mattiauda", "asdfasd", "asdfasd", "asdfasd@gmail.com");

		Alumnos diccionario = new Alumnos();
		diccionario.insert(leo.getCedula(), leo);
		diccionario.insert(santi.getCedula(), santi);
		diccionario.insert(rodri.getCedula(), rodri);
		diccionario.insert(elviejo.getCedula(), elviejo);

		Asignaturas as = new Asignaturas();

		for (int i = 0; i < Constantes.CANTIDAD_MATERIAS; i++) {
			String key = String.format("MAT%s", String.valueOf(i));
			as.insert(new Asignatura(key, "Materia", "Descripcion"));
		}

		for (VOAsignatura asig : as.listarAsignaturas()) {
			System.out.println(String.format(" clave %s", asig.getCodigo()));
		}

		ArrayList<VOAlumno> alumnosApellidos;
		alumnosApellidos = diccionario.listarAlumnosApellido("asdf");
		System.out.println(String.format("cantidad de alumnos: %s", alumnosApellidos.size()));

		Iterator<Alumno> iter = diccionario.values().iterator();
		while (iter.hasNext()) {
			final Alumno a = iter.next();
			System.out.println(a.toString());

		}

		TipoAlumno tipo = TipoAlumno.COMUN;
		VOAlumnoCompleto alu = new VOAlumnoCompleto("90000", "Rodri", "Gordano", tipo, "Las Piedras", "026090",
				"rgordano@gmail.com", 5000);

		Iterator<Alumno> iter2 = diccionario.values().iterator();
		while (iter.hasNext()) {
			final Alumno a = iter.next();
			System.out.println(a.toString());

		}

	}

}
