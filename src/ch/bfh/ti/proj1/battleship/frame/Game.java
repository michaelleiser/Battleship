package ch.bfh.ti.proj1.battleship.frame;

import java.awt.Color;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

import org.state.Context;

import ch.bfh.ti.proj1.battleship.client.Field;
import ch.bfh.ti.proj1.battleship.client.Player;
import ch.bfh.ti.proj1.battleship.client.Ship;
import ch.bfh.ti.proj1.battleship.exception.BattleshipException;
import ch.bfh.ti.proj1.battleship.sound.Sound;
import ch.bfh.ti.proj1.battleship.sound.Sound.Sounds;
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
	CoordinateFrame coordinateFrame;
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
		new MyServer(port);
		myClient = new MyClient(port, "localhost");
		myClient.setGame(this);
	}

	public void joinGame(final int port, final String IP) {
		myClient = new MyClient(port, IP);
		myClient.setGame(this);
		if(myClient.isConnected()){
			networkFrame.dispose();
			showCoordinateFrame();	
			coordinateFrame.disableComponents();
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
		coordinateFrame = new CoordinateFrame(this);
		coordinateFrame.setVisible(true);
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
		switch (ship.getShipType()) {
		case BATTLESHIP:
			if(k == 0){
				for(int i = 0; i < ship.size(); i++){
					fields[x][y+i].placeShip(ship);
					fields[x][y+i].setSelected(true);
					fields[x][y+i].setBackground(Color.black);
				}
			} else{
				for(int i = 0; i < ship.size(); i++){
					fields[x+i][y].placeShip(ship);
					fields[x+i][y].setSelected(true);
					fields[x+i][y].setBackground(Color.black);
					System.out.println(fields[x+i][y]);
				}
			}			
			this.nbrOfBattleships--;
			this.gameFrame.setNbrOfBattleship(nbrOfBattleships);
			break;
		case SUBMARINE:
			if(k == 0){
				for(int i = 0; i < ship.size(); i++){
					fields[x][y+i].placeShip(ship);
					fields[x][y+i].setSelected(true);
					fields[x][y+i].setBackground(Color.black);
				}
			} else{
				for(int i = 0; i < ship.size(); i++){
					fields[x+i][y].placeShip(ship);
					fields[x+i][y].setSelected(true);
					fields[x+i][y].setBackground(Color.black);
				}
			}
			this.nbrOfSubmarines--;
			this.gameFrame.setNbrOfSubmarine(nbrOfSubmarines);
			break;
		case DESTROYER:
			if(k == 0){
				for(int i = 0; i < ship.size(); i++){
					fields[x][y+i].placeShip(ship);
					fields[x][y+i].setSelected(true);
					fields[x][y+i].setBackground(Color.black);
				}
			} else{
				for(int i = 0; i < ship.size(); i++){
					fields[x+i][y].placeShip(ship);
					fields[x+i][y].setSelected(true);
					fields[x+i][y].setBackground(Color.black);
				}
			}
			this.nbrOfDestroyers--;
			this.gameFrame.setNbrOfDestroyer(nbrOfDestroyers);
			break;
		case CRUISER:
			if(k == 0){
				for(int i = 0; i < ship.size(); i++){
					fields[x][y+i].placeShip(ship);
					fields[x][y+i].setSelected(true);
					fields[x][y+i].setBackground(Color.black);
				}
			} else{
				for(int i = 0; i < ship.size(); i++){
					fields[x+i][y].placeShip(ship);
					fields[x+i][y].setSelected(true);
					fields[x+i][y].setBackground(Color.black);
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
		Field[][] fields = gameFrame.getYourField();
		Ship ship = fields[x][y].getShip();
		List<Field> positions = ship.getPositions();
		for(Field f : positions){
			f.removeShip();
			f.setSelected(false);
			f.setBackground(Color.lightGray);
		}
		switch (ship.getShipType()) {
		case BATTLESHIP:
			this.nbrOfBattleships++;
			this.gameFrame.setNbrOfBattleship(nbrOfBattleships);
			break;
		case SUBMARINE:
			this.nbrOfSubmarines++;
			this.gameFrame.setNbrOfSubmarine(nbrOfSubmarines);
			break;
		case DESTROYER:
			this.nbrOfDestroyers++;
			this.gameFrame.setNbrOfDestroyer(nbrOfDestroyers);
			break;
		case CRUISER:
			this.nbrOfCruisers++;
			this.gameFrame.setNbrOfCruiser(nbrOfCruisers);
			break;
		default:
			break;
		}
	}

	public void shootAt(int x, int y) {
		myClient.sendMessage("Game " + "Shoot " + x + " " + y);
	}
	
	public void checkShoot(int x, int y){
		Field[][] f = this.gameFrame.getYourField();
		if(f[x][y].getShip() != null){
			f[x][y].shoot();
			if(f[x][y].getShip().isSunk()){
				this.myClient.sendMessage("Game " + "Sunk " + x + " " + y);
			} else{
				this.myClient.sendMessage("Game " + "Hit " + x + " " + y);
				try {
					Sound.playingSound(Sounds.DEATH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			this.myClient.sendMessage("Game " + "Water " + x + " " + y);
		}
	}

	public void enterName(String name) {
		try {
			player = new Player(name);
		} catch (BattleshipException e) {
			e.printStackTrace();
		}
	}

}
