package edu.ude.bedelia.presentacion.controladores;

import java.rmi.RemoteException;
import java.util.List;

import edu.ude.bedelia.logica.excepciones.AsignaturasException;
import edu.ude.bedelia.logica.vo.VOAsignatura;
import edu.ude.bedelia.presentacion.Helper;
import edu.ude.bedelia.presentacion.UIConstantes.MensajeTitulo;
import edu.ude.bedelia.presentacion.UIConstantes.MensajesConfirmacion;
import edu.ude.bedelia.presentacion.UIConstantes.MensajesError;
import edu.ude.bedelia.presentacion.panel.listener.ICargarTabla;
import edu.ude.bedelia.presentacion.panel.listener.IMensaje;
import edu.ude.bedelia.presentacion.tablemodel.AsignaturaModel;

public class ControladorAsignaturas extends Controlador implements Controlador.IRegistrar, Controlador.IListar<String> {

	private static ControladorAsignaturas instancia;
	private IMensaje listener;
	private ICargarTabla cargar;
	
	protected ControladorAsignaturas() {
		super();
	}

	public static ControladorAsignaturas getInstancia() {
		if (instancia == null) {
			instancia = new ControladorAsignaturas();
		}
		return instancia;
	}

	public void setListener(IMensaje listener) {
		this.listener = listener;
	}

	public void setCargar(ICargarTabla cargar) {
		this.cargar = cargar;
	}

	@Override
	public void registrar(boolean extra, String... argumentos) {
		try {
			if (Helper.isEmpty(argumentos)) {
				listener.mostrarError(MensajeTitulo.TITULO_ERROR, MensajesError.ERROR_CAMPO);
			}else {
			fachada.registrarAsignatura(new VOAsignatura(argumentos[0], argumentos[1], argumentos[2]));
			listener.mostrarConfirmacion(MensajesConfirmacion.CONF_REGISTRAR_ASIGNATURA, MensajesConfirmacion.CONF_REGISTRAR_ASIGNATURA);
			}
		} catch (RemoteException r) {
			
			listener.mostrarError(MensajeTitulo.TITULO_ERROR,MensajesError.ERROR_CONEXION);
		} catch(AsignaturasException e) {
			listener.mostrarError(MensajeTitulo.TITULO_ERROR, MensajesError.ERROR_REGISTRAR_ASIGNATURA);
		}

	}

	@Override
	public void listar(String... argumentos) {
		// TODO Auto-generated method stub
		try {
			List<VOAsignatura> resultado = fachada.listarAsignaturas();
			cargar.cargarTabla(new AsignaturaModel(resultado,VOAsignatura.attr));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			cargar.mostrarError(MensajeTitulo.TITULO_LISTAR_ASIGNATURAS, MensajesError.ERROR_CONEXION);
		}
		
	}

}
