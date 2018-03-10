package edu.ude.bedelia.presentacion.panel.registro;

import java.awt.BorderLayout;
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

public class JPanelRegistroAsignatura extends JPanelBase implements ActionListener {

	private static final long serialVersionUID = 1L;
	public final static String TAG = JPanelRegistroAsignatura.class.getSimpleName();
	public final static String TITULAR = "Registro de asignatura";
	private JTextField textFieldNombre;
	private JTextArea textAreaDescripcion;
	private JButton btnRegistrar;
	private JTextField textFieldId;
	private final ControladorAsignaturas controlladorAsignaturas;
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public JPanelRegistroAsignatura() {
		super();
		configurarVista();
		controlladorAsignaturas = ControladorAsignaturas.getInstancia();
		controlladorAsignaturas.setListener(this);
	}

	private void configurarVista() {
		setLayout(new BorderLayout(0, 0));
		panel = new JPanel();
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
		controlladorAsignaturas.registrar(false, textFieldId.getText(), textFieldNombre.getText(),
				textAreaDescripcion.getText());
	}

	@Override
	public void mostrarConfirmacion(String titulo, String mensaje) {
		// TODO Auto-generated method stub
		super.mostrarConfirmacion(titulo, mensaje);
		inicializar();
		
	}

	@Override
	protected void inicializar() {
		// TODO Auto-generated method stub
		limpiarTextField(this.panel);
		
		
	}

}
