package edu.ude.bedelia.presentacion.tablemodel;

import java.util.List;

import edu.ude.bedelia.logica.vo.VOEgresado;
import edu.ude.bedelia.logica.vo.VOEgresadoCompleto;

public class EgresadoModel extends TableModelGenerico<VOEgresado> {

	private static final long serialVersionUID = 1L;

	public EgresadoModel(List<VOEgresado> modelData, List<String> columnNames) {
		super(modelData, columnNames);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Object objectoCelda = null;
		VOEgresado valor = getFila(rowIndex);
		if (valor instanceof VOEgresadoCompleto) {
			VOEgresadoCompleto completo = (VOEgresadoCompleto) valor;
			switch (columnIndex) {
			case 0:
				objectoCelda = completo.getApellido();
				break;
			case 1:
				objectoCelda = completo.getNombre();
				break;
			case 2:
				objectoCelda = completo.getCedula();
				break;
			case 3:
				objectoCelda = completo.getPromedioTotal();
				break;
			case 4:
				objectoCelda = completo.getPromedioAprobaciones();
				break;
			}
		} else {
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

			}
		}

		return objectoCelda;
	}

}
