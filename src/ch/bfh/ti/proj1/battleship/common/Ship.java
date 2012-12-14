package ch.bfh.ti.proj1.battleship.common;

import java.util.ArrayList;
import java.util.List;

/**
 * A ship has a type, is placed on the playing field,
 * knows where it is placed and knows where it is hit (until sunk).
 * 
 * @author Michael Leiser
 * @author Daniel Kotlàris
 */
public class Ship {

	private ShipType type;
	private int hits;
	private boolean sunk;
	private List<Field> positions;	

	/**
	 * Constructor for a ship where type is the type of the ship.
	 * @param type
	 * 				the type of the ship including a certain size
	 */
	public Ship(ShipType type) {
		this.type = type;
		this.hits = 0;
		this.sunk = false;
		this.positions = new ArrayList<Field>();
	}

	/**
	 * Returns the type of the ship.
	 * @return
	 * 			the type of the ship
	 */
	public ShipType getShipType(){
		return type;
	}

	/**
	 * Returns the size of the ship.
	 * @return
	 * 			the size of the ship
	 */
	public int getSize() {
		return type.getSize();
	}

	/**
	 * Returns the status whether the ship is placed or not.
	 * @return
	 * 			{@code true} if the ship is placed.
	 */
	public boolean isPlaced() {
		return this.getSize() == this.positions.size();
	}

	/**
	 * Shoots at the ship. Counts the number of hits.
	 */
	public void shoot() {
		++hits;
		if(hits == getSize()){
			sunk = true;
		}
	}

	/**
	 * Returns the status if the ship is already sunk or not.
	 * @return
	 * 			{@code true} if the ship is sunk
	 */
	public boolean isSunk(){
		return sunk;
	}
	
	/**
	 * Adds the position of the {@code field} to the ship.
	 * @param field
	 * 				the field to add
	 */
	public void addPosition(Field field) {
		positions.add(field);
	}
	
	/**
	 * Removes the position of the {@code field} from the ship.
	 * @param field
	 * 				the field to remove
	 */
	public void removePosition(Field field){
		positions.remove(field);
	}
		
	/**
	 * Returns a {@code List} of positions, where the ship is placed on.
	 * @return
	 * 			List of positions
	 */
	public List<Field> getPositions() {
		return positions;
	}

}
