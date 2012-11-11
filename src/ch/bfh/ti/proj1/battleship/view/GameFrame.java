package ch.bfh.ti.proj1.battleship.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import ch.bfh.ti.proj1.battleship.frame.Game;

/**
 * @author Daniel Kotlàris
 * @author Michael Leiser
 */
public class GameFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jPanePlayingField;

	private JPanel jPanelYourField;
	private JLabel jLabelYourField;

	private JPanel jPanelEnemyField;
	private JLabel jLabelEnemyField;

	private JRadioButton jRadioButtonNbrOfBattleship;
	private JLabel jLabelBattleship;
	private JRadioButton jRadioButtonNbrOfSubmarine;
	private JLabel jLabelSubmarine;
	private JRadioButton jRadioButtonNbrOfDestroyer;
	private JLabel jLabelDestroyer;
	private JRadioButton jRadioButtonNbrOfCruiser;
	private JLabel jLabelCruiser;
	private JRadioButton jRadioButtonHorizontal;
	private JRadioButton jRadioButtonVertical;

	private JPanel jPanelStatistics;
	private JLabel jLabelStatistics;
	private JLabel jLabelHits;
	private JLabel jLabelWater;
	private JLabel jLabelSunk;
	private JLabel jLabelShots;

	private JLabel jLabelYou;
	private JLabel jLabelYouHits;
	private JLabel jLabelYouWater;
	private JLabel jLabelYouSunk;
	private JLabel jLabelYouShots;

	private JLabel jLabelEnemy;
	private JLabel jLabelEnemyHits;
	private JLabel jLabelEnemyWater;
	private JLabel jLabelEnemySunk;
	private JLabel jLabelEnemyShots;

	private JPanel jPanelHistory;
	private JLabel jLabelHistory;
	private JScrollPane jScrollPaneHistory;
	private JTextPane jTextPaneHistory;
	private JPanel jPanelChat;
	private JLabel jLabelChat;
	private JScrollPane jScrollPaneChat;
	public JTextPane jTextPaneChat;
	private JScrollPane jScrollPaneYourMessage;
	private JTextPane jTextPaneYourMessage;
	private JButton jButtonSend;
	private JButton jButtonRestart;

	private JButton jButtonReady;
	
	private Game game;
	
	private JToggleButton yourField[][];
	private JToggleButton enemyField[][];
	
	public GameFrame(Game game) {
		this.game = game;
		initComponents();
	}

	private void initComponents() {
		jPanePlayingField = new JPanel();
		jPanePlayingField.setBackground(new Color(255, 255, 255));
		jPanePlayingField.setBorder(BorderFactory.createEtchedBorder());
		jPanePlayingField.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		
		jPanelYourField = new JPanel();
		jLabelYourField = new JLabel();
		jLabelYourField.setFont(new Font("Tahoma", 1, 14));
		jLabelYourField.setText("Your Field");
		
		jPanelEnemyField = new JPanel();
		jLabelEnemyField = new JLabel();
		jLabelEnemyField.setFont(new Font("Tahoma", 1, 14));
		jLabelEnemyField.setText("Enemy Field");	
		
		jRadioButtonNbrOfBattleship = new JRadioButton();
		jRadioButtonNbrOfBattleship.setText(this.game.getNbrOfBattleships() + "x");
		jRadioButtonNbrOfBattleship.setBackground(new Color(255, 255, 255));
		jRadioButtonNbrOfBattleship.setFont(new Font("Tahoma", 1, 11));
		jRadioButtonNbrOfBattleship.setSelected(true);
		jRadioButtonNbrOfBattleship.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jRadioButtonNbrOfBattleshipActionPerformed(evt);
			}
		});
		jLabelBattleship = new JLabel();
		jLabelBattleship.setIcon(new ImageIcon("img\\battleship.png"));
		jRadioButtonNbrOfSubmarine = new JRadioButton();
		jRadioButtonNbrOfSubmarine.setText(this.game.getNbrOfSubmarines() + "x");
		jRadioButtonNbrOfSubmarine.setBackground(new Color(255, 255, 255));
		jRadioButtonNbrOfSubmarine.setFont(new Font("Tahoma", 1, 11));
		jRadioButtonNbrOfSubmarine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jRadioButtonNbrOfSubmarineActionPerformed(evt);
			}
		});
		jLabelSubmarine = new JLabel();
		jLabelSubmarine.setIcon(new ImageIcon("img\\submarine.png"));
		jRadioButtonNbrOfDestroyer = new JRadioButton();
		jRadioButtonNbrOfDestroyer.setText(this.game.getNbrOfDestroyers() + "x");
		jRadioButtonNbrOfDestroyer.setBackground(new Color(255, 255, 255));
		jRadioButtonNbrOfDestroyer.setFont(new Font("Tahoma", 1, 11));
		jRadioButtonNbrOfDestroyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jRadioButtonNbrOfDestroyerActionPerformed(evt);
			}
		});
		jLabelDestroyer = new JLabel();
		jLabelDestroyer.setIcon(new ImageIcon("img\\destroyer.png"));
		jRadioButtonNbrOfCruiser = new JRadioButton();
		jRadioButtonNbrOfCruiser.setText(this.game.getNbrOfCruisers() + "x");	
		jRadioButtonNbrOfCruiser.setBackground(new Color(255, 255, 255));
		jRadioButtonNbrOfCruiser.setFont(new Font("Tahoma", 1, 11));
		jRadioButtonNbrOfCruiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jRadioButtonNbrOfCruiserActionPerformed(evt);
			}
		});
		jLabelCruiser = new JLabel();
		jLabelCruiser.setIcon(new ImageIcon("img\\cruiser.png"));
		jRadioButtonHorizontal = new JRadioButton();
		jRadioButtonHorizontal.setBackground(new Color(255, 255, 255));
		jRadioButtonHorizontal.setFont(new Font("Tahoma", 1, 11));
		jRadioButtonHorizontal.setSelected(true);
		jRadioButtonHorizontal.setText("horizontal");
		jRadioButtonHorizontal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jRadioButtonHorizontalActionPerformed(evt);
			}
		});
		jRadioButtonVertical = new JRadioButton();
		jRadioButtonVertical.setBackground(new Color(255, 255, 255));
		jRadioButtonVertical.setFont(new Font("Tahoma", 1, 11));
		jRadioButtonVertical.setText("vertical");
		jRadioButtonVertical.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jRadioButtonVerticalActionPerformed(evt);
			}
		});

		jPanelStatistics = new JPanel();
		jPanelStatistics.setBorder(BorderFactory.createEtchedBorder());
		jLabelStatistics = new JLabel();
		jLabelStatistics.setFont(new Font("Tahoma", 1, 11));
		jLabelStatistics.setText("Statistics");
		jLabelHits = new JLabel();
		jLabelHits.setFont(new Font("Tahoma", 1, 11));
		jLabelHits.setText("Hits");
		jLabelWater = new JLabel();
		jLabelWater.setFont(new Font("Tahoma", 1, 11));
		jLabelWater.setText("Water");
		jLabelSunk = new JLabel();
		jLabelSunk.setFont(new Font("Tahoma", 1, 11));
		jLabelSunk.setText("Sunk");
		jLabelShots = new JLabel();
		jLabelShots.setFont(new Font("Tahoma", 1, 11));
		jLabelShots.setText("Shots");
		jLabelYou = new JLabel();
		jLabelYou.setFont(new Font("Tahoma", 1, 11));
		jLabelYou.setText("You");
		jLabelYouHits = new JLabel();
		jLabelYouHits.setFont(new Font("Tahoma", 1, 11));
		jLabelYouHits.setText("0");
		jLabelYouWater = new JLabel();
		jLabelYouWater.setFont(new Font("Tahoma", 1, 11));
		jLabelYouWater.setText("0");
		jLabelYouSunk = new JLabel();
		jLabelYouSunk.setFont(new Font("Tahoma", 1, 11));
		jLabelYouSunk.setText("0");
		jLabelYouShots = new JLabel();
		jLabelYouShots.setFont(new Font("Tahoma", 1, 11));
		jLabelYouShots.setText("0");
		jLabelEnemy = new JLabel();
		jLabelEnemy.setFont(new Font("Tahoma", 1, 11));
		jLabelEnemy.setText("Enemy");
		jLabelEnemyHits = new JLabel();
		jLabelEnemyHits.setFont(new Font("Tahoma", 1, 11));
		jLabelEnemyHits.setText("0");
		jLabelEnemyWater = new JLabel();
		jLabelEnemyWater.setFont(new Font("Tahoma", 1, 11));
		jLabelEnemyWater.setText("0");
		jLabelEnemySunk = new JLabel();
		jLabelEnemySunk.setFont(new Font("Tahoma", 1, 11));
		jLabelEnemySunk.setText("0");
		jLabelEnemyShots = new JLabel();
		jLabelEnemyShots.setFont(new Font("Tahoma", 1, 11));
		jLabelEnemyShots.setText("0");	
		
		jPanelHistory = new JPanel();
		jPanelHistory.setBorder(BorderFactory.createEtchedBorder());
		jLabelHistory = new JLabel();
		jLabelHistory.setFont(new Font("Tahoma", 1, 11));
		jLabelHistory.setText("History");
		jScrollPaneHistory = new JScrollPane();
		jTextPaneHistory = new JTextPane();
		jTextPaneHistory.setEditable(false);
		jTextPaneHistory.setText("\n*******************************\n********* BATTLESHIP ***********\n*******************************\n\n\n* Player 1 Turn*\n\n\n\nPlayer 1 Shoot at B3 and hits a battleship\n\n\nPlayer 2 Shoot at B1 and hits the water\n\n\n\n*Player 2 Turn*");
		
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
		jTextPaneYourMessage.setText("{Your Message}");
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
		
		jButtonRestart = new JButton();
		jButtonRestart.setText("Restart");
		jButtonRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonRestartActionPerformed(evt);
			}
		});
		jButtonReady = new JButton();
		jButtonReady.setText("Ready");
		jButtonReady.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonReadyActionPerformed(evt);
			}
		});
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setName("FrameGame");

		jScrollPaneYourMessage.setViewportView(jTextPaneYourMessage);

		int rows = this.game.getNbrOfRows() + 1;
		int coloumns = this.game.getNbrOfColoumns() + 1;
		
		jPanelYourField.setMinimumSize(new Dimension(200, 200));
		jPanelYourField.setLayout(new GridLayout(rows, coloumns));
		yourField = new JToggleButton[rows][coloumns];
		
		jPanelEnemyField.setMinimumSize(new Dimension(200, 200));
		jPanelEnemyField.setLayout(new GridLayout(rows, coloumns));
		enemyField = new JToggleButton[rows][coloumns];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < coloumns; j++) {
				if (i == 0 && j == 0) {
					JLabel x = new JLabel();
					x.setFont(new Font("Tahoma", 1, 14));
					x.setHorizontalAlignment(SwingConstants.CENTER);
					x.setBorder(BorderFactory.createEtchedBorder());
					x.setText("/");
					jPanelYourField.add(x);
					
					JLabel x1 = new JLabel();
					x1.setFont(new Font("Tahoma", 1, 14));
					x1.setHorizontalAlignment(SwingConstants.CENTER);
					x1.setBorder(BorderFactory.createEtchedBorder());
					x1.setText("/");
					jPanelEnemyField.add(x1);
				} else if (i == 0) {
					JLabel x = new JLabel();
					x.setFont(new Font("Tahoma", 1, 14));
					x.setHorizontalAlignment(SwingConstants.CENTER);
					x.setBorder(BorderFactory.createEtchedBorder());
					x.setText(j + "");
					jPanelYourField.add(x);
					
					JLabel x1 = new JLabel();
					x1.setFont(new Font("Tahoma", 1, 14));
					x1.setHorizontalAlignment(SwingConstants.CENTER);
					x1.setBorder(BorderFactory.createEtchedBorder());
					x1.setText(j + "");
					jPanelEnemyField.add(x1);
				} else if (j == 0) {
					JLabel x = new JLabel();
					x.setFont(new Font("Tahoma", 1, 14));
					x.setHorizontalAlignment(SwingConstants.CENTER);
					x.setBorder(BorderFactory.createEtchedBorder());
					x.setText((char) (i + 64) + "");
					jPanelYourField.add(x);
					
					JLabel x1 = new JLabel();
					x1.setFont(new Font("Tahoma", 1, 14));
					x1.setHorizontalAlignment(SwingConstants.CENTER);
					x1.setBorder(BorderFactory.createEtchedBorder());
					x1.setText((char) (i + 64) + "");
					jPanelEnemyField.add(x1);
				} else {
					JToggleButton jtb = new JToggleButton();
					yourField[i - 1][j - 1] = jtb;
					jtb.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ae) {
							System.out.println(ae.getSource());
						}
					});
					jPanelYourField.add(jtb);
					
					JToggleButton jtb1 = new JToggleButton();
					jtb1.setEnabled(false);
					enemyField[i - 1][j - 1] = jtb1;
					jtb1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ae) {
							System.out.println(ae.getSource());
						}
					});
					jPanelEnemyField.add(jtb1);
				}
			}
		}

		GroupLayout jPanePlayingFieldLayout = new GroupLayout(jPanePlayingField);
		jPanePlayingField.setLayout(jPanePlayingFieldLayout);
		jPanePlayingFieldLayout
				.setHorizontalGroup(jPanePlayingFieldLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanePlayingFieldLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jPanelYourField,
												GroupLayout.PREFERRED_SIZE,
												300, GroupLayout.PREFERRED_SIZE)
										.addGap(37, 37, 37)
										.addGroup(
												jPanePlayingFieldLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanePlayingFieldLayout
																		.createSequentialGroup()
																		.addComponent(
																				jRadioButtonNbrOfBattleship)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabelBattleship))
														.addGroup(
																jPanePlayingFieldLayout
																		.createSequentialGroup()
																		.addGroup(
																				jPanePlayingFieldLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								jRadioButtonNbrOfCruiser)
																						.addComponent(
																								jRadioButtonNbrOfDestroyer)
																						.addComponent(
																								jRadioButtonNbrOfSubmarine))
																		.addGap(18,
																				18,
																				18)
																		.addGroup(
																				jPanePlayingFieldLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabelSubmarine)
																						.addGroup(
																								jPanePlayingFieldLayout
																										.createSequentialGroup()
																										.addGap(10,
																												10,
																												10)
																										.addGroup(
																												jPanePlayingFieldLayout
																														.createParallelGroup(
																																GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jLabelCruiser)
																														.addComponent(
																																jLabelDestroyer)))))
														.addGroup(
																jPanePlayingFieldLayout
																		.createSequentialGroup()
																		.addComponent(
																				jRadioButtonHorizontal)
																		.addGap(41,
																				41,
																				41)
																		.addComponent(
																				jRadioButtonVertical)))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED,
												43, Short.MAX_VALUE)
										.addComponent(jPanelEnemyField,
												GroupLayout.PREFERRED_SIZE,
												300, GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
						.addGroup(
								jPanePlayingFieldLayout
										.createSequentialGroup()
										.addGap(130, 130, 130)
										.addComponent(jLabelYourField)
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED,
												540, Short.MAX_VALUE)
										.addComponent(jLabelEnemyField)
										.addGap(117, 117, 117)));
		jPanePlayingFieldLayout
				.setVerticalGroup(jPanePlayingFieldLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanePlayingFieldLayout
										.createSequentialGroup()
										.addGroup(
												jPanePlayingFieldLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanePlayingFieldLayout
																		.createSequentialGroup()
																		.addGap(42,
																				42,
																				42)
																		.addComponent(
																				jRadioButtonNbrOfBattleship))
														.addGroup(
																jPanePlayingFieldLayout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addGroup(
																				jPanePlayingFieldLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jPanelEnemyField,
																								GroupLayout.PREFERRED_SIZE,
																								300,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jPanelYourField,
																								GroupLayout.PREFERRED_SIZE,
																								300,
																								GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								jPanePlayingFieldLayout
																										.createSequentialGroup()
																										.addGroup(
																												jPanePlayingFieldLayout
																														.createParallelGroup(
																																GroupLayout.Alignment.TRAILING)
																														.addComponent(
																																jRadioButtonNbrOfSubmarine)
																														.addGroup(
																																jPanePlayingFieldLayout
																																		.createSequentialGroup()
																																		.addComponent(
																																				jLabelBattleship)
																																		.addGap(18,
																																				18,
																																				18)
																																		.addComponent(
																																				jLabelSubmarine)))
																										.addGap(18,
																												18,
																												18)
																										.addGroup(
																												jPanePlayingFieldLayout
																														.createParallelGroup(
																																GroupLayout.Alignment.TRAILING)
																														.addComponent(
																																jLabelDestroyer)
																														.addComponent(
																																jRadioButtonNbrOfDestroyer))
																										.addGap(18,
																												18,
																												18)
																										.addGroup(
																												jPanePlayingFieldLayout
																														.createParallelGroup(
																																GroupLayout.Alignment.TRAILING)
																														.addComponent(
																																jRadioButtonNbrOfCruiser)
																														.addComponent(
																																jLabelCruiser))
																										.addGap(18,
																												18,
																												18)
																										.addGroup(
																												jPanePlayingFieldLayout
																														.createParallelGroup(
																																GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jRadioButtonHorizontal)
																														.addComponent(
																																jRadioButtonVertical))))))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanePlayingFieldLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabelYourField)
														.addComponent(
																jLabelEnemyField))
										.addContainerGap()));

		GroupLayout jPanelStatisticsLayout = new GroupLayout(jPanelStatistics);
		jPanelStatistics.setLayout(jPanelStatisticsLayout);
		jPanelStatisticsLayout
				.setHorizontalGroup(jPanelStatisticsLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanelStatisticsLayout
										.createSequentialGroup()
										.addGroup(
												jPanelStatisticsLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanelStatisticsLayout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jLabelStatistics))
														.addGroup(
																jPanelStatisticsLayout
																		.createSequentialGroup()
																		.addGap(30,
																				30,
																				30)
																		.addGroup(
																				jPanelStatisticsLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanelStatisticsLayout
																										.createSequentialGroup()
																										.addGroup(
																												jPanelStatisticsLayout
																														.createParallelGroup(
																																GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jLabelYouHits)
																														.addComponent(
																																jLabelYouWater)
																														.addComponent(
																																jLabelYouSunk)
																														.addComponent(
																																jLabelYouShots))
																										.addGap(50,
																												50,
																												50)
																										.addGroup(
																												jPanelStatisticsLayout
																														.createParallelGroup(
																																GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jLabelWater)
																														.addComponent(
																																jLabelHits)
																														.addComponent(
																																jLabelSunk)
																														.addComponent(
																																jLabelShots)))
																						.addComponent(
																								jLabelYou))
																		.addGap(27,
																				27,
																				27)
																		.addGroup(
																				jPanelStatisticsLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabelEnemyHits)
																						.addComponent(
																								jLabelEnemy)
																						.addComponent(
																								jLabelEnemyWater)
																						.addComponent(
																								jLabelEnemySunk)
																						.addComponent(
																								jLabelEnemyShots))))
										.addContainerGap(95, Short.MAX_VALUE)));
		jPanelStatisticsLayout
				.setVerticalGroup(jPanelStatisticsLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanelStatisticsLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabelStatistics)
										.addGap(18, 18, 18)
										.addGroup(
												jPanelStatisticsLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(jLabelYou)
														.addComponent(
																jLabelEnemy))
										.addGap(18, 18, 18)
										.addGroup(
												jPanelStatisticsLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabelYouHits)
														.addComponent(
																jLabelHits)
														.addComponent(
																jLabelEnemyHits))
										.addGap(18, 18, 18)
										.addGroup(
												jPanelStatisticsLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabelYouWater)
														.addComponent(
																jLabelWater)
														.addComponent(
																jLabelEnemyWater))
										.addGap(30, 30, 30)
										.addGroup(
												jPanelStatisticsLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabelYouSunk)
														.addComponent(
																jLabelSunk)
														.addComponent(
																jLabelEnemySunk))
										.addGap(26, 26, 26)
										.addGroup(
												jPanelStatisticsLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabelYouShots)
														.addComponent(
																jLabelShots)
														.addComponent(
																jLabelEnemyShots))
										.addContainerGap(16, Short.MAX_VALUE)));

		jScrollPaneChat.setViewportView(jTextPaneChat);

		GroupLayout jPanelChatLayout = new GroupLayout(jPanelChat);
		jPanelChat.setLayout(jPanelChatLayout);
		jPanelChatLayout
				.setHorizontalGroup(jPanelChatLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanelChatLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanelChatLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addComponent(
																jScrollPaneChat)
														.addComponent(
																jLabelChat)
														.addGroup(
																jPanelChatLayout
																		.createSequentialGroup()
																		.addComponent(
																				jScrollPaneYourMessage,
																				GroupLayout.PREFERRED_SIZE,
																				179,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18,
																				18,
																				18)
																		.addComponent(
																				jButtonSend,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		jPanelChatLayout.setVerticalGroup(jPanelChatLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				jPanelChatLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabelChat)
						.addPreferredGap(
								LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPaneChat,
								GroupLayout.PREFERRED_SIZE, 163,
								GroupLayout.PREFERRED_SIZE)
						.addGap(12, 12, 12)
						.addGroup(
								jPanelChatLayout
										.createParallelGroup(
												GroupLayout.Alignment.LEADING)
										.addComponent(jScrollPaneYourMessage,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(jButtonSend))
						.addGap(16, 16, 16)));

		jScrollPaneHistory.setViewportView(jTextPaneHistory);

		GroupLayout jPanelHistoryLayout = new GroupLayout(jPanelHistory);
		jPanelHistory.setLayout(jPanelHistoryLayout);
		jPanelHistoryLayout.setHorizontalGroup(jPanelHistoryLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						jPanelHistoryLayout.createSequentialGroup()
								.addContainerGap().addComponent(jLabelHistory)
								.addContainerGap(252, Short.MAX_VALUE))
				.addGroup(
						jPanelHistoryLayout.createParallelGroup(
								GroupLayout.Alignment.LEADING).addGroup(
								jPanelHistoryLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jScrollPaneHistory,
												GroupLayout.DEFAULT_SIZE, 283,
												Short.MAX_VALUE)
										.addContainerGap())));
		jPanelHistoryLayout
				.setVerticalGroup(jPanelHistoryLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanelHistoryLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabelHistory)
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
						.addGroup(
								jPanelHistoryLayout
										.createParallelGroup(
												GroupLayout.Alignment.LEADING)
										.addGroup(
												GroupLayout.Alignment.TRAILING,
												jPanelHistoryLayout
														.createSequentialGroup()
														.addContainerGap(33,
																Short.MAX_VALUE)
														.addComponent(
																jScrollPaneHistory,
																GroupLayout.PREFERRED_SIZE,
																206,
																GroupLayout.PREFERRED_SIZE)
														.addContainerGap())));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING,
												false)
												.addComponent(
														jPanePlayingField,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.LEADING,
																				false)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jButtonRestart,
																										GroupLayout.PREFERRED_SIZE,
																										129,
																										GroupLayout.PREFERRED_SIZE)
																								.addGap(18,
																										18,
																										18)
																								.addComponent(
																										jButtonReady,
																										GroupLayout.DEFAULT_SIZE,
																										GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE))
																				.addComponent(
																						jPanelStatistics,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE))
																.addGap(18, 18,
																		18)
																.addComponent(
																		jPanelHistory,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18,
																		18)
																.addComponent(
																		jPanelChat,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)))
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jPanePlayingField,
										GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING)
												.addComponent(
														jPanelHistory,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jPanelStatistics,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						jButtonRestart)
																				.addComponent(
																						jButtonReady)))
												.addComponent(
														jPanelChat,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addContainerGap()));

		pack();
	}

	private void jRadioButtonHorizontalActionPerformed(ActionEvent evt) {
		jRadioButtonVertical.setSelected(false);
		jRadioButtonHorizontal.setSelected(true);
	}

	private void jRadioButtonVerticalActionPerformed(ActionEvent evt) {
		jRadioButtonHorizontal.setSelected(false);
		jRadioButtonVertical.setSelected(true);
	}

	private void jRadioButtonNbrOfSubmarineActionPerformed(ActionEvent evt) {
		jRadioButtonNbrOfBattleship.setSelected(false);
		jRadioButtonNbrOfDestroyer.setSelected(false);
		jRadioButtonNbrOfCruiser.setSelected(false);
		jRadioButtonNbrOfSubmarine.setSelected(true);
	}

	private void jRadioButtonNbrOfBattleshipActionPerformed(ActionEvent evt) {
		jRadioButtonNbrOfSubmarine.setSelected(false);
		jRadioButtonNbrOfDestroyer.setSelected(false);
		jRadioButtonNbrOfCruiser.setSelected(false);
		jRadioButtonNbrOfBattleship.setSelected(true);
	}

	private void jRadioButtonNbrOfDestroyerActionPerformed(ActionEvent evt) {
		jRadioButtonNbrOfSubmarine.setSelected(false);
		jRadioButtonNbrOfBattleship.setSelected(false);
		jRadioButtonNbrOfCruiser.setSelected(false);
		jRadioButtonNbrOfDestroyer.setSelected(true);
	}

	private void jRadioButtonNbrOfCruiserActionPerformed(ActionEvent evt) {
		jRadioButtonNbrOfSubmarine.setSelected(false);
		jRadioButtonNbrOfBattleship.setSelected(false);
		jRadioButtonNbrOfDestroyer.setSelected(false);
		jRadioButtonNbrOfCruiser.setSelected(true);
	}

	private void jButtonSendActionPerformed(ActionEvent evt) {
		String s = "Game " + "Chat " + jTextPaneYourMessage.getText(); 
		game.mc.sendMessage(s);
	}

	private void jTextPaneYourMessageMouseClicked(MouseEvent evt) {
		jTextPaneYourMessage.setText(null);
	}

	private void jButtonRestartActionPerformed(ActionEvent evt) {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception ex) {
			Logger.getLogger(CoordinateFrame.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		game.showCoordinateFrame();
		this.dispose();
	}

	private void jButtonReadyActionPerformed(ActionEvent evt) {
		for(int i = 0; i < game.getNbrOfRows(); i++){
			for(int j = 0; j < game.getNbrOfColoumns(); j++){
				yourField[i][j].setEnabled(false);
				enemyField[i][j].setEnabled(true);
			}
		}
	}
	
}
