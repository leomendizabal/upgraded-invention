package edu.ude.bedelia.aplicacion.utiles;

public final class UrlBuilder {

	public final static String TEM_URL = "//%s:%d/%s";

	public static String buildUrl(final String ip, final int port, final String mothod) {
		return String.format(TEM_URL, ip, port, mothod);
	}
}
