package org.chat;

import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class chatframe extends JFrame implements Runnable {

	public int PORT = 8765;
	public String IP = "localhost";
	Socket socket;
	DataInputStream in;
	PrintStream out;
	JTextField inputfield;
	JTextArea outputarea;
	JButton button;
	Thread thread;

	public chatframe(int PORT, String IP) {
		this.PORT = PORT;
		this.IP = IP;
		init();
		start();
	}

	public void init() {
		inputfield = new JTextField();
		outputarea = new JTextArea();
		button = new JButton("Send");
		outputarea.setFont(new Font("Dialog", Font.PLAIN, 12));
		outputarea.setEditable(false);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridBagLayout());
		
		Container ct = this.getContentPane();
		GridBagLayout gbl = new GridBagLayout();
		ct.setLayout(gbl);
		addComponent(ct , gbl , outputarea      , 0 , 0 , 0 , 1 , 0.0 , 0.0);
		addComponent(ct , gbl , inputfield      , 0 , 1 , 1 , 1 , 1.0 , 1.0);
		addComponent(ct , gbl , button          , 2 , 2 , 1 , 1 , 0.0 , 0.0);
		
		this.setBackground(Color.lightGray);
		this.setForeground(Color.black);
		inputfield.setBackground(Color.white);
		outputarea.setBackground(Color.white);
		this.setVisible(true);
	}
	
	public static void addComponent(Container ct , GridBagLayout gbl , Component c , int x , int y , int width , int height , double weightx , double weighty) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbl.setConstraints(c, gbc);
		ct.add(c);	
	}

	public void start() {
		try {
			socket = new Socket(IP, PORT);
			in = new DataInputStream(socket.getInputStream());
			out = new PrintStream(socket.getOutputStream());
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String inp = inputfield.getText();
					out.println(inp);
					inputfield.setText("");
				}
			});
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
				if (line != null)
					outputarea.append(line + '\n');
			}
		} catch (IOException e) {
		}
	}

}