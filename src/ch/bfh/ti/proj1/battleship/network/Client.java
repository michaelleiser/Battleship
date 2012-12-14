package ch.bfh.ti.proj1.battleship.network;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import ch.bfh.ti.proj1.battleship.game.Game;
import ch.bfh.ti.proj1.battleship.game.GameMode;

/**
 * The client is responsible to connect to the server.
 * It sends and receives messages from the other client
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
	 * Constructor for a client that connects to a server with the {@code IP} address ("localhost", "127.0.0.1", ...) and the {@code port} number (1024 - 65535).
	 * @param port
	 * @param IP
	 */
	public Client(int port, String IP) {
		this.port = port;
		this.IP = IP;
		start();
	}

	/**
	 * Creates the connection to the server and starts a new thread to listen for the incoming messages.
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
	 * Stops the connection to the server.
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
					if(line.startsWith(Message.GAME_CHAT.toString())){
						String s = line.substring(Message.GAME_CHAT.toString().length() + 1, line.length());
						game.getGameFrame().concatjTextPaneChat(s + "\n");
					}
					if(line.startsWith(Message.GAME_HISTORY.toString())){
						String s = line.substring(Message.GAME_HISTORY.toString().length() + 1, line.length());
						game.getGameFrame().concatjTextPaneHistory(s + "\n");
					}
					if(line.startsWith(Message.GAME_SHOW.toString())){
						game.getNetworkFrame().dispose();
						game.showCoordinateFrame();
					}
					if(line.startsWith(Message.COORDINATE_ENABLE.toString())){
						game.getCoordinateFrame().enableComponents();
					}
					if(line.startsWith(Message.GAME_ENABLECOMPONENTS.toString())){
						game.getGameFrame().enableComponents();
					}
					if(line.startsWith(Message.GAME_DISABLE.toString())){
						game.setYourTurn(false);
					}
					if(line.startsWith(Message.GAME_ENABLE.toString())){
						game.setYourTurn(true);
					}
					if(line.startsWith(Message.COORDINATE_SHOWGAMEFRAME.toString())){
						game.showGameFrame();
					}
					if(line.startsWith(Message.COORDINATE_DISPOSE.toString())){
						game.getCoordinateFrame().dispose();
					}
					if(line.startsWith(Message.COORDINATE_OPTIONS.toString())){
						String[] s = line.split(" ");
						game.setOptions(Integer.parseInt(s[1]), Integer.parseInt(s[2]),
								Integer.parseInt(s[3]), Integer.parseInt(s[4]),
								Integer.parseInt(s[5]), Integer.parseInt(s[6]), GameMode.valueOf(s[7]));
						game.getCoordinateFrame().setComponents(Integer.parseInt(s[1]), Integer.parseInt(s[2]),
								Integer.parseInt(s[3]), Integer.parseInt(s[4]),
								Integer.parseInt(s[5]), Integer.parseInt(s[6]), GameMode.valueOf(s[7]));
					}
					if(line.startsWith(Message.COORDINATE_SETFIRST.toString())){
						game.getCoordinateFrame().setFirst(false);
					}
					if(line.startsWith(Message.GAME_SHOOT.toString())){
						String[] s = line.split(" ");
						game.checkShoot(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
					}
					if(line.startsWith(Message.GAME_HIT.toString())){
						String[] s = line.split(" " );
						game.hit(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
					}
					if(line.startsWith(Message.GAME_WATER.toString())){
						String[] s = line.split(" " );
						game.water(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
					}
					if(line.startsWith(Message.GAME_SUNK.toString())){
						String[] s = line.split(" " );
						game.sunk(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
					}
					if(line.startsWith(Message.GAME_WON.toString())){
						game.won();
					}
					if(line.startsWith(Message.GAME_START.toString())){
						game.setStartToFalse();
					}
					if(line.startsWith(Message.GAME_SOUND.toString())){
						// Sound.playBackGroundSound();
					}
					if(line.startsWith(Message.GAME_RESTART.toString())){
						game.restart();
					}
					if(line.startsWith(Message.CLOSECONNECTION.toString())){
						JOptionPane.showMessageDialog(null, "Other player has left the game");
//						this.stop();
						System.exit(0);
					}
					if(line.startsWith(Message.TESTCONNECTION.toString())){
						this.sendMessage(Message.OPENCONNECTION.toString());
					}
					if(line.startsWith(Message.OPENCONNECTION.toString())){
						this.connected = true;
					}
					if(line.startsWith(Message.GAME_ACTIVEPLAYER.toString())){
						game.getGameFrame().showActivePlayer();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return
	 * 			{@code true} if the client is connected to the server.
	 */
	public boolean isConnected() {
		if(socket != null){
			game.getClient().sendMessage(Message.TESTCONNECTION.toString());	// Sends a test connection message to the server. The other client will then reply with a open connection message.
			int i = 0;
			while(!connected && (i < 20)){			// Waits for 5 seconds for an open connection message from the other client.
				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				i++;
			}
			return connected;
		}
		else{
			return false;
		}
	}

	/**
	 * Sets the {@code game} to the client.
	 * @param game
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * Sends a {@code message} to the server.
	 * @param message
	 */
	public void sendMessage(String message) {
		out.println(message);
	}
}
