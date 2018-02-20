package edu.ude.bedelia.logica.colecciones;

import java.util.ArrayList;
import java.util.Iterator;

import edu.ude.bedelia.logica.entidades.Alumno;
import edu.ude.bedelia.logica.excepciones.AlumnosException;
import edu.ude.bedelia.logica.utiles.Mensajes;
import edu.ude.bedelia.logica.vo.VOAlumno;

public class DiccionarioAlumnos extends DiccionarioTreeMap<String, Alumno> {

	public DiccionarioAlumnos() {
		super();
	}

	// metodos especificos del diccionario alumnos
	public ArrayList<VOAlumno> listarAlumnosApellido(String apellido) throws AlumnosException {
		Iterator<Alumno> it = this.getIterator();
		ArrayList<VOAlumno> resultado = new ArrayList<VOAlumno>();
		Alumno current;

		while (it.hasNext()) {
			current = it.next();
			if (current.getApellido().contains(apellido)) {
				resultado.add(current.toVO(false));
			}
		}

		if (resultado.size() == 0) {
			throw new AlumnosException(Mensajes.MSG_NO_EXISTEN_ALUMNOS_APELLIDO);
		}

		return resultado;
	}

}
