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
import javax.swing.JTextPane;
import edu.ude.bedelia.presentacion.controladores.ControladorAlumno;
import edu.ude.bedelia.presentacion.controladores.ControladorInscripcion;
import edu.ude.bedelia.presentacion.panel.listener.IMensaje;
import edu.ude.bedelia.presentacion.panel.listener.IMostrarMonto;

public class JpanelMontoRecaudado extends JPanelBase implements IMostrarMonto  {
	
	private static final long serialVersionUID = 1L;
	private final ControladorInscripcion controladorInscripcion;
	private JTextField textCed;
	private JTextField textAno;
	private JButton btnCalcular;
	private JLabel lblMontoRecuadado;
	
	
	private void registrarEventListeners() {
		
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorInscripcion.mostrar(JpanelMontoRecaudado.this,textAno.getText(),textCed.getText());
				
				
			}
		});
	}
	/**
	 * Create the panel.
	 */
	public JpanelMontoRecaudado() {
		
		super();
		controladorInscripcion = ControladorInscripcion.getInstance(this);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(15, 16, 435, 298);
		add(panel);
		panel.setLayout(null);

		textCed = new JTextField();
		textCed.setBounds(124, 25, 253, 20);
		panel.add(textCed);
		textCed.setColumns(10);

		textAno = new JTextField();
		textAno.setColumns(10);
		textAno.setBounds(124, 56, 253, 20);
		panel.add(textAno);

		JLabel lblNombre = new JLabel("Cedula");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(10, 28, 89, 14);
		panel.add(lblNombre);

		JLabel lblApellido = new JLabel("A\u00F1o");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setBounds(10, 57, 89, 19);
		panel.add(lblApellido);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(183, 98, 115, 29);
		panel.add(btnCalcular);
		
	    lblMontoRecuadado = new JLabel("");
		lblMontoRecuadado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMontoRecuadado.setBounds(183, 148, 115, 19);
		panel.add(lblMontoRecuadado);
		
		registrarEventListeners();
	}
	@Override
	public void mostrar(String monto) {
		// TODO Auto-generated method stub
		lblMontoRecuadado.setText(monto);
		
	}
	
	
	
}
