
package edu.ude.bedelia.presentacion.frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.ude.bedelia.presentacion.panel.JPanelInscribirAsignatura;
import edu.ude.bedelia.presentacion.panel.JpanelMontoRecaudado;
import edu.ude.bedelia.presentacion.panel.listado.JPanelListado;
import edu.ude.bedelia.presentacion.panel.listado.JPanelListadoAlumnos;
import edu.ude.bedelia.presentacion.panel.listado.JPanelListadoAsignatura;
import edu.ude.bedelia.presentacion.panel.registro.JPanelRegistroAlumno;
import edu.ude.bedelia.presentacion.panel.registro.JPanelRegistroAsignatura;

public class JFramePrincipal extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel jPanelRegistrarAsignatura = new JPanelRegistroAsignatura();
	private JPanel jPanelRegistrarAlumno = new JPanelRegistroAlumno();
	private JPanelListado listadoAlumnos = new JPanelListadoAlumnos();
	private JPanelListadoAsignatura listadoAsignatura = new JPanelListadoAsignatura();
	private JPanel jPanelInscribirAsignatura = new JPanelInscribirAsignatura();
	private JPanel jPanelMontoRecaudado = new JpanelMontoRecaudado();
	private JMenuBar menuBar = new JMenuBar();

	JPanel visiblePanel = new JPanel(); // is the default, but showing it set

	/**
	 * Create the frame.
	 */
	public JFramePrincipal() {
		// conten panel
		super();
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		setContentPane(contentPane);

		initMenuBar();
		// constraint
	/*	GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 0.3;

		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
*/
		visiblePanel.setBorder(BorderFactory.createTitledBorder("Contendor"));
	   // custom panel
		jPanelRegistrarAlumno.setPreferredSize(new Dimension(visiblePanel.getWidth(), visiblePanel.getHeight()));
		jPanelRegistrarAsignatura.setPreferredSize(new Dimension(visiblePanel.getWidth(), visiblePanel.getHeight()));
		listadoAlumnos.setPreferredSize(new Dimension(visiblePanel.getWidth(), visiblePanel.getHeight()));
		listadoAsignatura.setPreferredSize(new Dimension(visiblePanel.getWidth(), visiblePanel.getHeight()));
		jPanelInscribirAsignatura.setPreferredSize(new Dimension(visiblePanel.getWidth(), visiblePanel.getHeight()));
		jPanelMontoRecaudado.setPreferredSize(new Dimension(visiblePanel.getWidth(), visiblePanel.getHeight()));
		
		getContentPane().add(visiblePanel);
		visiblePanel.setLayout(new CardLayout(0, 0));
		visiblePanel.add(jPanelRegistrarAlumno, "TAG1");
		visiblePanel.add(jPanelRegistrarAsignatura, "TAG2");
		visiblePanel.add(listadoAlumnos, "TAG3");
		visiblePanel.add(listadoAsignatura, "TAG4");
		visiblePanel.add(jPanelInscribirAsignatura, "TAG5");
		visiblePanel.add(jPanelMontoRecaudado, "TAG6");

		setSize(717, 563);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private void configurarMenuAlumnos() {
		JMenu topicoAlumnos = new JMenu("Alumnos");
		menuBar.add(topicoAlumnos);

		JMenuItem menuItemInscribirAlumno = new JMenuItem("Inscribir");
		JMenuItem menuItemModificarAlumno = new JMenuItem("Modificar");
		JMenuItem menuItemListarAlumnos = new JMenuItem("Listar");
		JMenuItem menuItemEscolaridadAlumnos = new JMenuItem("Escolaridad");

		menuItemInscribirAlumno.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout cardLayout = (CardLayout) visiblePanel.getLayout();
				cardLayout.show(visiblePanel, "TAG1");

			}
		});

		menuItemListarAlumnos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout cardLayout = (CardLayout) visiblePanel.getLayout();
				cardLayout.show(visiblePanel, "TAG3");
			}
		});

		topicoAlumnos.add(menuItemInscribirAlumno);
		topicoAlumnos.add(menuItemModificarAlumno);
		topicoAlumnos.add(menuItemListarAlumnos);
		topicoAlumnos.add(menuItemEscolaridadAlumnos);
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
				CardLayout cardLayout = (CardLayout) visiblePanel.getLayout();
				cardLayout.show(visiblePanel, "TAG2");
			}
		});

		menuItemListarAsignatura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout cardLayout = (CardLayout) visiblePanel.getLayout();
				cardLayout.show(visiblePanel, "TAG4");
			}
		});
		
		menuItemInscribirAsignatura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout cardLayout = (CardLayout) visiblePanel.getLayout();
				cardLayout.show(visiblePanel, "TAG5");
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
				CardLayout cardLayout = (CardLayout) visiblePanel.getLayout();
				cardLayout.show(visiblePanel, "TAG5");
			}
		});
		
	}
	
	private void configurarMenuRespaldo() {
		JMenu topicoRespaldo = new JMenu("Datos");
		menuBar.add(topicoRespaldo);
		
		JMenuItem menuItemMontoRecaudadoInscripcion = new JMenuItem("Respaldar");
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
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj instanceof JMenuItem) {
			JMenuItem menu = (JMenuItem) e.getSource();
			System.out.println(menu.toString());
			// switch (menu.getName()) {
			// case "":
			// break;
			// default:
			// break;
			// }

		}

	}

}