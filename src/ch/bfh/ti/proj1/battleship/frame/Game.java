package ch.bfh.ti.proj1.battleship.frame;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

import org.state.Context;

import ch.bfh.ti.proj1.battleship.client.Field;
import ch.bfh.ti.proj1.battleship.client.Player;
import ch.bfh.ti.proj1.battleship.client.Ship;
import ch.bfh.ti.proj1.battleship.exception.BattleshipException;
import ch.bfh.ti.proj1.battleship.view.CoordinateFrame;
import ch.bfh.ti.proj1.battleship.view.GameFrame;
import ch.bfh.ti.proj1.battleship.view.NetworkFrame;

/**
 * @author Daniel Kotlàris
 * @author Michael Leiser
 */
public class Game {
	
	public MyClient myClient;
	NetworkFrame networkFrame;
	CoordinateFrame clientFrame;
	GameFrame gameFrame;
	Player player;
	
	Context c;
	
	// initialize standard values
	private int nbrOfRows = 10;
	private int nbrOfColoumns = 10;
	private int nbrOfBattleships = 1;
	private int nbrOfSubmarines = 2;
	private int nbrOfDestroyers = 3;
	private int nbrOfCruisers = 4;
	private String gameMode = "Alternatively";
	
	public Game(){
		showNetworkFrame();
		c = new Context();
		c.handle(Context.EventType.Start);
	}
	
	public void hostGame(final int port) {
		try {
			player = new Player(this.networkFrame.getPlayerName());
		} catch (BattleshipException e) {
			e.printStackTrace();
		}
		new MyServer(port);
		myClient = new MyClient(port, "localhost");
		myClient.setGame(this);
	}

	public void joinGame(final int port, final String IP) {
		try {
			player = new Player(this.networkFrame.getPlayerName());
		} catch (BattleshipException e) {
			e.printStackTrace();
		}
		myClient = new MyClient(port, IP);
		myClient.setGame(this);
		if(myClient.isConnected()){
			networkFrame.dispose();
			showCoordinateFrame();	
			clientFrame.disableComponents();
			myClient.sendMessage("Game " + "Show ");
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
		networkFrame = new NetworkFrame(this);
		networkFrame.setVisible(true);
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
		clientFrame = new CoordinateFrame(this);
		clientFrame.setVisible(true);
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
		gameFrame = new GameFrame(this);
		gameFrame.setVisible(true);
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

	public Player getPlayer() {
		return this.player;
	}
	
	
	public void placeShip(Ship ship, int x, int y, int k) {
		Field[][] fields = gameFrame.getYourField();
		switch (ship) {
		case BATTLESHIP:
			if(k == 0){
				for(int i = 0; i < ship.size(); i++){
					fields[x][y+i].placeShip(Ship.BATTLESHIP);
				}
			} else{
				for(int i = 0; i < ship.size(); i++){
					fields[x+i][y].placeShip(Ship.BATTLESHIP);
				}
			}
			this.nbrOfBattleships--;
			this.gameFrame.setNbrOfBattleship(nbrOfBattleships);
			break;
		case SUBMARINE:
			if(k == 0){
				for(int i = 0; i < ship.size(); i++){
					fields[x][y+i].placeShip(Ship.SUBMARINE);
				}
			} else{
				for(int i = 0; i < ship.size(); i++){
					fields[x+i][y].placeShip(Ship.SUBMARINE);
				}
			}
			this.nbrOfSubmarines--;
			this.gameFrame.setNbrOfSubmarine(nbrOfSubmarines);
			break;
		case DESTROYER:
			if(k == 0){
				for(int i = 0; i < ship.size(); i++){
					fields[x][y+i].placeShip(Ship.DESTROYER);
				}
			} else{
				for(int i = 0; i < ship.size(); i++){
					fields[x+i][y].placeShip(Ship.DESTROYER);
				}
			}
			this.nbrOfDestroyers--;
			this.gameFrame.setNbrOfDestroyer(nbrOfDestroyers);
			break;
		case CRUISER:
			if(k == 0){
				for(int i = 0; i < ship.size(); i++){
					fields[x][y+i].placeShip(Ship.CRUISER);
				}
			} else{
				for(int i = 0; i < ship.size(); i++){
					fields[x+i][y].placeShip(Ship.CRUISER);
				}
			}
			this.nbrOfCruisers--;
			this.gameFrame.setNbrOfCruiser(nbrOfCruisers);
			break;
		default:
			break;
		}
	}

	public void removeShip(int x, int y) {
		//TODO
	}

	public void shootAt(int x, int y) {
		myClient.sendMessage("Game " + "Shoot " + x + " " + y);
	}

}
