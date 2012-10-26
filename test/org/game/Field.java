package org.game;

public class Field {

	Ship ship;
	boolean hit = false;
	
	public Field() {
	}
	
	public void placeShip(Ship ship) {
		this.ship = ship;
	}

	public boolean isHit() {
		return hit;
	}

	public void shoot() {
		this.ship.shoot();
		this.hit = true;
	}

}
