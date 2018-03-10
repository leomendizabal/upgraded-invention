package edu.ude.bedelia.presentacion.panel.registro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.ude.bedelia.presentacion.controladores.ControlladorModificarAlumno;
import edu.ude.bedelia.presentacion.panel.listener.IModificarDatos;
import edu.ude.bedelia.presentacion.vo.VOPresentacionAlumno;

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
	public void mostrarDatos(final VOPresentacionAlumno alumno) {
		boolean esBecado = alumno.esBecado();
		// TODO Auto-generated method stub
		modoBecado(esBecado);
		if (esBecado) {
			chckbxEsBecado.setSelected(esBecado);
			txtDescripcion.setText(alumno.getDescripcion());
			textFieldDescuento.setText(alumno.getStrPorcentaje());
		}
		textFieldNombre.setText(alumno.getNombre());
		textFieldApellido.setText(alumno.getApellido());
		textFieldDireccion.setText(alumno.getDomicilio());
		textFieldTelefono.setText(alumno.getTelefono());
		textFieldEmail.setText(alumno.getEmail());
		habilitarModificacion(true);

	}

	@Override
	public void mostrarConfirmacion(String titulo, String mensaje) {
		// TODO Auto-generated method stub
		super.mostrarConfirmacion(titulo, mensaje);
		limpiarFormulario();
		modoModificar(true);
	}

}
