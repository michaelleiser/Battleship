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

	private static final long serialVersionUID = 3616779595167692632L;
	
	private Ship ship;
	private boolean hit = false;
	private int x;
	private int y;
	
	/**
	 * Constructor for the {@link Field} where {@code x} and {@code y} are the position of the field.
	 * @param x
	 * 			the x-coordinate on the playing field
	 * @param y
	 * 			the y-coordinate on the playing field
	 */
	public Field(int x, int y) {
		this.setBackground(Color.white);
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Places a {@link Ship} onto this {@link Field}.
	 * @param ship
	 * 				the {@link Ship} to place
	 */
	public void placeShip(Ship ship) {
		this.ship = ship;
		this.ship.addPosition(this);
		this.setBackground(Color.black);
	}
	
	/**
	 * Removes a {@link Ship} from this {@link Field}.
	 */
	public void removeShip(){
		this.ship.removePosition(this);
		this.ship = null;
		this.setBackground(Color.white);
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
		return hit;
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
		return x;
	}

	/**
	 * Returns the {@code y}-position of the {@link Field} in the playingfield.
	 * @return
	 * 			the y-coordinate on the playing field
	 */
	public int getYPos(){
		return y;
	}
	
}
