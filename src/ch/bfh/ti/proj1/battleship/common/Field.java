package ch.bfh.ti.proj1.battleship.common;

import java.awt.Color;
import javax.swing.JButton;

/**
 * This is a field of the playing field.
 * It can contain a {@link Ship} and the other {@link Player} can shoot on it.
 * 
 * @author Daniel Kotlàris
 * @author Michael Leiser
 */
public class Field extends JButton {
	
	private static final long serialVersionUID = 1L;
	
	private int x;
	private int y;
	private boolean hit;
	private Ship ship;
	
	/**
	 * Constructor for the {@link Field} where {@code x} and {@code y} are the position of the field.
	 * @param x
	 * 			the x-coordinate on the playing field
	 * @param y
	 * 			the y-coordinate on the playing field
	 */
	public Field(int x, int y) {
		this.x = x;
		this.y = y;
		this.hit = false;
		this.setBackground(Color.white);
	}
	
	/**
	 * Places a {@link Ship} onto this {@link Field}.
	 * @param ship
	 * 				the {@link Ship} to place
	 */
	public void placeShip(Ship ship) {
		if(this.ship == null){
			this.ship = ship;
			this.ship.addPosition(this);
			this.setBackground(Color.black);
		}
	}
	
	/**
	 * Removes a {@link Ship} from this {@link Field}.
	 */
	public void removeShip(){
		if(this.ship != null){
			this.ship.removePosition(this);
			this.ship = null;
			this.setBackground(Color.white);
		}
	}

	/**
	 * Shoots at the {@link Ship} that is placed on this {@link Field}.
	 * Sets the hit flag to true.
	 */
	public void shoot() {
		if(this.ship != null){
			this.ship.shoot();
		}
		this.hit = true;
	}

	/**
	 * Sets the hit status flag to true.
	 */
	public void hit() {
		this.hit = true;
	}

	/**
	 * Returns the status of the {@link Field} if it is already hit.
	 * @return
	 * 			{@code true} if the {@link Field} is already hit
	 */
	public boolean isHit() {
		return this.hit;
	}

	/**
	 * Returns the {@link Ship} that is placed on this {@link Field}.
	 * @return
	 * 			the ship that is placed on this {@link Field}
	 */
	public Ship getShip() {
		return this.ship;
	}
	
	/**
	 * Returns the {@code x}-coordinate of the {@link Field} in the playingfield.
	 * @return
	 * 			the x-coordinate on the playing field
	 */
	public int getXPos(){
		return this.x;
	}

	/**
	 * Returns the {@code y}-position of the {@link Field} in the playingfield.
	 * @return
	 * 			the y-coordinate on the playing field
	 */
	public int getYPos(){
		return this.y;
	}
	
}
