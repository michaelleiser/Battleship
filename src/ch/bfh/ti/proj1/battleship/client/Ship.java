package ch.bfh.ti.proj1.battleship.client;

public enum Ship {

	BATTLESHIP(5), SUBMARINE(4), DESTROYER(3), CRUISER(2);

	private int hits;
	private int size;
	private boolean sunk;
	private boolean placed;
	private int[][] positions;
	

	private Ship(int size) {
		this.hits = 0;
		this.size = size;
		this.sunk = false;
		this.placed = false;
		this.positions = null;
	}

	public int size() {
		return size;
	}

	public boolean isSunk(){
		return sunk;
	}
	
	public void shoot() {
		++hits;
		if(hits == size){
			sunk = true;
		}
	}
	
	public void setPlaced() {
		this.placed = true;
	}
	
	public boolean isPlaced() {
		return this.placed;
	}
	
	public int[][] getPositions() {
		return positions;
	}

	public void setPositions(int[][] positions) {
		this.positions = positions;
	}
	
}
