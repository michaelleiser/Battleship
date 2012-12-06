package ch.bfh.ti.proj1.battleship.client;

import java.awt.Color;

import javax.swing.JButton;

/**
 * @author Daniel Kotlàris
 * @author Michael Leiser
 */
public class Field extends JButton {

	private static final long serialVersionUID = 3616779595167692632L;
	
	private Ship ship;
	private boolean hit = false;
	private int x;
	private int y;
	
	/**
	 * Constructor for the field where {@code x} and {@code y} are the position of the field.
	 * @param x
	 * @param y
	 */
	public Field(int x, int y) {
		this.setBackground(Color.white);
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Places a {@code ship} onto this field.
	 * @param ship
	 */
	public void placeShip(Ship ship) {
		this.ship = ship;
		this.ship.addPosition(this);
		this.setSelected(true);
		this.setBackground(Color.black);
	}
	
	/**
	 * Removes a ship from this field.
	 */
	public void removeShip(){
		this.setBackground(Color.white);
		this.setSelected(false);
		this.ship.removePosition(this);
		this.ship = null;
	}

	/**
	 * Shoots at the ship that is placed on this field.
	 * Sets the hit flag to true.
	 */
	public void shoot() {
		this.ship.shoot();
		this.hit = true;
	}

	/**
	 * Sets the hit status flag to true.
	 */
	public void hit() {
		this.hit = true;
	}

	/**
	 * Returns the status of the field if it is already hit.
	 * @return
	 * 			{@code true} if the field is already hit
	 */
	public boolean isHit() {
		return hit;
	}

	/**
	 * Returns the {@code ship} that is placed on this field.
	 * @return
	 * 			ship
	 */
	public Ship getShip() {
		return this.ship;
	}
	
	/**
	 * Returns the {@code x}-position of the field in the playingfield.
	 * @return
	 * 			x-position
	 */
	public int getXPos(){
		return x;
	}

	/**
	 * Returns the {@code y}-position of the field in the playingfield.
	 * @return
	 * 			y-position
	 */
	public int getYPos(){
		return y;
	}
	
}
