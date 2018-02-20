package edu.ude.bedelia.persistencia.fachada;

import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;

import edu.ude.bedelia.logica.colecciones.Alumnos;
import edu.ude.bedelia.logica.entidades.Alumno;
import edu.ude.bedelia.logica.utiles.Monitor;
import edu.ude.bedelia.persistencia.excepciones.PersistenciaException;
import edu.ude.bedelia.persistencia.vo.VODatoAlumnos;
import edu.ude.bedelia.persistencia.vo.VOGenerico;

public class FachadaPersistencia {

	private static FachadaPersistencia instance;

	private Monitor monitor;

	private FachadaPersistencia() {
		monitor = new Monitor();
	}

	public static synchronized FachadaPersistencia getInstance() {

		if (null == instance) {
			instance = new FachadaPersistencia();
		}

		return instance;

	}

	public void respaldarDatos(Alumnos alumnos) {
		monitor.comienzoEscritura();
		try {
			Respaldo<Alumnos> respaldo = new Respaldo<Alumnos>();
			respaldo.respaldar(respaldo.ruta, new VODatoAlumnos(alumnos));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PersistenciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		monitor.terminoEscritura();
	}

	//TODO: esto no esta terminado
	public void recuperarDatos() {
		monitor.comienzoEscritura();
		try {
			Respaldo<Alumnos> respaldo = new Respaldo<Alumnos>();
			VOGenerico<Alumnos> vo = (VOGenerico<Alumnos>) respaldo.recuperar(respaldo.ruta);
			Optional<VOGenerico> op = Optional.of(vo);
			if (op.isPresent()) {
				Alumnos diccio = vo.getObjeto();
				Iterator<Alumno> iter = diccio.values().iterator();
				while (iter.hasNext()) {
					final Alumno a = iter.next();
					System.out.println(a.toString());

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PersistenciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		monitor.terminoEscritura();
	}

}
