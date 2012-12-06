package ch.bfh.ti.proj1.battleship.client;

import java.util.ArrayList;
import java.util.List;

public class Ship {

	private ShipType type;
	private int hits;
	private boolean sunk;
	private List<Field> positions;	

	public Ship(ShipType type) {
		this.type = type;
		this.hits = 0;
		this.sunk = false;
		this.positions = new ArrayList<Field>();
	}

	public ShipType getShipType(){
		return type;
	}

	public int getSize() {
		return type.getSize();
	}

	public boolean isPlaced() {
		return this.getSize() == this.positions.size();
	}

	public void shoot() {
		++hits;
		if(hits == getSize()){
			sunk = true;
		}
	}

	public boolean isSunk(){
		return sunk;
	}
	
	public void addPosition(Field f) {
		positions.add(f);
	}
	
	public void removePosition(Field f){
//		positions.remove(f);								// TODO funktioniert nicht?
		this.positions = new ArrayList<Field>();
	}
		
	public List<Field> getPositions() {
		return positions;
	}

}
