package edu.ude.bedelia.persistencia.fachada;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import edu.ude.bedelia.logica.colecciones.Alumnos;
import edu.ude.bedelia.logica.colecciones.Asignaturas;
import edu.ude.bedelia.persistencia.excepciones.PersistenciaException;
import edu.ude.bedelia.persistencia.utiles.Constantes;
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
			final String ruta = respaldo.getRuta();
			if (existeRespaldo()) {
				new File(ruta).delete();
			}
			respaldo.respaldar(ruta, new VODato(alumnos, asignaturas));
		} catch (IOException | PersistenciaException e) {
			throw new PersistenciaException(Constantes.Mensajes.MSG_ERROR_PERSISTENCIA);
		}

	}

	public VODato recuperarDatos() throws PersistenciaException {
		VODato resultado = new VODato(new Alumnos(), new Asignaturas(0));
		try {
			Respaldo<Alumnos, Asignaturas> respaldo = new Respaldo<Alumnos, Asignaturas>();
			VOGenerico<Alumnos, Asignaturas> vo = (VOGenerico<Alumnos, Asignaturas>) respaldo.recuperar(respaldo.ruta);
			Optional<VOGenerico<Alumnos, Asignaturas>> op = Optional.of(vo);
			if (op.isPresent()) {
				resultado = new VODato(vo.getDiccionario(), vo.getSecuencia());
			}
			return resultado;
		} catch (IOException | PersistenciaException e) {
			throw new PersistenciaException(Constantes.Mensajes.MSG_ERROR_RECUPERAR);
		}
	}

	public boolean existeRespaldo() {
		try {
			Respaldo<Alumnos, Asignaturas> respaldo = new Respaldo<Alumnos, Asignaturas>();
			return new File(respaldo.ruta).exists();
		} catch (NullPointerException | IOException e) {
			System.err.println(e.getMessage());
			return false;
		}

	}

}
