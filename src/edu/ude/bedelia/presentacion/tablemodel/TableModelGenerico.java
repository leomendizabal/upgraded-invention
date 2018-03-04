package edu.ude.bedelia.presentacion.tablemodel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

abstract class TableModelGenerico<T> extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected List<T> modelData;
	protected List<String> columnNames;
	protected Class[] columnClasses;
	protected Boolean[] isColumnEditable;
	private Class<Object> rowClass = Object.class;
	private boolean isModelEditable = false;

	protected TableModelGenerico(Class<?> rowClass) {
		setRowClass(rowClass);
	}

	protected TableModelGenerico(List<String> columnNames) {
		this(new ArrayList<T>(), columnNames);
	}

	protected TableModelGenerico(List<T> modelData, List<String> columnNames) {
		setDataAndColumnNames(modelData, columnNames);
	}

	protected TableModelGenerico(List<T> modelData, List<String> columnNames, Class<?> rowClass) {
		setDataAndColumnNames(modelData, columnNames);
		setRowClass(rowClass);
	}

	protected void setDataAndColumnNames(List<T> modelData, List<String> columnNames) {
		this.modelData = modelData;
		this.columnNames = columnNames;
		columnClasses = new Class[getColumnCount()];
		isColumnEditable = new Boolean[getColumnCount()];
		fireTableStructureChanged();
	}

	protected void setRowClass(Class rowClass) {
		this.rowClass = rowClass;
	}

	public int getColumnCount() {
		return columnNames.size();
	}

	public String getColumnName(int column) {
		Object columnName = null;

		if (column < columnNames.size()) {
			columnName = columnNames.get(column);
		}

		return (columnName == null) ? super.getColumnName(column) : columnName.toString();
	}

	public int getRowCount() {
		return modelData.size();
	}

	public void addRow(T rowData) {
		insertRow(getRowCount(), rowData);
	}

	public T getRow(int row) {
		return modelData.get(row);
	}

	@SuppressWarnings("unchecked")
	public T[] getRowsAsArray(int... rows) {
		List<T> rowData = getRowsAsList(rows);
		T[] array = (T[]) Array.newInstance(rowClass, rowData.size());
		return (T[]) rowData.toArray(array);
	}

	public List<T> getRowsAsList(int... rows) {
		ArrayList<T> rowData = new ArrayList<T>(rows.length);

		for (int i = 0; i < rows.length; i++) {
			rowData.add(getRow(rows[i]));
		}

		return rowData;
	}

	public void insertRow(int row, T rowData) {
		modelData.add(row, rowData);
		fireTableRowsInserted(row, row);
	}

	public void insertRows(int row, List<T> rowList) {
		modelData.addAll(row, rowList);
		fireTableRowsInserted(row, row + rowList.size() - 1);
	}

	public void insertRows(int row, T[] rowArray) {
		List<T> rowList = new ArrayList<T>(rowArray.length);

		for (int i = 0; i < rowArray.length; i++) {
			rowList.add(rowArray[i]);
		}

		insertRows(row, rowList);
	}

	public void removeRowRange(int start, int end) {
		modelData.subList(start, end + 1).clear();
		fireTableRowsDeleted(start, end);
	}

	public void removeRows(int... rows) {
		for (int i = rows.length - 1; i >= 0; i--) {
			int row = rows[i];
			modelData.remove(row);
			fireTableRowsDeleted(row, row);
		}
	}

	public void setColumnClass(int column, Class columnClass) {
		columnClasses[column] = columnClass;
		fireTableRowsUpdated(0, getRowCount() - 1);
	}

	public void setColumnEditable(int column, boolean isEditable) {
		isColumnEditable[column] = isEditable ? Boolean.TRUE : Boolean.FALSE;
	}

	public void setModelEditable(boolean isModelEditable) {
		this.isModelEditable = isModelEditable;
	}

	public static String formatColumnName(String columnName) {
		if (columnName.length() < 3)
			return columnName;

		StringBuffer buffer = new StringBuffer(columnName);
		boolean isPreviousLowerCase = false;

		for (int i = 1; i < buffer.length(); i++) {
			boolean isCurrentUpperCase = Character.isUpperCase(buffer.charAt(i));

			if (isCurrentUpperCase && isPreviousLowerCase) {
				buffer.insert(i, " ");
				i++;
			}

			isPreviousLowerCase = !isCurrentUpperCase;
		}

		return buffer.toString().replaceAll("_", " ");
	}
}
