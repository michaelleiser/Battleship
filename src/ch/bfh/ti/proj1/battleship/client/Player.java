package ch.bfh.ti.proj1.battleship.client;

/**
 * A player who plays the battleship game.
 * 
 * @author Daniel Kotlàris
 * @author Michael Leiser
 */
public class Player {
	
	private String name;
	
	/**
	 * Constructor for a Player.
	 * @param name
	 * 			the Player's name
	 */
	public Player(String name) {
		this.name = name;
	}
	
	/**
	 * Get Player's {@code name}.
	 * @return
	 * 			the Player's name
	 */
	public String getName() {
		return name;
	}


	/**
	 * Set Player's {@code name}.
	 * @param name
	 * 			the Player's name
	 */
	public void setName(String name) {
		this.name = name;
	}
}
