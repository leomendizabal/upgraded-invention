package edu.ude.bedelia.presentacion.controladores;

import java.rmi.RemoteException;

import edu.ude.bedelia.logica.excepciones.AlumnosException;
import edu.ude.bedelia.logica.vo.TipoAlumno;
import edu.ude.bedelia.logica.vo.VOAlumnoCompleto;
import edu.ude.bedelia.logica.vo.VOBecadoCompleto;
import edu.ude.bedelia.presentacion.Helper;
import edu.ude.bedelia.presentacion.UIConstantes.MensajeTitulo;
import edu.ude.bedelia.presentacion.UIConstantes.MensajesConfirmacion;
import edu.ude.bedelia.presentacion.UIConstantes.MensajesError;
import edu.ude.bedelia.presentacion.panel.listener.IMensaje;

public class ControladorRegistrarAlumno extends Controlador implements Controlador.IRegistrar {

	private static final String TAG = ControladorRegistrarAlumno.class.getSimpleName().concat("  %s");
	private IMensaje listener;
	private static ControladorRegistrarAlumno instancia = null;

	protected ControladorRegistrarAlumno(IMensaje listener) {
		super();
		this.listener = listener;
	}

	public synchronized static ControladorRegistrarAlumno getInstance(IMensaje listener) {
		if (null == instancia) {
			instancia = new ControladorRegistrarAlumno(listener);
		}
		return instancia;
	}

	@Override
	public void registrar(boolean extra, String... argumentos) {
		try {
			if (Helper.isEmpty(argumentos)) {
				listener.mostrarError(MensajeTitulo.TITULO_ERROR, MensajesError.ERROR_CAMPO);
			} else {
				VOAlumnoCompleto voAlumno;
				if (extra) {
					voAlumno = new VOBecadoCompleto(argumentos[0], argumentos[1], argumentos[2], TipoAlumno.BECADO,
							argumentos[3], argumentos[4], argumentos[5], Float.parseFloat(argumentos[6]),
							argumentos[7]);
				} else {
					voAlumno = new VOAlumnoCompleto(argumentos[0], argumentos[1], argumentos[2], TipoAlumno.COMUN,
							argumentos[3], argumentos[4], argumentos[5]);
				}
				fachada.registrarAlumno(voAlumno);
				listener.mostrarConfirmacion(MensajeTitulo.TITULO_REGISTRAR,
						MensajesConfirmacion.CONF_REGISTRAR_ALUMNO);
			}

		} catch (AlumnosException e) {
			System.err.println(String.format(TAG, e.getMessage()));
			listener.mostrarError(MensajeTitulo.TITULO_REGISTRAR_ALUMNO, MensajesError.ERROR_REGISTRAR_ALUMNO);
		} catch (RemoteException r) {
			System.err.println(String.format(TAG, r.getMessage()));
			listener.mostrarError(MensajeTitulo.TITULO_ERROR, MensajesError.ERROR_CONEXION);
		} catch (NumberFormatException e) {
			System.err.println(String.format(TAG, e.getMessage()));
			listener.mostrarError(MensajeTitulo.TITULO_ERROR, MensajesError.ERROR_FORMATO_PARAMETRO);
		}
	}

}
