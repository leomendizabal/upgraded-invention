package edu.ude.bedelia.presentacion.tablemodel;

import java.util.List;

import edu.ude.bedelia.logica.vo.VOAlumno;

public class AlumnoModel extends TableModelGenerico<VOAlumno> {

	private static final long serialVersionUID = 1L;

	public AlumnoModel(List<VOAlumno> modelData, List<String> columnNames) {
		super(modelData, columnNames);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object objectoCelda = null;
		VOAlumno valor = getFila(rowIndex);

		switch (columnIndex) {
		case 0:
			objectoCelda = valor.getApellido();
			break;
		case 1:
			objectoCelda = valor.getNombre();
			break;
		case 2:
			objectoCelda = valor.getCedula();
			break;
		case 3:
			objectoCelda = valor.getTipo();
			break;
		}

		return objectoCelda;
	}
}
