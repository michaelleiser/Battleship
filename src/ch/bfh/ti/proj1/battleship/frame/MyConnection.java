package ch.bfh.ti.proj1.battleship.frame;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author Daniel Kotlàris
 * @author Michael Leiser
 */
class MyConnection extends Thread {
	protected Socket client;
	protected DataInputStream in;
	protected PrintStream out;
	protected MyServer server;

	public MyConnection(MyServer server, Socket client) {
		this.server = server;
		this.client = client;
		try {
			in = new DataInputStream(client.getInputStream());
			out = new PrintStream(client.getOutputStream());
		} catch (IOException e) {
			try {
				client.close();
			} catch (IOException e2) {
			}
		}
		this.start();
	}

	public void run() {
		String line;
		try {
			while (true) {
				line = in.readLine();
				if (line != null)
					server.broadcast(line, client);
			}
		} catch (IOException e) {
		}
	}
	
	public Socket getClient(){
		return client;
	}
}