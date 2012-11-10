package ch.bfh.ti.proj1.battleship.frame;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

import ch.bfh.ti.proj1.battleship.view.CoordinateFrame;
import ch.bfh.ti.proj1.battleship.view.GameFrame;
import ch.bfh.ti.proj1.battleship.view.NetworkFrame;

/**
 * @author Daniel Kotlàris
 * @author Michael Leiser
 */
public class Game {
	
	public MyClient mc;
	NetworkFrame nf;
	CoordinateFrame cf;
	GameFrame gf;
	
	public Game(){
		showNetworkFrame();
	}
	
	public void showNetworkFrame(){
		try {
			for (UIManager.LookAndFeelInfo info : UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception ex) {
			Logger.getLogger(NetworkFrame.class.getName()).log(Level.SEVERE,
					null, ex);
		}

		nf = new NetworkFrame(this);
		nf.setVisible(true);
	}

	public void hostGame(final int port) {
		new MyServer(port);
		mc = new MyClient(port, "localhost");
		mc.setGame(this);
//		showCoordinateFrame();
	}

	public void joinGame(final int port, final String IP) {
		mc = new MyClient(port, IP);
		mc.setGame(this);
		showCoordinateFrame();	
		mc.sendMessage("Game " + "Show ");
		cf.disableComponents();					// disable Components temporarily for the client
	}
	
	public void showCoordinateFrame() {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception ex) {
			Logger.getLogger(CoordinateFrame.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		
		cf = new CoordinateFrame(this);
		cf.setVisible(true);
	}
	
	public void showGameFrame(){
		try {
			for (UIManager.LookAndFeelInfo info : UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception ex) {
			Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, null,	ex);
		}
		

		gf = new GameFrame(nbrOfRows, nbrOfColoumns, nbrOfBattleships,
				nbrOfSubmarines, nbrOfDestroyers, nbrOfCruisers);
		gf.setVisible(true);
		gf.setGame(this);
	}

	
	private int nbrOfRows = 10;
	private int nbrOfColoumns = 10;
	private int nbrOfBattleships = 1;
	private int nbrOfSubmarines = 2;
	private int nbrOfDestroyers = 3;
	private int nbrOfCruisers = 4;
	private boolean gameModeAlternatively = true;
	private boolean gameModeShootUntilWater = false;
	
	public void setOptions(int nbrOfRows, int nbrOfColoumns, int nbrOfBattleships,
			int nbrOfSubmarines, int nbrOfDestroyers, int nbrOfCruisers, boolean gameModeAlternatively){
		this.nbrOfRows = nbrOfRows;
		this.nbrOfColoumns = nbrOfColoumns;
		this.nbrOfBattleships = nbrOfBattleships;
		this.nbrOfSubmarines = nbrOfSubmarines;
		this.nbrOfDestroyers = nbrOfDestroyers;
		this.nbrOfCruisers = nbrOfCruisers;
		if(gameModeAlternatively == true){
			this.gameModeAlternatively = true;
			this.gameModeShootUntilWater = false;
		}
		else{
			this.gameModeAlternatively = false;
			this.gameModeShootUntilWater = true;
		}
	}
}
