package edu.ude.bedelia.presentacion.panel.listado;

import java.awt.event.ComponentEvent;

import javax.swing.table.AbstractTableModel;

import edu.ude.bedelia.presentacion.UIConstantes;
import edu.ude.bedelia.presentacion.controladores.ControladorAsignaturas;
import edu.ude.bedelia.presentacion.panel.listener.ICargarTabla;

public class JPanelListadoAsinatura extends JPanelTablaSinFiltro implements ICargarTabla {

	private static final long serialVersionUID = 1L;
	public final static String TAG = JPanelListadoAsinatura.class.getName();
	public final static String TITULO = "Listado de asignatura";
	private final ControladorAsignaturas controlador;

	/**
	 * Create the panel.
	 */
	public JPanelListadoAsinatura() {
		super();
		ocultarMensaje();
		controlador = ControladorAsignaturas.getInstancia();
		controlador.setCargar(this);

	}

	@Override
	public void cargarTabla(AbstractTableModel model) {
		// TODO Auto-generated method stub
		setModel(model);

	}

	@Override
	public void mostrarError(String titulo, String mensaje) {
		// TODO Auto-generated method stub
		super.mostrarError(titulo, mensaje);
		tablaVacia();
	}

	@Override
	public void tablaVacia() {
		mostrarMensaje(UIConstantes.MensajesError.ERROR_NO_SE_CARGARON_DATOS);

	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		super.componentShown(e);
		controlador.listar();

	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		super.componentHidden(e);
	}

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

}
