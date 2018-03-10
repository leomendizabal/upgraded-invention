package edu.ude.bedelia.aplicacion.utiles;

import java.util.Properties;

public abstract class Configuracion {

	protected final Properties properties = new Properties();
	protected String ip = AppConstantes.Servidor.IP_POR_DEFECTO;
	protected String puerto = AppConstantes.Servidor.IP_POR_DEFECTO;
	protected String objeto;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPuerto() {
		return puerto;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}

	public String getObjeto() {
		return objeto;
	}

	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}

	public Properties getProperties() {
		return properties;
	}

}
