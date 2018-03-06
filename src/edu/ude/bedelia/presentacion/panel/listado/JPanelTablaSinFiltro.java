package edu.ude.bedelia.presentacion.panel.listado;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JPanelTablaSinFiltro extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTable table;

	/**
	 * Create the panel.
	 */
	public JPanelTablaSinFiltro() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 128, 450, 300);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setColumnHeaderView(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		panel.add(table, BorderLayout.SOUTH);

	}

}
