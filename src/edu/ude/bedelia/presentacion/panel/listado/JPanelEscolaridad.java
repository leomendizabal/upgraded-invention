package edu.ude.bedelia.presentacion.panel.listado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.AbstractTableModel;

import edu.ude.bedelia.presentacion.controladores.ControladorEscolaridad;
import edu.ude.bedelia.presentacion.panel.listener.ICargarTabla;

public class JPanelEscolaridad extends JPanelTablaConFiltro implements ICargarTabla, ActionListener {

	/**
	 * 
	 */
	public final static String TAG = JPanelEscolaridad.class.getSimpleName();
	public final static String TITULO = "Escolaridad";
	private static final long serialVersionUID = 1L;
	private final ControladorEscolaridad controlador;

	/**
	 * Create the panel.
	 */
	public JPanelEscolaridad() {
		super();
		controlador = ControladorEscolaridad.getInstance(this);
		setTextoReferenciaFiltro("Cedula");
		setTextoReferenciaModo("Modo");
		setActionListenerBtnFiltro(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		controlador.listar(textFieldTexto.getText(), String.valueOf(rdbtnCompleto.isSelected()));

	}

	@Override
	public void cargarTabla(AbstractTableModel model) {
		// TODO Auto-generated method stub
		table.setModel(model);

	}

	@Override
	public void tablaVacia() {
		// TODO Auto-generated method stub
		table.setVisible(false);
		lblMensaje.setVisible(true);
		lblMensaje.setText("No hay datos para mostrar");

	}
}
