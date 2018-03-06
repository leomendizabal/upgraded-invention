package edu.ude.bedelia.presentacion.panel.registro;

import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.ude.bedelia.presentacion.controladores.ControladorAlumno;
import edu.ude.bedelia.presentacion.controladores.ControladorRegistrarResultado;
import edu.ude.bedelia.presentacion.panel.JPanelBase;
import edu.ude.bedelia.presentacion.panel.listener.IMensaje;

import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class JPanelRegistrarNota extends JPanelBase implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final ControladorRegistrarResultado controlador;
	
	protected JTextField textFieldCedula;
	protected JTextField textFieldNroIns;
	protected JComboBox cmbNota;
	private JTextField textFieldAno;
	JButton btnGuardar;
	
	public JPanelRegistrarNota() {
		super();
		controlador = ControladorRegistrarResultado.getInstance(this);
		
		textFieldCedula = new JTextField();
		textFieldCedula.setBounds(103, 36, 259, 26);
		add(textFieldCedula);
		textFieldCedula.setColumns(10);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(20, 39, 48, 20);
		add(lblCedula);
		
		textFieldNroIns = new JTextField();
		textFieldNroIns.setBounds(103, 84, 259, 26);
		add(textFieldNroIns);
		textFieldNroIns.setColumns(10);
		
		JLabel lblNroIns = new JLabel("Nro Ins");
		lblNroIns.setBounds(20, 87, 53, 20);
		add(lblNroIns);
		
		cmbNota = new JComboBox();
		cmbNota.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cmbNota.setBounds(103, 191, 100, 26);
		add(cmbNota);
		
		JLabel lblNota = new JLabel("Nota");
		lblNota.setBounds(20, 194, 33, 20);
		add(lblNota);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(234, 190, 128, 29);
		add(btnGuardar);
		
		textFieldAno = new JTextField();
		textFieldAno.setBounds(103, 137, 259, 26);
		add(textFieldAno);
		textFieldAno.setColumns(10);
		
		JLabel lblAno = new JLabel("A\u00F1o");
		lblAno.setBounds(0, 0, 450, 300);
		add(lblAno);
		
		setActionListenerGuardar(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controlador.registrar(false, textFieldCedula.getText(),(String) cmbNota.getSelectedItem(), textFieldNroIns.getText(), textFieldAno.getText());
	}
	
	protected void setActionListenerGuardar(ActionListener listener) {
		btnGuardar.addActionListener(listener);
	}
}
