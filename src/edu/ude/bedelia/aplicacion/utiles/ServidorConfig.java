package edu.ude.bedelia.aplicacion.utiles;

import java.io.FileInputStream;
import java.io.IOException;

import edu.ude.bedelia.persistencia.utiles.Constantes;

public class ServidorConfig extends Configuracion {

	private static ServidorConfig instance;

	private ServidorConfig() {
		super();

		try {
			properties.load(new FileInputStream(Constantes.Servidor.RUTA_CONFIG));
			ip = properties.getProperty(Constantes.Servidor.CLAVE_IP, Constantes.Servidor.IP_POR_DEFECTO);
			puerto = properties.getProperty(Constantes.Servidor.CLAVE_PUERTO, Constantes.Servidor.PUERTO_POR_DEFECTO);
			objeto = properties.getProperty(Constantes.Servidor.CLAVE_OBJETO);
			properties.clear();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}

	public static synchronized ServidorConfig getInstance() {

		if (null == instance) {
			instance = new ServidorConfig();
		}

		return instance;

	}

}
