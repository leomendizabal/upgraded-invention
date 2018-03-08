package edu.ude.bedelia.presentacion.controladores;

import java.rmi.RemoteException;
import java.util.List;

import edu.ude.bedelia.logica.vo.VOAsignatura;
import edu.ude.bedelia.presentacion.UIConstantes.MensajesError;
import edu.ude.bedelia.presentacion.panel.listener.ICargarTabla;
import edu.ude.bedelia.presentacion.tablemodel.AsignaturaModel;

public class ControladorListadoAsignatura extends Controlador implements Controlador.IListar<String> {

	private static ControladorListadoAsignatura instancia;
	private ICargarTabla listener;

	protected ControladorListadoAsignatura(ICargarTabla listener) {
		super();
		this.listener = listener;
	}

	public static ControladorListadoAsignatura getInstancia(ICargarTabla listener) {
		if (instancia == null) {
			instancia = new ControladorListadoAsignatura(listener);
		}

		return instancia;
	}

	@Override
	public void listar(String... argumentos) {
		try {
			if (fachada != null) {
				List<VOAsignatura> resultado = fachada.listarAsignaturas();
				listener.cargarTabla(new AsignaturaModel(resultado, VOAsignatura.attr));
			} else {
				listener.mostrarError("Error", "tema de conexion");
			}
		} catch (RemoteException e) {
			// TODO colocar error amigables
			listener.mostrarError("Error", MensajesError.ERROR_CONEXION);
		}

	}
}
