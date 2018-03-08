package edu.ude.bedelia.presentacion.controladores;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import edu.ude.bedelia.logica.excepciones.AlumnosException;
import edu.ude.bedelia.logica.vo.VOAlumno;
import edu.ude.bedelia.logica.vo.VOAlumnoCompleto;
import edu.ude.bedelia.logica.vo.VOBecadoCompleto;
import edu.ude.bedelia.presentacion.Helper;
import edu.ude.bedelia.presentacion.UIConstantes.MensajeTitulo;
import edu.ude.bedelia.presentacion.UIConstantes.MensajesError;
import edu.ude.bedelia.presentacion.panel.listener.ICargarTabla;
import edu.ude.bedelia.presentacion.tablemodel.AlumnoDetalleModel;

public class ControladorDetalleAlumno extends ControladorAlumno implements Controlador.IListar<String> {

	private ICargarTabla listener;

	public ControladorDetalleAlumno(ICargarTabla listener) {
		super(listener);
		this.listener = listener;

	}

	@Override
	public void listar(String... argumentos) {
		try {
			if (Helper.isEmpty(argumentos)) {
				listener.mostrarError(MensajeTitulo.TITULO_ERROR, MensajesError.ERROR_CAMPO);
			} else {
				VOAlumno alumno = fachada.listarDatosAlumno(argumentos[0]);
				final List<VOAlumnoCompleto> resultado = new ArrayList<>(1);
				final List<String> columnas = new ArrayList<>();
				if (alumno instanceof VOAlumnoCompleto) {
					resultado.add((VOAlumnoCompleto) alumno);
					VOAlumnoCompleto alumnoCompleto = (VOAlumnoCompleto) alumno;
					if (alumnoCompleto instanceof VOBecadoCompleto) {
						columnas.addAll(VOBecadoCompleto.attrBecadoCompleto);
					} else {
						columnas.addAll(VOAlumnoCompleto.attrAlumnoCompleto);
					}
				}
				listener.cargarTabla(new AlumnoDetalleModel(resultado, columnas));
			}
		} catch (RemoteException r) {
			// TODO Auto-generated catch block
			listener.mostrarError(MensajesError.ERROR_DETALLE_ALUMNO, MensajesError.ERROR_CONEXION);

		} catch (AlumnosException a) {

			listener.mostrarError(MensajesError.ERROR_DETALLE_ALUMNO, a.getMessage());
		}

	}

}
