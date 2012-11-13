package ch.bfh.ti.proj1.battleship.client;

import javax.swing.JToggleButton;

import org.game.Ship;

public class Field extends JToggleButton {

	private static final long serialVersionUID = 3616779595167692632L;
	
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
	
	public Ship getShip() {
		return this.ship;
	}

}
