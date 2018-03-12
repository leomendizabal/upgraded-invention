package edu.ude.bedelia.presentacion.frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.ude.bedelia.presentacion.Mensajes;
import edu.ude.bedelia.presentacion.controladores.ControladorRespaldar;
import edu.ude.bedelia.presentacion.panel.JPanelImage;
import edu.ude.bedelia.presentacion.panel.JPanelMontoRecaudado;
import edu.ude.bedelia.presentacion.panel.listado.JPanelDetalleAlumno;
import edu.ude.bedelia.presentacion.panel.listado.JPanelEscolaridad;
import edu.ude.bedelia.presentacion.panel.listado.JPanelListadoApellido;
import edu.ude.bedelia.presentacion.panel.listado.JPanelListadoAsinatura;
import edu.ude.bedelia.presentacion.panel.listado.JPanelListadoEgresado;
import edu.ude.bedelia.presentacion.panel.listener.IMensaje;
import edu.ude.bedelia.presentacion.panel.registro.JPanelInscribirAsignatura;
import edu.ude.bedelia.presentacion.panel.registro.JPanelModificarAlumno;
import edu.ude.bedelia.presentacion.panel.registro.JPanelRegistrarAlumno;
import edu.ude.bedelia.presentacion.panel.registro.JPanelRegistrarNota;
import edu.ude.bedelia.presentacion.panel.registro.JPanelRegistroAsignatura;

public class JFramePrincipal extends JFrame implements IMensaje {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPane;
	private JPanel jPanelRegistrarAsignatura;
	private JPanel jPanelRegistrarAlumno;
	private JPanel jPanelRegistrarNota;
	private JPanel jPanelInscribirAsignatura;
	private JPanel jPanelMontoRecaudado;
	private JPanel jPanelListadoEgresado;
	private JPanel jPanelModificarAlumno;
	private JPanel jPanelEscolaridad;
	private JPanel jPanelListadoAsinatura;
	private JPanel jPanelListadoApellido;
	private JPanel jPanelDetalleAlumno;
	private JPanel jPanelInicio;

	private JMenuBar menuBar = new JMenuBar();

	JPanel visiblePanel = new JPanel(); // is the default, but showing it set

	/**
	 * Create the frame.
	 */
	public JFramePrincipal() {
		// conten panel
		super();
		initJPanels();
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		initMenuBar();

		initContenedor();

		agregarPaneles();

		setSize(717, 563);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private void initJPanels() {
		jPanelRegistrarAsignatura = new JPanelRegistroAsignatura();
		jPanelRegistrarAlumno = new JPanelRegistrarAlumno();
		jPanelRegistrarNota = new JPanelRegistrarNota();
		jPanelInscribirAsignatura = new JPanelInscribirAsignatura();
		jPanelMontoRecaudado = new JPanelMontoRecaudado();
		jPanelListadoEgresado = new JPanelListadoEgresado();
		jPanelModificarAlumno = new JPanelModificarAlumno();
		jPanelEscolaridad = new JPanelEscolaridad();
		jPanelListadoAsinatura = new JPanelListadoAsinatura();
		jPanelListadoApellido = new JPanelListadoApellido();
		jPanelDetalleAlumno = new JPanelDetalleAlumno();
		jPanelInicio = new JPanelImage();
	}

	private void initContenedor() {
		// custom panel
		jPanelRegistrarAsignatura.setPreferredSize(new Dimension(visiblePanel.getWidth(), visiblePanel.getHeight()));
		jPanelRegistrarAlumno.setPreferredSize(new Dimension(visiblePanel.getWidth(), visiblePanel.getHeight()));
		jPanelRegistrarNota.setPreferredSize(new Dimension(visiblePanel.getWidth(), visiblePanel.getHeight()));
		jPanelInscribirAsignatura.setPreferredSize(new Dimension(visiblePanel.getWidth(), visiblePanel.getHeight()));
		jPanelMontoRecaudado.setPreferredSize(new Dimension(visiblePanel.getWidth(), visiblePanel.getHeight()));
		jPanelListadoEgresado.setPreferredSize(new Dimension(visiblePanel.getWidth(), visiblePanel.getHeight()));
		jPanelModificarAlumno.setPreferredSize(new Dimension(visiblePanel.getWidth(), visiblePanel.getHeight()));
		jPanelListadoAsinatura.setPreferredSize(new Dimension(visiblePanel.getWidth(), visiblePanel.getHeight()));
		jPanelEscolaridad.setPreferredSize(new Dimension(visiblePanel.getWidth(), visiblePanel.getHeight()));
		jPanelInicio.setPreferredSize(new Dimension(visiblePanel.getWidth(), visiblePanel.getHeight()));
		jPanelDetalleAlumno.setPreferredSize(new Dimension(visiblePanel.getWidth(), visiblePanel.getHeight()));
		jPanelListadoApellido.setPreferredSize(new Dimension(visiblePanel.getWidth(), visiblePanel.getHeight()));
		getContentPane().add(visiblePanel);
	}

	private void agregarPaneles() {
		visiblePanel.setLayout(new CardLayout(0, 0));

		visiblePanel.add(jPanelInicio, JPanelImage.TAG);
		visiblePanel.add(jPanelRegistrarAlumno, JPanelRegistrarAlumno.TAG);
		visiblePanel.add(jPanelRegistrarAsignatura, JPanelRegistroAsignatura.TAG);
		visiblePanel.add(jPanelInscribirAsignatura, JPanelInscribirAsignatura.TAG);
		visiblePanel.add(jPanelMontoRecaudado, JPanelMontoRecaudado.TAG);
		visiblePanel.add(jPanelListadoEgresado, JPanelListadoEgresado.TAG);
		visiblePanel.add(jPanelModificarAlumno, JPanelModificarAlumno.TAG);
		visiblePanel.add(jPanelEscolaridad, JPanelEscolaridad.TAG);
		visiblePanel.add(jPanelListadoApellido, JPanelListadoApellido.TAG);
		visiblePanel.add(jPanelRegistrarNota, JPanelRegistrarNota.TAG);
		visiblePanel.add(jPanelListadoAsinatura, JPanelListadoAsinatura.TAG);
		visiblePanel.add(jPanelDetalleAlumno, JPanelDetalleAlumno.TAG);

	}

	private void configurarMenuAlumnos() {
		JMenu topicoAlumnos = new JMenu("Alumnos");
		menuBar.add(topicoAlumnos);

		JMenuItem menuItemInscribirAlumno = new JMenuItem("Registrar");
		JMenuItem menuItemModificarAlumno = new JMenuItem("Modificar");
		JMenuItem menuItemDetalleAlumno = new JMenuItem("Detalle por alumno");
		JMenuItem menuItemListarAlumnos = new JMenuItem("Listar por apellido");
		JMenuItem menuItemEscolaridadAlumnos = new JMenuItem("Escolaridad");
		JMenuItem menuItemListarEgresados = new JMenuItem("Listar egresados");

		menuItemInscribirAlumno.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mostrarPanel(JPanelRegistrarAlumno.TAG, JPanelRegistrarAlumno.TITULO);

			}
		});

		menuItemListarAlumnos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mostrarPanel(JPanelListadoApellido.TAG, JPanelListadoApellido.TITULO);
			}
		});

		menuItemListarEgresados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mostrarPanel(JPanelListadoEgresado.TAG, JPanelListadoEgresado.TITULO);
			}
		});

		menuItemModificarAlumno.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mostrarPanel(JPanelModificarAlumno.TAG, JPanelModificarAlumno.TITULO);

			}
		});

		menuItemEscolaridadAlumnos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mostrarPanel(JPanelEscolaridad.TAG, JPanelEscolaridad.TITULO);
			}
		});

		menuItemDetalleAlumno.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mostrarPanel(JPanelDetalleAlumno.TAG, JPanelDetalleAlumno.TITULO);
			}
		});

		topicoAlumnos.add(menuItemInscribirAlumno);
		topicoAlumnos.add(menuItemModificarAlumno);
		topicoAlumnos.add(menuItemDetalleAlumno);
		topicoAlumnos.add(menuItemListarAlumnos);
		topicoAlumnos.add(menuItemListarEgresados);
		topicoAlumnos.add(menuItemEscolaridadAlumnos);

	}

	private void mostrarPanel(final String tag, final String titulo) {
		setTitle(titulo);
		CardLayout cardLayout = (CardLayout) visiblePanel.getLayout();
		cardLayout.show(visiblePanel, tag);
	}

	private void configurarMenuAsignaturas() {
		JMenu topicoAsignaturas = new JMenu("Asignaturas");
		menuBar.add(topicoAsignaturas);

		JMenuItem menuItemRegistrarAsignatura = new JMenuItem("Crear");
		JMenuItem menuItemInscribirAsignatura = new JMenuItem("Inscribir");
		JMenuItem menuItemListarAsignatura = new JMenuItem("Listar");
		JMenuItem menuItemRegistrarResAsignatura = new JMenuItem("Registrar resultado");

		menuItemRegistrarAsignatura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mostrarPanel(JPanelRegistroAsignatura.TAG, JPanelRegistroAsignatura.TITULAR);
			}
		});

		menuItemListarAsignatura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mostrarPanel(JPanelListadoAsinatura.TAG, JPanelListadoAsinatura.TITULO);
			}
		});

		menuItemInscribirAsignatura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mostrarPanel(JPanelInscribirAsignatura.TAG, JPanelInscribirAsignatura.TITULO);
			}
		});

		menuItemRegistrarResAsignatura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mostrarPanel(JPanelRegistrarNota.TAG, JPanelRegistrarNota.TITULO);
			}
		});

		topicoAsignaturas.add(menuItemRegistrarAsignatura);
		topicoAsignaturas.add(menuItemInscribirAsignatura);
		topicoAsignaturas.add(menuItemListarAsignatura);
		topicoAsignaturas.add(menuItemRegistrarResAsignatura);
	}

	private void configurarMenuInscripciones() {
		JMenu topicoInscripciones = new JMenu("Inscripciones");
		menuBar.add(topicoInscripciones);

		JMenuItem menuItemMontoRecaudadoInscripcion = new JMenuItem("Monto recaudado");
		topicoInscripciones.add(menuItemMontoRecaudadoInscripcion);
		menuItemMontoRecaudadoInscripcion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mostrarPanel(JPanelMontoRecaudado.TAG, JPanelMontoRecaudado.TITULO);
			}
		});

	}

	private void configurarMenuRespaldo() {
		JMenu topicoRespaldo = new JMenu("Datos");
		menuBar.add(topicoRespaldo);

		JMenuItem menuItemMontoRecaudadoInscripcion = new JMenuItem("Respaldar");
		menuItemMontoRecaudadoInscripcion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorRespaldar.getInstance(JFramePrincipal.this).respaldar();
				;

			}
		});
		topicoRespaldo.add(menuItemMontoRecaudadoInscripcion);
	}

	private void initMenuBar() {

		this.configurarMenuAlumnos();
		this.configurarMenuAsignaturas();
		this.configurarMenuInscripciones();
		this.configurarMenuRespaldo();
		contentPane.add(menuBar, BorderLayout.NORTH);
	}

	@Override
	public void mostrarConfirmacion(String titulo, String mensaje) {
		// TODO Auto-generated method stub
		Mensajes.mostrarMensaje(this, titulo, mensaje, JOptionPane.INFORMATION_MESSAGE);

	}

	@Override
	public void mostrarError(String titulo, String mensaje) {
		// TODO Auto-generated method stub
		Mensajes.mostrarMensaje(this, titulo, mensaje, JOptionPane.ERROR_MESSAGE);

	}

}