package ch.bfh.ti.proj1.battleship.network;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import javax.swing.JOptionPane;
import ch.bfh.ti.proj1.battleship.game.Game;
import ch.bfh.ti.proj1.battleship.game.GameMode;

/**
 * The client is responsible to connect to the {@link Server}.
 * It sends and receives {@link Message}s from the other client
 * and acts as the controller for the corresponding actions.
 * 
 * @author Michael Leiser
 * @author Daniel Kotlàris
 */
public class Client implements Runnable{

	private int port;
	private String IP;
	
	private Socket socket;
	private DataInputStream in;
	private PrintStream out;
	private Thread thread;
	
	private Game game;
	
	private boolean connected = false;
	
	/**
	 * Constructor for a client that connects to a {@link Server} with the {@code IP} address ("localhost", "127.0.0.1", ...) and the {@code port} number (1024 - 65535).
	 * @param port
	 * @param IP
	 */
	public Client(int port, String IP) {
		this.port = port;
		this.IP = IP;
		start();
	}

	/**
	 * Creates the {@link Connection} to the {@link Server} and starts a new thread to listen for the incoming messages.
	 */
	public void start() {
		try {
			socket = new Socket(IP, port);
			in = new DataInputStream(socket.getInputStream());
			out = new PrintStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	/**
	 * Stops the {@link Connection} to the {@link Server}.
	 */
	@SuppressWarnings("deprecation")
	public void stop() {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if ((thread != null) && thread.isAlive()) {
			thread.stop();
			thread = null;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@SuppressWarnings("deprecation")
	public void run() {
		String line;
		try {
			while (true) {
				line = in.readLine();
				if (line != null){
					if(line.startsWith(Message.COORDINATE_CHAT.toString())){
						String s = line.substring(Message.COORDINATE_CHAT.toString().length() + 1, line.length());
						game.getCoordinateFrame().concatjTextPaneChat(s + "\n");
					}
					else if(line.startsWith(Message.GAME_CHAT.toString())){
						String s = line.substring(Message.GAME_CHAT.toString().length() + 1, line.length());
						game.getGameFrame().concatjTextPaneChat(s + "\n");
					}
					else if(line.startsWith(Message.GAME_HISTORY.toString())){
						String s = line.substring(Message.GAME_HISTORY.toString().length() + 1, line.length());
						game.getGameFrame().concatjTextPaneHistory(s + "\n");
					}
					else if(line.startsWith(Message.GAME_SHOW.toString())){
						game.getNetworkFrame().dispose();
						game.showCoordinateFrame();
					}
					else if(line.startsWith(Message.COORDINATE_ENABLE.toString())){
						game.getCoordinateFrame().enableComponents();
					}
					else if(line.startsWith(Message.GAME_ENABLECOMPONENTS.toString())){
						game.getGameFrame().enableComponents();
					}
					else if(line.startsWith(Message.GAME_DISABLE.toString())){
						game.setYourTurn(false);
					}
					else if(line.startsWith(Message.GAME_ENABLE.toString())){
						game.setYourTurn(true);
					}
					else if(line.startsWith(Message.COORDINATE_SHOWGAMEFRAME.toString())){
						game.showGameFrame();
					}
					else if(line.startsWith(Message.COORDINATE_DISPOSE.toString())){
						game.getCoordinateFrame().dispose();
					}
					else if(line.startsWith(Message.COORDINATE_OPTIONS.toString())){
						String[] s = line.split(" ");
						game.setOptions(Integer.parseInt(s[1]), Integer.parseInt(s[2]),
								Integer.parseInt(s[3]), Integer.parseInt(s[4]),
								Integer.parseInt(s[5]), Integer.parseInt(s[6]), GameMode.valueOf(s[7]));
						game.getCoordinateFrame().setComponents(Integer.parseInt(s[1]), Integer.parseInt(s[2]),
								Integer.parseInt(s[3]), Integer.parseInt(s[4]),
								Integer.parseInt(s[5]), Integer.parseInt(s[6]), GameMode.valueOf(s[7]));
					}
					else if(line.startsWith(Message.COORDINATE_SETFIRST.toString())){
						game.getCoordinateFrame().setFirst(false);
					}
					else if(line.startsWith(Message.GAME_SHOOT.toString())){
						String[] s = line.split(" ");
						game.checkShoot(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
					}
					else if(line.startsWith(Message.GAME_HIT.toString())){
						String[] s = line.split(" " );
						game.hit(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
					}
					else if(line.startsWith(Message.GAME_WATER.toString())){
						String[] s = line.split(" ");
						game.water(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
					}
					else if(line.startsWith(Message.GAME_SUNK.toString())){
						String[] s = line.split(" ");
						game.sunk(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
					}
					else if(line.startsWith(Message.GAME_WON.toString())){
						game.won();
					}
					else if(line.startsWith(Message.GAME_START.toString())){
						game.setStartToFalse();
					}
					else if(line.startsWith(Message.GAME_SOUND.toString())){
						// Sound.playBackGroundSound();
					}
					else if(line.startsWith(Message.GAME_RESTART.toString())){
						game.restart();
					}
					else if(line.startsWith(Message.CLOSECONNECTION.toString())){
						JOptionPane.showMessageDialog(null, "Other player has left the game");
						System.exit(0);
					}
					else if(line.startsWith(Message.TESTCONNECTION.toString())){
						this.sendMessage(Message.OPENCONNECTION.toString());
					}
					else if(line.startsWith(Message.OPENCONNECTION.toString())){
						this.connected = true;
					}
					else if(line.startsWith(Message.GAME_ACTIVEPLAYER.toString())){
						game.getGameFrame().showActivePlayer();
					}
					else if(line.startsWith(Message.GAME_SOLUTION.toString())){
						String[] s = line.split(" ");
						game.showSolution(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return
	 * 			{@code true} if the client is connected to the {@link Server}.
	 */
	public boolean isConnected() {
		if(socket != null){
			testConnection();
			return connected;
		}
		else{
			return false;
		}
	}

	/**
	 * Tests the {@link Connection} between the {@link Client} and the {@link Server}.
	 */
	private void testConnection() {
		sendMessage(Message.TESTCONNECTION.toString());	// Sends a test connection message to the server. The other client will then reply with a open connection message.
		int i = 0;
		while(!connected && (i < 20)){			// Waits for 5 seconds for an open connection message from the other client.
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
	}

	/**
	 * Sets the {@link Game} to the {@link Client}.
	 * @param game
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * Sends a {@link Message} to the {@link Server}.
	 * @param message
	 */
	public void sendMessage(String message) {
		out.println(message);
	}
}
