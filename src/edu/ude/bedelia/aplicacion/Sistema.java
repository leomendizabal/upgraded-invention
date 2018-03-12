package edu.ude.bedelia.aplicacion;

import java.rmi.Naming;

import edu.ude.bedelia.aplicacion.utiles.ClienteConfig;
import edu.ude.bedelia.aplicacion.utiles.UrlBuilder;
import edu.ude.bedelia.logica.fachada.IFachada;
import edu.ude.bedelia.presentacion.frame.JFrameError;
import edu.ude.bedelia.presentacion.frame.JFrameSplash;

public class Sistema {

	private static Sistema instancia;
	private static IFachada fachadaInstance;

	public static Sistema getInstancia() {
		if (instancia == null) {
			instancia = new Sistema();
		}

		return instancia;
	}

	public IFachada getFachadaInstance() {
		return fachadaInstance;
	}

	public static void setFachadaInstance(IFachada fachadaInstance) {
		Sistema.fachadaInstance = fachadaInstance;
	}

	public static void main(String[] args) {
		try {

			final ClienteConfig config = ClienteConfig.getInstance();

			final String puerto = config.getPuerto();
			final String ip = config.getIp();
			final String objeto = config.getObjeto();

			String url = UrlBuilder.buildUrl(ip, Integer.parseInt(puerto), objeto);
			System.out.println("URL ==> " + url);
			IFachada fachada = (IFachada) Naming.lookup(url);
			setFachadaInstance(fachada);
			new JFrameSplash().initPorDefecto();

		} catch (Exception e) {
			System.err.println(e.getMessage());
			// Error Pantalla
			new JFrameError();
		}

	}

}
