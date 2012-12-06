package ch.bfh.ti.proj1.battleship.client;

import java.awt.Color;

import javax.swing.JToggleButton;

public class Field extends JToggleButton {

	private static final long serialVersionUID = 3616779595167692632L;
	
	private Ship ship;
	private boolean hit = false;
	private int x;
	private int y;
	
	public Field(int x, int y) {
		this.setBackground(Color.white);
		this.x = x;
		this.y = y;
	}
	
	public void placeShip(Ship ship) {
		this.ship = ship;
		this.ship.addPosition(this);
		this.setSelected(true);
		this.setBackground(Color.black);
	}
	
	public void removeShip(){
		this.setBackground(Color.white);
		this.setSelected(false);
		this.ship.removePosition(this);
		this.ship = null;
	}

	public void shoot() {
		this.ship.shoot();
		this.hit = true;
	}

	public void hit() {
		this.hit = true;
	}

	public boolean isHit() {
		return hit;
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
