package edu.ude.bedelia.presentacion.panel.listado;

import java.awt.Dimension;
import java.awt.event.ActionListener;

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
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import edu.ude.bedelia.presentacion.panel.JPanelBase;

public class JPanelTablaConFiltro extends JPanelBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTable table;
	protected JTextField textFieldTexto;
	protected JPanel jPanelFiltro;
	protected JPanel contentPanel;
	protected JRadioButton rdbtnCompleto;
	protected JRadioButton rdbtnParcial;
	protected JLabel lblTipoReferencia;
	protected JLabel lblTextoReferencia;
	protected JButton btnFiltrar;
	protected JLabel lblMensaje;
	private JScrollPane scrollPane;

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

		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(363, 56, 117, 25);
		jPanelFiltro.add(btnFiltrar);

		rdbtnCompleto = new JRadioButton("Completo");
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

		lblMensaje = new JLabel("New label");
		lblMensaje.setVerticalAlignment(SwingConstants.BOTTOM);
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setBounds(12, 100, 590, 30);
		jPanelContenedor.add(lblMensaje);

		table = new JTable(new DefaultTableModel());
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 12, 590, 390);
		jPanelContenedor.add(scrollPane);

	}

	protected void ocultarModoFiltro() {
		rdbtnCompleto.setVisible(false);
		rdbtnParcial.setVisible(false);
		lblTipoReferencia.setVisible(false);
	}

	protected void ocultarTextoFiltro() {
		this.textFieldTexto.setVisible(false);
		this.lblTextoReferencia.setVisible(false);
		this.lblMensaje.setVisible(false);
	}

	protected void setTextoReferenciaFiltro(final String texto) {
		lblTextoReferencia.setText(texto);
	}

	protected void setTextoReferenciaModo(final String texto) {
		lblTipoReferencia.setText(texto);
	}

	protected void setActionListenerBtnFiltro(ActionListener listener) {
		btnFiltrar.addActionListener(listener);
	}

	protected void mostrarMensajeTabla(String mensaje) {
		scrollPane.setVisible(false);
		lblMensaje.setVisible(true);
		lblMensaje.setText(mensaje);
	}

	protected void setModel(AbstractTableModel model) {
		table.setModel(model);
		// resizeColumnWidth(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

	}

	protected void ocultarMensaje() {
		scrollPane.setVisible(true);
		lblMensaje.setVisible(false);
	}

	protected void limpiarFiltro() {
		rdbtnCompleto.setSelected(true);
		limpiarTextField(jPanelFiltro);
	}

	@Override
	protected void inicializar() {
		// TODO Auto-generated method stub
		limpiarTextField(jPanelFiltro);
	}
}
