package edu.ude.bedelia.presentacion.controladores;

import java.rmi.RemoteException;
import java.util.List;

import edu.ude.bedelia.logica.vo.VOAsignatura;
import edu.ude.bedelia.presentacion.panel.listener.ICargarTabla;
import edu.ude.bedelia.presentacion.tablemodel.AsignaturaModel;

public class ControlladorListadoAsignatura extends Controllador implements Controllador.IListar {

	private static ControlladorListadoAsignatura instancia;
	private ICargarTabla listener;

	protected ControlladorListadoAsignatura(ICargarTabla listener) {
		super();
		this.listener = listener;
	}

	public static ControlladorListadoAsignatura getInstancia(ICargarTabla listener) {
		if (instancia == null) {
			instancia = new ControlladorListadoAsignatura(listener);
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
			listener.mostrarError("Error", e.getMessage());
		}

	}
}
