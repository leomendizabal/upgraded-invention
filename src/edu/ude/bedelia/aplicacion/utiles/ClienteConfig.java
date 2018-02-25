package edu.ude.bedelia.aplicacion.utiles;

import java.io.FileInputStream;
import java.io.IOException;

import edu.ude.bedelia.persistencia.utiles.Constantes;

public class ClienteConfig extends Configuracion {

	private static ClienteConfig instance;

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

		if (null == instance) {
			instance = new ClienteConfig();
		}

		return instance;

	}

}
