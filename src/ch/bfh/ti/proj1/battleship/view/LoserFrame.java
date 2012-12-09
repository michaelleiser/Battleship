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

import ch.bfh.ti.proj1.battleship.frame.Game;

/**
 * This class displays the start screen.
 * 
 * @author Michael Leiser
 * @author Daniel Kotlàris
 */
public class LoserFrame extends JFrame {

	private Game game;
	/**
	 * This is the serial for this class
	 */
	private static final long serialVersionUID = 243473051023764686L;

	public LoserFrame(Game game) {
	
		this.game = game;
		
		JLabel label = new JLabel();
		ImageIcon img = new ImageIcon("img\\loser.jpg");
		label.setIcon(img);
		this.add(label);
		this.setSize(img.getIconWidth(), img.getIconHeight());
		this.setResizable(false);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();	
		int xCoord = (int)(dim.getWidth() - this.getWidth()) / 2;
		int yCoord = (int)(dim.getHeight() - this.getHeight()) / 2;
		this.setLocation(xCoord, yCoord);
		
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

	private void restartGame() {
		this.game.restart();
		this.dispose();
	}
}
