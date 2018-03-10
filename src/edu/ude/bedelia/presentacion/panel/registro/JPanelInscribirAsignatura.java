package edu.ude.bedelia.presentacion.panel.registro;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.ude.bedelia.presentacion.controladores.ControladorInscripcion;
import edu.ude.bedelia.presentacion.panel.JPanelBase;

public class JPanelInscribirAsignatura extends JPanelBase {

	private static final long serialVersionUID = 1L;
	public final static String TAG = JPanelInscribirAsignatura.class.getSimpleName();
	public final static String TITULO = "Inscripcion a asignatura";

	private final ControladorInscripcion controladorInscripcion;
	private JTextField textcedula;
	private JTextField textcodigo;
	private JTextField textFieldanio;
	private JButton btnInscribir;
	private JTextField textFieldmonto;
	private JPanel panel;

	private void registrarEventListeners() {

		btnInscribir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controladorInscripcion.registrar(false, textcedula.getText(), textcodigo.getText(),
						textFieldanio.getText(), textFieldmonto.getText());

			}
		});
	}

	/**
	 * Create the panel.
	 */
	public JPanelInscribirAsignatura() {

		super();
		controladorInscripcion = ControladorInscripcion.getInstance(this);
		setLayout(null);

	    panel = new JPanel();
		panel.setBounds(15, 16, 435, 298);
		
		panel.setLayout(null);

		textcedula = new JTextField();
		textcedula.setBounds(109, 25, 253, 20);
		panel.add(textcedula);
		textcedula.setColumns(10);

		textcodigo = new JTextField();
		textcodigo.setColumns(10);
		textcodigo.setBounds(109, 58, 253, 20);
		panel.add(textcodigo);

		textFieldanio = new JTextField();
		textFieldanio.setColumns(10);
		textFieldanio.setBounds(109, 89, 253, 20);
		panel.add(textFieldanio);

		JLabel lblNombre = new JLabel("Cedula");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(10, 28, 89, 14);
		panel.add(lblNombre);

		JLabel lblApellido = new JLabel("A\u00F1o");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setBounds(10, 90, 89, 19);
		panel.add(lblApellido);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigo.setBounds(10, 61, 89, 14);
		panel.add(lblCodigo);

		btnInscribir = new JButton("Inscribir");
		btnInscribir.setBounds(180, 186, 115, 29);
		panel.add(btnInscribir);

		textFieldmonto = new JTextField();
		textFieldmonto.setColumns(10);
		textFieldmonto.setBounds(109, 120, 253, 20);
		panel.add(textFieldmonto);

		JLabel lblMontoBase = new JLabel("Monto base");
		lblMontoBase.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMontoBase.setBounds(10, 121, 89, 19);
		panel.add(lblMontoBase);
		add(panel);
		registrarEventListeners();
	}

	@Override
	public void mostrarConfirmacion(String titulo, String mensaje) {
		// TODO Auto-generated method stub
		super.mostrarConfirmacion(titulo, mensaje);
		inicializar();
		//limpiarTextField(this.panel);
	}

	@Override
	protected void inicializar() {
		// TODO Auto-generated method stub
		limpiarTextField(this.panel);
	}
	
	
}
