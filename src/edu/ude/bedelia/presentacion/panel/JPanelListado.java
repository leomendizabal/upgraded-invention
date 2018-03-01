package edu.ude.bedelia.presentacion.panel;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.lang.reflect.Method;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import edu.ude.bedelia.logica.entidades.Alumno;
import edu.ude.bedelia.logica.entidades.Asignatura;
import edu.ude.bedelia.logica.vo.VOAlumno;
import edu.ude.bedelia.logica.vo.VOAsignatura;
import edu.ude.bedelia.test.DataClass;

public class JPanelListado extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public JPanelListado() {
		setLayout(new BorderLayout(0, 0));
		table = new JTable();
		//cargarTabla(table);
		
		//obtengo la info para llenar la tabla de asignaturas
		ArrayList<VOAsignatura> sourceAsignaturas = new ArrayList<VOAsignatura>();
		Iterator<Asignatura> it = DataClass.ASIGNATURA.iterator();
		while(it.hasNext()) {
			VOAsignatura a = it.next().toVO();
			sourceAsignaturas.add(a);
		}
		//fin obtener info para llenar tabla
		
		//obtengo la info para llenar la tabla de alumnos
		ArrayList<VOAlumno> sourceAlumnos = new ArrayList<VOAlumno>();
		Iterator<Alumno> iter = DataClass.ALUMNOS.getIterator();
		while(iter.hasNext()) {
			VOAlumno a = iter.next().toVO(false);
			sourceAlumnos.add(a);
		}
		//fin obtener info para llenar tabla
				
		cargarTablaGenerica(table, sourceAsignaturas);
		
		table.getTableHeader().setReorderingAllowed(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);

	}

	public void cargarTabla(JTable tabla) {
		DefaultTableModel modeloTabla = new DefaultTableModel();
		tabla.setModel(modeloTabla);

		modeloTabla.addColumn("Codigo");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Descrpcion");

		Object[] columna = new Object[3];

		Iterator<Asignatura> it = DataClass.ASIGNATURA.iterator();
		while (it.hasNext()) {
			Asignatura item = it.next();
			columna[0] = item.getCodigo();
			columna[1] = item.getNombre();
			columna[2] = item.getDescripcion();

			modeloTabla.addRow(columna);
		}
	}
	
	//precondicion: el modelo no puede estar vacio
	public <T> void cargarTablaGenerica(JTable tabla, ArrayList<T> modelo) {
		DefaultTableModel modeloTabla = new DefaultTableModel();
		tabla.setModel(modeloTabla);
		
		//guardo el primer objeto de la coleccion
		T object = modelo.get(0);									
		//guardo los atributos del objeto
		Field [] fields = object.getClass().getDeclaredFields(); 	
		
		/*
		 * recorro el array de atributos, obtengo el nombre de cada uno 
		 * con ese nombre genero una columna en la tabla
		 */
		for (Field field : fields) {
		    field.setAccessible(true);
		    String name = field.getName();
		    if(!name.equals("serialVersionUID")) {
		    	modeloTabla.addColumn(name);
		    }
		}
		
		//este objeto representa una entrada en la tabla
		Object[] fila = new Object[fields.length];
		
		Iterator<T> iter = modelo.iterator();
		//para cada elemento
		while(iter.hasNext()) {			
			T item = iter.next();
			int i = 0;
			//para cada atributo del elemento
			for(Field f: fields) {
				String propertyName = f.getName();
				if(!propertyName.equals("serialVersionUID")) {
					String methodName = "get" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1, propertyName.length());				
					Class itemClass = item.getClass();				

					try {
						Method method = itemClass.getMethod(methodName, null);					
						fila[i] = method.invoke(item, null);					
						i++;
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}				
			}
			
			modeloTabla.addRow(fila);
		}
		
	}
}
