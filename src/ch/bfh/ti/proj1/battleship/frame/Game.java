package ch.bfh.ti.proj1.battleship.frame;

import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Game {

	public void hostGame(final int port) {
		new MyServer(port);
		try {
			for (UIManager.LookAndFeelInfo info : UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(CoordinateFrame.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(CoordinateFrame.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(CoordinateFrame.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(CoordinateFrame.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CoordinateFrame(port, "localhost").setVisible(true);
			}
		});

	}

	public void joinGame(final int port, final String IP) {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(CoordinateFrame.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(CoordinateFrame.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(CoordinateFrame.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(CoordinateFrame.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				CoordinateFrame cf = new CoordinateFrame(port, IP);
				cf.setVisible(true);
				cf.disableComponents();
			}
		});
	}

}
