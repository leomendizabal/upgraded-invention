package edu.ude.bedelia.presentacion.controladores;

import java.rmi.RemoteException;

import edu.ude.bedelia.logica.excepciones.AsignaturasException;
import edu.ude.bedelia.logica.vo.VOAsignatura;
import edu.ude.bedelia.presentacion.panel.listener.IMensaje;

public class ControlladorAsignaturas extends Controllador implements Controllador.IRegistrar {

	private static ControlladorAsignaturas instancia;
	private IMensaje listener;

	protected ControlladorAsignaturas(IMensaje listener) {
		super();
		this.listener = listener;
	}

	public static ControlladorAsignaturas getInstancia(IMensaje listener) {
		if (instancia == null) {
			instancia = new ControlladorAsignaturas(listener);
		}

		return instancia;
	}

	@Override
	public void registrar(String... argumentos) {
		try {
			fachada.registrarAsignatura(new VOAsignatura(argumentos[0], argumentos[1], argumentos[2]));
			listener.mostrarConfirmacion("Registro", "Se ingreso correctamente");
		} catch (RemoteException | AsignaturasException e) {
			// TODO colocar error amigables
			listener.mostrarError("Error", e.getMessage());
		}

	}

}
