package org.chat;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class StarterFrame {

	public StarterFrame() {
		JTextField tfPort = new JTextField("4444");
		JTextField tfIP = new JTextField("localhost");
		
		JRadioButton rbHost = new JRadioButton();
		JRadioButton rbJoin = new JRadioButton();
		
		Object[] message = { "port", tfPort, "IP", tfIP , "Host" , rbHost, "Join" , rbJoin};

		JOptionPane pane = new JOptionPane(message, JOptionPane.PLAIN_MESSAGE,JOptionPane.OK_CANCEL_OPTION);
		pane.createDialog(null, "Start").setVisible(true);

		if (rbHost.isSelected()) {
			int port = Integer.parseInt(tfPort.getText());
			new chatserver(port);
			new chatframe(port, "localhost");
		} else if (rbJoin.isSelected()) {
			int port = Integer.parseInt(tfPort.getText());
			String IP = tfIP.getText();
			new chatframe(port, IP);
		}
	}
}
