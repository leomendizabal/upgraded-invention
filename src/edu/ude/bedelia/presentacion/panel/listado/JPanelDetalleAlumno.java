package edu.ude.bedelia.presentacion.panel.listado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.AbstractTableModel;

import edu.ude.bedelia.presentacion.panel.listener.ICargarTabla;

public class JPanelDetalleAlumno extends JPanelTablaConFiltro implements ICargarTabla, ActionListener {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public JPanelDetalleAlumno() {
		super();
		ocultarModo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cargarTabla(AbstractTableModel model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tablaVacia() {
		// TODO Auto-generated method stub
		
	}

}
