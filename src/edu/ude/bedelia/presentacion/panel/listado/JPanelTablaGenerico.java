package edu.ude.bedelia.presentacion.panel.listado;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import edu.ude.bedelia.presentacion.panel.JPanelBase;

import java.awt.Color;
import java.awt.Container;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;

public class JPanelTablaGenerico extends JPanelBase {

	protected JTable table ;
	
	/**
	 * Create the panel.
	 */
	public JPanelTablaGenerico() {
		super();
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 515, 428);
		add(panel);
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(getWidth(), getHeight()));
		JPanel jPanelFiltro = new JPanel();
		jPanelFiltro.setBounds(12, 12, 503, 47);
		panel.add(jPanelFiltro);
		jPanelFiltro.setLayout(null);

		JPanel jPanelContenedor = new JPanel();
		jPanelContenedor.setBounds(10, 74, 493, 342);
		panel.add(jPanelContenedor);
		jPanelContenedor.setLayout(null);
		
		table  = new JTable(new DefaultTableModel());

	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(12, 12, 469, 318);
	    jPanelContenedor.add(scrollPane);
	

	}
}
