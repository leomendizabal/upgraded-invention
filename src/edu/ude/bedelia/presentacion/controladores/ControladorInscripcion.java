package edu.ude.bedelia.presentacion.controladores;

import java.rmi.RemoteException;

import edu.ude.bedelia.logica.excepciones.AlumnosException;
import edu.ude.bedelia.logica.excepciones.AsignaturasException;
import edu.ude.bedelia.logica.excepciones.InscripcionesException;
import edu.ude.bedelia.presentacion.Helper;
import edu.ude.bedelia.presentacion.UIConstantes.MensajeTitulo;
import edu.ude.bedelia.presentacion.UIConstantes.MensajesConfirmacion;
import edu.ude.bedelia.presentacion.UIConstantes.MensajesError;
import edu.ude.bedelia.presentacion.panel.listener.IMensaje;
import edu.ude.bedelia.presentacion.panel.listener.IMostrarMonto;

public class ControladorInscripcion extends Controlador
		implements Controlador.IMostrar<IMostrarMonto>, Controlador.IRegistrar {

	private IMensaje listener;
	private static ControladorInscripcion instancia = null;

	private ControladorInscripcion(IMensaje listener) {
		super();
		this.listener = listener;
	}

	public synchronized static ControladorInscripcion getInstance(IMensaje listener) {
		if (null == instancia) {
			instancia = new ControladorInscripcion(listener);
		}
		return instancia;
	}

	@Override
	public void mostrar(IMostrarMonto listener, String... argumentos) {
		// TODO Auto-generated method stub
		try {
			if (Helper.isEmpty(argumentos)) {
				listener.mostrarError(MensajeTitulo.TITULO_ERROR, MensajesError.ERROR_CAMPO);
			} else {
				float resultado = fachada.montoRecaudadoPorAlumno(Integer.parseInt(argumentos[1]), argumentos[0]);
				listener.mostrar(String.valueOf(resultado));
			}
		} catch (NumberFormatException | AlumnosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			listener.mostrarError(MensajeTitulo.TITULO_ERROR, e.getMessage());
		} catch (RemoteException r) {
			listener.mostrarError(MensajeTitulo.TITULO_ERROR, MensajesError.ERROR_CONEXION);
		}

	}

	@Override
	public void registrar(boolean extra, String... argumentos) {
		// TODO Auto-generated method stub
		try {
			if (Helper.isEmpty(argumentos)) {
				listener.mostrarError(MensajeTitulo.TITULO_ERROR, MensajesError.ERROR_CAMPO);
			} else {
				fachada.inscribirAlumno(argumentos[0], argumentos[1], Integer.parseInt(argumentos[2]),
						Float.parseFloat(argumentos[3]));
				listener.mostrarConfirmacion(MensajeTitulo.TITULO_REGISTRAR_INSCRIPCION,
						MensajesConfirmacion.CONF_REGISTRAR_INSCRIPCION);
			}
		} catch (AsignaturasException | NumberFormatException | AlumnosException | InscripcionesException e) {
			// TODO colocar error amigables
			listener.mostrarError(MensajeTitulo.TITULO_ERROR, e.getMessage());
		} catch (RemoteException r) {
			listener.mostrarError(MensajeTitulo.TITULO_ERROR, MensajesError.ERROR_CONEXION);

		}

	}

}
