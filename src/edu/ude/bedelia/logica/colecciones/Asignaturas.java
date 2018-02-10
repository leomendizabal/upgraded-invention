package edu.ude.bedelia.logica.colecciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.ude.bedelia.logica.entidades.Asignatura;
import edu.ude.bedelia.logica.vo.VOAsignatura;

public class Asignaturas extends DiccionarioTreeMap<String, Asignatura> {
	
	
	
	
	public Asignaturas() {
		super();
	}

	public VOAsignatura[] listarAsignaturas() {
		final List<Asignatura> asignaturas = new ArrayList<Asignatura>(this.values());
		VOAsignatura[] result = new VOAsignatura[asignaturas.size()];
		int indice = 0;
		for (Asignatura a: asignaturas) {
			result[indice] = new VOAsignatura(a.getCodigo(), a.getNombre(), a.getDescripcion());
			indice++;
		}
		return result;
		
	}

}
