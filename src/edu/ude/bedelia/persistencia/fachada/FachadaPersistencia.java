package edu.ude.bedelia.persistencia.fachada;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;

import edu.ude.bedelia.logica.colecciones.Alumnos;
import edu.ude.bedelia.logica.colecciones.Asignaturas;
import edu.ude.bedelia.logica.entidades.Alumno;
import edu.ude.bedelia.persistencia.excepciones.PersistenciaException;
import edu.ude.bedelia.persistencia.vo.VODato;
import edu.ude.bedelia.persistencia.vo.VOGenerico;

public class FachadaPersistencia {

	private static FachadaPersistencia instance;

	private FachadaPersistencia() {

	}

	public static FachadaPersistencia getInstance() {

		if (null == instance) {
			instance = new FachadaPersistencia();
		}

		return instance;

	}

	public void respaldarDatos(Alumnos alumnos, Asignaturas asignaturas) throws PersistenciaException {

		try {
			Respaldo<Alumnos, Asignaturas> respaldo = new Respaldo<Alumnos, Asignaturas>();
			respaldo.respaldar(respaldo.ruta, new VODato(alumnos, asignaturas));
		} catch (IOException | PersistenciaException e) {
			throw new PersistenciaException("Ver el mensaje");
		}

	}

	// TODO: esto no esta terminado, ver de mover lo a la capa logica
	public void recuperarDatos() {

		try {
			Respaldo<Alumnos, Asignaturas> respaldo = new Respaldo<Alumnos, Asignaturas>();
			VOGenerico<Alumnos, Asignaturas> vo = (VOGenerico<Alumnos, Asignaturas>) respaldo.recuperar(respaldo.ruta);
			Optional<VOGenerico<Alumnos, Asignaturas>> op = Optional.of(vo);
			if (op.isPresent()) {
				Alumnos diccio = vo.getDiccionario();
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
	}

	public boolean existeRespaldo() {
		try {
			Respaldo<Alumnos, Asignaturas> respaldo = new Respaldo<Alumnos, Asignaturas>();
			return new File(respaldo.ruta).exists();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

}
