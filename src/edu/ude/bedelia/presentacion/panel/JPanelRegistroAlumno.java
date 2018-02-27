package edu.ude.bedelia.presentacion.panel;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanelRegistroAlumno extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public JPanelRegistroAlumno() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 547, 400);
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

	}
}
