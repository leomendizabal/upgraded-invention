package edu.ude.bedelia.presentacion.panel;

import java.awt.BorderLayout;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JPanelListado extends JPanelBase {

	protected JTable table;

	/**
	 * Create the panel.
	 */
	public JPanelListado() {
		super();
		setLayout(new BorderLayout(0, 0));
		table = new JTable();
		// cargarTabla(table);

		table.getTableHeader().setReorderingAllowed(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		// JScrollPane scrollPane = new JScrollPane(table);
		// add(scrollPane, BorderLayout.CENTER);

	}

	// precondicion: el modelo no puede estar vacio
	public <T> JTable cargarTablaGenerica(ArrayList<T> modelo) {
		DefaultTableModel modeloTabla = new DefaultTableModel();
		table.setModel(modeloTabla);

		// guardo el primer objeto de la coleccion
		T object = modelo.get(0);
		// guardo los atributos del objeto
		Field[] fields = object.getClass().getDeclaredFields();

		/*
		 * recorro el array de atributos, obtengo el nombre de cada uno con ese nombre
		 * genero una columna en la tabla
		 */
		for (Field field : fields) {
			field.setAccessible(true);
			String name = field.getName();
			if (!name.equals("serialVersionUID")) {
				modeloTabla.addColumn(name);
			}
		}

		// este objeto representa una entrada en la tabla
		Object[] fila = new Object[fields.length];

		Iterator<T> iter = modelo.iterator();
		// para cada elemento
		while (iter.hasNext()) {
			T item = iter.next();
			int i = 0;
			// para cada atributo del elemento
			for (Field f : fields) {
				String propertyName = f.getName();
				if (!propertyName.equals("serialVersionUID")) {
					String methodName = "get" + propertyName.substring(0, 1).toUpperCase()
							+ propertyName.substring(1, propertyName.length());
					Class itemClass = item.getClass();

					try {
						Method method = itemClass.getMethod(methodName, null);
						fila[i] = method.invoke(item, null);
						i++;
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
							| NoSuchMethodException | SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			modeloTabla.addRow(fila);
		}

		return table;
	}

}
