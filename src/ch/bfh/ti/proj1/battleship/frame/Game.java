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
	
	private int nbrOfRows = 10;
	private int nbrOfColoumns = 10;
	private int nbrOfBattleships = 1;
	private int nbrOfSubmarines = 2;
	private int nbrOfDestroyers = 3;
	private int nbrOfCruisers = 4;
	private String gameMode = "Alternatively";
	
	public Game(){
		showNetworkFrame();
	}
	
	public void hostGame(final int port) {
		new MyServer(port);
		mc = new MyClient(port, "localhost");
		mc.setGame(this);
	}

	public void joinGame(final int port, final String IP) {
		mc = new MyClient(port, IP);
		mc.setGame(this);
		if(mc.isConnected()){
			nf.dispose();
			showCoordinateFrame();	
			cf.disableComponents();
			mc.sendMessage("Game " + "Show ");
		}
	}
	
	public void showNetworkFrame(){
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			Logger.getLogger(NetworkFrame.class.getName()).log(Level.SEVERE, null, e);
		}
		nf = new NetworkFrame(this);
		nf.setVisible(true);
	}

	public void showCoordinateFrame() {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception ex) {
			Logger.getLogger(CoordinateFrame.class.getName()).log(Level.SEVERE, null, ex);
		}
		cf = new CoordinateFrame(this);
		cf.setVisible(true);
	}
	
	public void showGameFrame(){
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception ex) {
			Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, null,	ex);
		}
		gf = new GameFrame(this);
		gf.setVisible(true);
	}

	public int getNbrOfRows() {
		return nbrOfRows;
	}

	public void setNbrOfRows(int nbrOfRows) {
		this.nbrOfRows = nbrOfRows;
	}

	public int getNbrOfColoumns() {
		return nbrOfColoumns;
	}

	public void setNbrOfColoumns(int nbrOfColoumns) {
		this.nbrOfColoumns = nbrOfColoumns;
	}

	public int getNbrOfBattleships() {
		return nbrOfBattleships;
	}

	public void setNbrOfBattleships(int nbrOfBattleships) {
		this.nbrOfBattleships = nbrOfBattleships;
	}

	public int getNbrOfSubmarines() {
		return nbrOfSubmarines;
	}

	public void setNbrOfSubmarines(int nbrOfSubmarines) {
		this.nbrOfSubmarines = nbrOfSubmarines;
	}

	public int getNbrOfDestroyers() {
		return nbrOfDestroyers;
	}

	public void setNbrOfDestroyers(int nbrOfDestroyers) {
		this.nbrOfDestroyers = nbrOfDestroyers;
	}

	public int getNbrOfCruisers() {
		return nbrOfCruisers;
	}

	public void setNbrOfCruisers(int nbrOfCruisers) {
		this.nbrOfCruisers = nbrOfCruisers;
	}

	public String getGameMode() {
		return gameMode;
	}

	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}
	
	public void setOptions(int nbrOfRows, int nbrOfColoumns, int nbrOfBattleships,
			int nbrOfSubmarines, int nbrOfDestroyers, int nbrOfCruisers, String gameMode){
		this.nbrOfRows = nbrOfRows;
		this.nbrOfColoumns = nbrOfColoumns;
		this.nbrOfBattleships = nbrOfBattleships;
		this.nbrOfSubmarines = nbrOfSubmarines;
		this.nbrOfDestroyers = nbrOfDestroyers;
		this.nbrOfCruisers = nbrOfCruisers;
		if(gameMode.equals("Alternatively")){
			this.gameMode = "Alternatively";
		}
		else if (gameMode.equals("UntilWater")){
			this.gameMode = "UntilWater";
		}
	}
}
