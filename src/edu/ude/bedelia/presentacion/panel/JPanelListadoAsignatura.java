package edu.ude.bedelia.presentacion.panel;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;

import edu.ude.bedelia.presentacion.controladores.ControlladorAsignaturas;
import edu.ude.bedelia.presentacion.controladores.ControlladorListadoAsignatura;
import edu.ude.bedelia.presentacion.panel.listener.ICargarTabla;

public class JPanelListadoAsignatura extends JPanelListado implements ICargarTabla {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public JPanelListadoAsignatura() {
		super();

		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(223, 5, 3, 3);
		scrollPane.add(table);
		panel.add(scrollPane);
		// todo ver esto
		/*
		 * Runnable run = new Runnable() {
		 * 
		 * @Override public void run() {
		 */
		ControlladorListadoAsignatura.getInstancia(this).listar();

		/*
		 * } }; new Thread(run).start();
		 */

	}

	@Override
	public void cargarTabla(AbstractTableModel model) {
		table.setModel(model);
	}

}
