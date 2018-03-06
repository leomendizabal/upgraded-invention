package edu.ude.bedelia.presentacion.panel.registro;

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

public class JPanelInscribirAsignatura extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnGuardar;
	private JTextField textField_3;
	
	private void registrarEventListeners() {
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
	}
	/**
	 * Create the panel.
	 */
	public JPanelInscribirAsignatura() {
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

		JLabel lblNombre = new JLabel("Cedula");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(10, 28, 89, 14);
		panel.add(lblNombre);

		JLabel lblApellido = new JLabel("A\u00F1o");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setBounds(10, 90, 89, 19);
		panel.add(lblApellido);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigo.setBounds(10, 61, 89, 14);
		panel.add(lblCodigo);
		
		btnGuardar = new JButton("Inscribir");
		btnGuardar.setBounds(180, 186, 115, 29);
		panel.add(btnGuardar);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(109, 120, 253, 20);
		panel.add(textField_3);
		
		JLabel lblMontoBase = new JLabel("Monto base");
		lblMontoBase.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMontoBase.setBounds(10, 121, 89, 19);
		panel.add(lblMontoBase);
		
		registrarEventListeners();
	}
}
