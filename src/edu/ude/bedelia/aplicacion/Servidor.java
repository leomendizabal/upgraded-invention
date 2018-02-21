package edu.ude.bedelia.aplicacion;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import edu.ude.bedelia.aplicacion.utiles.ServidorConfig;
import edu.ude.bedelia.aplicacion.utiles.UrlBuilder;
import edu.ude.bedelia.logica.fachada.Fachada;
import edu.ude.bedelia.logica.fachada.IFachada;

public class Servidor {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			IFachada fachada = Fachada.getInstancia();
			final ServidorConfig config = ServidorConfig.getInstance(); 
			
			final String puerto = config.getPuerto();
			final String ip = config.getIp();
			final String objeto = config.getObjeto();
			
			int puertoInt = Integer.parseInt(puerto);
			LocateRegistry.createRegistry(puertoInt);
			System.out.println ("Antes de publicarlo");
			String url = UrlBuilder.buildUrl(ip, puertoInt, objeto);
			Naming.rebind(url, fachada);
			System.out.println("Se publico el servidor");
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
