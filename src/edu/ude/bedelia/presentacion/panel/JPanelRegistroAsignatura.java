package edu.ude.bedelia.presentacion.panel;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JPanelRegistroAsignatura extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public JPanelRegistroAsignatura() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 11, 483, 267);
		add(panel);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(109, 25, 253, 20);
		panel.add(textField);

		JLabel label = new JLabel("Nombre");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 28, 89, 14);
		panel.add(label);

		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescripcion.setBounds(10, 61, 89, 14);
		panel.add(lblDescripcion);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(109, 71, 253, 119);
		panel.add(textArea);

	}
}
