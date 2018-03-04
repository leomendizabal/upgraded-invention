package edu.ude.bedelia.presentacion.frame;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import edu.ude.bedelia.presentacion.panel.JPanelImage;

public class JFrameError extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JFrameError() {
		this("resource/image/error_server.jpg");
	}

	public JFrameError(final String urlImage) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(new JPanelImage(urlImage), SwingConstants.CENTER);
		setContentPane(contentPane);
	}

}
