package edu.ude.bedelia.presentacion.panel.registro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import edu.ude.bedelia.presentacion.UIConstantes;
import edu.ude.bedelia.presentacion.controladores.ControlladorModificarAlumno;
import edu.ude.bedelia.presentacion.panel.listener.IModificarDatos;

public class JPanelModificarAlumno extends JPanelAlumno implements IModificarDatos {

	private static final long serialVersionUID = 1L;
	public final static String TAG = JPanelModificarAlumno.class.getSimpleName();
	public final static String TITULO = "Modificar alumno";
	private final ControlladorModificarAlumno controlador;

	private final ActionListener actionListenerBuscar = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			controlador.buscar(textFieldCedula.getText());

		}
	};

	private final ActionListener actionListenerModificar = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			controlador.modificar(textFieldDireccion.getText(), textFieldEmail.getText(), textFieldTelefono.getText());

		}
	};

	/**
	 * Create the panel.
	 */

	public JPanelModificarAlumno() {
		super();
		controlador = ControlladorModificarAlumno.getInstance(this);
		modoModificar(true);
		setActionListenerBuscar(actionListenerBuscar);
		setActionListenerGuardar(actionListenerModificar);
	}

	@Override
	public void mostrarDatos(boolean esBecado, Map<String, String> atributos) {
		// TODO Auto-generated method stub
		modoBecado(esBecado);
		if (esBecado) {
			chckbxEsBecado.setSelected(esBecado);
			txtDescripcion.setText(atributos.get(UIConstantes.ParametrosAlumno.CLAVE_DESCRIPCION));
			textFieldDescuento.setText(atributos.get(UIConstantes.ParametrosAlumno.CLAVE_PORCENTAJE));
		}
		textFieldNombre.setText(atributos.get(UIConstantes.ParametrosAlumno.CLAVE_NOMBRE));
		textFieldApellido.setText(atributos.get(UIConstantes.ParametrosAlumno.CLAVE_APELLIDO));
		textFieldDireccion.setText(atributos.get(UIConstantes.ParametrosAlumno.CLAVE_DIRECCION));
		textFieldTelefono.setText(atributos.get(UIConstantes.ParametrosAlumno.CLAVE_TELEFONO));
		textFieldEmail.setText(atributos.get(UIConstantes.ParametrosAlumno.CLAVE_EMAIL));
		habilitarModificacion(true);

	}

}
