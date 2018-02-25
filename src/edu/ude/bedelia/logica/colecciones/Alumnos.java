package edu.ude.bedelia.logica.colecciones;

import java.util.ArrayList;
import java.util.Iterator;

import edu.ude.bedelia.logica.entidades.Alumno;
import edu.ude.bedelia.logica.vo.VOAlumno;
import edu.ude.bedelia.logica.vo.VOEgresado;

public class Alumnos extends DiccionarioTreeMap<String, Alumno> {

	private static final long serialVersionUID = 1850403552497737115L;

	public Alumnos() {
		super();
	}

	// Genera una lista de alumnos por apellido.
	public ArrayList<VOAlumno> listarAlumnosApellido(String apellido) {
		Iterator<Alumno> it = this.getIterator();
		ArrayList<VOAlumno> resultado = new ArrayList<VOAlumno>();
		Alumno current;

		while (it.hasNext()) {
			current = it.next();
			if (current.getApellido().toLowerCase().contains(apellido.toLowerCase())) {
				resultado.add(current.toVO(false));
			}
		}

		return resultado;
	}

	public VOAlumno listarDatosAlumno(String ci) {
		return this.find(ci).toVO(true);
	}

	public ArrayList<VOEgresado> listarEgresados(boolean esCompleto) {
		Iterator<Alumno> it = this.getIterator();
		ArrayList<VOEgresado> resultado = new ArrayList<VOEgresado>();
		Alumno current;

		while (it.hasNext()) {
			current = it.next();
			if (current.esEgresado()) {
				resultado.add(current.toVOEgresado(esCompleto));
			}
		}

		return resultado;
	}
}
