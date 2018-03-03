package edu.ude.bedelia.presentacion.controladores;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.ude.bedelia.aplicacion.utiles.ClienteConfig;
import edu.ude.bedelia.aplicacion.utiles.UrlBuilder;
import edu.ude.bedelia.logica.fachada.IFachada;
import edu.ude.bedelia.logica.vo.VOAlumno;
import edu.ude.bedelia.presentacion.panel.listado.JPanelListadoAlumnos;

public class ControladorListadoAlumnos {
	private IFachada fachada;
	private JPanelListadoAlumnos panel;

	public ControladorListadoAlumnos(JPanelListadoAlumnos v) {
		panel = v;
		try {

			final ClienteConfig config = ClienteConfig.getInstance();

			final String puerto = config.getPuerto();
			final String ip = config.getIp();
			final String objeto = config.getObjeto();

			String url = UrlBuilder.buildUrl(ip, Integer.parseInt(puerto), objeto);
			System.out.println("URL ==> " + url);
			fachada = (IFachada) Naming.lookup(url);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public ArrayList<VOAlumno> getAlumnosApellido(String apellido) {
		ArrayList<VOAlumno> resultado = new ArrayList<VOAlumno>();

		try {
			resultado = fachada.listarAlumnosApellido(apellido);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultado;
	}

}
