package ch.bfh.ti.proj1.battleship.client;

public class Ship {

	private int hits;
	private ShipType type;
	private boolean sunk;
	private boolean placed;
	private int[][] positions;	

	public Ship(ShipType type) {
		this.hits = 0;
		this.type = type;
		this.sunk = false;
		this.placed = false;
		this.positions = null;
	}

	public int size() {
		return type.getSize();
	}

	public boolean isSunk(){
		return sunk;
	}
	
	public void shoot() {
		++hits;
		if(hits == type.getSize()){
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
	
	public ShipType getShipType(){
		return type;
	}
}
