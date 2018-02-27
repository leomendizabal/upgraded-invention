package edu.ude.bedelia.presentacion.frame;

import javax.swing.JWindow;
import javax.swing.SwingConstants;

import edu.ude.bedelia.presentacion.panel.JPanelSplash;

public class JFrameSplash {

	public JFrameSplash() {
		super();
		JWindow window = new JWindow();
		window.getContentPane().add(new JPanelSplash(), SwingConstants.CENTER);
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrameSplash splash = new JFrameSplash();
	}

}
