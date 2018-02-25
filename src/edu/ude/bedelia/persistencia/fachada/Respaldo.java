package edu.ude.bedelia.persistencia.fachada;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Optional;
import java.util.Properties;

import edu.ude.bedelia.persistencia.excepciones.PersistenciaException;
import edu.ude.bedelia.persistencia.utiles.Constantes;
import edu.ude.bedelia.persistencia.vo.VOGenerico;

public class Respaldo<T1, T2> implements IRespaldo<VOGenerico<T1, T2>> {

	public final String ruta;
	private final Properties p = new Properties();

	public Respaldo() throws FileNotFoundException, IOException {
		super();
		p.load(new FileInputStream(Constantes.Respaldo.RUTA_CONFIG));
		this.ruta = p.getProperty(Constantes.Respaldo.CLAVE_RUTA_RESPALDO, Constantes.Respaldo.RUTA_POR_DEFECTO);
	}

	public String getRuta() {
		return ruta;
	}

	@Override
	public void respaldar(String nombreArchivo, VOGenerico<T1, T2> objeto) throws PersistenciaException {
		FileOutputStream archivoLocal = null;
		ObjectOutputStream buffer = null;
		try {
			archivoLocal = new FileOutputStream(nombreArchivo);
			buffer = new ObjectOutputStream(archivoLocal);
			buffer.writeObject(objeto);
			buffer.close();
			archivoLocal.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			throw new PersistenciaException(Constantes.Mensajes.MSG_ERROR_PERSISTENCIA);
		} finally {
			Optional<FileOutputStream> chequeoFile = Optional.of(archivoLocal);
			if (chequeoFile.isPresent()) {
				archivoLocal = null;
			}
			Optional<ObjectOutputStream> chequeoBuffer = Optional.of(buffer);
			if (chequeoBuffer.isPresent()) {
				buffer = null;
			}
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public VOGenerico<T1, T2> recuperar(String nombreArchivo) throws PersistenciaException {
		try {
			FileInputStream fileInputStream = new FileInputStream(nombreArchivo);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			VOGenerico<T1, T2> datos = (VOGenerico<T1, T2>) objectInputStream.readObject();
			objectInputStream.close();
			fileInputStream.close();
			return datos;
		} catch (ClassNotFoundException | IOException e) {
			System.err.println(e.getMessage());
			throw new PersistenciaException(Constantes.Mensajes.MSG_ERROR_RECUPERAR);
		}
	}

}
