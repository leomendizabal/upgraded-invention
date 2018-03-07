package edu.ude.bedelia.presentacion.panel.registro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.ude.bedelia.presentacion.controladores.ControladorRegistrarResultado;
import edu.ude.bedelia.presentacion.panel.JPanelBase;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;

public class JPanelRegistrarNota extends JPanelBase implements ActionListener {

	private static final long serialVersionUID = 1L;
	public final static String TAG = JPanelRegistrarNota.class.getSimpleName();
	private final ControladorRegistrarResultado controlador;

	protected JTextField textFieldCedula;
	protected JTextField textFieldNroIns;
	protected JComboBox<String> cmbNota;
	private JTextField textFieldAno;
	JButton btnGuardar;

	public JPanelRegistrarNota() {
		super();
		controlador = ControladorRegistrarResultado.getInstance(this);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 150, 100, 31, 136, 0 };
		gridBagLayout.rowHeights = new int[] { 62, 26, 26, 110, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblAno = new JLabel("A\u00F1o");
		lblAno.setHorizontalAlignment(SwingConstants.CENTER);
		lblAno.setAlignmentY(Component.TOP_ALIGNMENT);
		lblAno.setBounds(20, 194, 60, 26);
		GridBagConstraints gbc_lblAno = new GridBagConstraints();
		gbc_lblAno.anchor = GridBagConstraints.EAST;
		gbc_lblAno.insets = new Insets(0, 0, 5, 5);
		gbc_lblAno.fill = GridBagConstraints.VERTICAL;
		gbc_lblAno.gridx = 0;
		gbc_lblAno.gridy = 2;
		add(lblAno, gbc_lblAno);

		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(20, 39, 60, 20);
		GridBagConstraints gbc_lblCedula = new GridBagConstraints();
		gbc_lblCedula.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblCedula.insets = new Insets(0, 0, 5, 5);
		gbc_lblCedula.gridx = 0;
		gbc_lblCedula.gridy = 0;
		add(lblCedula, gbc_lblCedula);

		textFieldCedula = new JTextField();
		textFieldCedula.setBounds(103, 36, 259, 26);
		GridBagConstraints gbc_textFieldCedula = new GridBagConstraints();
		gbc_textFieldCedula.anchor = GridBagConstraints.SOUTH;
		gbc_textFieldCedula.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCedula.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCedula.gridwidth = 3;
		gbc_textFieldCedula.gridx = 1;
		gbc_textFieldCedula.gridy = 0;
		add(textFieldCedula, gbc_textFieldCedula);
		textFieldCedula.setColumns(10);

		JLabel lblNroIns = new JLabel("Nro Inscripcion");
		lblNroIns.setBounds(20, 87, 80, 20);
		GridBagConstraints gbc_lblNroIns = new GridBagConstraints();
		gbc_lblNroIns.anchor = GridBagConstraints.EAST;
		gbc_lblNroIns.insets = new Insets(0, 0, 5, 5);
		gbc_lblNroIns.gridx = 0;
		gbc_lblNroIns.gridy = 1;
		add(lblNroIns, gbc_lblNroIns);

		textFieldNroIns = new JTextField();
		textFieldNroIns.setBounds(103, 84, 259, 26);
		GridBagConstraints gbc_textFieldNroIns = new GridBagConstraints();
		gbc_textFieldNroIns.fill = GridBagConstraints.BOTH;
		gbc_textFieldNroIns.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNroIns.gridwidth = 3;
		gbc_textFieldNroIns.gridx = 1;
		gbc_textFieldNroIns.gridy = 1;
		add(textFieldNroIns, gbc_textFieldNroIns);
		textFieldNroIns.setColumns(10);

		textFieldAno = new JTextField();
		textFieldAno.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFieldAno.setBounds(103, 137, 259, 26);
		GridBagConstraints gbc_textFieldAno = new GridBagConstraints();
		gbc_textFieldAno.fill = GridBagConstraints.BOTH;
		gbc_textFieldAno.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldAno.gridwidth = 3;
		gbc_textFieldAno.gridx = 1;
		gbc_textFieldAno.gridy = 2;
		add(textFieldAno, gbc_textFieldAno);
		textFieldAno.setColumns(10);

		JLabel lblNota = new JLabel("Nota");
		lblNota.setBounds(20, 194, 60, 20);
		GridBagConstraints gbc_lblNota = new GridBagConstraints();
		gbc_lblNota.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNota.insets = new Insets(0, 0, 5, 5);
		gbc_lblNota.gridx = 0;
		gbc_lblNota.gridy = 3;
		add(lblNota, gbc_lblNota);

		cmbNota = new JComboBox<String>();
		cmbNota.setModel(new DefaultComboBoxModel<String>(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		cmbNota.setBounds(103, 191, 100, 26);
		GridBagConstraints gbc_cmbNota = new GridBagConstraints();
		gbc_cmbNota.anchor = GridBagConstraints.NORTH;
		gbc_cmbNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbNota.insets = new Insets(0, 0, 5, 5);
		gbc_cmbNota.gridx = 1;
		gbc_cmbNota.gridy = 3;
		add(cmbNota, gbc_cmbNota);

		

		btnGuardar = new JButton("Guardar");
		btnGuardar.setHorizontalAlignment(SwingConstants.RIGHT);
		btnGuardar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnGuardar.setBounds(234, 190, 128, 29);
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 0);
		gbc_btnGuardar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnGuardar.gridx = 3;
		gbc_btnGuardar.gridy = 3;
		add(btnGuardar, gbc_btnGuardar);
		
		setActionListenerGuardar(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controlador.registrar(false, textFieldCedula.getText(), (String) cmbNota.getSelectedItem(),
				textFieldNroIns.getText(), textFieldAno.getText());
	}

	protected void setActionListenerGuardar(ActionListener listener) {
		btnGuardar.addActionListener(listener);
	}
}
