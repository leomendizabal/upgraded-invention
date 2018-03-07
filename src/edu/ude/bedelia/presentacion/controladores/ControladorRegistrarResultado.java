package edu.ude.bedelia.presentacion.controladores;

import edu.ude.bedelia.presentacion.panel.listener.IMensaje;

public class ControladorRegistrarResultado extends Controlador implements Controlador.IRegistrar {

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
			fachada.registrarResultado(argumento[0], Integer.valueOf(argumento[1]), argumento[2],
					Integer.valueOf(argumento[3]));
			listener.mostrarConfirmacion("Registro", "La nota fue ingresada correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			listener.mostrarError("Error", e.getMessage());
		}
	}

}
