package ch.bfh.ti.proj1.battleship.game;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import ch.bfh.ti.proj1.battleship.common.Field;
import ch.bfh.ti.proj1.battleship.common.Player;
import ch.bfh.ti.proj1.battleship.common.Ship;
import ch.bfh.ti.proj1.battleship.common.ShipType;
import ch.bfh.ti.proj1.battleship.network.Client;
import ch.bfh.ti.proj1.battleship.network.Message;
import ch.bfh.ti.proj1.battleship.network.Server;
import ch.bfh.ti.proj1.battleship.sound.Sound;
import ch.bfh.ti.proj1.battleship.sound.Sound.Sounds;
import ch.bfh.ti.proj1.battleship.view.CoordinateFrame;
import ch.bfh.ti.proj1.battleship.view.GameFrame;
import ch.bfh.ti.proj1.battleship.view.LoserFrame;
import ch.bfh.ti.proj1.battleship.view.NetworkFrame;
import ch.bfh.ti.proj1.battleship.view.WinnerFrame;

/**
 * This class creates the game and defines the settings and the methods for playing the battleship game.
 * 
 * @author Daniel Kotlàris
 * @author Michael Leiser
 */
public class Game {
	
	private Server server;
	private Client client;
	private NetworkFrame networkFrame;
	private CoordinateFrame coordinateFrame;
	private GameFrame gameFrame;
	private Player player;
//	private Thread bgSoundThread;
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
	 * Constructor for creating a new {@link Game}.
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
	 * Host a {@link Game}. This method creates a {@link Server} and listens on the specified {@code port} number.
	 * @param port number
	 */
	public void hostGame(final int port) {
		server = new Server(port);
		if(server.isAvailable()){
			client = new Client(port, "localhost");
			client.setGame(this);
			networkFrame.disableComponents();
		}	
		else{
			JOptionPane.showMessageDialog(null, "Port is already in use.");
		}
	}

	/**
	 * Join a {@link Game}. This method creates a {@link Client} and connects to the {@link Server} with the {@code IP} address and {@code port} number.
	 * @param port number
	 * @param IP address
	 */
	public void joinGame(final int port, final String IP) {
		client = new Client(port, IP);
		client.setGame(this);
		if(client.isConnected()){
			networkFrame.setVisible(false);
			showCoordinateFrame();	
			coordinateFrame.disableComponents();
			client.sendMessage(Message.GAME_SHOW.toString());
		}
		else{
			JOptionPane.showMessageDialog(null, "Could not connect to the host.");
		}
	}
	
	/**
	 * Creates a new {@link NetworkFrame} and displays it.
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
			e.printStackTrace();
		}
		networkFrame = new NetworkFrame(this);
		networkFrame.setVisible(true);
	}

	/**
	 *  Creates a new {@link CoordinateFrame} and displays it.
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
			e.printStackTrace();
		}
		coordinateFrame = new CoordinateFrame(this);
		coordinateFrame.setVisible(true);
		Sound.playGameSound(new File("wav/gamesound0.wav"));										// Start the game sound
	}
	
	/**
	 *  Creates a new {@link GameFrame} and displays it.
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
			e.printStackTrace();
		}
		gameFrame = new GameFrame(this);
		gameFrame.setVisible(true);
	}

	/**
	 * Places a {@link Ship} with the specified {@link ShipType} either horizontally or vertically at the position {@code x} and {@code y}.
	 * @param type
	 * @param x
	 * @param y
	 * @param horizontalOrVertical
	 */
	public void placeShip(ShipType type, int x, int y, int horizontalOrVertical) {
		Field[][] fields = gameFrame.getYourField();
		Ship ship = new Ship(type);
		if(checkConstraints(fields, ship, x, y, horizontalOrVertical)){		// Checks if ship can be placed.
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

	/**
	 * Checks if the {@link Ship} can be placed at the {@link field}s with starting {@code x} and {@code y} position.
	 * @param fields of the playing field
	 * @param ship to be placed
	 * @param x coordinate
	 * @param y coordinate
	 * @param alignment horizontal or vertical
	 * @return
	 * 			{@code true} if the {@link Ship} can be placed at this position
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
	 * Removes the {@link Ship} that is placed on the {@link Field} with {@code x} and {@code y} position.
	 * @param x coordinate
	 * @param y coordinate
	 */
	public void removeShip(int x, int y) {
		Field[][] fields = gameFrame.getYourField();
		Ship ship = fields[y][x].getShip();
		List<Field> positions = ship.getPositions();
		for(int i = positions.size() - 1; i >= 0; i--){
			positions.get(i).removeShip();
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
	 * The active {@link Player} shoots at the {@link Field} with {@code x} and {@code y} position. 
	 * @param x coordinate
	 * @param y coordinate
	 */
	public void shootAt(int x, int y) {
		setYourTurn(false);
		client.sendMessage(Message.GAME_SHOOT.toString() + " " + x + " " + y);
	}
	
	/**
	 * The passive {@link Player} checks the {@link Field} with {@code x} and {@code y} position for a shoot in the water, hit a {@link Ship}, sunk a {@link Ship} and for wining the game. 
	 * @param x coordinate
	 * @param y coordinate
	 */
	public void checkShoot(int x, int y){
		Field[][] f = this.gameFrame.getYourField();
		if(f[y][x].getShip() != null){
			f[y][x].shoot();
			if(f[y][x].getShip().isSunk()){
				gameFrame.incjLabelEnemyHits();
				gameFrame.incjLabelEnemySunk();
				gameFrame.incjLabelEnemyShots();
				this.client.sendMessage(Message.GAME_SUNK.toString() + " " + x + " " + y);
				f[y][x].setBackground(Color.red);
				Sound.playingSound(Sounds.SUNK);
				if(allShipsSunk()){
					this.client.sendMessage(Message.GAME_WON.toString());
					lost();
				}
			} else{
				gameFrame.incjLabelEnemyHits();
				gameFrame.incjLabelEnemyShots();
				this.client.sendMessage(Message.GAME_HIT.toString() + " " + x + " " + y);
				f[y][x].setBackground(Color.orange);
				Sound.playingSound(Sounds.HIT);
			}
			if(gameMode.equals(GameMode.UNTILWATER)){
				this.client.sendMessage(Message.GAME_ENABLE.toString());
			}
			else{
				setYourTurn(true);
			}
		} else {
			gameFrame.incjLabelEnemyWater();
			gameFrame.incjLabelEnemyShots();
			this.client.sendMessage(Message.GAME_WATER.toString() + " " + x + " " + y);
			f[y][x].setBackground(Color.blue);
			Sound.playingSound(Sounds.WATER);
			setYourTurn(true);
		}
	}

	/**
	 * Creat a new {@link Player} with the entered {@code name}.
	 * @param name
	 */
	public void enterName(String name) {
		player = new Player(name);
	}

	/**
	 * The active {@link Player} has hit a {@link Ship} at the {@link Field} with {@code x} and {@code y} coordinate.
	 * @param x coordinate
	 * @param y coordinate
	 */
	public void hit(int x, int y) {
		Field[][]f = gameFrame.getEnemyField();
		f[y][x].setBackground(Color.orange);
		gameFrame.incjLabelYouHits();
		gameFrame.incjLabelYouShots();
		gameFrame.concatjTextPaneHistory(player.getName() + " : hits a ship at : " + (x+1) + " " + ((char)(y+65)) + "\n");
		client.sendMessage(Message.GAME_HISTORY.toString() + " " + player.getName() + " : hits a ship at : " + (x+1) + " " + ((char)(y+65)) + "\n");
		Sound.playingSound(Sounds.HIT);
		if(gameMode.equals(GameMode.ALTERNATIVELY)){
			this.client.sendMessage(Message.GAME_ACTIVEPLAYER.toString());
		}
	}

	/**
	 * The active {@link Player} has hit the water at the {@link Field} with {@code x} and {@code y} coordinate.
	 * @param x coordinate
	 * @param y coordinate
	 */
	public void water(int x, int y) {
		Field[][]f = gameFrame.getEnemyField();
		f[y][x].setBackground(Color.blue);
		gameFrame.incjLabelYouWater();
		gameFrame.incjLabelYouShots();
		gameFrame.concatjTextPaneHistory(player.getName() + " : hits the water at : " + (x+1) + " " + ((char)(y+65)) + "\n");
		client.sendMessage(Message.GAME_HISTORY.toString() + " " + player.getName() + " : hits the water at : " + (x+1) + " " + ((char)(y+65)) + "\n");
		Sound.playingSound(Sounds.WATER);
		if(gameMode.equals(GameMode.UNTILWATER)){
			this.client.sendMessage(Message.GAME_ACTIVEPLAYER.toString());
		}
		if(gameMode.equals(GameMode.ALTERNATIVELY)){
			this.client.sendMessage(Message.GAME_ACTIVEPLAYER.toString());
		}
	}

	/**
	 * The active {@link Player} has sunk a {@link Ship} at the {@link Field} with {@code x} and {@code y} coordinate.
	 * @param x coordinate
	 * @param y coordinate
	 */
	public void sunk(int x, int y) {
		Field[][]f = gameFrame.getEnemyField();
		f[y][x].setBackground(Color.red);
		gameFrame.incjLabelYouHits();
		gameFrame.incjLabelYouSunk();
		gameFrame.incjLabelYouShots();
		gameFrame.concatjTextPaneHistory(player.getName() + " : sinks a ship at : " + (x+1) + " " + ((char)(y+65)) + "\n");
		client.sendMessage(Message.GAME_HISTORY.toString() + " " + player.getName() + " : sinks a ship at : " + (x+1) + " " + ((char)(y+65)) + "\n");
		Sound.playingSound(Sounds.SUNK);
		if(gameMode.equals(GameMode.ALTERNATIVELY)){
			this.client.sendMessage(Message.GAME_ACTIVEPLAYER.toString());
		}
	}

	/**
	 * The active {@link Player} has won the game. This method creates the {@link WinnerFrame}.
	 * It also sends the solution to the other player.
	 */
//	@SuppressWarnings("deprecation")
	public void won() {
//		getBgSoundThread().stop();
		sendSolution();
		new WinnerFrame(this);
		Sound.playingSound(Sounds.WINNER);
	}
	
	/**
	 * This method checks the {@link Field}s, which are not hit be the other {@link Player} and sends these {@link Field}s to the other {@link Player}.
	 */
	private void sendSolution() {
		Field[][] yourField = this.gameFrame.getYourField();
		for(int y = 0 ; y < nbrOfColoumns ; y++){
			for(int x = 0 ; x < nbrOfRows ; x++){
				if(!yourField[y][x].isHit() && (yourField[y][x].getShip() != null)){
					this.client.sendMessage(Message.GAME_SOLUTION.toString() + " " + x + " " + y);
				}
			}
		}
	}

	/**
	 * This method displays the {@link Ship}s which are not hit by the {@link Player}.
	 * @param x coordinate of the {@link Field}
	 * @param y coordinate of the {@link Field}
	 */
	public void showSolution(int x, int y) {
		Field[][] f = this.gameFrame.getEnemyField();
		f[y][x].setBackground(Color.black);
	}
	
	/**
	 * The passive {@link Player} has lost the game. This method creates the {@link LoserFrame}.
	 */
//	@SuppressWarnings("deprecation")
	public void lost(){
//		getBgSoundThread().stop();
		new LoserFrame(this);
		Sound.playingSound(Sounds.LOSER);
	}
	
	/**
	 * This method sets the {@link Player} to the ready state. 
	 * The first {@link Player} who calls this method can later start with shooting in the game.
	 */
	public void ready() {
		Sound.stopGameSound();
		if(canStart){
			setYourTurn(true);
			this.client.sendMessage(Message.GAME_START.toString());
			this.gameFrame.concatjTextPaneHistory(player.getName() + " : is ready\n");
			this.client.sendMessage(Message.GAME_HISTORY.toString() + " " + player.getName() + " : is ready\n");
		}
		if(!canStart){
			this.gameFrame.concatjTextPaneHistory(player.getName() + " : is ready\n");
			this.client.sendMessage(Message.GAME_HISTORY.toString() + " " + player.getName() + " : is ready\n");
			this.client.sendMessage(Message.GAME_ENABLECOMPONENTS.toString());
			this.client.sendMessage(Message.GAME_SOUND.toString());
			this.getGameFrame().enableComponents();
			// Sound.playBackGroundSound();
			this.client.sendMessage(Message.GAME_ACTIVEPLAYER.toString());
		}
	}
	
	/**
	 * Returns a thread of the game sound.
	 * @return
	 * 			game sound thread
	 */
	public Thread getGameSoundThread() {
		return gameSoundThread;
	}

	
	
//	/**
//	 * Returns the background sound thread.
//	 * @return
//	 * 			background sound thread
//	 */
//	public Thread getBgSoundThread() {
//		return bgSoundThread;
//	}

	/**
	 * Sets the can start flag to false.
	 */
	public void setStartToFalse(){
		this.canStart = false;
	}

	/**
	 * Returns the status if all {@link Ship}s are placed or not.
	 * @return
	 * 			{@code true} if all {@link Ship}s are placed
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
	 * Returns the status if all {@link Ship}s are sunk or not.
	 * @return
	 * 			{@code true} if all {@link Ship}s are sunk
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
	 * 			the number of battleships left
	 */
	public int nbrOfBattleshipsLeft(){
		return this.nbrOfBattleships - this.battleships.size();
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
	 * 			the number of submarines left
	 */
	public int nbrOfSubmarinesLeft(){
		return this.nbrOfSubmarines - this.submarines.size();
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
	 * 			the number of destroyers left
	 */
	public int nbrOfDestroyersLeft(){
		return this.nbrOfDestroyers - this.destroyers.size();
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
	 * 			the number of cruisers left
	 */
	public int nbrOfCruisersLeft(){
		return this.nbrOfCruisers - this.cruisers.size();
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
		this.gameMode = gameMode;
	}

	/**
	 * @return
	 * 			the {@link Player}
	 */
	public Player getPlayer() {
		return this.player;
	}
	
	/**
	 * @return
	 * 			the {@link Server}
	 */
	public Server getServer() {
		return server;
	}
	
	/**
	 * @return
	 * 			the {@link Client}
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @return
	 * 			the {@link NetworkFrame}
	 */
	public NetworkFrame getNetworkFrame() {
		return networkFrame;
	}
	
	/**
	 * @return
	 * 			the {@link CoordinateFrame}
	 */
	public CoordinateFrame getCoordinateFrame(){
		return coordinateFrame;
	}
	
	/**
	 * @return
	 * 			the {@link GameFrame}
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
	 * Sets the status if it is your turn.
	 * @param yourTurn
	 */
	public void setYourTurn(boolean yourTurn) {
		this.yourTurn = yourTurn;
	}

	/**
	 * Restarts a {@link Game}.
	 */
	// @SuppressWarnings("deprecation")
	public void restart() {
		this.gameFrame.dispose();
		this.showCoordinateFrame();
		this.coordinateFrame.disableComponents();
		this.init();
		// this.bgSoundThread.stop();
		// Sound.stopBackgroundSound();
	}

}
