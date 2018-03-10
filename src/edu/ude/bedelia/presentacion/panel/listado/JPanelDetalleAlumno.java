package edu.ude.bedelia.presentacion.panel.listado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.AbstractTableModel;

import edu.ude.bedelia.presentacion.UIConstantes;
import edu.ude.bedelia.presentacion.controladores.ControladorDetalleAlumno;
import edu.ude.bedelia.presentacion.panel.listener.ICargarTabla;

public class JPanelDetalleAlumno extends JPanelTablaConFiltro implements ICargarTabla, ActionListener {

	private static final long serialVersionUID = 1L;
	public final static String TAG = JPanelDetalleAlumno.class.getSimpleName();
	public final static String TITULO = "Datos del alumno";
	private final static String TEXTO_REFERENCIA_FILTRO = "Cedula";
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
		ocultarMensaje();
		setTextoReferenciaFiltro(TEXTO_REFERENCIA_FILTRO);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		controlador.listar(textFieldTexto.getText());
	}

	@Override
	public void cargarTabla(AbstractTableModel model) {
		// TODO Auto-generated method stub
		setModel(model);
		limpiarFiltro();

	}

	@Override
	public void mostrarError(String titulo, String mensaje) {
		super.mostrarError(titulo, mensaje);
		tablaVacia();
	}

	@Override
	public void tablaVacia() {
		// TODO Auto-generated method stub
		mostrarMensajeTabla(UIConstantes.MensajesError.ERROR_NO_SE_CARGARON_DATOS);

	}

}
