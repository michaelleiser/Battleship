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
					if(line.contains("Coordinate Chat")){
						String s = line.substring(16, line.length());
						game.coordinateFrame.setjTextPaneChat(game.coordinateFrame.getjTextPaneChat().concat(s + "\n"));
					}
					if(line.contains("Game Chat")){
						String s = line.substring(10, line.length());
						game.gameFrame.setjTextPaneChat(game.gameFrame.getjTextPaneChat().concat(s + "\n"));
					}
					if(line.contains("Game Show")){
						game.networkFrame.dispose();
						game.showCoordinateFrame();
					}
					if(line.contains("Coordinate Enable")){
						game.coordinateFrame.enableComponents();
					}
					if(line.contains("Game Disable ")){
						game.gameFrame.disableComponents();
					}
					if(line.contains("Coordinate ShowGameFrame")){
						game.showGameFrame();
					}
					if(line.contains("Coordinate Dispose")){
						game.coordinateFrame.dispose();
					}
					if(line.contains("Coordinate Options")){
						String[] s = line.split(" ");
						game.setOptions(Integer.parseInt(s[2]), Integer.parseInt(s[3]),
								Integer.parseInt(s[4]), Integer.parseInt(s[5]),
								Integer.parseInt(s[6]), Integer.parseInt(s[7]), s[8]);
						game.coordinateFrame.setComponents(s[2], s[3], s[4], s[5], s[6], s[7], s[8]);
					}
					if(line.contains("Game Shoot")){
						String[] s = line.split(" ");
						game.checkShoot(Integer.parseInt(s[2]), Integer.parseInt(s[3]));
					}
					if(line.contains("Game Hit")){
						String[] s = line.split(" " );
						game.hit(s[2], s[3]);
					}
					if(line.contains("Game Water")){
						String[] s = line.split(" " );
						game.water(s[2], s[3]);
					}
					if(line.contains("Game Sunk")){
						String[] s = line.split(" " );
						game.sunk(s[2], s[3]);
					}
					if(line.contains("Game Won")){
						game.won();
					}
					if(line.contains("Game Start")){
						game.setStartToFalse();
					}
				}
			}
		} catch (IOException e) {
		}
	}
	
	public void sendMessage(String s) {
		out.println(s);
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public boolean isConnected() {
		if(socket == null){
			return false;
		}
		else{
			return true;
		}
	}
}
