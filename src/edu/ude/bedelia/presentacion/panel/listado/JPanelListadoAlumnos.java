package edu.ude.bedelia.presentacion.panel.listado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import edu.ude.bedelia.logica.vo.VOAlumno;
import edu.ude.bedelia.presentacion.controladores.ControladorListadoAlumnos;

public class JPanelListadoAlumnos extends JPanelListado {

	private JPanel panel;
	private JScrollPane tableContainer;
	private JRadioButton rdbtnCursando;
	private JRadioButton rdbtnEgresado;
	private ButtonGroup calidad;
	private JComboBox tipoBusqueda;
	private JTextField txtInfo;
	private JButton btnNewButton;
	private boolean listarEgresado = true;
	private ControladorListadoAlumnos controlador;
	private JLabel msg;

	private void agregarComponentes() {
		panel = new JPanel();
		panel.setBounds(15, 16, 385, 268);
		add(panel);
		panel.setLayout(null);

		tableContainer = new JScrollPane();
		tableContainer.setBounds(11, 200, 666, 200);

		rdbtnCursando = new JRadioButton("Cursando");
		rdbtnCursando.setBounds(11, 69, 99, 29);
		rdbtnCursando.setSelected(!listarEgresado);
		panel.add(rdbtnCursando);

		rdbtnEgresado = new JRadioButton("Egresado");
		rdbtnEgresado.setSelected(true);
		rdbtnEgresado.setBounds(11, 32, 155, 29);
		rdbtnEgresado.setVisible(listarEgresado);
		panel.add(rdbtnEgresado);

		calidad = new ButtonGroup();
		calidad.add(rdbtnCursando);
		calidad.add(rdbtnEgresado);

		tipoBusqueda = new JComboBox();
		tipoBusqueda.setModel(new DefaultComboBoxModel(new String[] { "Cedula", "Apellido" }));
		tipoBusqueda.setBounds(11, 113, 132, 26);
		tipoBusqueda.setVisible(!listarEgresado);
		panel.add(tipoBusqueda);

		txtInfo = new JTextField();
		txtInfo.setBounds(158, 113, 212, 26);
		txtInfo.setColumns(10);
		txtInfo.setVisible(!listarEgresado);
		panel.add(txtInfo);

		btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(11, 155, 132, 29);
		panel.add(btnNewButton);

		msg = new JLabel("");
		msg.setBounds(15, 225, 600, 20);
		msg.setVisible(false);
	}

	private void registrarEventListeners() {

		rdbtnCursando.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				listarEgresado = false;
				tipoBusqueda.setVisible(!listarEgresado);
				txtInfo.setVisible(!listarEgresado);
			}
		});

		rdbtnEgresado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				listarEgresado = true;
				tipoBusqueda.setVisible(!listarEgresado);
				txtInfo.setVisible(!listarEgresado);
			}
		});

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// obtengo la info para llenar la tabla de asignaturas
				/*
				 * ArrayList<VOAsignatura> sourceAsignaturas = new ArrayList<VOAsignatura>();
				 * Iterator<Asignatura> it = DataClass.ASIGNATURA.iterator();
				 * while(it.hasNext()) { VOAsignatura a = it.next().toVO();
				 * sourceAsignaturas.add(a); }
				 */
				// fin obtener info para llenar tabla

				// obtengo la info para llenar la tabla de alumnos
				String apellido = txtInfo.getText();
				ArrayList<VOAlumno> sourceAlumnos = controlador.getAlumnosApellido(apellido);
				if (sourceAlumnos.size() > 0) {
					tableContainer.setViewportView(cargarTablaGenerica(sourceAlumnos));
					panel.add(tableContainer);
					msg.setVisible(false);
					tableContainer.setVisible(true);
				} else {
					msg.setText("No existen alumnos con ese apellido");
					panel.add(msg);
					msg.setVisible(true);
					tableContainer.setVisible(false);
				}
			}
		});
	}

	public JPanelListadoAlumnos() {
		super();
		agregarComponentes();
		registrarEventListeners();
		controlador = new ControladorListadoAlumnos(this);
	}
}
