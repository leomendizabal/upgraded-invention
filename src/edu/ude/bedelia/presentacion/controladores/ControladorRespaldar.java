package edu.ude.bedelia.presentacion.controladores;

import java.rmi.RemoteException;

import edu.ude.bedelia.logica.excepciones.SistemaException;
import edu.ude.bedelia.persistencia.excepciones.PersistenciaException;
import edu.ude.bedelia.presentacion.panel.listener.IMensaje;

public class ControladorRespaldar extends Controlador implements Controlador.IRespaldar {

	private IMensaje listener;
	private static ControladorRespaldar instancia = null;

	private ControladorRespaldar(IMensaje listener) {
		super();
		this.listener = listener;
	}

	public synchronized static ControladorRespaldar getInstance(IMensaje listener) {
		if (null == instancia) {
			instancia = new ControladorRespaldar(listener);
		}
		return instancia;
	}

	@Override
	public void respaldar(String... argumentos) {
		// TODO Auto-generated method stub
		try {
			fachada.respaldarDatos();
			listener.mostrarConfirmacion("Respaldar", "se han respaldado los datos");
		} catch (RemoteException | SistemaException | PersistenciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			listener.mostrarError("Respaldar", e.getMessage());
		}
		
	}

}