package edu.ude.bedelia.presentacion.panel.listener;

import javax.swing.table.AbstractTableModel;

public interface ICargarTabla extends IMensaje {

	public void cargarTabla(AbstractTableModel model);
	
	public void tablaVacia( ) ;
}
