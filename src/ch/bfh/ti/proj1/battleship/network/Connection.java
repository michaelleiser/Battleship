package ch.bfh.ti.proj1.battleship.network;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

/**
 * A connection between a {@link Server} and a {@link Client}.
 * 
 * @author Daniel Kotl�ris
 * @author Michael Leiser
 */
class Connection extends Thread {
	
	protected Socket client;
	protected DataInputStream in;
	protected PrintStream out;
	protected Server server;

	/**
	 * Constructor for a connection between a {@link Server} and a {@link Client}.
	 * @param server
	 * @param client
	 */
	public Connection(Server server, Socket client) {
		this.server = server;
		this.client = client;
		try {
			in = new DataInputStream(client.getInputStream());
			out = new PrintStream(client.getOutputStream());
		} catch (IOException e) {
			try {
				client.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		this.start();
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@SuppressWarnings("deprecation")
	public void run() {
		String line;
		try {
			while (true) {
				line = in.readLine();
				if (line != null)
					server.send(line, client);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the {@link Client} of the connection between a {@link Server} and a {@link Client}.
	 * @return
	 * 			client
	 */
	public Socket getClient(){
		return client;
	}
}