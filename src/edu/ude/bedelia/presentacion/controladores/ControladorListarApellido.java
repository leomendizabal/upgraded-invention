package edu.ude.bedelia.presentacion.controladores;

import java.rmi.RemoteException;
import java.util.List;

import edu.ude.bedelia.logica.vo.VOAlumno;
import edu.ude.bedelia.presentacion.Helper;
import edu.ude.bedelia.presentacion.UIConstantes.MensajeTitulo;
import edu.ude.bedelia.presentacion.UIConstantes.MensajesError;
import edu.ude.bedelia.presentacion.panel.listener.ICargarTabla;
import edu.ude.bedelia.presentacion.tablemodel.AlumnoModel;

public class ControladorListarApellido extends Controlador implements Controlador.IListar<String> {

	private static final String TAG = ControladorListarApellido.class.getSimpleName().concat("  %s");
	private ICargarTabla listener;
	private static ControladorListarApellido instancia = null;

	private ControladorListarApellido(ICargarTabla listener) {
		super();
		this.listener = listener;
	}

	public synchronized static ControladorListarApellido getInstance(ICargarTabla listener) {
		if (null == instancia) {
			instancia = new ControladorListarApellido(listener);
		}
		return instancia;
	}

	@Override
	public void listar(String... argumentos) {
		List<VOAlumno> resultado;
		try {
			if (Helper.isEmpty(argumentos)) {
				listener.mostrarError(MensajeTitulo.TITULO_ERROR, MensajesError.ERROR_CAMPO);
			} else {
				resultado = fachada.listarAlumnosApellido(argumentos[0]);
				if (resultado.isEmpty()) {
					this.listener.tablaVacia();
				} else {
					List<String> columnas = VOAlumno.attrAlumno;
					listener.cargarTabla(new AlumnoModel(resultado, columnas));
				}
			}
		} catch (RemoteException e) {
			System.err.println(String.format(TAG, e.getMessage()));
			listener.mostrarError(MensajeTitulo.TITULO_LISTAR, MensajesError.ERROR_CONEXION);
		}
	}
}
