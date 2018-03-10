package edu.ude.bedelia.presentacion.panel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.ude.bedelia.presentacion.UIConstantes;
import edu.ude.bedelia.presentacion.controladores.ControladorInscripcion;
import edu.ude.bedelia.presentacion.panel.listener.IMostrarMonto;

public class JPanelMontoRecaudado extends JPanelBase implements IMostrarMonto {

	private static final long serialVersionUID = 1L;
	public final static String TAG = JPanelMontoRecaudado.class.getSimpleName();
	public final static String TITULO = "Monto recaudado";
	private final ControladorInscripcion controladorInscripcion;
	private JTextField textCed;
	private JTextField textAno;
	private JButton btnCalcular;
	private JLabel lblMontoRecuadado;

	private void registrarEventListeners() {

		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorInscripcion.mostrar(JPanelMontoRecaudado.this, textAno.getText(), textCed.getText());
			}
		});
	}

	/**
	 * Create the panel.
	 */
	public JPanelMontoRecaudado() {

		super();
		controladorInscripcion = ControladorInscripcion.getInstance(this);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(15, 16, 435, 298);
		add(panel);
		panel.setLayout(null);

		textCed = new JTextField();
		textCed.setBounds(124, 25, 253, 20);
		panel.add(textCed);
		textCed.setColumns(10);

		textAno = new JTextField();
		textAno.setColumns(10);
		textAno.setBounds(124, 56, 253, 20);
		panel.add(textAno);

		JLabel lblNombre = new JLabel("Cedula");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(10, 28, 89, 14);
		panel.add(lblNombre);

		JLabel lblApellido = new JLabel("A\u00F1o");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setBounds(10, 57, 89, 19);
		panel.add(lblApellido);

		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(262, 98, 115, 29);
		panel.add(btnCalcular);

		lblMontoRecuadado = new JLabel("");
		lblMontoRecuadado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMontoRecuadado.setBounds(10, 157, 367, 38);
		panel.add(lblMontoRecuadado);

		registrarEventListeners();
	}

	@Override
	public void mostrar(String monto) {
		// TODO Auto-generated method stub
		lblMontoRecuadado.setText(String.format(UIConstantes.MONTO_RECAUDADO_TEMPLE, monto));

	}

	@Override
	protected void inicializar() {
		// TODO Auto-generated method stub
		limpiarTextField(this);
	}

}
