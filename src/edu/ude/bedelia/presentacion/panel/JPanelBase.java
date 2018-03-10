package edu.ude.bedelia.presentacion.panel;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.text.JTextComponent;

import edu.ude.bedelia.presentacion.Mensajes;
import edu.ude.bedelia.presentacion.UIConstantes;
import edu.ude.bedelia.presentacion.panel.listener.IMensaje;

public class JPanelBase extends JPanel implements IMensaje {

	/**
	 * Create the panel.
	 */
	public JPanelBase() {
		setLayout(new BorderLayout(0, 0));

	}

	@Override
	public void mostrarConfirmacion(String titulo, String mensaje) {
		// TODO Auto-generated method stub
		Mensajes.mostrarMensaje(this, titulo, mensaje, JOptionPane.INFORMATION_MESSAGE);

	}

	@Override
	public void mostrarError(String titulo, String mensaje) {
		// TODO Auto-generated method stub
		Mensajes.mostrarMensaje(this, titulo, mensaje, JOptionPane.ERROR_MESSAGE);

	}

	protected void limpiarTextField(JPanel jpanel) {
		for (Component componente : jpanel.getComponents()) {
			System.out.println(componente.getClass().getName());
			if (componente instanceof JTextField || componente instanceof JTextArea) {

				((JTextComponent) componente).setText(UIConstantes.STRING_VACIO);
			}
		}
	}

	protected void resizeColumnWidth(JTable table) {
		final TableColumnModel columnModel = table.getColumnModel();
		for (int column = 0; column < table.getColumnCount(); column++) {
			int width = 15;
			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer renderer = table.getCellRenderer(row, column);
				Component comp = table.prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width + 1, width);
			}
			if (width > 300)
				width = 300;
			columnModel.getColumn(column).setPreferredWidth(width);
		}
	}

}
