package edu.ude.bedelia.presentacion.panel.registro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.ude.bedelia.presentacion.controladores.ControladorAlumno;

public class JPanelRegistrarAlumno extends JPanelAlumno implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ControladorAlumno controladorAlumno;

	/**
	 * Create the panel.
	 */
	public JPanelRegistrarAlumno() {
		super();
		controladorAlumno = ControladorAlumno.getInstance(this);
		modoRegistrar(true);
		setActionListenerGuardar(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		boolean esBecado = chckbxEsBecado.isSelected();
		if(esBecado) {
			controladorAlumno.registrar(esBecado, textFieldCedula.getText(),textFieldNombre.getText(),textFieldApellido.getText(),
					textFieldDireccion.getText(),textFieldTelefono.getText(),textFieldEmail.getText(),textFieldDescuento.getText(),txtDescripcion.getText());
		
		} else {
			controladorAlumno.registrar(esBecado, textFieldCedula.getText(),textFieldNombre.getText(),textFieldApellido.getText(),
					textFieldDireccion.getText(),textFieldTelefono.getText(),textFieldEmail.getText());
			
		}
	}

}
