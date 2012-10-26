package org.chat;

import java.net.*;
import java.io.*;
import java.util.*;

public class chatserver implements Runnable {
	public int PORT = 8765;
	protected ServerSocket listen;
	protected Vector<connection> connections;
	Thread connect;
	
	public chatserver(int PORT) {
		this.PORT = PORT;
		try {
			listen = new ServerSocket(PORT);
		} catch (IOException e) {
		}
		connections = new Vector<connection>();
		connect = new Thread(this);
		connect.start();
	}

	public void run() {
		try {
			while (true) {
				Socket client = listen.accept();
				connection c = new connection(this, client);
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
