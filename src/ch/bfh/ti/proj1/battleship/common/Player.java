package ch.bfh.ti.proj1.battleship.common;

/**
 * A player who plays the battleship game.
 * 
 * @author Daniel Kotlàris
 * @author Michael Leiser
 */
public class Player {
	
	private String name;
	
	/**
	 * Constructor for a {@link Player}.
	 * @param name
	 * 			the Player's name
	 */
	public Player(String name) {
		this.name = name;
	}
	
	/**
	 * Get {@link Player}'s {@code name}.
	 * @return
	 * 			the Player's name
	 */
	public String getName() {
		return name;
	}


	/**
	 * Set @link Player}'s {@code name}.
	 * @param name
	 * 			the Player's name
	 */
	public void setName(String name) {
		this.name = name;
	}
}
