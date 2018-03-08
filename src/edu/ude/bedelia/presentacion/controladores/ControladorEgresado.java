package edu.ude.bedelia.presentacion.controladores;

import java.rmi.RemoteException;
import java.util.List;

import edu.ude.bedelia.logica.vo.VOEgresado;
import edu.ude.bedelia.logica.vo.VOEgresadoCompleto;
import edu.ude.bedelia.presentacion.UIConstantes.MensajesError;
import edu.ude.bedelia.presentacion.panel.listener.ICargarTabla;
import edu.ude.bedelia.presentacion.tablemodel.EgresadoModel;

public class ControladorEgresado extends Controlador implements Controlador.IListar<Boolean> {

	private ICargarTabla listener;
	private static ControladorEgresado instancia = null;

	private ControladorEgresado(ICargarTabla listener) {
		super();
		this.listener = listener;
	}

	public synchronized static ControladorEgresado getInstance(ICargarTabla listener) {
		if (null == instancia) {
			instancia = new ControladorEgresado(listener);
		}
		return instancia;
	}

	@Override
	public void listar(Boolean... argumentos) {
		// TODO Auto-generated method stub
		try {
			List<VOEgresado> resultado = fachada.listarEgresados(argumentos[0]);
			if (resultado.isEmpty()) {
				listener.tablaVacia();
			} else {
				List<String> columnas = VOEgresado.attr;
				if (resultado.get(0) instanceof VOEgresadoCompleto) {
					columnas = VOEgresadoCompleto.attrCompleto;
				}
				listener.cargarTabla(new EgresadoModel(resultado, columnas));
			}

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			listener.mostrarError("Error", MensajesError.ERROR_CONEXION);

		}

	}

}
