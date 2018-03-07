package edu.ude.bedelia.presentacion.controladores;

import java.rmi.RemoteException;

import edu.ude.bedelia.logica.excepciones.AlumnosException;
import edu.ude.bedelia.logica.excepciones.AsignaturasException;
import edu.ude.bedelia.logica.excepciones.InscripcionesException;
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
			float resultado = fachada.montoRecaudadoPorAlumno(Integer.parseInt(argumentos[1]), argumentos[0]);
			listener.mostrar(String.valueOf(resultado));
		} catch (NumberFormatException | RemoteException | AlumnosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			listener.mostrarError("", "");
		}

	}

	@Override
	public void registrar(boolean extra, String... argumentos) {
		// TODO Auto-generated method stub
		try {
			fachada.inscribirAlumno(argumentos[0], argumentos[1], Integer.parseInt(argumentos[2]),
					Float.parseFloat(argumentos[3]));
			listener.mostrarConfirmacion("Registro", "Se ingreso correctamente");
		} catch (RemoteException | AsignaturasException | NumberFormatException | AlumnosException
				| InscripcionesException e) {
			// TODO colocar error amigables
			listener.mostrarError("Error", e.getMessage());
		}

	}

}
