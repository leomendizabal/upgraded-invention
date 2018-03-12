package edu.ude.bedelia.presentacion.controladores;

import java.rmi.RemoteException;

import edu.ude.bedelia.logica.excepciones.AlumnosException;
import edu.ude.bedelia.logica.excepciones.InscripcionesException;
import edu.ude.bedelia.presentacion.Helper;
import edu.ude.bedelia.presentacion.UIConstantes.MensajeTitulo;
import edu.ude.bedelia.presentacion.UIConstantes.MensajesConfirmacion;
import edu.ude.bedelia.presentacion.UIConstantes.MensajesError;
import edu.ude.bedelia.presentacion.panel.listener.IMensaje;

public class ControladorRegistrarResultado extends Controlador implements Controlador.IRegistrar {

	private static final String TAG = ControladorRegistrarResultado.class.getSimpleName().concat("   %s");
	private IMensaje listener;
	private static ControladorRegistrarResultado instancia = null;

	public ControladorRegistrarResultado(IMensaje listener) {
		super();
		this.listener = listener;
	}

	public synchronized static ControladorRegistrarResultado getInstance(IMensaje listener) {
		if (null == instancia) {
			instancia = new ControladorRegistrarResultado(listener);
		}
		return instancia;
	}

	@Override
	public void registrar(boolean extra, String... argumento) {
		try {
			if (Helper.isEmpty(argumento)) {
				listener.mostrarError(MensajeTitulo.TITULO_ERROR, MensajesError.ERROR_CAMPO);
			} else {
				fachada.registrarResultado(argumento[0], Integer.parseInt(argumento[1]), Integer.parseInt(argumento[2]),
						Integer.valueOf(argumento[3]));
				listener.mostrarConfirmacion(MensajeTitulo.TITULO_REGISTRAR_RESULTADO,
						MensajesConfirmacion.CONF_REGISTRAR_RESULTADO);
			}
		} catch (RemoteException e) {
			System.err.println(String.format(TAG, e.getMessage()));
			listener.mostrarError(MensajeTitulo.TITULO_ERROR, MensajesError.ERROR_CONEXION);
		} catch (NumberFormatException e) {
			System.err.println(String.format(TAG, e.getMessage()));
			listener.mostrarError(MensajeTitulo.TITULO_ERROR, MensajesError.ERROR_FORMATO_PARAMETRO);
		} catch (AlumnosException e) {
			System.err.println(String.format(TAG, e.getMessage()));
			listener.mostrarError(MensajeTitulo.TITULO_ERROR, e.getMessage());
		} catch (InscripcionesException e) {
			// TODO Auto-generated catch block
			System.err.println(String.format(TAG, e.getMessage()));
			listener.mostrarError(MensajeTitulo.TITULO_ERROR, e.getMessage());
		}
	}

}
