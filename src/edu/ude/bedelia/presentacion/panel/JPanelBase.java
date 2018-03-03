package edu.ude.bedelia.presentacion.panel;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import edu.ude.bedelia.presentacion.panel.listener.IMensaje;

public class JPanelBase extends JPanel implements IMensaje {

	/**
	 * Create the panel.
	 */
	public JPanelBase() {

	}

	@Override
	public void mostrarConfirmacion(String titulo, String mensaje) {
		// TODO Auto-generated method stub
		mostrarMensaje(titulo, mensaje, JOptionPane.INFORMATION_MESSAGE);

	}

	@Override
	public void mostrarError(String titulo, String mensaje) {
		// TODO Auto-generated method stub
		mostrarMensaje(titulo, mensaje, JOptionPane.ERROR_MESSAGE);

	}

	private void mostrarMensaje(String titulo, String mensaje, int tipo) {
		JOptionPane.showMessageDialog(this, titulo, mensaje, tipo);
	}

}
