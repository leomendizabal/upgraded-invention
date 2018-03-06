package edu.ude.bedelia.presentacion.panel.registro;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.ude.bedelia.presentacion.controladores.ControladorInscripcion;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;

public class JPanelInscribirAsignatura extends JPanelBase{
	
	private static final long serialVersionUID = 1L;
	private final ControladorInscripcion controladorInscripcion;
	private JTextField textcedula;
	private JTextField textcodigo;
	private JTextField textFieldanio;
	private JButton btnInscribir;
	private JTextField textFieldmonto;
	
	private void registrarEventListeners() {
		
		btnInscribir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controladorInscripcion.registrar(false,textcedula.getText(),textcodigo.getText(),textcodigo.getText(),textFieldmonto.getText() );
				
				
			}
		});
	}
	/**
	 * Create the panel.
	 */
	public JPanelInscribirAsignatura() {
		
		super();
		controladorInscripcion = ControladorInscripcion.getInstance(this);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(15, 16, 435, 298);
		add(panel);
		panel.setLayout(null);

		textcedula = new JTextField();
		textcedula.setBounds(109, 25, 253, 20);
		panel.add(textcedula);
		textcedula.setColumns(10);

		textcodigo = new JTextField();
		textcodigo.setColumns(10);
		textcodigo.setBounds(109, 58, 253, 20);
		panel.add(textcodigo);

		textFieldanio = new JTextField();
		textFieldanio.setColumns(10);
		textFieldanio.setBounds(109, 89, 253, 20);
		panel.add(textFieldanio);

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
		
		btnInscribir = new JButton("Inscribir");
		btnInscribir.setBounds(180, 186, 115, 29);
		panel.add(btnInscribir);
		
		textFieldmonto = new JTextField();
		textFieldmonto.setColumns(10);
		textFieldmonto.setBounds(109, 120, 253, 20);
		panel.add(textFieldmonto);
		
		JLabel lblMontoBase = new JLabel("Monto base");
		lblMontoBase.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMontoBase.setBounds(10, 121, 89, 19);
		panel.add(lblMontoBase);
		
		registrarEventListeners();
	}
}
