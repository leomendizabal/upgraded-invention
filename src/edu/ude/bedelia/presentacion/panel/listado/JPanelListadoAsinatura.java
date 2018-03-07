package edu.ude.bedelia.presentacion.panel.listado;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.table.AbstractTableModel;

import edu.ude.bedelia.presentacion.controladores.ControladorAsignaturas;
import edu.ude.bedelia.presentacion.panel.listener.ICargarTabla;

public class JPanelListadoAsinatura extends JPanelTablaSinFiltro implements ICargarTabla, ComponentListener {

	private static final long serialVersionUID = 1L;
	public final static String TAG = JPanelListadoAsinatura.class.getName();
	private final ControladorAsignaturas controlador;

	/**
	 * Create the panel.
	 */
	public JPanelListadoAsinatura() {
		super();
		addComponentListener(this);
		controlador = ControladorAsignaturas.getInstancia();
		controlador.setCargar(this);

	}

	@Override
	public void cargarTabla(AbstractTableModel model) {
		// TODO Auto-generated method stub
		ocultarMensaje();
		table.setModel(model);

	}

	@Override
	public void mostrarError(String titulo, String mensaje) {
		// TODO Auto-generated method stub
		super.mostrarError(titulo, mensaje);
		mostrarMensaje("No se puedo obtener las asignaturas");
	}

	@Override
	public void tablaVacia() {
		mostrarMensaje("No hay asignaturas");

	}

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Componente visible");
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				controlador.listar();

			}
		};
		new Thread(runnable).start();

	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Componente oculto");

	}

}
