package ch.bfh.ti.proj1.battleship.frame;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

/**
 * @author Daniel Kotlàris
 * @author Michael Leiser
 */
public class MyServer implements Runnable {
	
	private int portNbr;
	
	protected ServerSocket listen;
	protected Vector<MyConnection> connections;
	private Thread connectionThread;
	
	public MyServer(int port) {
		this.portNbr = port;
		try {
			listen = new ServerSocket(this.portNbr);
		} catch (IOException e) {
		}
		connections = new Vector<MyConnection>();
		connectionThread = new Thread(this);
		connectionThread.start();
	}

	public void run() {
		try {
			while (true) {
				Socket client = listen.accept();
				MyConnection c = new MyConnection(this, client);
				connections.addElement(c);
			}
		} catch (IOException e) {
		}
	}

	public void broadcast(String msg, Socket client) throws IOException {
		if(connections.get(0).getClient() == client){
			PrintWriter out = new PrintWriter(connections.get(1).getClient().getOutputStream(), true);
			out.println(msg);
		}
		else{
			PrintWriter out = new PrintWriter(connections.get(0).getClient().getOutputStream(), true);
			out.println(msg);
		}
	}
}
