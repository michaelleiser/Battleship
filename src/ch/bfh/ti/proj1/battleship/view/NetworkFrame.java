package ch.bfh.ti.proj1.battleship.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import ch.bfh.ti.proj1.battleship.frame.Game;

/**
 * @author Daniel Kotlàris
 * @author Michael Leiser
 */
public class NetworkFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel jLabelStep1of2;

	private JPanel jPanelEnterYourName;
	private JLabel jLabelEnterYourName;
	private JLabel jLabelPlayerName;
	private JTextField jTextFieldPlayerName;

	private JPanel jPanelHostOrJoinGame;
	private JLabel jLabelHostOrJoinGame;

	private JPanel jPanelHostGame;
	private JLabel jLabelHostGame;
	private JRadioButton jRadioButtonHostGame;
	private JLabel jLabelFreePort;
	private JTextField jTextFieldFreePort;

	private JPanel jPanelJoinGame;
	private JLabel jLabelJoinGame;
	private JRadioButton jRadioButtonJoinGame;
	private JLabel jLabelSharedPort;
	private JTextField jTextFieldSharedPort;
	private JLabel jLabeIPAddress;
	private JTextField jTextFieldIPAddress;

	private JLabel jLabelStatus;

	private JButton jButtonConnect;
	private JButton jButtonCancel;

	private Game game;

	/**
	 * Creates new form NewJFrame
	 * 
	 * @param game
	 */
	public NetworkFrame(Game game) {
		this.game = game;
		initComponents();
	}

	/**
	 * 
	 */
	private void initComponents() {
		this.setTitle("Battleship");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setResizable(false);

		jLabelStep1of2 = new JLabel();
		jLabelStep1of2.setFont(new Font("Tahoma", 0, 24));
		jLabelStep1of2.setText("Step 1/2 - Establish network connection");

		jPanelEnterYourName = new JPanel();
		jPanelEnterYourName.setBorder(BorderFactory.createEtchedBorder());
		jLabelEnterYourName = new JLabel();
		jLabelEnterYourName.setFont(new Font("Tahoma", 1, 11));
		jLabelEnterYourName.setText("Please enter your name:");
		jLabelPlayerName = new JLabel();
		jLabelPlayerName.setText("Player's Name");
		jTextFieldPlayerName = new JTextField();
		jTextFieldPlayerName.setText(System.getProperty("user.name"));

		jPanelHostOrJoinGame = new JPanel();
		jPanelHostOrJoinGame.setBorder(BorderFactory.createEtchedBorder());
		jLabelHostOrJoinGame = new JLabel();
		jLabelHostOrJoinGame.setFont(new Font("Tahoma", 1, 11));
		jLabelHostOrJoinGame.setText("Would you like to host a game or to join a hosted game?");

		jPanelHostGame = new JPanel();
		jPanelHostGame.setBorder(BorderFactory.createEtchedBorder());
		jLabelHostGame = new JLabel();
		jLabelHostGame.setFont(new Font("Tahoma", 1, 11));
		jLabelHostGame.setText("Host a new game:");
		jRadioButtonHostGame = new JRadioButton();
		jRadioButtonHostGame.setSelected(true);
		jRadioButtonHostGame.setToolTipText("Tooltip");
		jRadioButtonHostGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jRadioButtonHostGameActionPerformed();
			}
		});
		jLabelFreePort = new JLabel();
		jLabelFreePort.setText("Free Port");
		jTextFieldFreePort = new JTextField();
		jTextFieldFreePort.setText("4444");

		jPanelJoinGame = new JPanel();
		jPanelJoinGame.setBorder(BorderFactory.createEtchedBorder());
		jLabelJoinGame = new JLabel();
		jLabelJoinGame.setFont(new Font("Tahoma", 1, 11));
		jLabelJoinGame.setText("Join a hosted game:");
		jRadioButtonJoinGame = new JRadioButton();
		jRadioButtonJoinGame.setToolTipText("Tooltip");
		jRadioButtonJoinGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jRadioButtonJoinGameActionPerformed();
			}
		});
		jLabelSharedPort = new JLabel();
		jLabelSharedPort.setText("Shared Port of Host");
		jTextFieldSharedPort = new JTextField();
		jTextFieldSharedPort.setText("4444");
		jTextFieldSharedPort.setEnabled(false);
		jLabeIPAddress = new JLabel();
		jLabeIPAddress.setText("IP-Address of Host");
		jTextFieldIPAddress = new JTextField();
		jTextFieldIPAddress.setText("localhost");
		jTextFieldIPAddress.setEnabled(false);
		jLabelStatus = new JLabel();
		jLabelStatus.setText("Select host or join game and click connect");

		jButtonConnect = new JButton();
		jButtonConnect.setText("connect");
		jButtonConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonConnectActionPerformed();
			}
		});
		jButtonCancel = new JButton();
		jButtonCancel.setText("Cancel");
		jButtonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonCancelActionPerformed();
			}
		});

		GroupLayout jPanelEnterYourNameLayout = new GroupLayout(jPanelEnterYourName);
		jPanelEnterYourName.setLayout(jPanelEnterYourNameLayout);
		jPanelEnterYourNameLayout
				.setHorizontalGroup(jPanelEnterYourNameLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanelEnterYourNameLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanelEnterYourNameLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addComponent(
																jLabelEnterYourName)
														.addGroup(
																jPanelEnterYourNameLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabelPlayerName)
																		.addGap(18,
																				18,
																				18)
																		.addComponent(
																				jTextFieldPlayerName,
																				GroupLayout.PREFERRED_SIZE,
																				150,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		jPanelEnterYourNameLayout
				.setVerticalGroup(jPanelEnterYourNameLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanelEnterYourNameLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabelEnterYourName)
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												jPanelEnterYourNameLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																jTextFieldPlayerName,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jLabelPlayerName))
										.addContainerGap()));

		GroupLayout jPanelHostGameLayout = new GroupLayout(jPanelHostGame);
		jPanelHostGame.setLayout(jPanelHostGameLayout);
		jPanelHostGameLayout
				.setHorizontalGroup(jPanelHostGameLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanelHostGameLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanelHostGameLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanelHostGameLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabelHostGame)
																		.addGap(18,
																				18,
																				18)
																		.addComponent(
																				jRadioButtonHostGame))
														.addGroup(
																jPanelHostGameLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabelFreePort)
																		.addGap(18,
																				18,
																				18)
																		.addComponent(
																				jTextFieldFreePort,
																				GroupLayout.PREFERRED_SIZE,
																				97,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));
		jPanelHostGameLayout
				.setVerticalGroup(jPanelHostGameLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanelHostGameLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanelHostGameLayout
														.createParallelGroup(
																GroupLayout.Alignment.TRAILING)
														.addComponent(
																jLabelHostGame)
														.addComponent(
																jRadioButtonHostGame))
										.addGap(25, 25, 25)
										.addGroup(
												jPanelHostGameLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabelFreePort)
														.addComponent(
																jTextFieldFreePort,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(52, Short.MAX_VALUE)));

		GroupLayout jPanelJoinGameLayout = new GroupLayout(jPanelJoinGame);
		jPanelJoinGame.setLayout(jPanelJoinGameLayout);
		jPanelJoinGameLayout
				.setHorizontalGroup(jPanelJoinGameLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanelJoinGameLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanelJoinGameLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanelJoinGameLayout
																		.createSequentialGroup()
																		.addGroup(
																				jPanelJoinGameLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabelSharedPort)
																						.addComponent(
																								jLabeIPAddress))
																		.addGap(18,
																				18,
																				18)
																		.addGroup(
																				jPanelJoinGameLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jTextFieldIPAddress,
																								GroupLayout.DEFAULT_SIZE,
																								125,
																								Short.MAX_VALUE)
																						.addComponent(
																								jTextFieldSharedPort)))
														.addGroup(
																jPanelJoinGameLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabelJoinGame)
																		.addGap(18,
																				18,
																				18)
																		.addComponent(
																				jRadioButtonJoinGame)))
										.addContainerGap()));
		jPanelJoinGameLayout
				.setVerticalGroup(jPanelJoinGameLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanelJoinGameLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanelJoinGameLayout
														.createParallelGroup(
																GroupLayout.Alignment.TRAILING)
														.addComponent(
																jLabelJoinGame)
														.addComponent(
																jRadioButtonJoinGame,
																GroupLayout.PREFERRED_SIZE,
																21,
																GroupLayout.PREFERRED_SIZE))
										.addGap(25, 25, 25)
										.addGroup(
												jPanelJoinGameLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabelSharedPort)
														.addComponent(
																jTextFieldSharedPort,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanelJoinGameLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabeIPAddress)
														.addComponent(
																jTextFieldIPAddress,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		GroupLayout jPanelHostOrJoinGameLayout = new GroupLayout(jPanelHostOrJoinGame);
		jPanelHostOrJoinGame.setLayout(jPanelHostOrJoinGameLayout);
		jPanelHostOrJoinGameLayout
				.setHorizontalGroup(jPanelHostOrJoinGameLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanelHostOrJoinGameLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanelHostOrJoinGameLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanelHostOrJoinGameLayout
																		.createSequentialGroup()
																		.addComponent(
																				jPanelHostGame,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18,
																				18,
																				18)
																		.addComponent(
																				jPanelJoinGame,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																jLabelHostOrJoinGame))
										.addContainerGap(18, Short.MAX_VALUE)));
		jPanelHostOrJoinGameLayout
				.setVerticalGroup(jPanelHostOrJoinGameLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								GroupLayout.Alignment.TRAILING,
								jPanelHostOrJoinGameLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabelHostOrJoinGame)
										.addGap(18, 18, 18)
										.addGroup(
												jPanelHostOrJoinGameLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addComponent(
																jPanelHostGame,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jPanelJoinGame,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING,
												false)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(20, 20,
																		20)
																.addComponent(
																		jLabelStep1of2))
												.addGroup(
														layout.createSequentialGroup()
																.addContainerGap()
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.LEADING,
																				false)
																				.addComponent(
																						jPanelHostOrJoinGame,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						jPanelEnterYourName,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)))
												.addGroup(
														layout.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		jButtonConnect,
																		GroupLayout.PREFERRED_SIZE,
																		232,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18,
																		18)
																.addComponent(
																		jButtonCancel,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		jLabelStatus)))
								.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabelStep1of2)
						.addGap(18, 18, 18)
						.addComponent(jPanelEnterYourName,
								GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jPanelHostOrJoinGame,
								GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jLabelStatus)
						.addGap(18, 18, 18)
						.addGroup(
								layout.createParallelGroup(
										GroupLayout.Alignment.BASELINE)
										.addComponent(jButtonConnect)
										.addComponent(jButtonCancel))
						.addContainerGap(18, Short.MAX_VALUE)));

		pack();
	}

	/**
	 * 
	 */
	private void jRadioButtonHostGameActionPerformed() {
		jRadioButtonHostGame.setSelected(true);
		jRadioButtonJoinGame.setSelected(false);

		jTextFieldFreePort.setEnabled(true);
		jTextFieldIPAddress.setEnabled(false);
		jTextFieldSharedPort.setEnabled(false);
	}

	/**
	 * 
	 */
	private void jRadioButtonJoinGameActionPerformed() {
		jRadioButtonHostGame.setSelected(false);
		jRadioButtonJoinGame.setSelected(true);

		jTextFieldFreePort.setEnabled(false);
		jTextFieldIPAddress.setEnabled(true);
		jTextFieldSharedPort.setEnabled(true);
	}

	/**
	 * 
	 */
	private void jButtonCancelActionPerformed() {
		System.exit(0);
	}

	/**
	 * 
	 */
	private void jButtonConnectActionPerformed() {
		if (jRadioButtonHostGame.isSelected()) {
			if (validatePort(jTextFieldFreePort.getText())) {
				game.enterName(jTextFieldPlayerName.getText());
				final int port = Integer.parseInt(jTextFieldFreePort.getText());
				game.hostGame(port);
				jLabelStatus
						.setText("Connecting...Please start application of second player if it is not started yet.");
				disableComponents();
			} else {
				JOptionPane.showMessageDialog(this,
						"Entered port number is not valid!");
			}
		} else if (jRadioButtonJoinGame.isSelected()) {
			if (validatePort(jTextFieldSharedPort.getText())
					&& validateIPAddress(jTextFieldIPAddress.getText())) {
				game.enterName(jTextFieldPlayerName.getText());
				final int port = Integer.parseInt(jTextFieldSharedPort
						.getText());
				final String IP = jTextFieldIPAddress.getText();
				game.joinGame(port, IP);
			} else {
				JOptionPane
						.showMessageDialog(this,
								"Entered IP address or shared port number is not valid!");
			}
		}
	}

	/**
	 * @param port
	 * @return
	 */
	private final boolean validatePort(String port) {
		if (Pattern.matches("\\d{4,5}", port)) {
			int p = Integer.parseInt(port);
			if ((1024 <= p) && (p <= 65535)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * @param ipAddress
	 * @return
	 */
	private final boolean validateIPAddress(String ipAddress) {
		if (jTextFieldIPAddress.getText().equalsIgnoreCase("localhost")) {
			return true;
		} else if (Pattern.matches("[0123456789.]*", ipAddress)) {
			String[] parts = ipAddress.split("\\.");
			if (parts.length != 4)
				return false;
			for (String s : parts) {
				int i = Integer.parseInt(s);
				if ((i < 0) || (i > 255))
					return false;
			}
			return true;
		} else
			return false;
	}

	/**
	 * 
	 */
	private void disableComponents() {
		jTextFieldPlayerName.setEnabled(false);
		jRadioButtonHostGame.setEnabled(false);
		jRadioButtonJoinGame.setEnabled(false);
		jTextFieldFreePort.setEnabled(false);
		jButtonConnect.setEnabled(false);
	}

	/**
	 * @return
	 */
	public String getPlayerName() {
		return jTextFieldPlayerName.getText();
	}
}
