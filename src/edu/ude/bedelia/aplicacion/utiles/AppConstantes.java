package edu.ude.bedelia.aplicacion.utiles;

public final class AppConstantes {

	public final class Servidor {

		public final static String RUTA_CONFIG = "config/server_config.properties";
		public final static String CLAVE_IP = "ipServidor";
		public final static String CLAVE_PUERTO = "puertoServidor";
		public final static String CLAVE_OBJETO = "objeto";
		public final static String CLAVE_MOCK = "mock";

		public final static String IP_POR_DEFECTO = "localhost";
		public final static String PUERTO_POR_DEFECTO = "1099";
		public final static String OBJETO_POR_DEFECTO = "objeto";
		public final static String MOCKEADO = "false";

	}

	public final class Cliente {

		public final static String RUTA_CONFIG = "config/client_config.properties";
		public final static String CLAVE_IP = "ipServidor";
		public final static String CLAVE_PUERTO = "puertoServidor";
		public final static String CLAVE_OBJETO = "objeto";

		public final static String IP_POR_DEFECTO = "localhost";
		public final static String PUERTO_POR_DEFECTO = "1099";
		public final static String OBJETO_POR_DEFECTO = "objeto";
	}
}
