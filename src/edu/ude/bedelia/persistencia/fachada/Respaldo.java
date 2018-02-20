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

public class Respaldo<T> implements IRespaldo<VOGenerico<T>> {

	public final String ruta;
	private final Properties p = new Properties();

	public Respaldo() throws FileNotFoundException, IOException {
		super();
		p.load(new FileInputStream(Constantes.Respaldo.RUTA_CONFIG));
		this.ruta = p.getProperty(Constantes.Respaldo.CLAVE_RUTA_RESPALDO);
	}

	public String getRuta() {
		return ruta;
	}

	@Override
	public void respaldar(String nombreArchivo, VOGenerico<T> objeto) throws PersistenciaException {
		try {
			FileOutputStream archivoLocal = new FileOutputStream(nombreArchivo);
			ObjectOutputStream buffer = new ObjectOutputStream(archivoLocal);
			buffer.writeObject(objeto);
			buffer.close();
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new PersistenciaException("");
		}

	}

	@Override
	public VOGenerico<T> recuperar(String nombreArchivo) throws PersistenciaException {
		try {
			FileInputStream f = new FileInputStream(nombreArchivo);
			ObjectInputStream o = new ObjectInputStream(f);
			VOGenerico<T> r = (VOGenerico<T>) o.readObject();
			o.close();
			f.close();
			return r;
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			throw new PersistenciaException("");
		}
	}

}
