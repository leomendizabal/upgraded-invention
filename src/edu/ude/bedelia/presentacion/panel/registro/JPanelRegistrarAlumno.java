package edu.ude.bedelia.presentacion.panel.registro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.ude.bedelia.presentacion.controladores.ControladorRegistrarAlumno;

public class JPanelRegistrarAlumno extends JPanelAlumno implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static String TAG = JPanelRegistrarAlumno.class.getSimpleName();
	public final static String TITULO = "Registro de alumno";

	private final ControladorRegistrarAlumno controladorAlumno;

	/**
	 * Create the panel.
	 */
	public JPanelRegistrarAlumno() {
		super();
		controladorAlumno = ControladorRegistrarAlumno.getInstance(this);
		modoRegistrar(true);
		modoBecado(false);
		setActionListenerGuardar(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		boolean esBecado = chckbxEsBecado.isSelected();
		if (esBecado) {
			controladorAlumno.registrar(esBecado, textFieldCedula.getText(), textFieldNombre.getText(),
					textFieldApellido.getText(), textFieldDireccion.getText(), textFieldTelefono.getText(),
					textFieldEmail.getText(), textFieldDescuento.getText(), txtDescripcion.getText());

		} else {
			controladorAlumno.registrar(esBecado, textFieldCedula.getText(), textFieldNombre.getText(),
					textFieldApellido.getText(), textFieldDireccion.getText(), textFieldTelefono.getText(),
					textFieldEmail.getText());

		}
	}

	@Override
	public void mostrarConfirmacion(String titulo, String mensaje) {
		// TODO Auto-generated method stub
		super.mostrarConfirmacion(titulo, mensaje);
		limpiarFormulario();
	}

}
