package edu.ude.bedelia.persistencia.fachada;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
		//TODO:incluir valores por defecto
		this.ruta = p.getProperty(Constantes.Respaldo.CLAVE_RUTA_RESPALDO);
	}

	public String getRuta() {
		return ruta;
	}

	@Override
	public void respaldar(String nombreArchivo, VOGenerico<T1, T2> objeto) throws PersistenciaException {
		try {
			FileOutputStream archivoLocal = new FileOutputStream(nombreArchivo);
			ObjectOutputStream buffer = new ObjectOutputStream(archivoLocal);
			buffer.writeObject(objeto);
			buffer.close();
			buffer.close();
			System.out.println("Respaldo OK");
		} catch (IOException e) {
			e.printStackTrace();
			// TODO: Determinar el error
			throw new PersistenciaException("");
		}

	}

	@Override
	public VOGenerico<T1, T2> recuperar(String nombreArchivo) throws PersistenciaException {
		try {
			FileInputStream fileInputStream = new FileInputStream(nombreArchivo);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			VOGenerico<T1, T2> datos = null;

			datos = (VOGenerico<T1, T2>) objectInputStream.readObject();

			objectInputStream.close();
			fileInputStream.close();
			return datos;
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			// TODO: Determinar el error
			throw new PersistenciaException("");
		}
	}

}
