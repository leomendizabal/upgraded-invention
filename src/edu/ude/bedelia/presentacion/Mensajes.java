package edu.ude.bedelia.presentacion;

import java.awt.Component;

import javax.swing.JOptionPane;

public final class Mensajes extends Component {

	private static final long serialVersionUID = 1L;

	public static void mostrarMensaje(final Component component, String titulo, String mensaje, int tipo) {
		JOptionPane.showMessageDialog(component, titulo, mensaje, tipo);
	}

}
