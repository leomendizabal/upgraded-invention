package edu.ude.bedelia.presentacion.panel.listado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.AbstractTableModel;

import edu.ude.bedelia.presentacion.controladores.ControladorDetalleAlumno;
import edu.ude.bedelia.presentacion.panel.listener.ICargarTabla;
import edu.ude.bedelia.presentacion.panel.registro.JPanelRegistroAsignatura;

public class JPanelDetalleAlumno extends JPanelTablaConFiltro implements ICargarTabla, ActionListener {

	private static final long serialVersionUID = 1L;
	public final static String TAG = JPanelDetalleAlumno.class.getSimpleName();
	private final ControladorDetalleAlumno controlador;

	/**
	 * Create the panel.
	 */
	public JPanelDetalleAlumno() {
		super();
		controlador = new ControladorDetalleAlumno(this);
		configurarVista();
		setActionListenerBtnFiltro(this);
	}

	private void configurarVista() {
		ocultarModoFiltro();
		setTextoReferenciaFiltro("Cedula");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		controlador.listar(textFieldTexto.getText());
	}

	@Override
	public void cargarTabla(AbstractTableModel model) {
		// TODO Auto-generated method stub
		table.setModel(model);

	}

	@Override
	public void mostrarError(String titulo, String mensaje) {
		super.mostrarError(titulo, mensaje);
		tablaVacia();
	}

	@Override
	public void tablaVacia() {
		// TODO Auto-generated method stub
		table.setVisible(false);
		lblMensaje.setVisible(true);
		lblMensaje.setText("No hay datos para mostrar");

	}

}
