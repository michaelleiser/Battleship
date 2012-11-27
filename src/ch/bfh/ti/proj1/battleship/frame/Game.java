package ch.bfh.ti.proj1.battleship.frame;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import ch.bfh.ti.proj1.battleship.client.Field;
import ch.bfh.ti.proj1.battleship.client.Player;
import ch.bfh.ti.proj1.battleship.client.Ship;
import ch.bfh.ti.proj1.battleship.client.ShipType;
import ch.bfh.ti.proj1.battleship.view.CoordinateFrame;
import ch.bfh.ti.proj1.battleship.view.GameFrame;
import ch.bfh.ti.proj1.battleship.view.NetworkFrame;

/**
 * @author Daniel Kotlàris
 * @author Michael Leiser
 */
public class Game {
	
	private MyClient myClient;
	private NetworkFrame networkFrame;
	private CoordinateFrame coordinateFrame;
	private GameFrame gameFrame;
	private Player player;
	
//	private Context context;
	
	// initialize standard values
	private int nbrOfRows = 10;
	private int nbrOfColoumns = 10;
	private int nbrOfBattleships = 1;
	private int nbrOfSubmarines = 2;
	private int nbrOfDestroyers = 3;
	private int nbrOfCruisers = 4;
	private String gameMode = "Alternatively";
	
	private List<Ship> battleships = new ArrayList<Ship>();
	private List<Ship> submarines = new ArrayList<Ship>();
	private List<Ship> destroyers = new ArrayList<Ship>();
	private List<Ship> cruisers = new ArrayList<Ship>();
	
	private boolean canStart = true;
	
	public Game(){
		showNetworkFrame();
//		context = new Context();
//		context.handle(Context.EventType.Start);
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
			networkFrame.setVisible(false);
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
		} catch (Exception e) {
			Logger.getLogger(CoordinateFrame.class.getName()).log(Level.SEVERE, null, e);
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
		} catch (Exception e) {
			Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, null,	e);
		}
		gameFrame = new GameFrame(this);
		gameFrame.setVisible(true);
	}
	
	public void placeShip(ShipType type, int x, int y, int horizontalOrVertical) {
		Field[][] fields = gameFrame.getYourField();
		Ship ship = new Ship(type);
		if(checkConstraints(fields, ship, x, y, horizontalOrVertical)){
			switch (type) {
			case BATTLESHIP:
				if((this.nbrOfBattleships - this.battleships.size()) > 0){
					this.battleships.add(ship);
					if(horizontalOrVertical == 0){
						for(int i = 0; i < type.getSize(); i++){
							fields[y][x+i].placeShip(ship);
						}
					} else{
						for(int i = 0; i < type.getSize(); i++){
							fields[y+i][x].placeShip(ship);
						}
					}			
					this.gameFrame.setNbrOfBattleship(this.nbrOfBattleships - this.battleships.size());
				}
				break;
			case SUBMARINE:
				if((this.nbrOfSubmarines - this.submarines.size()) > 0){
					this.submarines.add(ship);
					if(horizontalOrVertical == 0){
						for(int i = 0; i < type.getSize(); i++){
							fields[y][x+i].placeShip(ship);
						}
					} else{
						for(int i = 0; i < type.getSize(); i++){
							fields[y+i][x].placeShip(ship);
						}
					}
					this.gameFrame.setNbrOfSubmarine(this.nbrOfSubmarines - this.submarines.size());
				}
				break;
			case DESTROYER:
				if((this.nbrOfDestroyers - this.destroyers.size()) > 0){
					this.destroyers.add(ship);
					if(horizontalOrVertical == 0){
						for(int i = 0; i < type.getSize(); i++){
							fields[y][x+i].placeShip(ship);
						}
					} else{
						for(int i = 0; i < type.getSize(); i++){
							fields[y+i][x].placeShip(ship);
						}
					}
					this.gameFrame.setNbrOfDestroyer(this.nbrOfDestroyers - this.destroyers.size());
				}
				break;
			case CRUISER:
				if((this.nbrOfCruisers - this.cruisers.size()) > 0){
					this.cruisers.add(ship);
					if(horizontalOrVertical == 0){
						for(int i = 0; i < type.getSize(); i++){
							fields[y][x+i].placeShip(ship);
						}
					} else{
						for(int i = 0; i < type.getSize(); i++){
							fields[y+i][x].placeShip(ship);
						}
					}
					this.gameFrame.setNbrOfCruiser(this.nbrOfCruisers - this.cruisers.size());
				}
				break;
			default:
				break;
			}
		}
	}

	private boolean checkConstraints(Field[][] fields, Ship s, int x, int y, int k) {
		if(k == 0){
			for(int i = 0; i < s.size(); i++){
				if(((x+i) >= this.nbrOfColoumns) || (fields[y][x+i].getShip() != null)){
					return false;
				}
				if(((x+i) > 0) && (fields[y][x+i-1].getShip() != null)){
					return false;
				}
				if(((x+i) < nbrOfColoumns-1) && (fields[y][x+i+1].getShip() != null)){
					return false;
				}
				if((y > 0) && (fields[y-1][x+i].getShip() != null)){
					return false;
				}
				if((y < nbrOfRows-1) && (fields[y+1][x+i].getShip() != null)){
					return false;
				}
			}
		} else{
			for(int i = 0; i < s.size(); i++){
				if(((y+i) >= this.nbrOfRows) || (fields[y+i][x].getShip() != null)){
					return false;
				}
				if((x > 0) && (fields[y+i][x-1].getShip() != null)){
					return false;
				}
				if((x < nbrOfColoumns-1) && (fields[y+i][x+1].getShip() != null)){
					return false;
				}
				if(((y+i) > 0) && (fields[y+i-1][x].getShip() != null)){
					return false;
				}
				if(((y+i) < nbrOfRows-1) && (fields[y+i+1][x].getShip() != null)){
					return false;
				}
			}
		}
		return true;
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
			this.gameFrame.setNbrOfBattleship(this.nbrOfBattleships - this.battleships.size());
			break;
		case SUBMARINE:
			this.submarines.remove(ship);
			this.gameFrame.setNbrOfSubmarine(this.nbrOfSubmarines - this.submarines.size());
			break;
		case DESTROYER:
			this.destroyers.remove(ship);
			this.gameFrame.setNbrOfDestroyer(this.nbrOfDestroyers - this.destroyers.size());
			break;
		case CRUISER:
			this.cruisers.remove(ship);
			this.gameFrame.setNbrOfCruiser(this.nbrOfCruisers - this.cruisers.size());
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
					lost();
				}
			} else{
				gameFrame.setjLabelEnemyHits();
				gameFrame.setjLabelEnemyShots();
				this.myClient.sendMessage("Game " + "Hit " + x + " " + y);
				try {
//					Sound.playingSound(Sounds.DEATH);
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
				this.gameFrame.concatjTextPaneHistory(">>> " + getPlayer().getName() + " <<<\n");
				this.myClient.sendMessage("Game " + "History " + ">>> " + getPlayer().getName() + " <<<\n");
			}
		}
		if(gameMode.equals("Alternatively")){
			this.myClient.sendMessage("Game " + "Disable ");
			this.gameFrame.enableComponents();
			this.gameFrame.concatjTextPaneHistory(">>> " + getPlayer().getName() + " <<<\n");
			this.myClient.sendMessage("Game " + "History " + ">>> " + getPlayer().getName() + " <<<\n");
		}
	}

	public void enterName(String name) {
		player = new Player(name);
	}

	public void hit(String x, String y) {
		Field[][]f = gameFrame.getEnemyField();
		f[Integer.parseInt(y)][Integer.parseInt(x)].setBackground(Color.red);
		gameFrame.setjLabelYouHits();
		gameFrame.setjLabelYouShots();
		gameFrame.concatjTextPaneHistory(getPlayer().getName() + " hits : " + x + " " + y + "\n");
		myClient.sendMessage("Game " + "History " + getPlayer().getName() + " hits : " + x + " " + y + "\n");
	}

	public void water(String x, String y) {
		Field[][]f = gameFrame.getEnemyField();
		f[Integer.parseInt(y)][Integer.parseInt(x)].setBackground(Color.blue);
		gameFrame.setjLabelYouWater();
		gameFrame.setjLabelYouShots();
		gameFrame.concatjTextPaneHistory(getPlayer().getName() + " water : " + x + " " + y + "\n");
		myClient.sendMessage("Game " + "History " + getPlayer().getName() + " water : " + x + " " + y + "\n");
	}

	public void sunk(String x, String y) {
		Field[][]f = gameFrame.getEnemyField();
		f[Integer.parseInt(y)][Integer.parseInt(x)].setBackground(Color.green);
		gameFrame.setjLabelYouHits();
		gameFrame.setjLabelYouSunk();
		gameFrame.setjLabelYouShots();
		gameFrame.concatjTextPaneHistory(getPlayer().getName() + " sunk : " + x + " " + y + "\n");
		myClient.sendMessage("Game " + "History " + getPlayer().getName() + " sunk : " + x + " " + y + "\n");
	}

	public void won() {
		JOptionPane.showMessageDialog(null, "You won");
		canStart = true;
		battleships = new ArrayList<Ship>();
		submarines = new ArrayList<Ship>();
		destroyers = new ArrayList<Ship>();
		cruisers = new ArrayList<Ship>();
		gameFrame.setVisible(false);
		coordinateFrame.setVisible(true);
		coordinateFrame.disableComponents();
		coordinateFrame.setFirst(true);
	}
	
	public void lost(){
		JOptionPane.showMessageDialog(null, "You lost");
		canStart = true;
		battleships = new ArrayList<Ship>();
		submarines = new ArrayList<Ship>();
		destroyers = new ArrayList<Ship>();
		cruisers = new ArrayList<Ship>();
		gameFrame.setVisible(false);
		coordinateFrame.setVisible(true);
		coordinateFrame.enableComponents();
		coordinateFrame.setFirst(true);
	}
	
	public void ready() {
		if(canStart){
			this.gameFrame.enableComponents();
			this.myClient.sendMessage("Game " + "Start ");
			
			this.gameFrame.concatjTextPaneHistory(">>> " + getPlayer().getName() + " <<<\n");
			this.myClient.sendMessage("Game " + "History " + ">>> " + getPlayer().getName() + " <<<\n");
		}
	}
	
	public void setStartToFalse(){
		this.canStart = false;
	}

	public boolean allShipsPlaced() {
		if((nbrOfBattleships == this.battleships.size()) &&
				(nbrOfSubmarines == this.submarines.size()) &&
				(nbrOfDestroyers == this.destroyers.size()) &&
				(nbrOfCruisers == this.cruisers.size())){
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
	
	public MyClient getClient() {
		return myClient;
	}

	public NetworkFrame getNetworkFrame() {
		return networkFrame;
	}
	
	public CoordinateFrame getCoordinateFrame(){
		return coordinateFrame;
	}
	
	public GameFrame getGameFrame(){
		return gameFrame;
	}

}
