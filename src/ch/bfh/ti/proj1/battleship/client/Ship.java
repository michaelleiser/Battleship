package ch.bfh.ti.proj1.battleship.client;

import java.util.ArrayList;
import java.util.List;

public class Ship {

	private ShipType type;
	private int hits;
	private boolean sunk;
	private List<Field> positions;	

	/**
	 * Constructor for a ship where type is the type of the ship.
	 * @param type
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
	 * 			shiptype
	 */
	public ShipType getShipType(){
		return type;
	}

	/**
	 * Returns the size of the ship.
	 * @return
	 * 			size
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
	 * Shoots at the ship.
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
	 */
	public void addPosition(Field field) {
		positions.add(field);
	}
	
	/**
	 * Removes the position of the {@code field} from the ship.
	 * @param field
	 */
	public void removePosition(Field field){
//		positions.remove(field);								// TODO funktioniert nicht?
		this.positions = new ArrayList<Field>();
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
