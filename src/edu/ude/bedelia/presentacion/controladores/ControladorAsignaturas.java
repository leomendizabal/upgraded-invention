package edu.ude.bedelia.presentacion.controladores;

import java.rmi.RemoteException;
import java.util.List;

import edu.ude.bedelia.logica.excepciones.AsignaturasException;
import edu.ude.bedelia.logica.vo.VOAsignatura;
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
			fachada.registrarAsignatura(new VOAsignatura(argumentos[0], argumentos[1], argumentos[2]));
			listener.mostrarConfirmacion("Registro", "Se ingreso correctamente");
		} catch (RemoteException | AsignaturasException e) {
			// TODO colocar error amigables
			listener.mostrarError("Error", e.getMessage());
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
			cargar.mostrarError("Listar asignaturas", e.getMessage());
		}
		
	}

}
