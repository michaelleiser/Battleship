package ch.bfh.ti.proj1.battleship.client;

public enum ShipType {
	
	BATTLESHIP(5), SUBMARINE(4), DESTROYER(3), CRUISER(2);
	
	private int size;

	/**
	 * Constructor for the ship type where size is the size of the ship type.
	 * @param size
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