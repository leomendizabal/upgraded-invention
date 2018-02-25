package edu.ude.bedelia.persistencia.utiles;

public final class Constantes {

	public final class Respaldo {
		public final static String CLAVE_RUTA_RESPALDO = "rutaRespaldo";
		public final static String RUTA_CONFIG = "config/app_config.properties";
		public final static String RUTA_POR_DEFECTO = "config/respaldo.dat";
	}

	public final class Mensajes {
		public final static String MSG_NO_EXISTE_ARCHIVO = "El archivo %s no extiste";
		public final static String MSG_ERROR_PERSISTENCIA = "Ocurrio un error al persistir los datos";
		public final static String MSG_ERROR_RECUPERAR = "Ocurrio un error al recuperar los datos";
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

		public final static String RUTA_CONFIG = "config/client_config.properties";
		public final static String CLAVE_IP = "ipServidor";
		public final static String CLAVE_PUERTO = "puertoServidor";
		public final static String CLAVE_OBJETO = "objeto";

		public final static String IP_POR_DEFECTO = "localhost";
		public final static String PUERTO_POR_DEFECTO = "1099";
	}
}
