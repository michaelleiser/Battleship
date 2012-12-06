package ch.bfh.ti.proj1.battleship.frame;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import ch.bfh.ti.proj1.battleship.client.Field;
import ch.bfh.ti.proj1.battleship.client.Player;
import ch.bfh.ti.proj1.battleship.client.Ship;
import ch.bfh.ti.proj1.battleship.client.ShipType;
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
	
	private MyClient myClient;
	private NetworkFrame networkFrame;
	private CoordinateFrame coordinateFrame;
	private GameFrame gameFrame;
	private Player player;
	private Thread bgSoundThread;
	private Thread gameSoundThread;
	
	// initialize standard values
	private int nbrOfRows = 10;
	private int nbrOfColoumns = 10;
	private int nbrOfBattleships = 1;
	private int nbrOfSubmarines = 2;
	private int nbrOfDestroyers = 3;
	private int nbrOfCruisers = 4;
	private String gameMode = "Alternatively";
	
	private List<Ship> battleships;
	private List<Ship> submarines;
	private List<Ship> destroyers;
	private List<Ship> cruisers;
	
	private boolean canStart;
	
	private boolean yourTurn;
	
	public Game(){
		init();
		showNetworkFrame();
	}
	
	public void init(){
		canStart = true;
		yourTurn = false;
		battleships = new ArrayList<Ship>();
		submarines = new ArrayList<Ship>();
		destroyers = new ArrayList<Ship>();
		cruisers = new ArrayList<Ship>();
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
		startGameSound();												// Start the game sound
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
			for(int i = 0; i < s.getSize(); i++){
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
			for(int i = 0; i < s.getSize(); i++){
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
				gameFrame.incjLabelEnemyHits();
				gameFrame.incjLabelEnemySunk();
				gameFrame.incjLabelEnemyShots();
				this.myClient.sendMessage("Game " + "Sunk " + x + " " + y);
				f[y][x].setBackground(Color.green);
				Sound.playingSound(Sounds.SUNK);
				if(allShipsSunk()){
					this.myClient.sendMessage("Game " + "Won ");
					lost();
				}
			} else{
				gameFrame.incjLabelEnemyHits();
				gameFrame.incjLabelEnemyShots();
				this.myClient.sendMessage("Game " + "Hit " + x + " " + y);
				f[y][x].setBackground(Color.red);
				Sound.playingSound(Sounds.HIT);
			}
		} else {
			gameFrame.incjLabelEnemyWater();
			gameFrame.incjLabelEnemyShots();
			this.myClient.sendMessage("Game " + "Water " + x + " " + y);
			f[y][x].setBackground(Color.blue);
			Sound.playingSound(Sounds.WATER);
			if(gameMode.equals("UntilWater")){
				this.myClient.sendMessage("Game " + "Disable ");
				setYourTurn(true);
				this.gameFrame.concatjTextPaneHistory(">>> " + player.getName() + " <<<\n");
				this.myClient.sendMessage("Game " + "History " + ">>> " + player.getName() + " <<<\n");
			}
		}
		if(gameMode.equals("Alternatively")){
			this.myClient.sendMessage("Game " + "Disable ");
			setYourTurn(true);
			this.gameFrame.concatjTextPaneHistory(">>> " + player.getName() + " <<<\n");
			this.myClient.sendMessage("Game " + "History " + ">>> " + player.getName() + " <<<\n");
		}
	}

	public void enterName(String name) {
		player = new Player(name);
	}

	public void hit(int x, int y) {
		Field[][]f = gameFrame.getEnemyField();
		f[y][x].setBackground(Color.red);
		gameFrame.incjLabelYouHits();
		gameFrame.incjLabelYouShots();
		gameFrame.concatjTextPaneHistory(player.getName() + " hits : " + (x+1) + " " + ((char)(y+65)) + "\n");
		myClient.sendMessage("Game " + "History " + player.getName() + " hits : " + (x+1) + " " + ((char)(y+65)) + "\n");
		Sound.playingSound(Sounds.HIT);
	}

	public void water(int x, int y) {
		Field[][]f = gameFrame.getEnemyField();
		f[y][x].setBackground(Color.blue);
		gameFrame.incjLabelYouWater();
		gameFrame.incjLabelYouShots();
		gameFrame.concatjTextPaneHistory(player.getName() + " water : " + (x+1) + " " + ((char)(y+65)) + "\n");
		myClient.sendMessage("Game " + "History " + player.getName() + " water : " + (x+1) + " " + ((char)(y+65)) + "\n");
		Sound.playingSound(Sounds.WATER);
	}

	public void sunk(int x, int y) {
		Field[][]f = gameFrame.getEnemyField();
		f[y][x].setBackground(Color.green);
		gameFrame.incjLabelYouHits();
		gameFrame.incjLabelYouSunk();
		gameFrame.incjLabelYouShots();
		gameFrame.concatjTextPaneHistory(player.getName() + " sunk : " + (x+1) + " " + ((char)(y+65)) + "\n");
		myClient.sendMessage("Game " + "History " + player.getName() + " sunk : " + (x+1) + " " + ((char)(y+65)) + "\n");
		Sound.playingSound(Sounds.SUNK);
	}

	public void won() {
		Sound.playingSound(Sounds.WINNER);
		JOptionPane.showMessageDialog(null, "You won");
		init();
		gameFrame.setVisible(false);
		coordinateFrame.setVisible(true);
		coordinateFrame.disableComponents();
		coordinateFrame.setFirst(true);
		this.bgSoundThread.stop();
	}
	
	public void lost(){
		Sound.playingSound(Sounds.LOSER);
		JOptionPane.showMessageDialog(null, "You lost");
		init();
		gameFrame.setVisible(false);
		coordinateFrame.setVisible(true);
		coordinateFrame.enableComponents();
		coordinateFrame.setFirst(true);
		this.bgSoundThread.stop();
	}
	
	public void ready() {
		if(canStart){
			setYourTurn(true);
			this.myClient.sendMessage("Game " + "Start ");
			
			this.gameFrame.concatjTextPaneHistory(">>> " + player.getName() + " <<<\n");
			this.myClient.sendMessage("Game " + "History " + ">>> " + player.getName() + " <<<\n");
		}
		if(!canStart){
			this.myClient.sendMessage("Game " + "Enable ");
			this.myClient.sendMessage("Game " + "Sound ");
			this.getGameFrame().enableComponents();
			gameSoundThread.stop();
			startBackgroundSound();
		}
	}
	
	public void startGameSound() {
		this.gameSoundThread = new Thread(new Runnable() {

			@Override
			public void run() {
				while(true) {
					
					Sound.playGameSound();

				}
			}
		});
		this.gameSoundThread.start();

	}

	public Thread getGameSoundThread() {
		return gameSoundThread;
	}

	public void startBackgroundSound() {
		this.bgSoundThread = new Thread(new Runnable() {

			@Override
			public void run() {
				while(true) {
					Random random = new Random();
					Sound.playBackgroundSound(random.nextInt(3));

					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		this.bgSoundThread.start();
	}
	
	
	public Thread getBgSoundThread() {
		return bgSoundThread;
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
	
	public boolean isYourTurn() {
		return yourTurn;
	}

	public void setYourTurn(boolean yourTurn) {
		this.yourTurn = yourTurn;
	}
}
