package edu.ude.bedelia.aplicacion.utiles;

import java.io.FileInputStream;
import java.io.IOException;

public class ClienteConfig extends Configuracion {

	private static ClienteConfig instance;

	private ClienteConfig() {
		super();
		try {
			properties.load(new FileInputStream(AppConstantes.Cliente.RUTA_CONFIG));
			ip = properties.getProperty(AppConstantes.Cliente.CLAVE_IP, AppConstantes.Cliente.IP_POR_DEFECTO);
			puerto = properties.getProperty(AppConstantes.Cliente.CLAVE_PUERTO,
					AppConstantes.Cliente.PUERTO_POR_DEFECTO);
			objeto = properties.getProperty(AppConstantes.Cliente.CLAVE_OBJETO,
					AppConstantes.Cliente.OBJETO_POR_DEFECTO);

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
