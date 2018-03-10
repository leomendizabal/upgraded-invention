package edu.ude.bedelia.presentacion.controladores;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import edu.ude.bedelia.logica.excepciones.AlumnosException;
import edu.ude.bedelia.logica.vo.VOAlumno;
import edu.ude.bedelia.logica.vo.VOAlumnoCompleto;
import edu.ude.bedelia.presentacion.Helper;
import edu.ude.bedelia.presentacion.UIConstantes.MensajeTitulo;
import edu.ude.bedelia.presentacion.UIConstantes.MensajesConfirmacion;
import edu.ude.bedelia.presentacion.UIConstantes.MensajesError;
import edu.ude.bedelia.presentacion.panel.listener.IModificarDatos;
import edu.ude.bedelia.presentacion.vo.VOPresentacionAlumno;

public class ControlladorModificarAlumno extends Controlador implements Controlador.IBuscar, Controlador.IModificar {

	private IModificarDatos listener;
	private static ControlladorModificarAlumno instancia = null;
	private VOAlumnoCompleto instanciaAlumno = null;

	private ControlladorModificarAlumno(IModificarDatos listener) {
		super();
		this.listener = listener;
	}

	public synchronized static ControlladorModificarAlumno getInstance(IModificarDatos listener) {
		if (null == instancia) {
			instancia = new ControlladorModificarAlumno(listener);
		}
		return instancia;
	}

	@Override
	public void buscar(String... argumentos) {
		try {
			if (Helper.isEmpty(argumentos)) {
				listener.mostrarError(MensajeTitulo.TITULO_ERROR, MensajesError.ERROR_CAMPO);
			} else {
				final Map<String, String> mapeo = new HashMap<String, String>();
				VOAlumno alumno = fachada.listarDatosAlumno(argumentos[0]);
				if (alumno instanceof VOAlumnoCompleto) {
					instanciaAlumno = (VOAlumnoCompleto) alumno;
					listener.mostrarDatos(new VOPresentacionAlumno(instanciaAlumno));
				} else {
					listener.mostrarError(MensajeTitulo.TITULO_BUSCAR, MensajesError.ERROR_DATOS_ALUMNO);
				}
			}
		} catch (AlumnosException e) {
			e.printStackTrace();
			listener.mostrarError(MensajeTitulo.TITULO_BUSCAR, e.getMessage());
		} catch (RemoteException r) {
			listener.mostrarError(MensajeTitulo.TITULO_ERROR, MensajesError.ERROR_CONEXION);
		}

	}

	@Override
	public void modificar(String... argumentos) {
		// TODO Auto-generated method stub
		if (Helper.isEmpty(argumentos)) {
			listener.mostrarError(MensajeTitulo.TITULO_ERROR, MensajesError.ERROR_CAMPO);
		} else {
			if (instanciaAlumno != null) {
				instanciaAlumno.setDomicilio(argumentos[0]);
				instanciaAlumno.setEmail(argumentos[1]);
				instanciaAlumno.setTelefono(argumentos[2]);
				try {
					fachada.modificarAlumno(instanciaAlumno);
					listener.mostrarConfirmacion(MensajeTitulo.TITULO_MODIFICAR,
							MensajesConfirmacion.CONF_MODIFICAR_ALUMNO);
				} catch (AlumnosException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					listener.mostrarError(MensajeTitulo.TITULO_MODIFICAR, e.getMessage());
				} catch (RemoteException r) {
					listener.mostrarError(MensajeTitulo.TITULO_ERROR, MensajesError.ERROR_CONEXION);
				}
			} else {
				listener.mostrarError(MensajeTitulo.TITULO_MODIFICAR, MensajesError.ERROR_VALIDAR_ALUMNO);
			}

		}
	}
}
