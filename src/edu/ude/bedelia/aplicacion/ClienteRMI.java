package edu.ude.bedelia.aplicacion;

import java.rmi.Naming;
import java.util.ArrayList;

import edu.ude.bedelia.aplicacion.utiles.ClienteConfig;
import edu.ude.bedelia.aplicacion.utiles.UrlBuilder;
import edu.ude.bedelia.logica.fachada.IFachada;
import edu.ude.bedelia.logica.vo.VOAlumno;

public class ClienteRMI {

	public static void main(String[] args) {
		try {

			final ClienteConfig config = ClienteConfig.getInstance();

			final String puerto = config.getPuerto();
			final String ip = config.getIp();
			final String objeto = config.getObjeto();

			String url = UrlBuilder.buildUrl(ip, Integer.parseInt(puerto), objeto);
			System.out.println("URL ==> " + url);
			IFachada fachada = (IFachada) Naming.lookup(url);

			Cliente.correrPruebas(fachada);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
