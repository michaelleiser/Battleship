package ch.bfh.ti.proj1.battleship.frame;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.state.Context;

import ch.bfh.ti.proj1.battleship.client.Field;
import ch.bfh.ti.proj1.battleship.client.Player;
import ch.bfh.ti.proj1.battleship.client.Ship;
import ch.bfh.ti.proj1.battleship.client.ShipType;
import ch.bfh.ti.proj1.battleship.exception.BattleshipException;
import ch.bfh.ti.proj1.battleship.sound.Sound;
import ch.bfh.ti.proj1.battleship.sound.Sound.Sounds;
import ch.bfh.ti.proj1.battleship.view.CoordinateFrame;
import ch.bfh.ti.proj1.battleship.view.GameFrame;
import ch.bfh.ti.proj1.battleship.view.NetworkFrame;

/**
 * @author Daniel Kotl�ris
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
	
	private boolean canStart = true;
	
	private List<Ship> battleships = new ArrayList<Ship>();
	private List<Ship> submarines = new ArrayList<Ship>();
	private List<Ship> destroyers = new ArrayList<Ship>();
	private List<Ship> cruisers = new ArrayList<Ship>();
	
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
	
	public void placeShip(ShipType type, int x, int y, int k) {
		Field[][] fields = gameFrame.getYourField();
		Ship s = new Ship(type);
		if(checkConstraints(fields, s, x, y, k)){
			switch (type) {
			case BATTLESHIP:
				this.battleships.add(s);
				if(this.nbrOfBattleships > 0){
					if(k == 0){
						for(int i = 0; i < type.getSize(); i++){
							fields[y][x+i].placeShip(s);
						}
					} else{
						for(int i = 0; i < type.getSize(); i++){
							fields[y+i][x].placeShip(s);
						}
					}			
					this.nbrOfBattleships--;
					this.gameFrame.setNbrOfBattleship(this.nbrOfBattleships);
				}
				break;
			case SUBMARINE:
				this.submarines.add(s);
				if(this.nbrOfSubmarines > 0){
					if(k == 0){
						for(int i = 0; i < type.getSize(); i++){
							fields[y][x+i].placeShip(s);
						}
					} else{
						for(int i = 0; i < type.getSize(); i++){
							fields[y+i][x].placeShip(s);
						}
					}
					this.nbrOfSubmarines--;
					this.gameFrame.setNbrOfSubmarine(this.nbrOfSubmarines);
				}
				break;
			case DESTROYER:
				this.destroyers.add(s);
				if(this.nbrOfDestroyers > 0){
					if(k == 0){
						for(int i = 0; i < type.getSize(); i++){
							fields[y][x+i].placeShip(s);
						}
					} else{
						for(int i = 0; i < type.getSize(); i++){
							fields[y+i][x].placeShip(s);
						}
					}
					this.nbrOfDestroyers--;
					this.gameFrame.setNbrOfDestroyer(this.nbrOfDestroyers);
				}
				break;
			case CRUISER:
				this.cruisers.add(s);
				if(this.nbrOfCruisers > 0){
					if(k == 0){
						for(int i = 0; i < type.getSize(); i++){
							fields[y][x+i].placeShip(s);
						}
					} else{
						for(int i = 0; i < type.getSize(); i++){
							fields[y+i][x].placeShip(s);
						}
					}
					this.nbrOfCruisers--;
					this.gameFrame.setNbrOfCruiser(this.nbrOfCruisers);
				}
				break;
			default:
				break;
			}
		}
	}

	private boolean checkConstraints(Field[][] fields, Ship s, int x, int y, int k) {
//		System.out.println("x: " + x + " : y: " + y + " : k: " + k);
		boolean placeable = true;
		if(k == 0){
			for(int i = 0; i < s.size(); i++){
				if(((x+i) >= this.nbrOfColoumns) || (fields[y][x+i].getShip() != null)){
					placeable = false;
				}
			
//				if(((x+i) > 0) && ((x+i) < nbrOfColoumns-1)){
//					if((fields[y][x+i-1].getShip() != null) || (fields[y][x+i+1].getShip() != null)){
//						placeable = false;
//					}
//				}
//				else if(((x+i) <= 0)){
//					if((fields[y][x+i-1].getShip() != null)){
//						placeable = false;
//					}
//				}
//				else if(((x+i) >= nbrOfColoumns-1)){
//					if((fields[y][x+i+1].getShip() != null)){
//						placeable = false;
//					}
//				}
//				if(((x+i) > 0) && (fields[y][x+i-1].getShip() != null)){
//					placeable = false;
//				}
//				if(((x+i) < nbrOfColoumns-1) && (fields[y][x+i+1].getShip() != null)){
//					placeable = false;
//				}
//				if((y > 0) && (fields[y-1][x+i].getShip() != null)){
//					placeable = false;
//				}
//				if((y < nbrOfRows-1) && (fields[y+1][x+i].getShip() != null)){
//					placeable = false;
//				}
			}
		} else{
			for(int i = 0; i < s.size(); i++){
				if(((y+i) >= this.nbrOfRows) || (fields[y+i][x].getShip() != null)){
					placeable = false;
				}
				
//				if((x > 0) && (fields[y+i][x-1].getShip() != null)){
//					placeable = false;
//				}
//				if((x < nbrOfColoumns-1) && (fields[y+i][x+1].getShip() != null)){
//					placeable = false;
//				}
//				if(((y+i) > 0) && (fields[y+i-1][x].getShip() != null)){
//					placeable = false;
//				}
//				if(((y+i) < nbrOfRows-1) && (fields[y+i+1][x].getShip() != null)){
//					placeable = false;
//				}
			}
		}
		return placeable;
	}

	public void removeShip(int x, int y) {
		Field[][] fields = gameFrame.getYourField();
		Ship ship = fields[y][x].getShip();
		List<Field> positions = ship.getPositions();
		for(Field f : positions){
			f.removeShip();
		}
		switch (ship.getShipType()) {
		case BATTLESHIP:
			this.battleships.remove(ship);
			this.nbrOfBattleships++;
			this.gameFrame.setNbrOfBattleship(this.nbrOfBattleships);
			break;
		case SUBMARINE:
			this.submarines.remove(ship);
			this.nbrOfSubmarines++;
			this.gameFrame.setNbrOfSubmarine(this.nbrOfSubmarines);
			break;
		case DESTROYER:
			this.destroyers.remove(ship);
			this.nbrOfDestroyers++;
			this.gameFrame.setNbrOfDestroyer(this.nbrOfDestroyers);
			break;
		case CRUISER:
			this.cruisers.remove(ship);
			this.nbrOfCruisers++;
			this.gameFrame.setNbrOfCruiser(this.nbrOfCruisers);
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
		if(f[y][x].getShip() != null){
			f[y][x].shoot();
			if(f[y][x].getShip().isSunk()){
				gameFrame.setjLabelEnemyHits();
				gameFrame.setjLabelEnemySunk();
				gameFrame.setjLabelEnemyShots();
				this.myClient.sendMessage("Game " + "Sunk " + x + " " + y);
				if(allShipsSunk()){
					this.myClient.sendMessage("Game " + "Won ");
					JOptionPane.showMessageDialog(null, "You lost");
				}
			} else{
				gameFrame.setjLabelEnemyHits();
				gameFrame.setjLabelEnemyShots();
				this.myClient.sendMessage("Game " + "Hit " + x + " " + y);
				try {
					Sound.playingSound(Sounds.DEATH);
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
		} else {
			gameFrame.setjLabelEnemyWater();
			gameFrame.setjLabelEnemyShots();
			this.myClient.sendMessage("Game " + "Water " + x + " " + y);
			if(gameMode.equals("UntilWater")){
				this.myClient.sendMessage("Game " + "Disable ");
				this.gameFrame.enableComponents();
			}
		}
		if(gameMode.equals("Alternatively")){
			this.myClient.sendMessage("Game " + "Disable ");
			this.gameFrame.enableComponents();
		}
	}

	public void enterName(String name) {
		try {
			player = new Player(name);
		} catch (BattleshipException e) {
			e.printStackTrace();
		}
	}

	public void hit(String x, String y) {
		Field[][]f = gameFrame.getEnemyField();
		f[Integer.parseInt(y)][Integer.parseInt(x)].setBackground(Color.red);
		gameFrame.setjLabelYouHits();
		gameFrame.setjLabelYouShots();
	}

	public void water(String x, String y) {
		Field[][]f = gameFrame.getEnemyField();
		f[Integer.parseInt(y)][Integer.parseInt(x)].setBackground(Color.blue);
		gameFrame.setjLabelYouWater();
		gameFrame.setjLabelYouShots();
	}

	public void sunk(String x, String y) {
		Field[][]f = gameFrame.getEnemyField();
		f[Integer.parseInt(y)][Integer.parseInt(x)].setBackground(Color.green);
		gameFrame.setjLabelYouHits();
		gameFrame.setjLabelYouSunk();
		gameFrame.setjLabelYouShots();
	}

	public void won() {
		JOptionPane.showMessageDialog(null, "You Won");
	}
	
	public void ready() {
		if(canStart){
			this.gameFrame.enableComponents();
			this.myClient.sendMessage("Game " + "Start ");
		}
	}
	
	public void setStartToFalse(){
		this.canStart = false;
	}

	public boolean allShipsPlaced() {
		if((nbrOfBattleships == 0) && (nbrOfSubmarines == 0) && (nbrOfDestroyers == 0) && (nbrOfCruisers == 0)){
			return true;
		} else{
			return false;
		}	
	}
	
	public boolean allShipsSunk(){
		for(Ship s : battleships){
			if(!s.isSunk()){
				return false;
			}
		}
		for(Ship s : submarines){
			if(!s.isSunk()){
				return false;
			}
		}
		for(Ship s : destroyers){
			if(!s.isSunk()){
				return false;
			}
		}
		for(Ship s : cruisers){
			if(!s.isSunk()){
				return false;
			}
		}
		return true;
	}

}
