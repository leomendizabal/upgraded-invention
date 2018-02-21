package edu.ude.bedelia.persistencia.utiles;

public final class Constantes {

	public final class Respaldo {
		public final static String CLAVE_RUTA_RESPALDO = "rutaRespaldo";
		public final static String RUTA_CONFIG = "config/app_config.properties";
	}

	public final class Mensajes {
		public final static String MSG_NO_EXISTE_ARCHIVO = "El archivo %s no extiste";
	}

	public final class Servidor {

		public final static String RUTA_CONFIG = "config/server_config.properties";
		public final static String CLAVE_IP = "ipServidor";
		public final static String CLAVE_PUERTO = "puertoServidor";
		public final static String CLAVE_OBJETO = "objeto";

		public final static String IP_POR_DEFECTO = "localhost";
		public final static String PUERTO_POR_DEFECTO = "1099";

	}

	public final class Cliente {
		// TODO: Ver nombre correcto
		public final static String RUTA_CONFIG = "config/client_config.properties";
		public final static String CLAVE_IP = "ipServidor";
		public final static String CLAVE_PUERTO = "puertoServidor";
		public final static String CLAVE_OBJETO = "objeto";

		public final static String IP_POR_DEFECTO = "localhost";
		public final static String PUERTO_POR_DEFECTO = "1099";
	}
}
