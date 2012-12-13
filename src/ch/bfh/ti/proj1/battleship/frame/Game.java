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
import ch.bfh.ti.proj1.battleship.view.LoserFrame;
import ch.bfh.ti.proj1.battleship.view.NetworkFrame;
import ch.bfh.ti.proj1.battleship.view.WinnerFrame;

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
	private GameMode gameMode = GameMode.ALTERNATIVELY;
	
	private List<Ship> battleships;
	private List<Ship> submarines;
	private List<Ship> destroyers;
	private List<Ship> cruisers;
	
	private boolean canStart;
	
	private boolean yourTurn;
	
	/**
	 * Constructor for creating a new game.
	 */
	public Game(){
		init();
		showNetworkFrame();
	}
	
	/**
	 * Initializes some variables.
	 */
	public void init(){
		canStart = true;
		yourTurn = false;
		battleships = new ArrayList<Ship>();
		submarines = new ArrayList<Ship>();
		destroyers = new ArrayList<Ship>();
		cruisers = new ArrayList<Ship>();
	}
	
	/**
	 * Host a game. This method creates a server and listens on the specified {@code port} number.
	 * @param port
	 */
	public void hostGame(final int port) {
		MyServer myServer = new MyServer(port);
		if(myServer.isAvailable()){
			myClient = new MyClient(port, "localhost");
			myClient.setGame(this);
			networkFrame.disableComponents();
		}	
		else{
			JOptionPane.showMessageDialog(null, "Port is already in use.");
		}
	}

	/**
	 * Join a game. This method connects to the server with {@code IP} address and {@code port} number.
	 * @param port
	 * @param IP
	 */
	public void joinGame(final int port, final String IP) {
		myClient = new MyClient(port, IP);
		myClient.setGame(this);
		if(myClient.isConnected()){
			networkFrame.setVisible(false);
			showCoordinateFrame();	
			coordinateFrame.disableComponents();
			myClient.sendMessage(Message.GAME_SHOW.toString());
		}
		else{
			JOptionPane.showMessageDialog(null, "Could not connect to the host.");
		}
	}
	
	/**
	 * Creates a new NetworkFrame and displays it.
	 */
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

	/**
	 *  Creates a new CoordinateFrame and displays it.
	 */
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
	
	/**
	 *  Creates a new GameFrame and displays it.
	 */
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

	/**
	 * Places a ship with the specified {@code type} either horizontally or vertically at the position {@code x} and {@code y}.
	 * @param type
	 * @param x
	 * @param y
	 * @param horizontalOrVertical
	 */
	public void placeShip(ShipType type, int x, int y, int horizontalOrVertical) {
		Field[][] fields = gameFrame.getYourField();
		Ship ship = new Ship(type);
		if(checkConstraints(fields, ship, x, y, horizontalOrVertical)){
			switch (type) {
			case BATTLESHIP:
				if(nbrOfBattleshipsLeft() > 0){
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
					this.gameFrame.setNbrOfBattleship(nbrOfBattleshipsLeft());
				}
				break;
			case SUBMARINE:
				if(nbrOfSubmarinesLeft() > 0){
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
					this.gameFrame.setNbrOfSubmarine(nbrOfSubmarinesLeft());
				}
				break;
			case DESTROYER:
				if(nbrOfDestroyersLeft() > 0){
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
					this.gameFrame.setNbrOfDestroyer(nbrOfDestroyersLeft());
				}
				break;
			case CRUISER:
				if(nbrOfCruisersLeft() > 0){
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
					this.gameFrame.setNbrOfCruiser(nbrOfCruisersLeft());
				}
				break;
			default:
				break;
			}
		}
	}
	
	
	public int nbrOfBattleshipsLeft(){
		return this.nbrOfBattleships - this.battleships.size();
	}
	
	public int nbrOfSubmarinesLeft(){
		return this.nbrOfSubmarines - this.submarines.size();
	}
	
	public int nbrOfDestroyersLeft(){
		return this.nbrOfDestroyers - this.destroyers.size();
	}
	
	public int nbrOfCruisersLeft(){
		return this.nbrOfCruisers - this.cruisers.size();
	}

	/**
	 * Checks if the {@code ship} can be placed at the {@code fields} with starting {@code x} and {@code y} position.
	 * @param fields
	 * @param ship
	 * @param x
	 * @param y
	 * @param alignment
	 * @return
	 * 			{@code true} if the ship can be placed at this position
	 */
	public boolean checkConstraints(Field[][] fields, Ship ship, int x, int y, int alignment) {
		if(alignment == 0){
			for(int i = 0; i < ship.getSize(); i++){
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
			for(int i = 0; i < ship.getSize(); i++){
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

	/**
	 * Removes the ship that is placed on the field with {@code x} and {@code y} position.
	 * @param x
	 * @param y
	 */
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

	/**
	 * The active player shoots at the field with {@code x} and {@code y} position. 
	 * @param x
	 * @param y
	 */
	public void shootAt(int x, int y) {
		setYourTurn(false);
		myClient.sendMessage(Message.GAME_SHOOT.toString() + " " + x + " " + y);
	}
	
	/**
	 * The passive player checks the field with {@code x} and {@code y} position for a shoot in the water, hit a ship, sunk a ship and for wining the game. 
	 * @param x
	 * @param y
	 */
	public void checkShoot(int x, int y){
		Field[][] f = this.gameFrame.getYourField();
		if(f[y][x].getShip() != null){
			f[y][x].shoot();
			if(f[y][x].getShip().isSunk()){
				gameFrame.incjLabelEnemyHits();
				gameFrame.incjLabelEnemySunk();
				gameFrame.incjLabelEnemyShots();
				this.myClient.sendMessage(Message.GAME_SUNK.toString() + " " + x + " " + y);
				f[y][x].setBackground(Color.red);
				Sound.playingSound(Sounds.SUNK);
				if(allShipsSunk()){
					this.myClient.sendMessage(Message.GAME_WON.toString());
					lost();
				}
			} else{
				gameFrame.incjLabelEnemyHits();
				gameFrame.incjLabelEnemyShots();
				this.myClient.sendMessage(Message.GAME_HIT.toString() + " " + x + " " + y);
				f[y][x].setBackground(Color.orange);
				Sound.playingSound(Sounds.HIT);
			}
			if(gameMode.equals(GameMode.UNTILWATER)){
				this.myClient.sendMessage(Message.GAME_ENABLE.toString());
			}
			else{
				setYourTurn(true);
			}
		} else {
			gameFrame.incjLabelEnemyWater();
			gameFrame.incjLabelEnemyShots();
			this.myClient.sendMessage(Message.GAME_WATER.toString() + " " + x + " " + y);
			f[y][x].setBackground(Color.blue);
			Sound.playingSound(Sounds.WATER);
			setYourTurn(true);
		}
	}

	/**
	 * Creat a new Player with the entered {@code name}.
	 * @param name
	 */
	public void enterName(String name) {
		player = new Player(name);
	}

	/**
	 * The active player has hit a ship at the field with {@code x} and {@code y} position.
	 * @param x
	 * @param y
	 */
	public void hit(int x, int y) {
		Field[][]f = gameFrame.getEnemyField();
		f[y][x].setBackground(Color.orange);
		gameFrame.incjLabelYouHits();
		gameFrame.incjLabelYouShots();
		gameFrame.concatjTextPaneHistory(player.getName() + " hits : " + (x+1) + " " + ((char)(y+65)) + "\n");
		myClient.sendMessage(Message.GAME_HISTORY.toString() + " " + player.getName() + " hits : " + (x+1) + " " + ((char)(y+65)) + "\n");
		Sound.playingSound(Sounds.HIT);
		if(gameMode.equals(GameMode.ALTERNATIVELY)){
			this.myClient.sendMessage(Message.GAME_ACTIVEPLAYER.toString());
		}
	}

	/**
	 * The active player has hit the water at the field with {@code x} and {@code y} position.
	 * @param x
	 * @param y
	 */
	public void water(int x, int y) {
		Field[][]f = gameFrame.getEnemyField();
		f[y][x].setBackground(Color.blue);
		gameFrame.incjLabelYouWater();
		gameFrame.incjLabelYouShots();
		gameFrame.concatjTextPaneHistory(player.getName() + " water : " + (x+1) + " " + ((char)(y+65)) + "\n");
		myClient.sendMessage(Message.GAME_HISTORY.toString() + " " + player.getName() + " water : " + (x+1) + " " + ((char)(y+65)) + "\n");
		Sound.playingSound(Sounds.WATER);
		if(gameMode.equals(GameMode.UNTILWATER)){
			this.myClient.sendMessage(Message.GAME_ACTIVEPLAYER.toString());
		}
		if(gameMode.equals(GameMode.ALTERNATIVELY)){
			this.myClient.sendMessage(Message.GAME_ACTIVEPLAYER.toString());
		}
	}

	/**
	 * The active player has sunk a ship at the field with {@code x} and {@code y} position.
	 * @param x
	 * @param y
	 */
	public void sunk(int x, int y) {
		Field[][]f = gameFrame.getEnemyField();
		f[y][x].setBackground(Color.red);
		gameFrame.incjLabelYouHits();
		gameFrame.incjLabelYouSunk();
		gameFrame.incjLabelYouShots();
		gameFrame.concatjTextPaneHistory(player.getName() + " sunk : " + (x+1) + " " + ((char)(y+65)) + "\n");
		myClient.sendMessage(Message.GAME_HISTORY.toString() + " " + player.getName() + " sunk : " + (x+1) + " " + ((char)(y+65)) + "\n");
		Sound.playingSound(Sounds.SUNK);
		if(gameMode.equals(GameMode.ALTERNATIVELY)){
			this.myClient.sendMessage(Message.GAME_ACTIVEPLAYER.toString());
		}
	}

	/**
	 * The active player has won the game.
	 */
	@SuppressWarnings("deprecation")
	public void won() {
		new WinnerFrame(this);
		Sound.playingSound(Sounds.WINNER);
	}
	
	/**
	 * The passive player has lost the game.
	 */
	@SuppressWarnings("deprecation")
	public void lost(){
		new LoserFrame(this);
		Sound.playingSound(Sounds.LOSER);
	}
	
	/**
	 * This method sets the player to the ready state. The first player who calls this method can later start with shooting in the game.
	 */
	@SuppressWarnings("deprecation")
	public void ready() {
		if(canStart){
			setYourTurn(true);
			this.myClient.sendMessage(Message.GAME_START.toString());
			this.gameFrame.concatjTextPaneHistory("... " + player.getName() + " ...\n");
			this.myClient.sendMessage(Message.GAME_HISTORY.toString() + " " + "... " + player.getName() + " ...\n");
		}
		if(!canStart){
			this.gameFrame.concatjTextPaneHistory("... " + player.getName() + " ...\n");
			this.myClient.sendMessage(Message.GAME_HISTORY.toString() + " " + "... " + player.getName() + " ...\n");
			this.myClient.sendMessage(Message.GAME_ENABLECOMPONENTS.toString());
			this.myClient.sendMessage(Message.GAME_SOUND.toString());
			this.getGameFrame().enableComponents();
			gameSoundThread.stop();
			startBackgroundSound();
			this.myClient.sendMessage(Message.GAME_ACTIVEPLAYER.toString());
		}
	}
	
	/**
	 * Starts the game sound.
	 */
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

	/**
	 * Returns a thread of the game sound.
	 * @return
	 * 			game sound thread
	 */
	public Thread getGameSoundThread() {
		return gameSoundThread;
	}

	/**
	 * Starts the background sound.
	 */
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
	
	
	/**
	 * Returns the background sound thread.
	 * @return
	 * 			background sound thread
	 */
	public Thread getBgSoundThread() {
		return bgSoundThread;
	}

	/**
	 * TODO
	 */
	public void setStartToFalse(){
		this.canStart = false;
	}

	/**
	 * Returns the status if all ships are placed or not.
	 * @return
	 * 			{@code true} if all ships are placed
	 */
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
	
	/**
	 * Returns the status if all ships are sunk or not.
	 * @return
	 * 			{@code true} if all ships are sunk
	 */
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

	/**
	 * @return
	 * 			the number of rows
	 */
	public int getNbrOfRows() {
		return nbrOfRows;
	}

	/**
	 * Sets the number of rows.
	 * @param nbrOfRows
	 */
	public void setNbrOfRows(int nbrOfRows) {
		this.nbrOfRows = nbrOfRows;
	}

	/**
	 * @return
	 * 			the number of coloumns
	 */
	public int getNbrOfColoumns() {
		return nbrOfColoumns;
	}

	/**
	 * Sets the number of coloumns.
	 * @param nbrOfColoumns
	 */
	public void setNbrOfColoumns(int nbrOfColoumns) {
		this.nbrOfColoumns = nbrOfColoumns;
	}

	/**
	 * @return
	 * 			the number of battleships
	 */
	public int getNbrOfBattleships() {
		return nbrOfBattleships;
	}

	/**
	 * Sets the number of battleships.
	 * @param nbrOfBattleships
	 */
	public void setNbrOfBattleships(int nbrOfBattleships) {
		this.nbrOfBattleships = nbrOfBattleships;
	}

	/**
	 * @return
	 * 			the number of submarines
	 */
	public int getNbrOfSubmarines() {
		return nbrOfSubmarines;
	}

	/**
	 * Sets the number of submarines.
	 * @param nbrOfSubmarines
	 */
	public void setNbrOfSubmarines(int nbrOfSubmarines) {
		this.nbrOfSubmarines = nbrOfSubmarines;
	}

	/**
	 * @return
	 * 			the number of destroyers
	 */
	public int getNbrOfDestroyers() {
		return nbrOfDestroyers;
	}

	/**
	 * Sets the number of destroyers.
	 * @param nbrOfDestroyers
	 */
	public void setNbrOfDestroyers(int nbrOfDestroyers) {
		this.nbrOfDestroyers = nbrOfDestroyers;
	}

	/**
	 * @return
	 * 			the number of cruisers
	 */
	public int getNbrOfCruisers() {
		return nbrOfCruisers;
	}

	/**
	 * Sets the number of cruisers.
	 * @param nbrOfCruisers
	 */
	public void setNbrOfCruisers(int nbrOfCruisers) {
		this.nbrOfCruisers = nbrOfCruisers;
	}

	/**
	 * @return
	 * 			the game mode
	 */
	public GameMode getGameMode() {
		return gameMode;
	}

	/**
	 * Sets the game mode.
	 * @param gameMode
	 */
	public void setGameMode(GameMode gameMode) {
		this.gameMode = gameMode;
	}
	
	/**
	 * This method sets the game options.
	 * @param nbrOfRows
	 * @param nbrOfColoumns
	 * @param nbrOfBattleships
	 * @param nbrOfSubmarines
	 * @param nbrOfDestroyers
	 * @param nbrOfCruisers
	 * @param gameMode
	 */
	public void setOptions(int nbrOfRows, int nbrOfColoumns, int nbrOfBattleships,
			int nbrOfSubmarines, int nbrOfDestroyers, int nbrOfCruisers, GameMode gameMode){
		this.nbrOfRows = nbrOfRows;
		this.nbrOfColoumns = nbrOfColoumns;
		this.nbrOfBattleships = nbrOfBattleships;
		this.nbrOfSubmarines = nbrOfSubmarines;
		this.nbrOfDestroyers = nbrOfDestroyers;
		this.nbrOfCruisers = nbrOfCruisers;
		if(gameMode.equals(GameMode.ALTERNATIVELY)){
			this.gameMode = GameMode.ALTERNATIVELY;
		}
		else if (gameMode.equals(GameMode.UNTILWATER)){
			this.gameMode = GameMode.UNTILWATER;
		}
	}

	/**
	 * @return
	 * 			the player
	 */
	public Player getPlayer() {
		return this.player;
	}
	
	/**
	 * @return
	 * 			the client
	 */
	public MyClient getClient() {
		return myClient;
	}

	/**
	 * @return
	 * 			the networkFrame
	 */
	public NetworkFrame getNetworkFrame() {
		return networkFrame;
	}
	
	/**
	 * @return
	 * 			the coordinateFrame
	 */
	public CoordinateFrame getCoordinateFrame(){
		return coordinateFrame;
	}
	
	/**
	 * @return
	 * 			the gameFrame
	 */
	public GameFrame getGameFrame(){
		return gameFrame;
	}
	
	/**
	 * @return
	 * 			{@code true} if it's your turn
	 */
	public boolean isYourTurn() {
		return yourTurn;
	}

	/**
	 * @param yourTurn
	 */
	public void setYourTurn(boolean yourTurn) {
		this.yourTurn = yourTurn;
	}

	/**
	 * Restarts a game.
	 */
	@SuppressWarnings("deprecation")
	public void restart() {
		this.gameFrame.dispose();
		this.showCoordinateFrame();
		this.coordinateFrame.disableComponents();
		this.init();
//		this.bgSoundThread.stop();
	}

	/**
	 * Shows the active player in the history.
	 */
	public void showActivePlayer() {
		this.gameFrame.concatjTextPaneHistory(">>> " + player.getName() + " <<<\n");
		this.myClient.sendMessage(Message.GAME_HISTORY.toString() + " " + ">>> " + player.getName() + " <<<\n");
	}
}
