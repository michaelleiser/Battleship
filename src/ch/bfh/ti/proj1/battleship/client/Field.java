package ch.bfh.ti.proj1.battleship.client;

import javax.swing.JToggleButton;


public class Field extends JToggleButton {

	private static final long serialVersionUID = 3616779595167692632L;
	
	private Ship ship;
	private boolean hit = false;
	int x;
	int y;
	
	public Field(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void placeShip(Ship ship) {
		this.ship = ship;
		this.setSelected(true);
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
	
	public int getXPos(){
		return x;
	}

	public int getYPos(){
		return y;
	}
}
