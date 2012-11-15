package ch.bfh.ti.proj1.battleship.client;

public enum ShipType {
	
	BATTLESHIP(5), SUBMARINE(4), DESTROYER(3), CRUISER(2);
	
	int size;

	private ShipType(int size) {
		this.size = size;
	}

	public int getSize() {
		return this.size;
	}
}