package edu.ude.bedelia.presentacion.panel.registro;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;

public class JPanelRegistroAlumno extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JCheckBox chckbxEsBecado;
	private JComboBox<String> cmbPorcentaje;
	private JLabel lblDescripcion;
	private JTextArea txtDescripcion;
	private JButton btnGuardar;

	private void registrarEventListeners() {
		chckbxEsBecado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean esBecado = chckbxEsBecado.isSelected();
				cmbPorcentaje.setVisible(esBecado);
				lblDescripcion.setVisible(esBecado);
				txtDescripcion.setVisible(esBecado);
			}
		});

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}

	/**
	 * Create the panel.
	 */
	public JPanelRegistroAlumno() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(197, 58, 253, 20);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(197, 91, 253, 20);
		panel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(197, 28, 253, 20);
		panel.add(textField_2);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(98, 61, 89, 14);
		panel.add(lblNombre);

		JLabel lblApellido = new JLabel("Cedula");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setBounds(98, 29, 89, 19);
		panel.add(lblApellido);

		JLabel label = new JLabel("Apellido");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(98, 94, 89, 14);
		panel.add(label);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(347, 282, 115, 29);
		panel.add(btnGuardar);

		chckbxEsBecado = new JCheckBox("Es becado");
		chckbxEsBecado.setBounds(197, 154, 139, 29);
		panel.add(chckbxEsBecado);

		lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(103, 208, 84, 20);
		lblDescripcion.setVisible(false);
		panel.add(lblDescripcion);

		cmbPorcentaje = new JComboBox();
		cmbPorcentaje.setModel(new DefaultComboBoxModel<String>(
				new String[] { "10%", "20%", "30%", "40%", "50%", "60%", "70%", "80%", "90%", "100%" }));
		cmbPorcentaje.setToolTipText("Porcentaje");
		cmbPorcentaje.setBounds(347, 158, 99, 26);
		cmbPorcentaje.setVisible(false);
		panel.add(cmbPorcentaje);

		txtDescripcion = new JTextArea();
		txtDescripcion.setBounds(197, 208, 253, 62);
		txtDescripcion.setVisible(false);
		panel.add(txtDescripcion);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(197, 282, 115, 29);
		panel.add(btnBuscar);

		registrarEventListeners();
	}
}