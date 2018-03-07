package edu.ude.bedelia.presentacion.panel.registro;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.ude.bedelia.presentacion.panel.JPanelBase;

public class JPanelAlumno extends JPanelBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTextField textFieldNombre;
	protected JTextField textFieldApellido;
	protected JTextField textFieldCedula;
	protected JCheckBox chckbxEsBecado;
	protected JLabel lblDescripcion;
	protected JTextArea txtDescripcion;
	protected JButton btnGuardar;
	protected JLabel lblEmail;
	protected JLabel lblTelefono;
	protected JTextField textFieldEmail;
	protected JTextField textFieldTelefono;
	protected JButton btnBuscar;
	protected JLabel lblDireccion;
	protected JTextField textFieldDireccion;
	protected JTextField textFieldDescuento;
	protected JLabel lblDescuento;

	private void registrarEventListeners() {

		chckbxEsBecado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean esBecado = chckbxEsBecado.isSelected();
				modoBecado(esBecado);
			}
		});

	}

	/**
	 * Create the panel.
	 */
	public JPanelAlumno() {
		super();
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 594, 445);
		add(panel);
		panel.setLayout(null);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(197, 58, 253, 20);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(197, 91, 253, 20);
		panel.add(textFieldApellido);

		textFieldCedula = new JTextField();
		textFieldCedula.setColumns(10);
		textFieldCedula.setBounds(197, 28, 253, 20);
		panel.add(textFieldCedula);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(98, 61, 89, 14);
		panel.add(lblNombre);

		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCedula.setBounds(98, 29, 89, 19);
		panel.add(lblCedula);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setBounds(98, 94, 89, 14);
		panel.add(lblApellido);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(335, 386, 115, 29);
		panel.add(btnGuardar);

		chckbxEsBecado = new JCheckBox("Es becado");
		chckbxEsBecado.setBounds(202, 222, 139, 29);
		panel.add(chckbxEsBecado);

		lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(98, 288, 84, 20);
		panel.add(lblDescripcion);

		txtDescripcion = new JTextArea();
		txtDescripcion.setBounds(197, 291, 253, 62);
		panel.add(txtDescripcion);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(473, 27, 84, 20);
		panel.add(btnBuscar);

		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblEmail.setBounds(98, 196, 89, 14);
		panel.add(lblEmail);

		lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblTelefono.setBounds(98, 120, 89, 23);
		panel.add(lblTelefono);

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(197, 194, 253, 20);
		panel.add(textFieldEmail);

		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(197, 123, 253, 20);
		panel.add(textFieldTelefono);

		lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblDireccion.setBounds(98, 157, 89, 14);
		panel.add(lblDireccion);

		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(197, 155, 253, 20);
		panel.add(textFieldDireccion);

		textFieldDescuento = new JTextField();
		textFieldDescuento.setColumns(10);
		textFieldDescuento.setBounds(197, 259, 253, 20);
		panel.add(textFieldDescuento);

		lblDescuento = new JLabel("Descuento");
		lblDescuento.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblDescuento.setBounds(98, 262, 89, 14);
		panel.add(lblDescuento);

		registrarEventListeners();
	}

	protected void modoModificar(boolean esActivo) {
		textFieldNombre.setEnabled(!esActivo);
		textFieldApellido.setEnabled(!esActivo);
		textFieldEmail.setEnabled(!esActivo);
		textFieldTelefono.setEnabled(!esActivo);
		textFieldDireccion.setEnabled(!esActivo);
		textFieldDescuento.setEnabled(!esActivo);
		chckbxEsBecado.setEnabled(!esActivo);
		txtDescripcion.setEnabled(!esActivo);
		btnGuardar.setEnabled(!esActivo);
	}

	protected void habilitarModificacion(boolean esActivo) {
		// bloqueados
		textFieldNombre.setEnabled(!esActivo);
		textFieldApellido.setEnabled(!esActivo);
		chckbxEsBecado.setEnabled(!esActivo);
		textFieldDescuento.setEnabled(!esActivo);
		txtDescripcion.setEnabled(!esActivo);

		// activos
		textFieldEmail.setEnabled(esActivo);
		textFieldTelefono.setEnabled(esActivo);
		textFieldDireccion.setEnabled(esActivo);
		btnGuardar.setEnabled(esActivo);
	}

	protected void modoRegistrar(boolean esVisible) {
		btnBuscar.setVisible(!esVisible);
	}

	protected void modoBecado(boolean esBecado) {
		lblDescuento.setVisible(esBecado);
		textFieldDescuento.setVisible(esBecado);
		lblDescripcion.setVisible(esBecado);
		txtDescripcion.setVisible(esBecado);
	}

	protected void cargarDatos(boolean comun, String... contenido) {
		modoBecado(!comun);
		textFieldNombre.setText(contenido[0]);
		textFieldApellido.setText(contenido[1]);
		textFieldEmail.setText(contenido[2]);
		textFieldTelefono.setText(contenido[3]);
		textFieldDireccion.setText(contenido[4]);
	}

	protected void setActionListenerBuscar(ActionListener listener) {
		btnBuscar.addActionListener(listener);

	}

	protected void setActionListenerGuardar(ActionListener listener) {
		btnGuardar.addActionListener(listener);

	}
}