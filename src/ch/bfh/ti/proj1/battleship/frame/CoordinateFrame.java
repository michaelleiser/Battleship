package ch.bfh.ti.proj1.battleship.frame;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

/**
 * 
 * @author L1r
 */
public class CoordinateFrame extends JFrame {

	// Variables declaration - do not modify
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
	// End of variables declaration

	/** Creates new form NewJFrame */
	public CoordinateFrame() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		
		jLabelStep2of2 = new JLabel();
		jLabelStep2of2.setFont(new Font("Tahoma", 0, 24)); // NOI18N
		jLabelStep2of2.setText("Step 2/2 - Coordinate game settings");
		
		jPanelGameSettings = new JPanel();
		jPanelGameSettings.setBorder(BorderFactory.createEtchedBorder());
		
		jPanelNbrOfFields = new JPanel();
		jPanelNbrOfFields.setBorder(BorderFactory.createEtchedBorder());
		jLabelNbrOfFields = new JLabel();
		jLabelNbrOfFields.setFont(new Font("Tahoma", 1, 11)); // NOI18N
		jLabelNbrOfFields.setText("Number of fields : ");
		jLabelNbrOfRows = new JLabel();
		jLabelNbrOfRows.setText("Number of rows : ");
		jTextFieldNbrOfRows = new JTextField();
		jTextFieldNbrOfRows.setText("10");
		jLabelNbrOfColoumns = new JLabel();
		jLabelNbrOfColoumns.setText("Number of coloumns : ");
		jTextFieldNbrOfColoumns = new JTextField();
		jTextFieldNbrOfColoumns.setText("10");
		
		jPanelNbrOfShips = new JPanel();
		jPanelNbrOfShips.setBorder(BorderFactory.createEtchedBorder());
		jLabelNbrOfShips = new JLabel();
		jLabelNbrOfShips.setFont(new Font("Tahoma", 1, 11)); // NOI18N
		jLabelNbrOfShips.setText("Number of ships : ");
		jLabelNbrOfBattleship = new JLabel();
		jLabelNbrOfBattleship.setText("Number of Battleship : ");
		jTextFieldNbrOfBattleship = new JTextField();
		jTextFieldNbrOfBattleship.setText("1");
		jTextFieldNbrOfBattleship.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jTextFieldNbrOfBattleshipActionPerformed(evt);
			}
		});
		jLabelNbrOfSubmarine = new JLabel();
		jLabelNbrOfSubmarine.setText("Number of Submarine : ");
		jTextFieldNbrOfSubmarine = new JTextField();
		jTextFieldNbrOfSubmarine.setText("2");
		jLabelNbrOfDestroyer = new JLabel();
		jLabelNbrOfDestroyer.setText("Number of Destroyer : ");
		jTextFieldNbrOfDestroyer = new JTextField();
		jTextFieldNbrOfDestroyer.setText("3");
		jLabelNbrOfCruiser = new JLabel();
		jLabelNbrOfCruiser.setText("Number of Cruiser : ");
		jTextFieldNbrOfCruiser = new JTextField();
		jTextFieldNbrOfCruiser.setText("4");
	
		jPanelGameMode = new JPanel();
		jLabelGameMode = new JLabel();
		jLabelGameMode.setFont(new Font("Tahoma", 1, 11)); // NOI18N
		jLabelGameMode.setText("Game mode : ");
		jRadioButtonShootAlternatively = new JRadioButton();
		jRadioButtonShootAlternatively.setSelected(true);
		jRadioButtonShootAlternatively.setText("Shoot alternatively");
		jRadioButtonShootAlternatively.setToolTipText("Tooltip");
		jRadioButtonShootAlternatively.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jRadioButtonShootAlternativelyActionPerformed(evt);
			}
		});
		jRadioButtonShootUntilWater = new JRadioButton();
		jRadioButtonShootUntilWater.setText("Shoot until water");
		jRadioButtonShootUntilWater.setToolTipText("Tooltip");
		jRadioButtonShootUntilWater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jRadioButtonShootUntilWaterActionPerformed(evt);
			}
		});
		
		jPanelChat = new JPanel();
		jPanelChat.setBorder(BorderFactory.createEtchedBorder());
		jLabelChat = new JLabel();
		jLabelChat.setFont(new Font("Tahoma", 1, 11)); // NOI18N
		jLabelChat.setText("Chat");
		jScrollPaneChat = new JScrollPane();
		jTextPaneChat = new JTextPane();
		jTextPaneChat.setEditable(false);
		jScrollPaneYourMessage = new JScrollPane();
		jTextPaneYourMessage = new JTextPane();
		jTextPaneYourMessage.setText("{Your message}");
		jTextPaneYourMessage.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				jTextPaneYourMessageMouseClicked(evt);
			}
		});
		jButtonSend = new JButton();
		jButtonSend.setText("Send");
		jButtonSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonSendActionPerformed(evt);
			}
		});
		
		jButtonValidateAndCoordinate = new JButton();
		jButtonValidateAndCoordinate.setText("Validate & Coordinate");
		jButtonValidateAndCoordinate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonValidateAndCoordinateActionPerformed(evt);
			}
		});
		jButtonCancel = new JButton();
		jButtonCancel.setText("Cancel");
		jButtonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonCancelActionPerformed(evt);
			}
		});
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Battle ship");
		setName("FrameCoordinateGameSettings"); // NOI18N

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
	}// </editor-fold>

	private void jTextFieldNbrOfBattleshipActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jRadioButtonShootAlternativelyActionPerformed(ActionEvent evt) {
		jRadioButtonShootUntilWater.setSelected(false);
		jRadioButtonShootAlternatively.setSelected(true);
	}

	private void jRadioButtonShootUntilWaterActionPerformed(ActionEvent evt) {
		jRadioButtonShootAlternatively.setSelected(false);
		jRadioButtonShootUntilWater.setSelected(true);
	}

	private void jButtonCancelActionPerformed(ActionEvent evt) {
		System.exit(0);
	}

	private void jButtonSendActionPerformed(ActionEvent evt) {
		String s = jTextPaneChat.getText();
		s = s.concat(jTextPaneYourMessage.getText() + "\n");
		jTextPaneChat.setText(s);
	}

	private void jButtonValidateAndCoordinateActionPerformed(ActionEvent evt) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (UIManager.LookAndFeelInfo info : UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		EventQueue.invokeLater(new Runnable() {

			int nbrOfRows = Integer.parseInt(jTextFieldNbrOfRows.getText());
			int nbrOfColoumns = Integer.parseInt(jTextFieldNbrOfColoumns
					.getText());
			int nbrOfBattleships = Integer.parseInt(jTextFieldNbrOfBattleship
					.getText());
			int nbrOfSubmarines = Integer.parseInt(jTextFieldNbrOfSubmarine
					.getText());
			int nbrOfDestroyers = Integer.parseInt(jTextFieldNbrOfDestroyer
					.getText());
			int nbrOfCruisers = Integer.parseInt(jTextFieldNbrOfCruiser
					.getText());

			public void run() {
				new GameFrame(nbrOfRows, nbrOfColoumns, nbrOfBattleships,
						nbrOfSubmarines, nbrOfDestroyers, nbrOfCruisers)
						.setVisible(true);
			}
		});
		this.dispose();
	}

	private void jTextPaneYourMessageMouseClicked(MouseEvent evt) {
		jTextPaneYourMessage.setText(null);
	}

}
