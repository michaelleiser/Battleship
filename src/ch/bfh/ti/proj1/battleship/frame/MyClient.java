package ch.bfh.ti.proj1.battleship.frame;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

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
//			jButtonSend.addActionListener(new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					String inp = jTextPaneYourMessage.getText();
//					out.println(inp);
//					jTextPaneYourMessage.setText("");
//				}
//			});
		} catch (IOException e) {
		}

		if (thread == null) {
			thread = new Thread(this);
			thread.setPriority(Thread.MIN_PRIORITY);
			thread.start();
		}
	}

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

	public void run() {
		String line;
		try {
			while (true) {
				line = in.readLine();
				if (line != null){
					game.cf.jTextPaneChat.setText(line);
				}
			}
		} catch (IOException e) {
		}
	}
	

	Socket socket;
	DataInputStream in;
	PrintStream out;
	Thread thread;

	public void sendMessage(ActionEvent evt) {
		out.println(game.cf.jTextPaneYourMessage.getText());
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	private Game game;
}
