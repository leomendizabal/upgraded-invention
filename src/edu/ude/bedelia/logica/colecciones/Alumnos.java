package edu.ude.bedelia.logica.colecciones;

import java.util.ArrayList;
import java.util.Iterator;

import edu.ude.bedelia.logica.entidades.Alumno;
import edu.ude.bedelia.logica.entidades.Inscripcion;
import edu.ude.bedelia.logica.excepciones.AlumnosException;
import edu.ude.bedelia.logica.utiles.Mensajes;
import edu.ude.bedelia.logica.vo.VOAlumno;
import edu.ude.bedelia.logica.vo.VOEgresado;

public class Alumnos extends DiccionarioTreeMap<String, Alumno> {

	private static final long serialVersionUID = 1850403552497737115L;

	public Alumnos() {
		super();
	}

	//metodos especificos del diccionario alumnos
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
		
		if(resultado.size() == 0) {
			throw new AlumnosException(Mensajes.MSG_NO_EXISTEN_ALUMNOS_APELLIDO);
		}

		return resultado;
	}

	public VOAlumno listarDatosAlumno(String ci) {
		return this.find(ci).toVO(true);
	}
	
	public ArrayList<VOEgresado> listarEgresados(boolean esCompleto) throws AlumnosException {
		Iterator<Alumno> it = this.getIterator();
		ArrayList<VOEgresado> resultado = new ArrayList<VOEgresado>();
		Alumno current;
		
		while(it.hasNext()) {
			current = it.next();
			if(current.esEgresado()) {				
				resultado.add(current.toVOEgresado(esCompleto));
			}		
		}
		
		if(resultado.size() == 0) {
			throw new AlumnosException(Mensajes.MSG_NO_EXISTEN_ALUMNOS_EGRESADOS);
		}
		
		return resultado;
	}
}
