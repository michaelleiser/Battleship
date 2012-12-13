package ch.bfh.ti.proj1.battleship.client;

/**
 * Defines the ship type and its size.
 * 
 * @author Michael Leiser
 * @author Daniel Kotlàris
 */
public enum ShipType {
	
	BATTLESHIP(5), SUBMARINE(4), DESTROYER(3), CRUISER(2);
	
	private int size;

	/**
	 * Constructor for the ship type where size is the size of the ship type.
	 * @param size
	 * 				the size of the ship type
	 */
	private ShipType(int size) {
		this.size = size;
	}

	/**
	 * Returns the size of the ship type.
	 * @return
	 * 			the size of the ship type
	 */
	public int getSize() {
		return this.size;
	}
}