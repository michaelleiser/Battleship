package ch.bfh.ti.proj1.battleship.frame;

import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class STARTER {

	public static void main(String[] args) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(NetworkFrame.class.getName()).log(Level.SEVERE,null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(NetworkFrame.class.getName()).log(Level.SEVERE,null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(NetworkFrame.class.getName()).log(Level.SEVERE,null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(NetworkFrame.class.getName()).log(Level.SEVERE,null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new NetworkFrame().setVisible(true);
			}
		});
	}
}
