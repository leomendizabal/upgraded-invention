package edu.ude.bedelia.logica.colecciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

import edu.ude.bedelia.logica.entidades.Alumno;
import edu.ude.bedelia.logica.excepciones.AlumnosException;
import edu.ude.bedelia.logica.utiles.Mensajes;
import edu.ude.bedelia.logica.vo.VOAlumno;

public class Alumnos extends DiccionarioTreeMap<String, Alumno> {
	
	public Alumnos() {
		
	}
	
	//metodos especificos del diccionario alumnos
	public ArrayList<VOAlumno> listarAlumnosApellido(String apellido) {
		Iterator it = this.getIterator();
		ArrayList<VOAlumno> resultado = new ArrayList<VOAlumno>();
		Alumno current;
		
		while(it.hasNext()) {
			current = (Alumno) it.next();
			if(current.getApellido().contains(apellido)) {
				resultado.add(current.toVO(false));
			}			
		}
		
		return resultado;
	}
	
	public VOAlumno listarDatosAlumno(String ci) {
		return this.find(ci).toVO(true);
	}
}
