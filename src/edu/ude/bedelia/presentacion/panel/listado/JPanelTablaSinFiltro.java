package edu.ude.bedelia.presentacion.panel.listado;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;

import edu.ude.bedelia.presentacion.panel.JPanelBase;

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
		
		table = new JTable();
		scrollPane = new JScrollPane(table);
		add(scrollPane);

		

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

	protected void setModel(AbstractTableModel model) {
		table.setModel(model);
		//resizeColumnWidth(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	}

	@Override
	protected void inicializar() {
		// TODO Auto-generated method stub
		limpiarTextField(this);
	}

}
