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

import edu.ude.bedelia.presentacion.panel.JPanelListado;
import edu.ude.bedelia.presentacion.panel.JPanelRegistroAlumno;
import edu.ude.bedelia.presentacion.panel.JPanelRegistroAsignatura;

public class JFramePrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel jPanelRegistrarAsignatura = new JPanelRegistroAsignatura();
	private JPanel jPanelRegistrarAlumno = new JPanelRegistroAlumno();
	private JPanel jPanelListado = new JPanelListado();
	private JMenuBar menuBar = new JMenuBar();
	
	JPanel visiblePanel = new JPanel(); // is the default, but showing it set

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// FrmPrincipal frame = new FrmPrincipal();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public JFramePrincipal() {
		// conten panel
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		setContentPane(contentPane);

		initMenuBar();
		// constraint
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 0.3;

		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;

		visiblePanel.setBorder(BorderFactory.createTitledBorder("Contendor"));

		// custom panel
		jPanelRegistrarAlumno.setPreferredSize(new Dimension(visiblePanel.getWidth(), visiblePanel.getHeight()));
		jPanelRegistrarAsignatura.setPreferredSize(new Dimension(visiblePanel.getWidth(), visiblePanel.getHeight()));
		jPanelListado.setPreferredSize(new Dimension(visiblePanel.getWidth(), visiblePanel.getHeight()));
		// visiblePanel.removeAll();
		// visiblePanel.add(childPanel3, gbc);
		// visiblePanel.revalidate();
		// visiblePanel.repaint();

		getContentPane().add(visiblePanel);
		visiblePanel.setLayout(new CardLayout(0, 0));
		visiblePanel.add(jPanelRegistrarAlumno, "TAG1");
		visiblePanel.add(jPanelRegistrarAsignatura, "TAG2");
		visiblePanel.add(jPanelListado, "TAG3");

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
	}
	
	private void initMenuBar() {
		
		this.configurarMenuAlumnos();
		this.configurarMenuAsignaturas();
		this.configurarMenuInscripciones();

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