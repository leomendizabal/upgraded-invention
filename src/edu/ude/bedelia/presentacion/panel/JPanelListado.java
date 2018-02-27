package edu.ude.bedelia.presentacion.panel;

import java.awt.BorderLayout;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.ude.bedelia.logica.entidades.Asignatura;
import edu.ude.bedelia.test.DataClass;

public class JPanelListado extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public JPanelListado() {
		setLayout(new BorderLayout(0, 0));
		table = new JTable();
		cargarTabla(table);
		table.getTableHeader().setReorderingAllowed(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);

	}

	public void cargarTabla(JTable tabla) {
		DefaultTableModel modeloTabla = new DefaultTableModel();
		tabla.setModel(modeloTabla);

		modeloTabla.addColumn("Codigo");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Descrpcion");

		Object[] columna = new Object[3];

		Iterator<Asignatura> it = DataClass.ASIGNATURA.iterator();
		while (it.hasNext()) {
			Asignatura item = it.next();
			columna[0] = item.getCodigo();
			columna[1] = item.getNombre();
			columna[2] = item.getDescripcion();

			modeloTabla.addRow(columna);
		}

	}
}
