package edu.ude.bedelia.presentacion.panel.listado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.AbstractTableModel;

import edu.ude.bedelia.presentacion.UIConstantes;
import edu.ude.bedelia.presentacion.controladores.ControladorEgresado;
import edu.ude.bedelia.presentacion.panel.listener.ICargarTabla;

public class JPanelListadoEgresado extends JPanelTablaConFiltro implements ICargarTabla, ActionListener {

	private static final long serialVersionUID = 1L;
	private final ControladorEgresado controlador;
	public final static String TAG = JPanelListadoEgresado.class.getSimpleName();
	public final static String TITULO = "Listado de Egresados";
	private final static String TEXTO_REFERENCIA_MODO = "Modo";

	/**
	 * Create the panel.
	 */
	public JPanelListadoEgresado() {
		super();
		controlador = ControladorEgresado.getInstance(this);
		configurarVista();
		setActionListenerBtnFiltro(this);
	}

	private void configurarVista() {
		ocultarTextoFiltro();
		setTextoReferenciaModo(TEXTO_REFERENCIA_MODO);
	}

	@Override
	public void cargarTabla(AbstractTableModel model) {
		setModel(model);
		limpiarFiltro();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Llamar controllador
		controlador.listar(rdbtnCompleto.isSelected());
	}

	@Override
	public void tablaVacia() {
		mostrarMensajeTabla(UIConstantes.MensajesError.ERROR_NO_SE_CARGARON_DATOS);

	}

}
