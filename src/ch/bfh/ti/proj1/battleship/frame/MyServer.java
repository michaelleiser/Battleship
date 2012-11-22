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
	
	protected ServerSocket serverSocket;
	protected Vector<MyConnection> connections;
	private Thread connectionThread;
	
	public MyServer(int port) {
		this.portNbr = port;
		try {
			serverSocket = new ServerSocket(this.portNbr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		connections = new Vector<MyConnection>();
		connectionThread = new Thread(this);
		connectionThread.start();
	}

	public void run() {
		try {
			while (true) {
				Socket client = serverSocket.accept();
				MyConnection c = new MyConnection(this, client);
				connections.addElement(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void broadcast(String msg, Socket client){
		try {
			if(connections.get(0).getClient() == client){
				PrintWriter out = new PrintWriter(connections.get(1).getClient().getOutputStream(), true);
				out.println(msg);
			}
			else{
				PrintWriter out = new PrintWriter(connections.get(0).getClient().getOutputStream(), true);
				out.println(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
