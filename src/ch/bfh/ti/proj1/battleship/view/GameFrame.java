package ch.bfh.ti.proj1.battleship.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import ch.bfh.ti.proj1.battleship.common.Field;
import ch.bfh.ti.proj1.battleship.common.Ship;
import ch.bfh.ti.proj1.battleship.common.ShipType;
import ch.bfh.ti.proj1.battleship.game.Game;
import ch.bfh.ti.proj1.battleship.network.Message;

/**
 * This class displays the game frame.
 * It is also responsible for the interaction with the GUI elements.
 * 
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
	private JLabel jLabelAccuracy;

	private JLabel jLabelYou;
	private JLabel jLabelYouHits;
	private JLabel jLabelYouWater;
	private JLabel jLabelYouSunk;
	private JLabel jLabelYouShots;
	private JLabel jLabelYouAccuracy;

	private JLabel jLabelEnemy;
	private JLabel jLabelEnemyHits;
	private JLabel jLabelEnemyWater;
	private JLabel jLabelEnemySunk;
	private JLabel jLabelEnemyShots;
	private JLabel jLabelEnemyAccuracy;

	private JPanel jPanelHistory;
	private JLabel jLabelHistory;
	private JScrollPane jScrollPaneHistory;
	private JTextPane jTextPaneHistory;
	private JPanel jPanelChat;
	private JLabel jLabelChat;
	private JScrollPane jScrollPaneChat;
	private JTextPane jTextPaneChat;

	private JScrollPane jScrollPaneYourMessage;
	private JTextPane jTextPaneYourMessage;
	private JButton jButtonSend;
	private JButton jButtonRestart;

	private JButton jButtonReady;
	
	private Game game;
	
	private Field[][] yourField;
	private Field[][] enemyField;
	
	/**
	 * Creates a new {@link JFrame} for the {@link Game}.
	 * 
	 * @param game
	 */
	public GameFrame(Game game) {
		this.game = game;
		initComponents();
	}

	/**
	 * Initializes the frame components.
	 */
	private void initComponents() {
		this.setTitle("Battleship - Player " + game.getPlayer().getName());
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e){
				exit();
			}
		});
		this.setResizable(false);
		
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
				jRadioButtonNbrOfBattleshipActionPerformed();
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
				jRadioButtonNbrOfSubmarineActionPerformed();
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
				jRadioButtonNbrOfDestroyerActionPerformed();
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
				jRadioButtonNbrOfCruiserActionPerformed();
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
				jRadioButtonHorizontalActionPerformed();
			}
		});
		jRadioButtonVertical = new JRadioButton();
		jRadioButtonVertical.setBackground(new Color(255, 255, 255));
		jRadioButtonVertical.setFont(new Font("Tahoma", 1, 11));
		jRadioButtonVertical.setText("vertical");
		jRadioButtonVertical.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jRadioButtonVerticalActionPerformed();
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
		jLabelAccuracy = new JLabel();
		jLabelAccuracy.setFont(new Font("Tahoma", 1, 11));
        jLabelAccuracy.setText("Accuracy");
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
		jLabelYouAccuracy = new JLabel();
		jLabelYouAccuracy.setFont(new Font("Tahoma", 1, 11)); // NOI18N
        jLabelYouAccuracy.setText("0%");
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
		jLabelEnemyAccuracy = new JLabel();
		jLabelEnemyAccuracy.setFont(new Font("Tahoma", 1, 11));
        jLabelEnemyAccuracy.setText("0%");
		
		jPanelHistory = new JPanel();
		jPanelHistory.setBorder(BorderFactory.createEtchedBorder());
		jLabelHistory = new JLabel();
		jLabelHistory.setFont(new Font("Tahoma", 1, 11));
		jLabelHistory.setText("History");
		jScrollPaneHistory = new JScrollPane();
		jTextPaneHistory = new JTextPane();
		jTextPaneHistory.setEditable(false);
		jTextPaneHistory.setText(	"************************************\n" +
									"********* BATTLESHIP ***********\n" +
									"************************************\n\n\n");
		
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
				jTextPaneYourMessageMouseClicked();
			}
		});
		jTextPaneYourMessage.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					jButtonSendActionPerformed();
				}
			}
		});
		jButtonSend = new JButton();
		jButtonSend.setText("Send");
		jButtonSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonSendActionPerformed();
			}
		});
		
		jButtonRestart = new JButton();
		jButtonRestart.setText("Restart");
		jButtonRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonRestartActionPerformed();
			}
		});
		jButtonReady = new JButton();
		jButtonReady.setText("Ready");
		jButtonReady.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonReadyActionPerformed();
			}
		});
		
		jScrollPaneYourMessage.setViewportView(jTextPaneYourMessage);

		int rows = this.game.getNbrOfRows() + 1;
		int coloumns = this.game.getNbrOfColoumns() + 1;
		
		jPanelYourField.setMinimumSize(new Dimension(200, 200));
		jPanelYourField.setLayout(new GridLayout(rows, coloumns));
		yourField = new Field[rows][coloumns];
		
		jPanelEnemyField.setMinimumSize(new Dimension(200, 200));
		jPanelEnemyField.setLayout(new GridLayout(rows, coloumns));
		enemyField = new Field[rows][coloumns];
		
		for (int yCoord = 0; yCoord < rows; yCoord++) {			// Creates the two playing fields.
			for (int xCoord = 0; xCoord < coloumns; xCoord++) {
				if (yCoord == 0 && xCoord == 0) {				// left top /
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
				} else if (yCoord == 0) {						// first row 1, 2, 3, ...
					JLabel x = new JLabel();
					x.setFont(new Font("Tahoma", 1, 14));
					x.setHorizontalAlignment(SwingConstants.CENTER);
					x.setBorder(BorderFactory.createEtchedBorder());
					x.setText(xCoord + "");
					jPanelYourField.add(x);
					
					JLabel x1 = new JLabel();
					x1.setFont(new Font("Tahoma", 1, 14));
					x1.setHorizontalAlignment(SwingConstants.CENTER);
					x1.setBorder(BorderFactory.createEtchedBorder());
					x1.setText(xCoord + "");
					jPanelEnemyField.add(x1);
				} else if (xCoord == 0) {						// first coloumn a, b, c, ...
					JLabel x = new JLabel();
					x.setFont(new Font("Tahoma", 1, 14));
					x.setHorizontalAlignment(SwingConstants.CENTER);
					x.setBorder(BorderFactory.createEtchedBorder());
					x.setText((char) (yCoord + 64) + "");
					jPanelYourField.add(x);
					
					JLabel x1 = new JLabel();
					x1.setFont(new Font("Tahoma", 1, 14));
					x1.setHorizontalAlignment(SwingConstants.CENTER);
					x1.setBorder(BorderFactory.createEtchedBorder());
					x1.setText((char) (yCoord + 64) + "");
					jPanelEnemyField.add(x1);
				} else {										// the playing fields
					final Field field1 = new Field(xCoord-1, yCoord-1);
					yourField[yCoord-1][xCoord-1] = field1;
					field1.addMouseListener(new MouseListener(){
						@Override
						public void mouseClicked(MouseEvent e) {
							Field f = (Field) e.getSource();
							int x = f.getXPos();
							int y = f.getYPos();
							int alignment = 0;
							if(jRadioButtonHorizontal.isSelected()){
								alignment = 0;
							} else{
								alignment = 1;
							}
							ShipType type = null;
							if(jRadioButtonNbrOfBattleship.isSelected()){
								type = ShipType.BATTLESHIP;
							} else if(jRadioButtonNbrOfSubmarine.isSelected()){
								type = ShipType.SUBMARINE;
							} else if(jRadioButtonNbrOfDestroyer.isSelected()){
								type = ShipType.DESTROYER;
							} else{
								type = ShipType.CRUISER;
							}	
							if(f.getShip() == null){				// if there is no ship on the field, place ship on the field.
								game.placeShip(type, x, y, alignment);
							} else{									// if there is a ship on the field, remove ship from the field.
								game.removeShip(x, y);
							}
						}
						@Override
						public void mousePressed(MouseEvent e) {
						}
						@Override
						public void mouseReleased(MouseEvent e) {
						}
						@Override
						public void mouseEntered(MouseEvent e) {
							Field f = (Field) e.getSource();
							toggleFieldColor(f, Color.green);
						}
						@Override
						public void mouseExited(MouseEvent e) {
							Field f = (Field) e.getSource();
							toggleFieldColor(f, Color.white);
						}
						private void toggleFieldColor(Field f, Color color) {	// method for displaying the positions of the ship when place it.
							int x = f.getXPos();
							int y = f.getYPos();
							int alignment = 0;
							if(jRadioButtonHorizontal.isSelected()){
								alignment = 0;
							} else{
								alignment = 1;
							}
							ShipType type = null;
							if(jRadioButtonNbrOfBattleship.isSelected()){
								type = ShipType.BATTLESHIP;
							} else if(jRadioButtonNbrOfSubmarine.isSelected()){
								type = ShipType.SUBMARINE;
							} else if(jRadioButtonNbrOfDestroyer.isSelected()){
								type = ShipType.DESTROYER;
							} else{
								type = ShipType.CRUISER;
							}	
							if(game.checkConstraints(yourField, new Ship(type), x, y, alignment)){
								switch (type) {
								case BATTLESHIP:
									if(game.nbrOfBattleshipsLeft() > 0){
										if(alignment == 0){
											for(int i = 0; i < type.getSize(); i++){
												yourField[y][x+i].setBackground(color);
											}
										} else{
											for(int i = 0; i < type.getSize(); i++){
												yourField[y+i][x].setBackground(color);
											}
										}	
									}
									break;
								case SUBMARINE:
									if(game.nbrOfSubmarinesLeft() > 0){
										if(alignment == 0){
											for(int i = 0; i < type.getSize(); i++){
												yourField[y][x+i].setBackground(color);
											}
										} else{
											for(int i = 0; i < type.getSize(); i++){
												yourField[y+i][x].setBackground(color);
											}
										}
									}
									break;
								case DESTROYER:
									if(game.nbrOfDestroyersLeft() > 0){
										if(alignment == 0){
											for(int i = 0; i < type.getSize(); i++){
												yourField[y][x+i].setBackground(color);
											}
										} else{
											for(int i = 0; i < type.getSize(); i++){
												yourField[y+i][x].setBackground(color);
											}
										}
									}
									break;
								case CRUISER:
									if(game.nbrOfCruisersLeft() > 0){
										if(alignment == 0){
											for(int i = 0; i < type.getSize(); i++){
												yourField[y][x+i].setBackground(color);
											}
										} else{
											for(int i = 0; i < type.getSize(); i++){
												yourField[y+i][x].setBackground(color);
											}
										}
									}
									break;
								default:
									break;
								}
							} 
						}});
					
					jPanelYourField.add(field1);
					
					Field field2 = new Field(xCoord-1, yCoord-1);
					field2.setEnabled(false);
					enemyField[yCoord-1][xCoord-1] = field2;
					field2.addMouseListener(new MouseListener(){
						@Override
						public void mouseClicked(MouseEvent e) {
							if(game.isYourTurn()){					// if it is your turn, you can shoot an a field.
								Field f = (Field) e.getSource();
								if(!f.isHit()){						// only if the field is not already hit.
									int x = f.getXPos();
									int y = f.getYPos();
									game.shootAt(x, y);
								}
								f.hit();
							}
						}
						@Override
						public void mousePressed(MouseEvent e) {
						}
						@Override
						public void mouseReleased(MouseEvent e) {
						}
						@Override
						public void mouseEntered(MouseEvent e) {
							if(game.isYourTurn()){
								Field f = (Field) e.getSource();
								if(!f.isHit()){
									f.setBackground(Color.green);
								}
							}
						}
						@Override
						public void mouseExited(MouseEvent e) {
							if(game.isYourTurn()){
								Field f = (Field) e.getSource();
								if(!f.isHit()){
									f.setBackground(Color.white);
								}
							}
						}});
					jPanelEnemyField.add(field2);
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
        jPanelStatisticsLayout.setHorizontalGroup(
            jPanelStatisticsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStatisticsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelStatistics)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelStatisticsLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanelStatisticsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelYouWater)
                    .addComponent(jLabelYou)
                    .addComponent(jLabelYouSunk)
                    .addComponent(jLabelYouShots)
                    .addComponent(jLabelYouAccuracy)
                    .addComponent(jLabelYouHits))
                .addGap(49, 49, 49)
                .addGroup(jPanelStatisticsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelWater)
                    .addComponent(jLabelSunk)
                    .addComponent(jLabelShots)
                    .addComponent(jLabelAccuracy)
                    .addComponent(jLabelHits))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanelStatisticsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEnemy)
                    .addComponent(jLabelEnemyWater)
                    .addComponent(jLabelEnemySunk)
                    .addComponent(jLabelEnemyShots)
                    .addComponent(jLabelEnemyAccuracy)
                    .addComponent(jLabelEnemyHits))
                .addGap(39, 39, 39))
        );
        jPanelStatisticsLayout.setVerticalGroup(
            jPanelStatisticsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStatisticsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelStatistics)
                .addGap(18, 18, 18)
                .addGroup(jPanelStatisticsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelYou)
                    .addComponent(jLabelEnemy))
                .addGap(9, 9, 9)
                .addGroup(jPanelStatisticsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelWater)
                    .addComponent(jLabelYouWater)
                    .addComponent(jLabelEnemyWater))
                .addGap(18, 18, 18)
                .addGroup(jPanelStatisticsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHits)
                    .addComponent(jLabelYouHits)
                    .addComponent(jLabelEnemyHits))
                .addGap(18, 18, 18)
                .addGroup(jPanelStatisticsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSunk)
                    .addComponent(jLabelYouSunk)
                    .addComponent(jLabelEnemySunk))
                .addGap(18, 18, 18)
                .addGroup(jPanelStatisticsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelYouShots)
                    .addComponent(jLabelShots)
                    .addComponent(jLabelEnemyShots))
                .addGap(18, 18, 18)
                .addGroup(jPanelStatisticsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAccuracy)
                    .addComponent(jLabelYouAccuracy)
                    .addComponent(jLabelEnemyAccuracy))
                .addContainerGap(13, Short.MAX_VALUE))
        );

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
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();	
		int xCoordinate = (int)(dim.getWidth() - this.getWidth()) / 2;
		int yCoordinate = (int)(dim.getHeight() - this.getHeight()) / 2;
		this.setLocation(xCoordinate, yCoordinate);
	}

	/**
	 * Toggles between the horizontal and vertical alignment.
	 */
	private void jRadioButtonHorizontalActionPerformed() {
		jRadioButtonHorizontal.setSelected(true);
		jRadioButtonVertical.setSelected(false);
	}

	/**
	 * Toggles between the horizontal and vertical alignment.
	 */
	private void jRadioButtonVerticalActionPerformed() {
		jRadioButtonHorizontal.setSelected(false);
		jRadioButtonVertical.setSelected(true);
	}

	/**
	 * Toggles between the {@link Ship}s to place.
	 */
	private void jRadioButtonNbrOfBattleshipActionPerformed() {
		jRadioButtonNbrOfBattleship.setSelected(true);
		jRadioButtonNbrOfSubmarine.setSelected(false);
		jRadioButtonNbrOfDestroyer.setSelected(false);
		jRadioButtonNbrOfCruiser.setSelected(false);
	}
	
	/**
	 * Toggles between the {@link Ship}s to place.
	 */
	private void jRadioButtonNbrOfSubmarineActionPerformed() {
		jRadioButtonNbrOfBattleship.setSelected(false);
		jRadioButtonNbrOfSubmarine.setSelected(true);
		jRadioButtonNbrOfDestroyer.setSelected(false);
		jRadioButtonNbrOfCruiser.setSelected(false);
	}

	/**
	 * Toggles between the {@link Ship}s to place.
	 */
	private void jRadioButtonNbrOfDestroyerActionPerformed() {
		jRadioButtonNbrOfSubmarine.setSelected(false);
		jRadioButtonNbrOfBattleship.setSelected(false);
		jRadioButtonNbrOfDestroyer.setSelected(true);
		jRadioButtonNbrOfCruiser.setSelected(false);
	}

	/**
	 * Toggles between the {@link Ship}s to place.
	 */
	private void jRadioButtonNbrOfCruiserActionPerformed() {
		jRadioButtonNbrOfSubmarine.setSelected(false);
		jRadioButtonNbrOfBattleship.setSelected(false);
		jRadioButtonNbrOfDestroyer.setSelected(false);
		jRadioButtonNbrOfCruiser.setSelected(true);
	}

	/**
	 * Sends the {@link Message} to the opponent {@link Player} and concatenates the messages in the chat jTextPane.
	 */
	private void jButtonSendActionPerformed() {
		String name = game.getPlayer().getName();
		String text = jTextPaneYourMessage.getText().trim(); 
		if(!text.equals("")){
			game.getClient().sendMessage(Message.GAME_CHAT.toString() + " " + name + ": " + text + "\n");
			concatjTextPaneChat(name + ": " + text + "\n");
		}
		jTextPaneYourMessage.setText("");
	}

	/**
	 * Clears the {@link Message} jTextPane when clicked on it.
	 */
	private void jTextPaneYourMessageMouseClicked() {
		jTextPaneYourMessage.setText(null);
	}

	/**
	 * This method invokes the restart method of the {@link Game}.
	 * This method also sends a {@link Message} to the other {@link Player} for restarting the {@link Game}.
	 */
	private void jButtonRestartActionPerformed() {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			Logger.getLogger(CoordinateFrame.class.getName()).log(Level.SEVERE,null, e);
		}
		game.restart();
		game.getCoordinateFrame().enableComponents();
		game.getClient().sendMessage(Message.GAME_RESTART.toString());
	}

	/**
	 * When all {@link Ship}s are placed, this method invokes the ready method of the {@link Game}.
	 * This method also removes the {@link MouseListener}s from your playing field.
	 */
	private void jButtonReadyActionPerformed() {
		if(game.allShipsPlaced()){
			for(int i = 0; i < game.getNbrOfRows(); i++){
				for(int j = 0; j < game.getNbrOfColoumns(); j++){
					MouseListener[] listeners = yourField[i][j].getMouseListeners();
					for(MouseListener l : listeners){
						yourField[i][j].removeMouseListener(l);
					}
				}
			}
			jButtonReady.setEnabled(false);
			game.ready();
		} else{
			JOptionPane.showMessageDialog(null, "Not all Ships are placed");
		}
	}
	
	/**
	 * Enables the components of the enemy playing field, so the {@link Player} can shoot on it.
	 */
	public void enableComponents(){
		for(int i = 0; i < game.getNbrOfRows(); i++){
			for(int j = 0; j < game.getNbrOfColoumns(); j++){
				enemyField[i][j].setEnabled(true);
			}
		}
	}
	
	/**
	 * Disables the components of the enemy field, so the {@link Player} cannot shoot on it.
	 */
	public void disableComponents(){
		for(int i = 0; i < game.getNbrOfRows(); i++){
			for(int j = 0; j < game.getNbrOfColoumns(); j++){
				enemyField[i][j].setEnabled(false);
			}
		}
	}

	/**
	 * Returns a two dimensional array of your {@link Field}s.
	 * @return
	 * 			your fields
	 */
	public Field[][] getYourField() {
		return yourField;
	}
	
	/**
	 * Returns a two dimensional array of the enemy {@link Field}s.
	 * @return
	 * 			enemy fields
	 */
	public Field[][] getEnemyField() {
		return enemyField;
	}
	
	/**
	 * Sets the number of battleships.
	 * @param number
	 */
	public void setNbrOfBattleship(int number){
		jRadioButtonNbrOfBattleship.setText(number + "x");
	}
	
	/**
	 * Sets the number of submarines.
	 * @param number
	 */
	public void setNbrOfSubmarine(int number){
		jRadioButtonNbrOfSubmarine.setText(number + "x");
	}
	
	/**
	 * Sets the number of destroyers.
	 * @param number
	 */
	public void setNbrOfDestroyer(int number){
		jRadioButtonNbrOfDestroyer.setText(number + "x");
	}
	
	/**
	 * Sets the number of cruisers.
	 * @param number
	 */
	public void setNbrOfCruiser(int number){
		jRadioButtonNbrOfCruiser.setText(number + "x");
	}
	
	/**
	 * Increments the jLabelYouHits by one.
	 */
	public void incjLabelYouHits() {
		this.jLabelYouHits.setText((1+Integer.parseInt(jLabelYouHits.getText())) + "");
	}

	/**
	 * Increments the jLabelYouWater by one.
	 */
	public void incjLabelYouWater() {
		this.jLabelYouWater.setText((1+Integer.parseInt(jLabelYouWater.getText())) + "");
	}

	/**
	 * Increments the jLabelYouSunk by one.
	 */
	public void incjLabelYouSunk() {
		this.jLabelYouSunk.setText((1+Integer.parseInt(jLabelYouSunk.getText())) + "");
	}

	/**
	 * Increments the jLabelYouShots by one.
	 */
	public void incjLabelYouShots() {
		this.jLabelYouShots.setText((1+Integer.parseInt(jLabelYouShots.getText())) + "");
		refreshjLabelYouAccuracy();
	}

	/**
	 * Refreshes the jLabelYouAccuracy.
	 */
	public void refreshjLabelYouAccuracy(){
		int hits = Integer.parseInt(jLabelYouHits.getText());
		int shots = Integer.parseInt(jLabelYouShots.getText());
		int accuracy = (100 * hits / shots);
		this.jLabelYouAccuracy.setText(accuracy + "%");
	}
	
	/**
	 * Increments the jLabelEnemyHits by one.
	 */
	public void incjLabelEnemyHits() {
		this.jLabelEnemyHits.setText((1+Integer.parseInt(jLabelEnemyHits.getText())) + "");
	}

	/**
	 * Increments the jLabelEnemyWater by one.
	 */
	public void incjLabelEnemyWater() {
		this.jLabelEnemyWater.setText((1+Integer.parseInt(jLabelEnemyWater.getText())) + "");
	}

	/**
	 * Increments the jLabelEnemySunk by one.
	 */
	public void incjLabelEnemySunk() {
		this.jLabelEnemySunk.setText((1+Integer.parseInt(jLabelEnemySunk.getText())) + "");
	}

	/**
	 * Increments the jLabelEnemyShots by one.
	 */
	public void incjLabelEnemyShots() {
		this.jLabelEnemyShots.setText((1+Integer.parseInt(jLabelEnemyShots.getText())) + "");
		refreshjLabelEnemyAccuracy();
	}
	
	/**
	 * Refreshes the jLabelEnemyAccuracy.
	 */
	public void refreshjLabelEnemyAccuracy(){
		int hits = Integer.parseInt(jLabelEnemyHits.getText());
		int shots = Integer.parseInt(jLabelEnemyShots.getText());
		int accuracy = (100 * hits / shots);
		this.jLabelEnemyAccuracy.setText(accuracy + "%");
	}
	
	/**
	 * Concats the actual text in the Chat with the new {@code text}
	 * @param text
	 */
	public void concatjTextPaneChat(String text) {
		String oldText = jTextPaneChat.getText();
		jTextPaneChat.setText(oldText + text);
	}
	
	/**
	 * Concats the actual text in the History with the new {@code text}
	 * @param text
	 */
	public void concatjTextPaneHistory(String text){
		String oldText = jTextPaneHistory.getText();
		jTextPaneHistory.setText(oldText + text);
	}
	
	
	/**
	 * Shows the active {@link Player} in the history field.
	 */
	public void showActivePlayer() {
		concatjTextPaneHistory("<<< " + game.getPlayer().getName() + " >>>\n");
		game.getClient().sendMessage(Message.GAME_HISTORY.toString() + " " + "<<< " + game.getPlayer().getName() + " >>>\n");
	}

	/**
	 * Sends a close connection {@link Message} to the other {@link Client}.
	 * Stops the {@link Connection}.
	 * Exits the {@link Game}.
	 */
	private void exit(){
		this.game.getClient().sendMessage(Message.CLOSECONNECTION.toString());
		this.game.getClient().stop();
		System.exit(0);
	}
}
