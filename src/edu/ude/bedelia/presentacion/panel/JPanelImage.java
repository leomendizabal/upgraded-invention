package edu.ude.bedelia.presentacion.panel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class JPanelImage extends JPanel {

	private BufferedImage image;

	/**
	 * Create the panel.
	 */

	public JPanelImage() {
		this("resource/image/cheff.jpg");
	}

	public JPanelImage(String imageUrl) {
		try {
			// TODO: Quitar url harcode
			image = ImageIO.read(new File(imageUrl));
		} catch (IOException ex) {
			// handle exception...
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	}

}
