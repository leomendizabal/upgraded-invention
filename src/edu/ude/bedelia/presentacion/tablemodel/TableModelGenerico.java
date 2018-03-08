package edu.ude.bedelia.presentacion.tablemodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

abstract class TableModelGenerico<T> extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected List<T> datos;
	protected List<String> columnas;
	protected Class[] clasesColumnas;
	protected Boolean[] esColumnaEditable;
	private Class<Object> clasesFila = Object.class;
	private boolean esModeloEditable = false;

	protected TableModelGenerico(Class<?> rowClass) {
		setClaseFila(rowClass);
	}

	protected TableModelGenerico(List<String> columnNames) {
		this(new ArrayList<T>(), columnNames);
	}

	protected TableModelGenerico(List<T> modelData, List<String> columnNames) {
		setDatosColumnas(modelData, columnNames);
	}

	protected TableModelGenerico(List<T> modelData, List<String> columnNames, Class<?> rowClass) {
		setDatosColumnas(modelData, columnNames);
		setClaseFila(rowClass);
	}

	protected void setDatosColumnas(List<T> modelData, List<String> columnNames) {
		this.datos = modelData;
		this.columnas = columnNames;
		clasesColumnas = new Class[getColumnCount()];
		esColumnaEditable = new Boolean[getColumnCount()];
		fireTableStructureChanged();
	}

	protected void setClaseFila(Class filaClass) {
		this.clasesFila = filaClass;
	}

	public int getColumnCount() {
		return columnas.size();
	}

	public String getColumnName(int column) {
		Object columnName = null;

		if (column < columnas.size()) {
			columnName = columnas.get(column);
		}

		return (columnName == null) ? super.getColumnName(column) : columnName.toString();
	}

	public int getRowCount() {
		return datos.size();
	}

	public void addRow(T rowData) {
		insertFila(getRowCount(), rowData);
	}

	public T getFila(int row) {
		return datos.get(row);
	}

	/*
	 * @SuppressWarnings("unchecked") public T[] getRowsAsArray(int... rows) {
	 * List<T> rowData = getRowsAsList(rows); T[] array = (T[])
	 * Array.newInstance(clasesFila, rowData.size()); return (T[])
	 * rowData.toArray(array); }
	 * 
	 * public List<T> getRowsAsList(int... rows) { ArrayList<T> rowData = new
	 * ArrayList<T>(rows.length);
	 * 
	 * for (int i = 0; i < rows.length; i++) { rowData.add(getFila(rows[i])); }
	 * 
	 * return rowData; }
	 */

	public void insertFila(int fila, T datoFila) {
		datos.add(fila, datoFila);
		fireTableRowsInserted(fila, fila);
	}

	public void insertFilas(int row, List<T> rowList) {
		datos.addAll(row, rowList);
		fireTableRowsInserted(row, row + rowList.size() - 1);
	}

	public void insertFilas(int row, T[] rowArray) {
		List<T> rowList = new ArrayList<T>(rowArray.length);

		for (int i = 0; i < rowArray.length; i++) {
			rowList.add(rowArray[i]);
		}

		insertFilas(row, rowList);
	}

	/*
	 * public void removeRowRange(int start, int end) { datos.subList(start, end +
	 * 1).clear(); fireTableRowsDeleted(start, end); }
	 * 
	 * public void removeRows(int... rows) { for (int i = rows.length - 1; i >= 0;
	 * i--) { int row = rows[i]; datos.remove(row); fireTableRowsDeleted(row, row);
	 * } }
	 */

	public void setClaseColumna(int column, Class columnClass) {
		clasesColumnas[column] = columnClass;
		fireTableRowsUpdated(0, getRowCount() - 1);
	}

	public void setColumnaEditable(int column, boolean isEditable) {
		esColumnaEditable[column] = isEditable ? Boolean.TRUE : Boolean.FALSE;
	}

	public void setModelEditable(boolean isModelEditable) {
		this.esModeloEditable = isModelEditable;
	}

	/*
	 * public static String formatColumnName(String columnName) { if
	 * (columnName.length() < 3) return columnName;
	 * 
	 * StringBuffer buffer = new StringBuffer(columnName); boolean
	 * isPreviousLowerCase = false;
	 * 
	 * for (int i = 1; i < buffer.length(); i++) { boolean isCurrentUpperCase =
	 * Character.isUpperCase(buffer.charAt(i));
	 * 
	 * if (isCurrentUpperCase && isPreviousLowerCase) { buffer.insert(i, " "); i++;
	 * }
	 * 
	 * isPreviousLowerCase = !isCurrentUpperCase; }
	 * 
	 * return buffer.toString().replaceAll("_", " "); }
	 */
}
