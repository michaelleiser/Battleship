package ch.bfh.ti.proj1.battleship.frame;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author Daniel Kotlàris
 * @author Michael Leiser
 */
public class MyClient implements Runnable{

	private int port;
	private String IP;
	
	private Socket socket;
	private DataInputStream in;
	private PrintStream out;
	private Thread thread;
	
	private Game game;
	
	public MyClient(int port, String IP) {
		this.port = port;
		this.IP = IP;
		start();
	}

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
			thread.setPriority(Thread.MIN_PRIORITY);
			thread.start();
		}
	}

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

	@SuppressWarnings("deprecation")
	public void run() {
		String line;
		try {
			while (true) {
				line = in.readLine();
				if (line != null){
					if(line.startsWith(Message.COORDINATE_CHAT.toString())){
						String s = line.substring(16, line.length());
						game.getCoordinateFrame().concatjTextPaneChat(s + "\n");
					}
					if(line.startsWith(Message.GAME_CHAT.toString())){
						String s = line.substring(10, line.length());
						game.getGameFrame().concatjTextPaneChat(s + "\n");
					}
					if(line.startsWith(Message.GAME_HISTORY.toString())){
						String s = line.substring(13, line.length());
						game.getGameFrame().concatjTextPaneHistory(s + "\n");
					}
					if(line.startsWith(Message.GAME_SHOW.toString())){
						game.getNetworkFrame().dispose();
						game.showCoordinateFrame();
					}
					if(line.startsWith(Message.COORDINATE_ENABLE.toString())){
						game.getCoordinateFrame().enableComponents();
					}
					if(line.startsWith(Message.GAME_ENABLE.toString())){
						game.getGameFrame().enableComponents();
					}
					if(line.startsWith(Message.GAME_DISABLE.toString())){
						game.setYourTurn(false);
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
						game.getCoordinateFrame().setComponents(s[1], s[2], s[3], s[4], s[5], s[6], GameMode.valueOf(s[7]));
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
						game.startBackgroundSound();
						game.getGameSoundThread().stop();
					}
					if(line.startsWith(Message.GAME_RESTART.toString())){
						game.restart();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isConnected() {
		if(socket == null){
			return false;
		}
		else{
			return true;
		}
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void sendMessage(String s) {
		out.println(s);
	}
}
