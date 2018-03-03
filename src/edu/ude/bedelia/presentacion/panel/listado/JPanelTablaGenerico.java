package edu.ude.bedelia.presentacion.panel.listado;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import edu.ude.bedelia.presentacion.panel.JPanelBase;

import java.awt.Color;
import java.awt.Container;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

public class JPanelTablaGenerico extends JPanelBase {

	protected JTable table;
	private JTextField textFieldTexto;
	protected JPanel jPanelFiltro;
	protected JPanel contentPanel;

	/**
	 * Create the panel.
	 */
	public JPanelTablaGenerico() {
		super();
		setLayout(null);
        contentPanel = new JPanel();
		contentPanel.setBounds(12, 12, 527, 462);
		add(contentPanel);
		contentPanel.setLayout(null);
		contentPanel.setPreferredSize(new Dimension(getWidth(), getHeight()));
		jPanelFiltro = new JPanel();
		jPanelFiltro.setBorder(new TitledBorder(null, "Filtro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jPanelFiltro.setBounds(10, 12, 493, 94);
		contentPanel.add(jPanelFiltro);
		jPanelFiltro.setLayout(null);

		JLabel lblTextoReferencia = new JLabel("Texto");
		lblTextoReferencia.setBounds(58, 22, 70, 19);
		jPanelFiltro.add(lblTextoReferencia);

		textFieldTexto = new JTextField();
		textFieldTexto.setBounds(146, 22, 191, 24);
		jPanelFiltro.add(textFieldTexto);
		textFieldTexto.setColumns(10);

		JLabel lblTipoReferencia = new JLabel("Tipo");
		lblTipoReferencia.setBounds(58, 58, 70, 20);
		jPanelFiltro.add(lblTipoReferencia);

		JComboBox comboBoxModo = new JComboBox();
		comboBoxModo.setBounds(146, 58, 191, 24);
		jPanelFiltro.add(comboBoxModo);

		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(362, 19, 117, 25);
		jPanelFiltro.add(btnFiltrar);

		JPanel jPanelContenedor = new JPanel();
		jPanelContenedor.setBounds(10, 119, 493, 331);
		contentPanel.add(jPanelContenedor);
		jPanelContenedor.setLayout(null);

		table = new JTable(new DefaultTableModel());

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 12, 469, 307);
		jPanelContenedor.add(scrollPane);

	}
}
