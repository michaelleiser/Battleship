package ch.bfh.ti.proj1.battleship.client;

/**
 * One of the two players who plays the battleship game.
 * 
 * @author Daniel Kotlàris
 * @author Michael Leiser
 */
public class Player {
	
	private String name;
	
	/**
	 * Constructor for remote player
	 */
	public Player(String name) {
		this.name = name;
	}
	
	/**
	 * Get Player's name
	 * @param name
	 * 			the Player's name
	 */
	public String getName() {
		return name;
	}


	/**
	 * Set Player's name
	 * @param name
	 * 			the Player's name
	 */
	public void setName(String name) {
		this.name = name;
	}
}
