package edu.ude.bedelia.presentacion.panel.listado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.AbstractTableModel;

import edu.ude.bedelia.presentacion.controladores.ControladorListarApellido;
import edu.ude.bedelia.presentacion.panel.listener.ICargarTabla;

public class JPanelListadoApellido extends JPanelTablaConFiltro implements ICargarTabla, ActionListener {

	/**
	 * 
	 */
	public final static String TAG = JPanelListadoApellido.class.getSimpleName();
	private static final long serialVersionUID = 1L;
	private final ControladorListarApellido controlador;

	public JPanelListadoApellido() {
		super();
		lblMensaje.setText("");
		controlador = ControladorListarApellido.getInstance(this);
		configurarVista();
		setActionListener();
	}

	private void configurarVista() {
		setTextoReferenciaFiltro("Apellido");
		ocultarModoFiltro();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controlador.listar(textFieldTexto.getText());
	}

	@Override
	public void cargarTabla(AbstractTableModel model) {
		this.table.setModel(model);
		this.lblMensaje.setVisible(false);
		this.table.setVisible(true);
	}

	@Override
	public void tablaVacia() {
		this.lblMensaje.setText("No hay datos para mostrar");
		this.lblMensaje.setVisible(true);
		this.table.setVisible(false);
	}

	private void setActionListener() {
		btnFiltrar.addActionListener(this);
	}
}
