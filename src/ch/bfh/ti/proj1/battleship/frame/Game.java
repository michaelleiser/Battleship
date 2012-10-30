package ch.bfh.ti.proj1.battleship.frame;

import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author Daniel Kotlàris
 * @author Michael Leiser
 */
public class Game {
	
	MyClient mc;
	CoordinateFrame cf;
	GameFrame gf;
	
	public Game(){}

	public void hostGame(final int port) {
		new MyServer(port);
		mc = new MyClient(port, "localhost");
		mc.setGame(this);
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
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				cf = new CoordinateFrame();
//				cf.setVisible(true);
//			}
//		});
		cf = new CoordinateFrame();
		cf.setVisible(true);
		cf.setGame(this);
	}

	public void joinGame(final int port, final String IP) {
		mc = new MyClient(port, IP);
		mc.setGame(this);
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
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				cf = new CoordinateFrame();
//				cf.setVisible(true);
//				cf.disableComponents();
//			}
//		});
		cf = new CoordinateFrame();
		cf.setVisible(true);
		cf.disableComponents();					// disable Components temporarily for the client
		cf.setGame(this);
	}

	public void setGameFrame(GameFrame gf) {
		this.gf = gf;
	}

}
