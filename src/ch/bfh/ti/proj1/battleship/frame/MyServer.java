package ch.bfh.ti.proj1.battleship.frame;

import java.net.*;
import java.io.*;
import java.util.*;

public class MyServer implements Runnable {
	public int PORT = 8765;
	protected ServerSocket listen;
	protected Vector<MyConnection> connections;
	Thread connect;
	
	public MyServer(int PORT) {
		this.PORT = PORT;
		try {
			listen = new ServerSocket(PORT);
		} catch (IOException e) {
		}
		connections = new Vector<MyConnection>();
		connect = new Thread(this);
		connect.start();
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