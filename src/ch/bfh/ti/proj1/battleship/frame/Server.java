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
public class Server implements Runnable {
	
	private int portNbr;
	
	protected ServerSocket serverSocket;
	protected Vector<Connection> connections;
	private Thread connectionThread;
	
	/**
	 * Constructor for a server that opens a port with the {@code port} number and listens for an incoming connection.
	 * @param port
	 */
	public Server(int port) {
		this.portNbr = port;
		try {
			serverSocket = new ServerSocket(this.portNbr);
			connections = new Vector<Connection>();
			connectionThread = new Thread(this);
			connectionThread.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return
	 * 			{@code true} if server is successfully created.
	 */
	public boolean isAvailable(){
		return serverSocket != null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		try {
			while (true) {
				Socket client = serverSocket.accept();
				Connection c = new Connection(this, client);
				connections.addElement(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sends the {@code message} to the {@code client}.
	 * @param message
	 * @param client
	 */
	public void send(String message, Socket client){
		try {
			if(connections.get(0).getClient() == client){
				PrintWriter out = new PrintWriter(connections.get(1).getClient().getOutputStream(), true);
				out.println(message);
			}
			else{
				PrintWriter out = new PrintWriter(connections.get(0).getClient().getOutputStream(), true);
				out.println(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
