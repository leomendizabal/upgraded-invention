package edu.ude.bedelia.presentacion.panel.listado;

import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import edu.ude.bedelia.presentacion.panel.JPanelBase;

public class JPanelTablaConFiltro extends JPanelBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTable table;
	private JTextField textFieldTexto;
	protected JPanel jPanelFiltro;
	protected JPanel contentPanel;
	protected JRadioButton rdbtnCompleto ;
	protected JRadioButton rdbtnParcial ;
	protected JLabel lblTipoReferencia;
	protected JLabel lblTextoReferencia;
	/**
	 * Create the panel.
	 */
	public JPanelTablaConFiltro() {
		super();
		setLayout(null);
        contentPanel = new JPanel();
		contentPanel.setBounds(12, 12, 636, 545);
		add(contentPanel);
		contentPanel.setLayout(null);
		contentPanel.setPreferredSize(new Dimension(getWidth(), getHeight()));
		jPanelFiltro = new JPanel();
		jPanelFiltro.setBorder(new TitledBorder(null, "Filtro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jPanelFiltro.setBounds(10, 12, 614, 94);
		contentPanel.add(jPanelFiltro);
		jPanelFiltro.setLayout(null);

		lblTextoReferencia = new JLabel("Texto");
		lblTextoReferencia.setBounds(58, 22, 70, 19);
		jPanelFiltro.add(lblTextoReferencia);

		textFieldTexto = new JTextField();
		textFieldTexto.setBounds(146, 22, 191, 24);
		jPanelFiltro.add(textFieldTexto);
		textFieldTexto.setColumns(10);

		lblTipoReferencia = new JLabel("Tipo");
		lblTipoReferencia.setBounds(58, 58, 70, 20);
		jPanelFiltro.add(lblTipoReferencia);

		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(363, 56, 117, 25);
		jPanelFiltro.add(btnFiltrar);
		
		JRadioButton rdbtnCompleto = new JRadioButton("Completo");
		rdbtnCompleto.setSelected(true);
		rdbtnCompleto.setBounds(146, 54, 92, 23);
		jPanelFiltro.add(rdbtnCompleto);
		
		rdbtnParcial = new JRadioButton("Parcial");
		rdbtnParcial.setBounds(256, 57, 80, 23);
		jPanelFiltro.add(rdbtnParcial);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnCompleto);
		buttonGroup.add(rdbtnParcial);
		
		JPanel jPanelContenedor = new JPanel();
		jPanelContenedor.setBorder(new TitledBorder(null, "Tabla", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jPanelContenedor.setBounds(10, 119, 614, 414);
		contentPanel.add(jPanelContenedor);
		jPanelContenedor.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 100, 590, 30);
		jPanelContenedor.add(lblNewLabel);

		table = new JTable(new DefaultTableModel());

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 12, 590, 390);
		jPanelContenedor.add(scrollPane);

	}
}
