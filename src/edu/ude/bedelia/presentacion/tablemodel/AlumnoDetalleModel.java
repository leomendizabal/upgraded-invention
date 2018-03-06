package edu.ude.bedelia.presentacion.tablemodel;

import java.util.List;

import edu.ude.bedelia.logica.vo.VOAlumnoCompleto;
import edu.ude.bedelia.logica.vo.VOBecadoCompleto;

public class AlumnoDetalleModel extends TableModelGenerico<VOAlumnoCompleto> {

	private static final long serialVersionUID = 1L;

	protected AlumnoDetalleModel(List<VOAlumnoCompleto> modelData, List<String> columnNames) {
		super(modelData, columnNames);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		VOAlumnoCompleto alumno = getRow(rowIndex);
		Object value = null;

		switch (columnIndex) {
		case 0:
			value = alumno.getCedula();
			break;
		case 1:
			value = alumno.getNombre();
			break;
		case 2:
			value = alumno.getApellido();
			break;
		case 3:
			value = alumno.getDomicilio();
			break;
		case 4:
			value = alumno.getTelefono();
			break;
		case 5:
			value = alumno.getEmail();
			break;
		case 6:
			value = alumno.getMonto();
			break;
		case 7:
			value = alumno.getTipo().name();
			break;
		}

		if (alumno instanceof VOBecadoCompleto) {
			VOBecadoCompleto becado = (VOBecadoCompleto) alumno;
			switch (columnIndex) {
			case 8:
				value = becado.getPorcentaje();
				break;
			case 9:
				value = becado.getDescripcion();
				break;
			}
		}
		return value;
	}

}
