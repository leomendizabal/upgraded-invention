package edu.ude.bedelia.presentacion.panel.listado;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.table.AbstractTableModel;

import edu.ude.bedelia.presentacion.controladores.ControlladorListadoAsignatura;
import edu.ude.bedelia.presentacion.panel.listener.ICargarTabla;

public class JPanelListadoAsignatura extends JPanelTablaGenerico implements ICargarTabla {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public JPanelListadoAsignatura() {
		super();
		contentPanel.remove(jPanelFiltro);
		contentPanel.revalidate();
		contentPanel.repaint();

		ControlladorListadoAsignatura.getInstancia(this).listar();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}

	@Override
	public void cargarTabla(AbstractTableModel model) {
		table.setModel(model);
	}

}
