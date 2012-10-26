package ch.bfh.ti.proj1.battleship.frame;

/**
 * 
 * @author L1r
 */
public class CoordinateFrame extends javax.swing.JFrame {

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

		jButtonCancel = new javax.swing.JButton();
		jButtonValidateAndCoordinate = new javax.swing.JButton();
		jLabelStep2of2 = new javax.swing.JLabel();
		jPanelGameSettings = new javax.swing.JPanel();
		jPanelNbrOfFields = new javax.swing.JPanel();
		jTextFieldNbrOfFields = new javax.swing.JTextField();
		jLabelNbrOfFields = new javax.swing.JLabel();
		jPanelNbrOfShips = new javax.swing.JPanel();
		jLabelNbrOfDestroyer = new javax.swing.JLabel();
		jLabelNbrOfBattleship = new javax.swing.JLabel();
		jLabelNbrOfSubmarine = new javax.swing.JLabel();
		jLabelNbrOfShips = new javax.swing.JLabel();
		jTextFieldNbrOfSubmarine = new javax.swing.JTextField();
		jTextFieldNbrOfBattleship = new javax.swing.JTextField();
		jLabelNbrOfCruiser = new javax.swing.JLabel();
		jTextFieldNbrOfCruiser = new javax.swing.JTextField();
		jTextFieldNbrOfDestroyer = new javax.swing.JTextField();
		jPanelGameMode = new javax.swing.JPanel();
		jRadioButtonShootUntilWater = new javax.swing.JRadioButton();
		jRadioButtonShootAlternatively = new javax.swing.JRadioButton();
		jLabelGameMode = new javax.swing.JLabel();
		jPanelChat = new javax.swing.JPanel();
		jScrollPaneChat = new javax.swing.JScrollPane();
		jTextPaneChat = new javax.swing.JTextPane();
		jScrollPaneYourMessage = new javax.swing.JScrollPane();
		jTextPaneYourMessage = new javax.swing.JTextPane();
		jLabelChat = new javax.swing.JLabel();
		jButtonSend = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Battle ship");
		setName("FrameCoordinateGameSettings"); // NOI18N

		jButtonCancel.setText("Cancel");
		jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonCancelActionPerformed(evt);
			}
		});

		jButtonValidateAndCoordinate.setText("Validate & Coordinate");
		jButtonValidateAndCoordinate
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						jButtonValidateAndCoordinateActionPerformed(evt);
					}
				});

		jLabelStep2of2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		jLabelStep2of2.setText("Step 2/2 - Coordinate game settings");

		jPanelGameSettings.setBorder(javax.swing.BorderFactory
				.createEtchedBorder());

		jPanelNbrOfFields.setBorder(javax.swing.BorderFactory
				.createEtchedBorder());

		jTextFieldNbrOfFields.setText("100");
		jTextFieldNbrOfFields
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						jTextFieldNbrOfFieldsActionPerformed(evt);
					}
				});

		jLabelNbrOfFields.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabelNbrOfFields.setText("Number of fields : ");

		javax.swing.GroupLayout jPanelNbrOfFieldsLayout = new javax.swing.GroupLayout(
				jPanelNbrOfFields);
		jPanelNbrOfFields.setLayout(jPanelNbrOfFieldsLayout);
		jPanelNbrOfFieldsLayout.setHorizontalGroup(jPanelNbrOfFieldsLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						jPanelNbrOfFieldsLayout
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(jLabelNbrOfFields)
								.addGap(18, 18, 18)
								.addComponent(jTextFieldNbrOfFields,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										94,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(26, Short.MAX_VALUE)));
		jPanelNbrOfFieldsLayout
				.setVerticalGroup(jPanelNbrOfFieldsLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanelNbrOfFieldsLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanelNbrOfFieldsLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabelNbrOfFields)
														.addComponent(
																jTextFieldNbrOfFields,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		jPanelNbrOfShips.setBorder(javax.swing.BorderFactory
				.createEtchedBorder());

		jLabelNbrOfDestroyer.setText("Number of Destroyer : ");

		jLabelNbrOfBattleship.setText("Number of Battleship : ");

		jLabelNbrOfSubmarine.setText("Number of Submarine : ");

		jLabelNbrOfShips.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabelNbrOfShips.setText("Number of ships : ");

		jTextFieldNbrOfSubmarine.setText("2");

		jTextFieldNbrOfBattleship.setText("1");
		jTextFieldNbrOfBattleship
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						jTextFieldNbrOfBattleshipActionPerformed(evt);
					}
				});

		jLabelNbrOfCruiser.setText("Number of Cruiser : ");

		jTextFieldNbrOfCruiser.setText("4");

		jTextFieldNbrOfDestroyer.setText("3");

		javax.swing.GroupLayout jPanelNbrOfShipsLayout = new javax.swing.GroupLayout(
				jPanelNbrOfShips);
		jPanelNbrOfShips.setLayout(jPanelNbrOfShipsLayout);
		jPanelNbrOfShipsLayout
				.setHorizontalGroup(jPanelNbrOfShipsLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanelNbrOfShipsLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanelNbrOfShipsLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanelNbrOfShipsLayout
																		.createSequentialGroup()
																		.addGroup(
																				jPanelNbrOfShipsLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabelNbrOfBattleship)
																						.addComponent(
																								jLabelNbrOfDestroyer)
																						.addComponent(
																								jLabelNbrOfSubmarine)
																						.addComponent(
																								jLabelNbrOfCruiser))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanelNbrOfShipsLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jTextFieldNbrOfSubmarine,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								95,
																								Short.MAX_VALUE)
																						.addComponent(
																								jTextFieldNbrOfCruiser,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								95,
																								Short.MAX_VALUE)
																						.addComponent(
																								jTextFieldNbrOfDestroyer,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								95,
																								Short.MAX_VALUE)
																						.addComponent(
																								jTextFieldNbrOfBattleship,
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								95,
																								Short.MAX_VALUE)))
														.addComponent(
																jLabelNbrOfShips))
										.addGap(26, 26, 26)));
		jPanelNbrOfShipsLayout
				.setVerticalGroup(jPanelNbrOfShipsLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanelNbrOfShipsLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabelNbrOfShips)
										.addGap(18, 18, 18)
										.addGroup(
												jPanelNbrOfShipsLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabelNbrOfBattleship)
														.addComponent(
																jTextFieldNbrOfBattleship,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanelNbrOfShipsLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabelNbrOfSubmarine)
														.addComponent(
																jTextFieldNbrOfSubmarine,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanelNbrOfShipsLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jTextFieldNbrOfDestroyer,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jLabelNbrOfDestroyer))
										.addGap(18, 18, 18)
										.addGroup(
												jPanelNbrOfShipsLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jTextFieldNbrOfCruiser,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jLabelNbrOfCruiser))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		jPanelGameMode
				.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		jRadioButtonShootUntilWater.setText("Shoot until water");
		jRadioButtonShootUntilWater.setToolTipText("Tooltip");
		jRadioButtonShootUntilWater
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						jRadioButtonShootUntilWaterActionPerformed(evt);
					}
				});

		jRadioButtonShootAlternatively.setSelected(true);
		jRadioButtonShootAlternatively.setText("Shoot alternatively");
		jRadioButtonShootAlternatively.setToolTipText("Tooltip");
		jRadioButtonShootAlternatively
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						jRadioButtonShootAlternativelyActionPerformed(evt);
					}
				});

		jLabelGameMode.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabelGameMode.setText("Game mode : ");

		javax.swing.GroupLayout jPanelGameModeLayout = new javax.swing.GroupLayout(
				jPanelGameMode);
		jPanelGameMode.setLayout(jPanelGameModeLayout);
		jPanelGameModeLayout
				.setHorizontalGroup(jPanelGameModeLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanelGameModeLayout
										.createSequentialGroup()
										.addGap(16, 16, 16)
										.addComponent(jLabelGameMode)
										.addGap(18, 18, 18)
										.addGroup(
												jPanelGameModeLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jRadioButtonShootUntilWater)
														.addComponent(
																jRadioButtonShootAlternatively))
										.addGap(20, 20, 20)));
		jPanelGameModeLayout
				.setVerticalGroup(jPanelGameModeLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanelGameModeLayout
										.createSequentialGroup()
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
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
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												jRadioButtonShootUntilWater)
										.addContainerGap(9, Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanelGameSettingsLayout = new javax.swing.GroupLayout(
				jPanelGameSettings);
		jPanelGameSettings.setLayout(jPanelGameSettingsLayout);
		jPanelGameSettingsLayout
				.setHorizontalGroup(jPanelGameSettingsLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanelGameSettingsLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanelGameSettingsLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addComponent(
																jPanelGameMode,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jPanelNbrOfShips,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jPanelNbrOfFields,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap(15, Short.MAX_VALUE)));
		jPanelGameSettingsLayout
				.setVerticalGroup(jPanelGameSettingsLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanelGameSettingsLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jPanelNbrOfFields,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												jPanelNbrOfShips,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												jPanelGameMode,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												64,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		jPanelChat.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		jTextPaneChat.setEditable(false);
		jScrollPaneChat.setViewportView(jTextPaneChat);

		jTextPaneYourMessage.setText("{Your message}");
		jTextPaneYourMessage
				.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent evt) {
						jTextPaneYourMessageMouseClicked(evt);
					}
				});
		jScrollPaneYourMessage.setViewportView(jTextPaneYourMessage);

		jLabelChat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabelChat.setText("Chat");

		jButtonSend.setText("Send");
		jButtonSend.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonSendActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanelChatLayout = new javax.swing.GroupLayout(
				jPanelChat);
		jPanelChat.setLayout(jPanelChatLayout);
		jPanelChatLayout
				.setHorizontalGroup(jPanelChatLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanelChatLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanelChatLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jScrollPaneChat,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																219,
																Short.MAX_VALUE)
														.addGroup(
																jPanelChatLayout
																		.createSequentialGroup()
																		.addComponent(
																				jScrollPaneYourMessage,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				152,
																				Short.MAX_VALUE)
																		.addGap(10,
																				10,
																				10)
																		.addComponent(
																				jButtonSend))
														.addComponent(
																jLabelChat,
																javax.swing.GroupLayout.Alignment.LEADING))
										.addContainerGap()));
		jPanelChatLayout
				.setVerticalGroup(jPanelChatLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanelChatLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabelChat)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jScrollPaneChat,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												270, Short.MAX_VALUE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												jPanelChatLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jScrollPaneYourMessage,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jButtonSend))
										.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(20, 20, 20)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabelStep2of2)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				false)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jButtonValidateAndCoordinate,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																								.addComponent(
																										jButtonCancel,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										90,
																										javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addComponent(
																						jPanelGameSettings,
																						javax.swing.GroupLayout.Alignment.LEADING,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		jPanelChat,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jLabelStep2of2)
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														jPanelGameSettings,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														jPanelChat,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 19, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														jButtonValidateAndCoordinate)
												.addComponent(jButtonCancel))
								.addContainerGap()));

		pack();
	}// </editor-fold>

	private void jTextFieldNbrOfFieldsActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jTextFieldNbrOfBattleshipActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jRadioButtonShootAlternativelyActionPerformed(
			java.awt.event.ActionEvent evt) {
		jRadioButtonShootUntilWater.setSelected(false);
		jRadioButtonShootAlternatively.setSelected(true);
	}

	private void jRadioButtonShootUntilWaterActionPerformed(
			java.awt.event.ActionEvent evt) {
		jRadioButtonShootAlternatively.setSelected(false);
		jRadioButtonShootUntilWater.setSelected(true);
	}

	private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}

	private void jButtonSendActionPerformed(java.awt.event.ActionEvent evt) {
		String s = jTextPaneChat.getText();
		s = s.concat(jTextPaneYourMessage.getText() + "\n");
		jTextPaneChat.setText(s);
	}

	private void jButtonValidateAndCoordinateActionPerformed(
			java.awt.event.ActionEvent evt) {
		String s = jTextPaneChat.getText();
		s = s.concat("*** Validate ***" + "\n");
		s = s.concat("Fields: " + jTextFieldNbrOfFields.getText() + "\n");
		s = s.concat("Battleships: " + jTextFieldNbrOfBattleship.getText()
				+ "\n");
		s = s.concat("Submarine: " + jTextFieldNbrOfSubmarine.getText() + "\n");
		s = s.concat("Destroyer: " + jTextFieldNbrOfDestroyer.getText() + "\n");
		s = s.concat("Cruiser: " + jTextFieldNbrOfCruiser.getText() + "\n");
		if (jRadioButtonShootAlternatively.isSelected()) {
			s = s.concat("Play Mode: " + "Shoot alternatively" + "\n");
		} else if (jRadioButtonShootUntilWater.isSelected()) {
			s = s.concat("Play Mode: " + "Shoot until water" + "\n");
		}
		jTextPaneChat.setText(s);

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
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new GameFrame().setVisible(true);
			}
		});
		this.dispose();
	}

	private void jTextPaneYourMessageMouseClicked(java.awt.event.MouseEvent evt) {
		jTextPaneYourMessage.setText(null);
	}

	// Variables declaration - do not modify
	private javax.swing.JButton jButtonCancel;
	private javax.swing.JButton jButtonSend;
	private javax.swing.JButton jButtonValidateAndCoordinate;
	private javax.swing.JLabel jLabelChat;
	private javax.swing.JLabel jLabelGameMode;
	private javax.swing.JLabel jLabelNbrOfBattleship;
	private javax.swing.JLabel jLabelNbrOfCruiser;
	private javax.swing.JLabel jLabelNbrOfDestroyer;
	private javax.swing.JLabel jLabelNbrOfFields;
	private javax.swing.JLabel jLabelNbrOfShips;
	private javax.swing.JLabel jLabelNbrOfSubmarine;
	private javax.swing.JLabel jLabelStep2of2;
	private javax.swing.JPanel jPanelChat;
	private javax.swing.JPanel jPanelGameMode;
	private javax.swing.JPanel jPanelGameSettings;
	private javax.swing.JPanel jPanelNbrOfFields;
	private javax.swing.JPanel jPanelNbrOfShips;
	private javax.swing.JRadioButton jRadioButtonShootAlternatively;
	private javax.swing.JRadioButton jRadioButtonShootUntilWater;
	private javax.swing.JScrollPane jScrollPaneChat;
	private javax.swing.JScrollPane jScrollPaneYourMessage;
	private javax.swing.JTextField jTextFieldNbrOfBattleship;
	private javax.swing.JTextField jTextFieldNbrOfCruiser;
	private javax.swing.JTextField jTextFieldNbrOfDestroyer;
	private javax.swing.JTextField jTextFieldNbrOfFields;
	private javax.swing.JTextField jTextFieldNbrOfSubmarine;
	private javax.swing.JTextPane jTextPaneChat;
	private javax.swing.JTextPane jTextPaneYourMessage;
	// End of variables declaration
}
