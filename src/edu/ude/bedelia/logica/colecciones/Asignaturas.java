package edu.ude.bedelia.logica.colecciones;

import java.util.Iterator;
import edu.ude.bedelia.logica.entidades.Asignatura;
import edu.ude.bedelia.logica.utiles.Constantes;
import edu.ude.bedelia.logica.utiles.Mensajes;
import edu.ude.bedelia.logica.vo.VOAsignatura;

public class Asignaturas extends SecuenciaArrayList<Asignatura>{
	
	public Asignaturas() {
		super(Constantes.CANTIDAD_MATERIAS);
	}
	
	@Override
	public void insert(Asignatura element) throws ArrayIndexOutOfBoundsException {
		if(this.size() == Constantes.CANTIDAD_MATERIAS) {
			throw new ArrayIndexOutOfBoundsException(String.format(Mensajes.MSG_MAXIMO_MATERIAS_SUPERADO, Constantes.CANTIDAD_MATERIAS));
		} else {
			super.insert(element);
		}
	}

	public VOAsignatura[] listarAsignaturas() {
		final Iterator<Asignatura> it = this.iterator();
		VOAsignatura[] result = new VOAsignatura[this.size()];
		int indice = 0;
		while (it.hasNext()) {
			result[indice] = it.next().toVO();
			indice++;
		}
		return result;
		
	}
	
	public boolean pertenece(String cod) {
		boolean esta=false;
		int indice = 0;
		while ( (indice<secuencia.size()) &&  (!esta) ) {
		   Asignatura as=secuencia.get(indice);
		   if (cod.equals(as.getCodigo()))
			  esta=true;
		   else
			   indice++;
		}
		
		return esta;
	}
	
	
	public Asignatura devolverAsignatura (String cod) {
		
		int indice = 0;
		Asignatura as=secuencia.get(indice);
		while ( !(cod.equals(as.getCodigo())) ) {
			indice++;
			as=secuencia.get(indice);
		   
		}
		
		return as;
	}
	
	

}
