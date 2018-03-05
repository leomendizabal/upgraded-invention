package edu.ude.bedelia.presentacion.panel.listado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.AbstractTableModel;

import edu.ude.bedelia.presentacion.controladores.ControladorEgresado;
import edu.ude.bedelia.presentacion.panel.listener.ICargarTabla;

public class JPanelListadoEgresado extends JPanelTablaConFiltro implements ICargarTabla, ActionListener {

	private static final long serialVersionUID = 1L;
	private final ControladorEgresado controlador;

	/**
	 * Create the panel.
	 */
	public JPanelListadoEgresado() {
		super();
		controlador = ControladorEgresado.getInstance(this);
		configurarVista();
		setActionListener();
	}

	private void configurarVista() {
		this.textFieldTexto.setVisible(false);
		this.lblTextoReferencia.setVisible(false);
		this.lblMensaje.setVisible(false);
	}

	private void setActionListener() {
		btnFiltrar.addActionListener(this);
	}

	@Override
	public void cargarTabla(AbstractTableModel model) {
		this.table.setModel(model);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Llamar controllador
		controlador.listar(rdbtnCompleto.isSelected());
	}

	@Override
	public void tablaVacia() {
		// TODO ocultar la tabla y mostrar mensaje
		this.lblMensaje.setText("No hay datos para mostrar");
		this.lblMensaje.setVisible(true);

	}

}
