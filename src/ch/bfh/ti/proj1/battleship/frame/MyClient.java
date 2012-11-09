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
						game.cf.jTextPaneChat.setText(line);
					}
					if(line.contains("Game Chat")){
						game.gf.jTextPaneChat.setText(line);
					}
					if(line.contains("Coordinate Validate ")){
						String[] s = line.split(" ");
						game.cf.setComponents(s[2], s[3], s[4], s[5], s[6], s[7]);
					}
					if(line.contains("Game Show")){
						game.nf.dispose();
						game.showCoordinateFrame();
					}
				}
			}
		} catch (IOException e) {
		}
	}
	

	Socket socket;
	DataInputStream in;
	PrintStream out;
	Thread thread;

	public void sendMessage(String s) {
		out.println(s);
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	private Game game;
}
