package edu.ude.bedelia.presentacion.controladores;

import java.rmi.RemoteException;

import edu.ude.bedelia.logica.excepciones.AlumnosException;
import edu.ude.bedelia.logica.vo.TipoAlumno;
import edu.ude.bedelia.logica.vo.VOAlumnoCompleto;
import edu.ude.bedelia.logica.vo.VOBecadoCompleto;
import edu.ude.bedelia.presentacion.panel.listener.IMensaje;

public class ControladorAlumno extends Controlador implements Controlador.IRegistrar {

	private IMensaje listener;
	private static ControladorAlumno instancia = null;

	private ControladorAlumno(IMensaje listener) {
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
		//TODO: si tamos bien pasar a MAP<String,String>
		try {
		VOAlumnoCompleto voAlumno = null;
		if (extra) {
			voAlumno = new VOBecadoCompleto(argumentos[0], argumentos[1], argumentos[2], TipoAlumno.BECADO,
					argumentos[3], argumentos[4], argumentos[5],Float.valueOf(argumentos[6]),argumentos[7]);
		} else {
			voAlumno = new VOAlumnoCompleto(argumentos[0], argumentos[1], argumentos[2], TipoAlumno.COMUN,
					argumentos[3], argumentos[4], argumentos[5]);
		}
			fachada.registrarAlumno(voAlumno);
			listener.mostrarConfirmacion("Registro", "El alumno fue registrado correctamente");
		} catch (RemoteException | AlumnosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			listener.mostrarError("Error",e.getMessage());
		}
	}

}