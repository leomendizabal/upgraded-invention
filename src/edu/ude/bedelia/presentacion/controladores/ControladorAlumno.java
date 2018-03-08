package edu.ude.bedelia.presentacion.controladores;

import java.rmi.RemoteException;

import edu.ude.bedelia.logica.excepciones.AlumnosException;
import edu.ude.bedelia.logica.utiles.Mensajes;
import edu.ude.bedelia.logica.vo.TipoAlumno;
import edu.ude.bedelia.logica.vo.VOAlumno;
import edu.ude.bedelia.logica.vo.VOAlumnoCompleto;
import edu.ude.bedelia.logica.vo.VOBecadoCompleto;
import edu.ude.bedelia.presentacion.panel.listener.IMensaje;
import edu.ude.bedelia.presentacion.Helper;
import edu.ude.bedelia.presentacion.UIConstantes;
import edu.ude.bedelia.presentacion.UIConstantes.MensajeTitulo;
import edu.ude.bedelia.presentacion.UIConstantes.MensajesConfirmacion;
import edu.ude.bedelia.presentacion.UIConstantes.MensajesError;

public class ControladorAlumno extends Controlador implements Controlador.IRegistrar {

	private IMensaje listener;
	private static ControladorAlumno instancia = null;

	protected ControladorAlumno(IMensaje listener) {
		super();
		this.listener = listener;
	}

	public synchronized static ControladorAlumno getInstance(IMensaje listener) {
		if (null == instancia) {
			instancia = new ControladorAlumno(listener);
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
							argumentos[3], argumentos[4], argumentos[5], Float.valueOf(argumentos[6]), argumentos[7]);
				} else {
					voAlumno = new VOAlumnoCompleto(argumentos[0], argumentos[1], argumentos[2], TipoAlumno.COMUN,
							argumentos[3], argumentos[4], argumentos[5]);
				}
				fachada.registrarAlumno(voAlumno);
				listener.mostrarConfirmacion(MensajeTitulo.TITULO_REGISTRAR, MensajesConfirmacion.CONF_REGISTRAR_ALUMNO);
			}
			
		} catch (AlumnosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			listener.mostrarError(MensajeTitulo.TITULO_REGISTRAR_ALUMNO, MensajesError.ERROR_REGISTRAR_ALUMNO);
		} catch (RemoteException r) {
			listener.mostrarError(MensajeTitulo.TITULO_ERROR, MensajesError.ERROR_CONEXION);
		}
	}

}
