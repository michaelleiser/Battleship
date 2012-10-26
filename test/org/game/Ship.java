package org.game;

public class Ship {
	
	int hits = 0;
	int size = 3;
	boolean sunk = false;
	
	public Ship() {
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

}
