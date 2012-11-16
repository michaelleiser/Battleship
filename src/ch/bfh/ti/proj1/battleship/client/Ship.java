package ch.bfh.ti.proj1.battleship.client;

import java.util.ArrayList;
import java.util.List;

public class Ship {

	private int hits;
	private ShipType type;
	private boolean sunk;
	private boolean placed;
	private List<Field> positions;	

	public Ship(ShipType type) {
		this.hits = 0;
		this.type = type;
		this.sunk = false;
		this.placed = false;
		this.positions = new ArrayList<Field>();
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
	
	public void setUnplaced(){
		this.placed  = false;
	}
	
	public boolean isPlaced() {
		return this.placed;
	}
	
	public void addPositions(Field f) {
		positions.add(f);
	}
	
	public void removePositions(Field f){
//		positions.remove(f);								// TODO funktioniert nicht?
		this.positions = new ArrayList<Field>();
	}
		
	public List<Field> getPositions() {
		return positions;
	}

	public ShipType getShipType(){
		return type;
	}

}
