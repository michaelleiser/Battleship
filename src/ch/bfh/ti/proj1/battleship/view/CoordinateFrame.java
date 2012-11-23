package ch.bfh.ti.proj1.battleship.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import ch.bfh.ti.proj1.battleship.client.ShipType;
import ch.bfh.ti.proj1.battleship.frame.Game;

/**
 * @author Daniel Kotl�ris
 * @author Michael Leiser
 */
public class CoordinateFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	private JLabel jLabelStep2of2;

	private JPanel jPanelGameSettings;

	private JPanel jPanelNbrOfFields;
	private JLabel jLabelNbrOfFields;
	private JLabel jLabelNbrOfRows;
	private JTextField jTextFieldNbrOfRows;
	private JLabel jLabelNbrOfColoumns;
	private JTextField jTextFieldNbrOfColoumns;

	private JPanel jPanelNbrOfShips;
	private JLabel jLabelNbrOfShips;
	private JLabel jLabelNbrOfBattleship;
	private JTextField jTextFieldNbrOfBattleship;
	private JLabel jLabelNbrOfSubmarine;
	private JTextField jTextFieldNbrOfSubmarine;
	private JLabel jLabelNbrOfDestroyer;
	private JTextField jTextFieldNbrOfDestroyer;
	private JLabel jLabelNbrOfCruiser;
	private JTextField jTextFieldNbrOfCruiser;

	private JPanel jPanelGameMode;
	private JLabel jLabelGameMode;
	private JRadioButton jRadioButtonShootAlternatively;
	private JRadioButton jRadioButtonShootUntilWater;

	private JPanel jPanelChat;
	private JLabel jLabelChat;
	private JScrollPane jScrollPaneChat;
	private JTextPane jTextPaneChat;
	private JScrollPane jScrollPaneYourMessage;
	private JTextPane jTextPaneYourMessage;

	private JButton jButtonSend;

	private JButton jButtonValidateAndCoordinate;
	private JButton jButtonCancel;

	private Game game;
	
	public CoordinateFrame(Game game) {
		this.game = game;
		initComponents();
	}

	private void initComponents() {
		this.setTitle("Battleship - Player " + game.getPlayer().getName());
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		jLabelStep2of2 = new JLabel();
		jLabelStep2of2.setFont(new Font("Tahoma", 0, 24));
		jLabelStep2of2.setText("Step 2/2 - Coordinate game settings");
		
		jPanelGameSettings = new JPanel();
		jPanelGameSettings.setBorder(BorderFactory.createEtchedBorder());
		
		jPanelNbrOfFields = new JPanel();
		jPanelNbrOfFields.setBorder(BorderFactory.createEtchedBorder());
		jLabelNbrOfFields = new JLabel();
		jLabelNbrOfFields.setFont(new Font("Tahoma", 1, 11));
		jLabelNbrOfFields.setText("Number of fields : ");
		jLabelNbrOfRows = new JLabel();
		jLabelNbrOfRows.setText("Number of rows : ");
		jTextFieldNbrOfRows = new JTextField();
		jTextFieldNbrOfRows.setText(game.getNbrOfRows() + "");
		jLabelNbrOfColoumns = new JLabel();
		jLabelNbrOfColoumns.setText("Number of coloumns : ");
		jTextFieldNbrOfColoumns = new JTextField();
		jTextFieldNbrOfColoumns.setText(game.getNbrOfColoumns() + "");
		
		jPanelNbrOfShips = new JPanel();
		jPanelNbrOfShips.setBorder(BorderFactory.createEtchedBorder());
		jLabelNbrOfShips = new JLabel();
		jLabelNbrOfShips.setFont(new Font("Tahoma", 1, 11));
		jLabelNbrOfShips.setText("Number of ships : ");
		jLabelNbrOfBattleship = new JLabel();
		jLabelNbrOfBattleship.setText("Number of Battleship : ");
		jTextFieldNbrOfBattleship = new JTextField();
		jTextFieldNbrOfBattleship.setText(game.getNbrOfBattleships() + "");
		jLabelNbrOfSubmarine = new JLabel();
		jLabelNbrOfSubmarine.setText("Number of Submarine : ");
		jTextFieldNbrOfSubmarine = new JTextField();
		jTextFieldNbrOfSubmarine.setText(game.getNbrOfSubmarines() + "");
		jLabelNbrOfDestroyer = new JLabel();
		jLabelNbrOfDestroyer.setText("Number of Destroyer : ");
		jTextFieldNbrOfDestroyer = new JTextField();
		jTextFieldNbrOfDestroyer.setText(game.getNbrOfDestroyers() + "");
		jLabelNbrOfCruiser = new JLabel();
		jLabelNbrOfCruiser.setText("Number of Cruiser : ");
		jTextFieldNbrOfCruiser = new JTextField();
		jTextFieldNbrOfCruiser.setText(game.getNbrOfCruisers() + "");
	
		jPanelGameMode = new JPanel();
		jLabelGameMode = new JLabel();
		jLabelGameMode.setFont(new Font("Tahoma", 1, 11));
		jLabelGameMode.setText("Game mode : ");
		jRadioButtonShootAlternatively = new JRadioButton();
		jRadioButtonShootAlternatively.setSelected(true);
		jRadioButtonShootAlternatively.setText("Shoot alternatively");
		jRadioButtonShootAlternatively.setToolTipText("Tooltip");
		jRadioButtonShootAlternatively.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jRadioButtonShootAlternativelyActionPerformed();
			}
		});
		jRadioButtonShootUntilWater = new JRadioButton();
		jRadioButtonShootUntilWater.setText("Shoot until water");
		jRadioButtonShootUntilWater.setToolTipText("Tooltip");
		jRadioButtonShootUntilWater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jRadioButtonShootUntilWaterActionPerformed();
			}
		});
		
		jPanelChat = new JPanel();
		jPanelChat.setBorder(BorderFactory.createEtchedBorder());
		jLabelChat = new JLabel();
		jLabelChat.setFont(new Font("Tahoma", 1, 11));
		jLabelChat.setText("Chat");
		jScrollPaneChat = new JScrollPane();
		jTextPaneChat = new JTextPane();
		jTextPaneChat.setEditable(false);
		jScrollPaneYourMessage = new JScrollPane();
		jTextPaneYourMessage = new JTextPane();
		jTextPaneYourMessage.setText("{Your message}");
		jTextPaneYourMessage.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				jTextPaneYourMessageMouseClicked();
			}
		});
		
		jButtonSend = new JButton();
		jButtonSend.setText("Send");
		jButtonSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonSendActionPerformed();
			}
		});
		
		jButtonValidateAndCoordinate = new JButton();
		jButtonValidateAndCoordinate.setText("Validate & Coordinate");
		jButtonValidateAndCoordinate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonValidateAndCoordinateActionPerformed();
			}
		});
		jButtonCancel = new JButton();
		jButtonCancel.setText("Cancel");
		jButtonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonCancelActionPerformed();
			}
		});
		
		GroupLayout jPanelNbrOfFieldsLayout = new GroupLayout(jPanelNbrOfFields);
		jPanelNbrOfFields.setLayout(jPanelNbrOfFieldsLayout);
		jPanelNbrOfFieldsLayout
				.setHorizontalGroup(jPanelNbrOfFieldsLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanelNbrOfFieldsLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanelNbrOfFieldsLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addComponent(
																jLabelNbrOfFields)
														.addGroup(
																jPanelNbrOfFieldsLayout
																		.createParallelGroup(
																				GroupLayout.Alignment.TRAILING,
																				false)
																		.addGroup(
																				GroupLayout.Alignment.LEADING,
																				jPanelNbrOfFieldsLayout
																						.createSequentialGroup()
																						.addComponent(
																								jLabelNbrOfRows)
																						.addPreferredGap(
																								LayoutStyle.ComponentPlacement.RELATED,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jTextFieldNbrOfRows,
																								GroupLayout.PREFERRED_SIZE,
																								94,
																								GroupLayout.PREFERRED_SIZE))
																		.addGroup(
																				GroupLayout.Alignment.LEADING,
																				jPanelNbrOfFieldsLayout
																						.createSequentialGroup()
																						.addComponent(
																								jLabelNbrOfColoumns)
																						.addPreferredGap(
																								LayoutStyle.ComponentPlacement.UNRELATED)
																						.addComponent(
																								jTextFieldNbrOfColoumns,
																								GroupLayout.PREFERRED_SIZE,
																								94,
																								GroupLayout.PREFERRED_SIZE))))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		jPanelNbrOfFieldsLayout
				.setVerticalGroup(jPanelNbrOfFieldsLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanelNbrOfFieldsLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanelNbrOfFieldsLayout
														.createParallelGroup(
																GroupLayout.Alignment.TRAILING)
														.addGroup(
																jPanelNbrOfFieldsLayout
																		.createSequentialGroup()
																		.addComponent(
																				jTextFieldNbrOfRows,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jTextFieldNbrOfColoumns,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanelNbrOfFieldsLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabelNbrOfFields)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				jLabelNbrOfRows)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				jLabelNbrOfColoumns)))
										.addContainerGap(17, Short.MAX_VALUE)));
	
		GroupLayout jPanelNbrOfShipsLayout = new GroupLayout(jPanelNbrOfShips);
		jPanelNbrOfShips.setLayout(jPanelNbrOfShipsLayout);
		jPanelNbrOfShipsLayout
				.setHorizontalGroup(jPanelNbrOfShipsLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanelNbrOfShipsLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanelNbrOfShipsLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanelNbrOfShipsLayout
																		.createSequentialGroup()
																		.addGroup(
																				jPanelNbrOfShipsLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabelNbrOfBattleship)
																						.addComponent(
																								jLabelNbrOfDestroyer)
																						.addComponent(
																								jLabelNbrOfSubmarine)
																						.addComponent(
																								jLabelNbrOfCruiser))
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanelNbrOfShipsLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jTextFieldNbrOfSubmarine)
																						.addComponent(
																								jTextFieldNbrOfCruiser)
																						.addComponent(
																								jTextFieldNbrOfDestroyer)
																						.addComponent(
																								jTextFieldNbrOfBattleship,
																								GroupLayout.Alignment.TRAILING)))
														.addComponent(
																jLabelNbrOfShips))
										.addGap(26, 26, 26)));
		jPanelNbrOfShipsLayout
				.setVerticalGroup(jPanelNbrOfShipsLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanelNbrOfShipsLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabelNbrOfShips)
										.addGap(18, 18, 18)
										.addGroup(
												jPanelNbrOfShipsLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabelNbrOfBattleship)
														.addComponent(
																jTextFieldNbrOfBattleship,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanelNbrOfShipsLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabelNbrOfSubmarine)
														.addComponent(
																jTextFieldNbrOfSubmarine,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanelNbrOfShipsLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																jTextFieldNbrOfDestroyer,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jLabelNbrOfDestroyer))
										.addGap(18, 18, 18)
										.addGroup(
												jPanelNbrOfShipsLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addComponent(
																jTextFieldNbrOfCruiser,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jLabelNbrOfCruiser))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		jPanelGameMode.setBorder(BorderFactory.createEtchedBorder());

		GroupLayout jPanelGameModeLayout = new GroupLayout(jPanelGameMode);
		jPanelGameMode.setLayout(jPanelGameModeLayout);
		jPanelGameModeLayout
				.setHorizontalGroup(jPanelGameModeLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanelGameModeLayout
										.createSequentialGroup()
										.addGap(16, 16, 16)
										.addComponent(jLabelGameMode)
										.addGap(18, 18, 18)
										.addGroup(
												jPanelGameModeLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addComponent(
																jRadioButtonShootUntilWater)
														.addComponent(
																jRadioButtonShootAlternatively))
										.addGap(20, 20, 20)));
		jPanelGameModeLayout
				.setVerticalGroup(jPanelGameModeLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								GroupLayout.Alignment.TRAILING,
								jPanelGameModeLayout
										.createSequentialGroup()
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(jLabelGameMode)
										.addGap(40, 40, 40))
						.addGroup(
								jPanelGameModeLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jRadioButtonShootAlternatively)
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												jRadioButtonShootUntilWater)
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		GroupLayout jPanelGameSettingsLayout = new GroupLayout(jPanelGameSettings);
		jPanelGameSettings.setLayout(jPanelGameSettingsLayout);
		jPanelGameSettingsLayout
				.setHorizontalGroup(jPanelGameSettingsLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanelGameSettingsLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanelGameSettingsLayout
														.createParallelGroup(
																GroupLayout.Alignment.TRAILING,
																false)
														.addComponent(
																jPanelGameMode,
																GroupLayout.Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jPanelNbrOfShips,
																GroupLayout.Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jPanelNbrOfFields,
																GroupLayout.Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap(15, Short.MAX_VALUE)));
		jPanelGameSettingsLayout
				.setVerticalGroup(jPanelGameSettingsLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanelGameSettingsLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jPanelNbrOfFields,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGap(18, 18, 18)
										.addComponent(jPanelNbrOfShips,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jPanelGameMode,
												GroupLayout.PREFERRED_SIZE, 64,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));

		jScrollPaneChat.setViewportView(jTextPaneChat);

		jScrollPaneYourMessage.setViewportView(jTextPaneYourMessage);

		GroupLayout jPanelChatLayout = new GroupLayout(jPanelChat);
		jPanelChat.setLayout(jPanelChatLayout);
		jPanelChatLayout
				.setHorizontalGroup(jPanelChatLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								GroupLayout.Alignment.TRAILING,
								jPanelChatLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanelChatLayout
														.createParallelGroup(
																GroupLayout.Alignment.TRAILING)
														.addComponent(
																jScrollPaneChat,
																GroupLayout.Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																219,
																Short.MAX_VALUE)
														.addGroup(
																jPanelChatLayout
																		.createSequentialGroup()
																		.addComponent(
																				jScrollPaneYourMessage,
																				GroupLayout.DEFAULT_SIZE,
																				152,
																				Short.MAX_VALUE)
																		.addGap(10,
																				10,
																				10)
																		.addComponent(
																				jButtonSend))
														.addComponent(
																jLabelChat,
																GroupLayout.Alignment.LEADING))
										.addContainerGap()));
		jPanelChatLayout
				.setVerticalGroup(jPanelChatLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								GroupLayout.Alignment.TRAILING,
								jPanelChatLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabelChat)
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jScrollPaneChat)
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												jPanelChatLayout
														.createParallelGroup(
																GroupLayout.Alignment.TRAILING)
														.addComponent(
																jScrollPaneYourMessage,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jButtonSend))
										.addContainerGap()));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(20, 20, 20)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING)
												.addComponent(jLabelStep2of2)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.TRAILING,
																				false)
																				.addGroup(
																						GroupLayout.Alignment.LEADING,
																						layout.createSequentialGroup()
																								.addComponent(
																										jButtonValidateAndCoordinate)
																								.addGap(18,
																										18,
																										18)
																								.addComponent(
																										jButtonCancel,
																										GroupLayout.DEFAULT_SIZE,
																										GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE))
																				.addComponent(
																						jPanelGameSettings,
																						GroupLayout.Alignment.LEADING,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE))
																.addGap(18, 18,
																		18)
																.addComponent(
																		jPanelChat,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabelStep2of2)
						.addGap(18, 18, 18)
						.addGroup(
								layout.createParallelGroup(
										GroupLayout.Alignment.LEADING)
										.addComponent(jPanelChat,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(jPanelGameSettings,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
						.addGap(18, 18, 18)
						.addGroup(
								layout.createParallelGroup(
										GroupLayout.Alignment.BASELINE)
										.addComponent(
												jButtonValidateAndCoordinate)
										.addComponent(jButtonCancel))
						.addContainerGap()));

		pack();
	}

	private void jRadioButtonShootAlternativelyActionPerformed() {
		jRadioButtonShootUntilWater.setSelected(false);
		jRadioButtonShootAlternatively.setSelected(true);
		game.setGameMode("Alternatively");
	}

	private void jRadioButtonShootUntilWaterActionPerformed() {
		jRadioButtonShootAlternatively.setSelected(false);
		jRadioButtonShootUntilWater.setSelected(true);
		game.setGameMode("UntilWater");
	}

	private void jButtonCancelActionPerformed() {
		System.exit(0);
	}

	private void jButtonSendActionPerformed() {
		String name = game.getPlayer().getName();
		String text = jTextPaneYourMessage.getText();
		if(!text.equals("")){
			game.getClient().sendMessage("Coordinate " + "Chat " + name + ": " + text);
			concatjTextPaneChat(name + ": " + text + "\n");
			jTextPaneYourMessage.setText("");
		}
	}

	private void jButtonValidateAndCoordinateActionPerformed() {
		try {
			int nbrOfRows = Integer.parseInt(jTextFieldNbrOfRows.getText());
			int nbrOfColoumns = Integer.parseInt(jTextFieldNbrOfColoumns.getText());
			int nbrOfBattleships = Integer.parseInt(jTextFieldNbrOfBattleship.getText());
			int nbrOfSubmarines = Integer.parseInt(jTextFieldNbrOfSubmarine.getText());
			int nbrOfDestroyers = Integer.parseInt(jTextFieldNbrOfDestroyer.getText());
			int nbrOfCruisers = Integer.parseInt(jTextFieldNbrOfCruiser.getText());
			String gameMode = "";
			if(jRadioButtonShootAlternatively.isSelected()){
				gameMode = "Alternatively";
			}
			else if(jRadioButtonShootUntilWater.isSelected()){
				gameMode = "UntilWater";
			}
		
			
			if (validateSettings(nbrOfRows, nbrOfColoumns, nbrOfBattleships, 
					nbrOfSubmarines, nbrOfDestroyers, nbrOfCruisers)) {
				game.getClient().sendMessage("Coordinate " + "Options " + nbrOfRows + " "
						+ nbrOfColoumns + " " + nbrOfBattleships + " " + nbrOfSubmarines + " "
						+ nbrOfDestroyers + " " + nbrOfCruisers + " " + gameMode);
				game.getClient().sendMessage("Coordinate " + "Enable ");
				if (	(game.getNbrOfRows() == nbrOfRows) && 
						(game.getNbrOfColoumns() == nbrOfColoumns) &&
						(game.getNbrOfBattleships() == nbrOfBattleships) &&
						(game.getNbrOfSubmarines() == nbrOfSubmarines) &&
						(game.getNbrOfCruisers() == nbrOfCruisers) &&
						(game.getNbrOfDestroyers() == nbrOfDestroyers) &&
						(game.getGameMode().equals(gameMode))){
					game.showGameFrame();
					this.dispose();
					game.getClient().sendMessage("Coordinate " + "ShowGameFrame ");
					game.getClient().sendMessage("Coordinate " + "Dispose ");
				}
				game.setOptions(nbrOfRows, nbrOfColoumns, nbrOfBattleships, 
						nbrOfSubmarines, nbrOfDestroyers, nbrOfCruisers, gameMode);
				disableComponents();		
			} else {
				// do nothing
				return;
			}

		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Some of the entered credentials are no valid numbers");
			// do nothing
			return;
		}
	}

	private final boolean validateSettings(int nbrOfRows, int nbrOfColoumns, int nbrOfBattleships, 
			int nbrOfSubmarines, int nbrOfDestroyers, int nbrOfCruisers) {
		
		// calculate the total covered fields by the ships
		int totalFields = nbrOfRows * nbrOfColoumns;	
		int totalCoveredFieldsByShips = (ShipType.BATTLESHIP.getSize() * nbrOfBattleships)
				+ (ShipType.SUBMARINE.getSize() * nbrOfSubmarines)
				+ (ShipType.DESTROYER.getSize() * nbrOfDestroyers)
				+ (ShipType.CRUISER.getSize() * nbrOfCruisers);
		
		
		// test if the entered credentials fit the system's constraints
		if((nbrOfRows < 10) || (nbrOfRows > 20)) {
			JOptionPane.showMessageDialog(this, "Number of rows too high or too low");
			return false;
		} else if((nbrOfColoumns < 10) || (nbrOfColoumns > 20)) {
			JOptionPane.showMessageDialog(this, "Number of columns too high or too low");
			return false;
		} else if ((nbrOfBattleships < 1) || (nbrOfBattleships > 20)) {
			JOptionPane.showMessageDialog(this, "Number of battleships too high or too low");
			return false;
		} else if ((nbrOfSubmarines < 1) || (nbrOfSubmarines > 20)) {
			JOptionPane.showMessageDialog(this, "Number of submarines too high or too low");
			return false;
		} else if ((nbrOfDestroyers < 1) || (nbrOfDestroyers > 20)) {
			JOptionPane.showMessageDialog(this, "Number of destroyers too high or too low");
			return false;
		} else if ((nbrOfCruisers < 1) || (nbrOfCruisers > 20)) {
			JOptionPane.showMessageDialog(this, "Number of cruisers too high or too low");
			return false;
		// ships must cover 10%-30% of the fields
		} else if ((0.3 * totalFields) < totalCoveredFieldsByShips) {
			JOptionPane.showMessageDialog(this, "Ships cover TOO MANY fields");
			return false;
		} else if ((0.1 * totalFields) > totalCoveredFieldsByShips) {
			JOptionPane.showMessageDialog(this, "Ships do NOT cover ENOUGH fields");
			return false;
		} else {
			return true;
		}
		
		
		
		
		
		
		
		
//		// test if input is valid. Numbers between 1 and 20
//		if (	(nbrOfRows < 10) && (nbrOfRows > 20) &&
//				(nbrOfColoumns < 10) && (nbrOfColoumns > 20) &&
//				(nbrOfBattleships < 1) && (nbrOfBattleships > 20) &&
//				(nbrOfSubmarines < 1) && (nbrOfSubmarines > 20) &&
//				(nbrOfDestroyers < 1) && (nbrOfDestroyers > 20) &&
//				(nbrOfCruisers < 1) && (nbrOfCruisers > 20) 	)
//		{
//			errorString = errorString.concat("Values are not valid. Some values are too high or too low! \n");
//			//JOptionPane.showMessageDialog(this, "Values are not valid. Some values are too high or too low!");
//			//return false;
//		}
//		
//		int totalFields = nbrOfRows * nbrOfColoumns;	
//		int totalCoveredFieldsByShips = (ShipType.BATTLESHIP.getSize() * nbrOfBattleships)
//				+ (ShipType.SUBMARINE.getSize() * nbrOfSubmarines)
//				+ (ShipType.DESTROYER.getSize() * nbrOfDestroyers)
//				+ (ShipType.CRUISER.getSize() * nbrOfCruisers);
//		// ships must cover 10%-30% of the fields
//		if ((0.3 * totalFields) < totalCoveredFieldsByShips){
//			errorString = errorString.concat("Ships cover too many fields! \n");
//			//JOptionPane.showMessageDialog(this, "Ships cover too many fields!");
//			//return false;
//		}
//		if ((0.1 * totalFields) > totalCoveredFieldsByShips){
//			errorString = errorString.concat("Ships do not cover enough fields! \n");
//			//JOptionPane.showMessageDialog(this, "Ships do not cover enough fields!");
//			//return false;
//		}
//		return errorString;
	}
	
	
	private void jTextPaneYourMessageMouseClicked() {
		jTextPaneYourMessage.setText(null);
	}	

	public void disableComponents() {
		jTextFieldNbrOfBattleship.setEnabled(false);
		jTextFieldNbrOfColoumns.setEnabled(false);
		jTextFieldNbrOfCruiser.setEnabled(false);
		jTextFieldNbrOfDestroyer.setEnabled(false);
		jTextFieldNbrOfRows.setEnabled(false);
		jTextFieldNbrOfSubmarine.setEnabled(false);
		jRadioButtonShootAlternatively.setEnabled(false);
		jRadioButtonShootUntilWater.setEnabled(false);
		jButtonValidateAndCoordinate.setEnabled(false);
	}
	
	public void enableComponents() {
		jTextFieldNbrOfBattleship.setEnabled(true);
		jTextFieldNbrOfColoumns.setEnabled(true);
		jTextFieldNbrOfCruiser.setEnabled(true);
		jTextFieldNbrOfDestroyer.setEnabled(true);
		jTextFieldNbrOfRows.setEnabled(true);
		jTextFieldNbrOfSubmarine.setEnabled(true);
		jRadioButtonShootAlternatively.setEnabled(true);
		jRadioButtonShootUntilWater.setEnabled(true);
		jButtonValidateAndCoordinate.setEnabled(true);
	}
	
	public void setComponents(String nbrOfRows, String nbrOfColoumns, String nbrOfBattleships,
			String nbrOfSubmarines, String nbrOfDestroyers, String nbrOfCruisers, String gameMode){
		jTextFieldNbrOfRows.setText(nbrOfRows);
		jTextFieldNbrOfColoumns.setText(nbrOfColoumns);
		jTextFieldNbrOfBattleship.setText(nbrOfBattleships);
		jTextFieldNbrOfSubmarine.setText(nbrOfSubmarines);
		jTextFieldNbrOfDestroyer.setText(nbrOfDestroyers);
		jTextFieldNbrOfCruiser.setText(nbrOfCruisers);
		if(gameMode.equals("Alternatively")){
			jRadioButtonShootUntilWater.setSelected(false);
			jRadioButtonShootAlternatively.setSelected(true);
		}
		else if(gameMode.equals("UntilWater")){
			jRadioButtonShootAlternatively.setSelected(false);
			jRadioButtonShootUntilWater.setSelected(true);
		}
	}	

	public void concatjTextPaneChat(String text) {
		String s = jTextPaneChat.getText();
		jTextPaneChat.setText(s + text);
	}
}
