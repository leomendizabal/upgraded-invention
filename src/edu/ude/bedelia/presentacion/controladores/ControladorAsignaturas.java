package edu.ude.bedelia.presentacion.controladores;

import java.rmi.RemoteException;

import edu.ude.bedelia.logica.excepciones.AsignaturasException;
import edu.ude.bedelia.logica.vo.VOAsignatura;
import edu.ude.bedelia.presentacion.panel.listener.IMensaje;

public class ControladorAsignaturas extends Controlador implements Controlador.IRegistrar {

	private static ControladorAsignaturas instancia;
	private IMensaje listener;

	protected ControladorAsignaturas(IMensaje listener) {
		super();
		this.listener = listener;
	}

	public static ControladorAsignaturas getInstancia(IMensaje listener) {
		if (instancia == null) {
			instancia = new ControladorAsignaturas(listener);
		}

		return instancia;
	}

	@Override
	public void registrar(boolean extra, String... argumentos) {
		try {
			fachada.registrarAsignatura(new VOAsignatura(argumentos[0], argumentos[1], argumentos[2]));
			listener.mostrarConfirmacion("Registro", "Se ingreso correctamente");
		} catch (RemoteException | AsignaturasException e) {
			// TODO colocar error amigables
			listener.mostrarError("Error", e.getMessage());
		}

	}

}
