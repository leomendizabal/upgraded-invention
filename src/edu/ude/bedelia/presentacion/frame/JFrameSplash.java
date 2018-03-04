package edu.ude.bedelia.presentacion.frame;

import javax.swing.JWindow;
import javax.swing.SwingConstants;

import edu.ude.bedelia.presentacion.panel.JPanelImage;

public class JFrameSplash {

	public JFrameSplash() {
		super();
	}

	public JFrameSplash(String urlImage) {
		super();
		init(urlImage);
	}

	public void initPorDefecto() {
		init("resource/image/cheff.jpg");
	}

	public void init(final String url) {
		JWindow window = new JWindow();
		window.getContentPane().add(new JPanelImage(url), SwingConstants.CENTER);
		window.setBounds(500, 0, 800, 781);
		window.setVisible(true);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		window.setVisible(false);
		JFramePrincipal principal = new JFramePrincipal();
		principal.setVisible(true);
		window.dispose();
	}

}
