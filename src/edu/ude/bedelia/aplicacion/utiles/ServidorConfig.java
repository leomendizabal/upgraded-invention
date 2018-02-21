package edu.ude.bedelia.aplicacion.utiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import edu.ude.bedelia.persistencia.utiles.Constantes;

public class ServidorConfig extends Configuracion {

	private static ServidorConfig instance;
	private static long timeStamp;

	private ServidorConfig() {
		super();

		try {
			properties.load(new FileInputStream(Constantes.Servidor.RUTA_CONFIG));
			ip = properties.getProperty(Constantes.Servidor.CLAVE_IP, Constantes.Servidor.IP_POR_DEFECTO);
			puerto = properties.getProperty(Constantes.Servidor.CLAVE_PUERTO, Constantes.Servidor.PUERTO_POR_DEFECTO);
			objeto = properties.getProperty(Constantes.Servidor.CLAVE_OBJETO);
			properties.clear();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}

	}

	public static synchronized ServidorConfig getInstance() {

		if (null == instance || seActualizoArchivo(Constantes.Servidor.RUTA_CONFIG)) {
			instance = new ServidorConfig();
		}

		return instance;

	}

	private static boolean seActualizoArchivo(String path) {
		boolean seActualizo = false;
		final long ultimaModificacion = ultimaModificacion(path);

		if (timeStamp != ultimaModificacion) {
			timeStamp = ultimaModificacion;
			seActualizo = true;
		}
		return seActualizo;
	}

}
