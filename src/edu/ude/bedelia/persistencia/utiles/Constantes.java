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

}
