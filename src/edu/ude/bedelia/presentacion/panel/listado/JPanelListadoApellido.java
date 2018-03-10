package edu.ude.bedelia.presentacion.panel.listado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.AbstractTableModel;

import edu.ude.bedelia.presentacion.UIConstantes;
import edu.ude.bedelia.presentacion.controladores.ControladorListarApellido;
import edu.ude.bedelia.presentacion.panel.listener.ICargarTabla;

public class JPanelListadoApellido extends JPanelTablaConFiltro implements ICargarTabla, ActionListener {

	public final static String TAG = JPanelListadoApellido.class.getSimpleName();
	public final static String TITULO = "Listado de alumno por apellido";
	private final static String TEXTO_REFERENCIA_FILTRO = "Apellidoo";
	private static final long serialVersionUID = 1L;
	private final ControladorListarApellido controlador;

	public JPanelListadoApellido() {
		super();
		controlador = ControladorListarApellido.getInstance(this);
		configurarVista();
		setActionListenerBtnFiltro(this);
	}

	private void configurarVista() {
		setTextoReferenciaFiltro(TEXTO_REFERENCIA_FILTRO);
		ocultarMensaje();
		ocultarModoFiltro();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controlador.listar(textFieldTexto.getText());
	}

	@Override
	public void cargarTabla(AbstractTableModel model) {
		setModel(model);
	}

	@Override
	public void tablaVacia() {
		mostrarMensajeTabla(UIConstantes.MensajesError.ERROR_NO_SE_CARGARON_DATOS);
	}

}
