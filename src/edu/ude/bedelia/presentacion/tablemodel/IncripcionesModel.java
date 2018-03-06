package edu.ude.bedelia.presentacion.tablemodel;

import java.util.List;

import edu.ude.bedelia.logica.vo.VOInscripcion;
import edu.ude.bedelia.logica.vo.VOInscripcionCompleta;

public class IncripcionesModel extends TableModelGenerico<VOInscripcion> {

	private static final long serialVersionUID = 1L;

	public IncripcionesModel(List<String> columnNames) {
		super(columnNames);
		// TODO Auto-generated constructor stub
	}

	public IncripcionesModel(List<VOInscripcion> modelData, List<String> columnNames) {
		super(modelData, columnNames);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Object value = null;
		VOInscripcion inscripcion = getRow(rowIndex);

		switch (columnIndex) {
		case 0:
			value = inscripcion.getNumero();
			break;
		case 1:
			value = inscripcion.getAsignatura().getNombre();
			break;
		case 2:
			value = inscripcion.getAnio();
			break;
		case 3:
			value = inscripcion.getCalificacion();
			break;
		}

		if (inscripcion instanceof VOInscripcionCompleta && columnIndex == 4) {
			value = ((VOInscripcionCompleta) inscripcion).getMontoBase();
		}
		return value;
	}

}
