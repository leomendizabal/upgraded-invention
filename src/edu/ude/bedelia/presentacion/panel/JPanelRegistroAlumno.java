package edu.ude.bedelia.presentacion.panel;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;

public class JPanelRegistroAlumno extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JCheckBox chckbxEsBecado;
	private JComboBox cmbPorcentaje;
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
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(15, 16, 435, 298);
		add(panel);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(109, 25, 253, 20);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(109, 58, 253, 20);
		panel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(109, 89, 253, 20);
		panel.add(textField_2);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(10, 28, 89, 14);
		panel.add(lblNombre);

		JLabel lblApellido = new JLabel("Cedula");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setBounds(10, 90, 89, 19);
		panel.add(lblApellido);

		JLabel label = new JLabel("Apellido");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 61, 89, 14);
		panel.add(label);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(247, 253, 115, 29);
		panel.add(btnGuardar);
		
		chckbxEsBecado = new JCheckBox("Es becado");
		chckbxEsBecado.setBounds(109, 121, 139, 29);
		panel.add(chckbxEsBecado);
				
		lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(15, 175, 84, 20);
		lblDescripcion.setVisible(false);
		panel.add(lblDescripcion);
		
		cmbPorcentaje = new JComboBox();
		cmbPorcentaje.setModel(new DefaultComboBoxModel(new String[] {"10%", "20%", "30%", "40%", "50%", "60%", "70%", "80%", "90%", "100%"}));
		cmbPorcentaje.setToolTipText("Porcentaje");
		cmbPorcentaje.setBounds(259, 125, 99, 26);
		cmbPorcentaje.setVisible(false);
		panel.add(cmbPorcentaje);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setBounds(109, 175, 253, 62);
		txtDescripcion.setVisible(false);
		panel.add(txtDescripcion);
		
		registrarEventListeners();
	}
}
