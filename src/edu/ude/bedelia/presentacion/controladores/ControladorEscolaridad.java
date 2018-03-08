package edu.ude.bedelia.presentacion.controladores;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.ude.bedelia.logica.excepciones.AlumnosException;
import edu.ude.bedelia.logica.vo.VOInscripcion;
import edu.ude.bedelia.logica.vo.VOInscripcionCompleta;
import edu.ude.bedelia.presentacion.panel.listener.ICargarTabla;
import edu.ude.bedelia.presentacion.tablemodel.IncripcionesModel;
import edu.ude.bedelia.presentacion.UIConstantes.MensajesError;

public class ControladorEscolaridad extends Controlador implements Controlador.IListar<String> {

	private ICargarTabla listener;
	private static ControladorEscolaridad instancia = null;

	private ControladorEscolaridad(ICargarTabla listener) {
		super();
		this.listener = listener;
	}

	public synchronized static ControladorEscolaridad getInstance(ICargarTabla listener) {
		if (null == instancia) {
			instancia = new ControladorEscolaridad(listener);
		}
		return instancia;
	}

	@Override
	public void listar(String... argumentos) {
		try {
			boolean esCompleto = new Boolean(argumentos[0]);
			List<VOInscripcion> resultado = fachada.listarEscolaridad(argumentos[0], esCompleto);
			if (resultado.isEmpty()) {
				listener.tablaVacia();
			} else {
				List<String> columanas = new ArrayList<>();
				if (esCompleto) {
					columanas = VOInscripcionCompleta.attrsCompleto;
				} else {
					columanas = VOInscripcion.attrs;
				}
				Collections.sort(resultado);
				listener.cargarTabla(new IncripcionesModel(resultado, columanas));
			}
		} catch (RemoteException r) {
			// TODO Auto-generated catch block
			r.printStackTrace();
			listener.mostrarError("listar",MensajesError.ERROR_CONEXION);
		} catch ( AlumnosException e){
			listener.mostrarError("listar", e.getMessage());
		}

	}
}
