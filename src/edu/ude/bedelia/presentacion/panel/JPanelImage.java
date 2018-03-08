package edu.ude.bedelia.presentacion.panel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class JPanelImage extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	public final static String TAG = JPanelImage.class.getSimpleName();

	/**
	 * Create the panel.
	 */

	public JPanelImage() {
		this("resource/image/cheff.jpg");
	}

	public JPanelImage(String imageUrl) {
		try {
			image = ImageIO.read(new File(imageUrl));
		} catch (IOException ex) {
			// handle exception...
			ex.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	}

}
