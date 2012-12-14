package ch.bfh.ti.proj1.battleship.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ch.bfh.ti.proj1.battleship.game.Game;

/**
 * This class displays the winner screen.
 * 
 * @author Michael Leiser
 * @author Daniel Kotlàris
 */
public class WinnerFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private Game game;

	public WinnerFrame(Game game) {
		this.game = game;
		
		JLabel label = new JLabel();									// Add Image to the JFrame
		ImageIcon img = new ImageIcon("img\\winner.jpg");
		label.setIcon(img);
		this.add(label);
		this.setSize(img.getIconWidth(), img.getIconHeight());
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();	// Centering the JFrame
		int xCoord = (int)(dim.getWidth() - this.getWidth()) / 2;
		int yCoord = (int)(dim.getHeight() - this.getHeight()) / 2;
		this.setLocation(xCoord, yCoord);
		
		this.setResizable(false);
		this.setUndecorated(true);
		this.setVisible(true);
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				restartGame();
			}
		});
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				restartGame();
			}
		});
	}

	/**
	 * Restarts the game.
	 */
	private void restartGame() {
		this.game.restart();
		this.dispose();
	}
}
