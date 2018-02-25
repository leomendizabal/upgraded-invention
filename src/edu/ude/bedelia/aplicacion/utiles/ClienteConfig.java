package edu.ude.bedelia.aplicacion.utiles;

import java.io.FileInputStream;
import java.io.IOException;

import edu.ude.bedelia.persistencia.utiles.Constantes;

public class ClienteConfig extends Configuracion {

	private static ClienteConfig instance;
	private static long timeStamp;

	private ClienteConfig() {
		super();

		try {
			properties.load(new FileInputStream(Constantes.Cliente.RUTA_CONFIG));
			ip = properties.getProperty(Constantes.Cliente.CLAVE_IP, Constantes.Cliente.IP_POR_DEFECTO);
			puerto = properties.getProperty(Constantes.Cliente.CLAVE_PUERTO, Constantes.Cliente.PUERTO_POR_DEFECTO);
			objeto = properties.getProperty(Constantes.Cliente.CLAVE_OBJETO);

		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}

	public static synchronized ClienteConfig getInstance() {

		if (null == instance || seActualizoArchivo(Constantes.Cliente.RUTA_CONFIG)) {
			instance = new ClienteConfig();
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
