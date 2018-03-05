package edu.ude.bedelia.presentacion.panel.registro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.ude.bedelia.presentacion.controladores.ControladorAsignaturas;
import edu.ude.bedelia.presentacion.panel.JPanelBase;
import java.awt.BorderLayout;

public class JPanelRegistroAsignatura extends JPanelBase implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;
	private JTextArea textAreaDescripcion;
	private JButton btnRegistrar;
	private JTextField textFieldId;
	private final ControladorAsignaturas controlladorAsignaturas;

	/**
	 * Create the panel.
	 */
	public JPanelRegistroAsignatura() {
		super();
		initView();
		controlladorAsignaturas = ControladorAsignaturas.getInstancia(this);
	}
    // TODO: eliminar valore harcode
	private void initView() {
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNombreAsignatura = new JLabel("Nombre");
		lblNombreAsignatura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreAsignatura.setBounds(12, 68, 132, 23);
		panel.add(lblNombreAsignatura);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(162, 68, 214, 24);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		JLabel lblDescripcionAsignatura = new JLabel("Decripcion");
		lblDescripcionAsignatura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescripcionAsignatura.setBounds(12, 116, 132, 23);
		panel.add(lblDescripcionAsignatura);

		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setBounds(162, 116, 214, 91);
		panel.add(textAreaDescripcion);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(264, 219, 105, 25);
		btnRegistrar.addActionListener(this);
		panel.add(btnRegistrar);

		textFieldId = new JTextField();
		textFieldId.setColumns(10);
		textFieldId.setBounds(162, 32, 214, 24);
		panel.add(textFieldId);

		JLabel lblId = new JLabel("Codigo");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(12, 32, 132, 23);
		panel.add(lblId);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		final String codigo = textFieldId.getText();
		final String nombre = textFieldNombre.getText();
		final String descripcion = textAreaDescripcion.getText();

		controlladorAsignaturas.registrar(codigo, nombre, descripcion);

	}
}
