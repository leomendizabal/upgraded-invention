package edu.ude.bedelia.aplicacion.utiles;

import java.io.FileInputStream;
import java.io.IOException;

public class ServidorConfig extends Configuracion {

	private static ServidorConfig instance;
	private String mockear;

	private ServidorConfig() {
		super();

		try {
			properties.load(new FileInputStream(AppConstantes.Servidor.RUTA_CONFIG));
			ip = properties.getProperty(AppConstantes.Servidor.CLAVE_IP, AppConstantes.Servidor.IP_POR_DEFECTO);
			puerto = properties.getProperty(AppConstantes.Servidor.CLAVE_PUERTO,
					AppConstantes.Servidor.PUERTO_POR_DEFECTO);
			objeto = properties.getProperty(AppConstantes.Servidor.CLAVE_OBJETO,
					AppConstantes.Servidor.OBJETO_POR_DEFECTO);
			mockear = properties.getProperty(AppConstantes.Servidor.CLAVE_MOCK, AppConstantes.Servidor.MOCKEADO);
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

	public boolean mockear() {
		return !mockear.equalsIgnoreCase(AppConstantes.Servidor.MOCKEADO);
	}

}
