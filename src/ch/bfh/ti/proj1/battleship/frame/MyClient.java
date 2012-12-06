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
					if(line.startsWith("Coordinate Chat")){
						String s = line.substring(16, line.length());
						game.getCoordinateFrame().concatjTextPaneChat(s + "\n");
					}
					if(line.startsWith("Game Chat")){
						String s = line.substring(10, line.length());
						game.getGameFrame().concatjTextPaneChat(s + "\n");
					}
					if(line.startsWith("Game History")){
						String s = line.substring(13, line.length());
						game.getGameFrame().concatjTextPaneHistory(s + "\n");
					}
					if(line.startsWith("Game Show")){
						game.getNetworkFrame().dispose();
						game.showCoordinateFrame();
					}
					if(line.startsWith("Coordinate Enable")){
						game.getCoordinateFrame().enableComponents();
					}
					if(line.startsWith("Game Enable")){
						game.getGameFrame().enableComponents();
					}
					if(line.startsWith("Game Disable ")){
						game.setYourTurn(false);
					}
					if(line.startsWith("Coordinate ShowGameFrame")){
						game.showGameFrame();
					}
					if(line.startsWith("Coordinate Dispose")){
						game.getCoordinateFrame().dispose();
					}
					if(line.startsWith("Coordinate Options")){
						String[] s = line.split(" ");
						game.setOptions(Integer.parseInt(s[2]), Integer.parseInt(s[3]),
								Integer.parseInt(s[4]), Integer.parseInt(s[5]),
								Integer.parseInt(s[6]), Integer.parseInt(s[7]), s[8]);
						game.getCoordinateFrame().setComponents(s[2], s[3], s[4], s[5], s[6], s[7], s[8]);
					}
					if(line.startsWith("Coordinate SetFirst")){
						game.getCoordinateFrame().setFirst(false);
					}
					if(line.startsWith("Game Shoot")){
						String[] s = line.split(" ");
						game.checkShoot(Integer.parseInt(s[2]), Integer.parseInt(s[3]));
					}
					if(line.startsWith("Game Hit")){
						String[] s = line.split(" " );
						game.hit(Integer.parseInt(s[2]), Integer.parseInt(s[3]));
					}
					if(line.startsWith("Game Water")){
						String[] s = line.split(" " );
						game.water(Integer.parseInt(s[2]), Integer.parseInt(s[3]));
					}
					if(line.startsWith("Game Sunk")){
						String[] s = line.split(" " );
						game.sunk(Integer.parseInt(s[2]), Integer.parseInt(s[3]));
					}
					if(line.startsWith("Game Won")){
						game.won();
					}
					if(line.startsWith("Game Start")){
						game.setStartToFalse();
					}
					if(line.startsWith("Game Sound ")){
						game.startBackgroundSound();
						game.getGameSoundThread().stop();
					}
					if(line.startsWith("GameFrame Restart")){
						game.getGameFrame().dispose();
						game.showCoordinateFrame();
						game.getCoordinateFrame().disableComponents();
						game.init();
						game.getBgSoundThread().stop();
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
