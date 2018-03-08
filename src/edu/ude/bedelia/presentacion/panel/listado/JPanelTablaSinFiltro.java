package edu.ude.bedelia.presentacion.panel.listado;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import edu.ude.bedelia.presentacion.panel.JPanelBase;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JPanelTablaSinFiltro extends JPanelBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTable table;
	protected JLabel lblMensaje;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public JPanelTablaSinFiltro() {
		setLayout(new BorderLayout(0, 0));
		
		lblMensaje = new JLabel("No hay contenido");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblMensaje, BorderLayout.NORTH);

		scrollPane = new JScrollPane();
		add(scrollPane);

		JPanel panel = new JPanel();
		scrollPane.setColumnHeaderView(panel);
		panel.setLayout(new BorderLayout(12, 0));

		table = new JTable();
		panel.add(table, BorderLayout.CENTER);

	}
	
	protected void mostrarMensaje(String mensaje) {
		scrollPane.setVisible(false);
		lblMensaje.setVisible(true);
		lblMensaje.setText(mensaje);
	}
	
	protected void ocultarMensaje() {
		scrollPane.setVisible(true);
		lblMensaje.setVisible(false);
	}

}
