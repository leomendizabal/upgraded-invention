package edu.ude.bedelia.presentacion.tablemodel;

import java.util.List;

import edu.ude.bedelia.logica.vo.VOAsignatura;

public class AsignaturaModel extends TableModelGenerico<VOAsignatura> {

	private static final long serialVersionUID = 1L;

	protected AsignaturaModel(List<String> columnNames) {
		super(columnNames);
	}

	public AsignaturaModel(List<VOAsignatura> modelData, List<String> columnNames) {
		super(modelData, columnNames);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Object value = null;
		VOAsignatura asignatura = getRow(rowIndex);
		switch (columnIndex) {
			case 0:
				return asignatura.getCodigo();
			case 1:
				return asignatura.getNombre(); // Nombre
			case 2:
				return asignatura.getDescripcion();
		}
		return value;
	}

}
