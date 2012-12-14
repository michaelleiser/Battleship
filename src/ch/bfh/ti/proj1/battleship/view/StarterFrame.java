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
 * This class displays the start screen.
 * 
 * @author Michael Leiser
 * @author Daniel Kotlàris
 */
public class StarterFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public StarterFrame() {
		
		JLabel label = new JLabel();									// Add Image to the JFrame
		ImageIcon img = new ImageIcon("img\\start.jpg");
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
				start();
			}
		});
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				start();
			}
		});
	}

	/**
	 * Starts a new game.
	 */
	private void start() {
		new Game();
		this.dispose();	
	}
}
