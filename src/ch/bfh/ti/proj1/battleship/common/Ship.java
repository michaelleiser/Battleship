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
	 * Constructor for a {@link Ship} where type is the {@link ShipType}.
	 * @param type
	 * 				the type of the {@link Ship} including a certain size
	 */
	public Ship(ShipType type) {
		this.type = type;
		this.hits = 0;
		this.sunk = false;
		this.positions = new ArrayList<Field>();
	}

	/**
	 * Returns the {@link ShipType}.
	 * @return
	 * 			the type of the {@link Ship}
	 */
	public ShipType getShipType(){
		return this.type;
	}

	/**
	 * Returns the size of the {@link Ship}.
	 * @return
	 * 			the size of the {@link Ship}
	 */
	public int getSize() {
		return this.type.getSize();
	}

	/**
	 * Returns the status whether the {@link Ship} is placed or not.
	 * @return
	 * 			{@code true} if the {@link Ship} is placed.
	 */
	public boolean isPlaced() {
		return this.getSize() == this.positions.size();
	}

	/**
	 * Shoots at the {@link Ship}. Counts the number of hits.
	 */
	public void shoot() {
		++this.hits;
		if(this.hits == getSize()){
			this.sunk = true;
		}
	}

	/**
	 * Returns the status if the {@link Ship} is already sunk or not.
	 * @return
	 * 			{@code true} if the {@link Ship} is sunk
	 */
	public boolean isSunk(){
		return sunk;
	}
	
	/**
	 * Adds the position of the {@link Field} to the {@link Ship}.
	 * @param field
	 * 				the {@link Field} to add
	 */
	public void addPosition(Field field) {
		positions.add(field);
	}
	
	/**
	 * Removes the position of the {@link Field} from the {@link Ship}.
	 * @param field
	 * 				the {@link Field} to remove
	 */
	public void removePosition(Field field){
		positions.remove(field);
	}
		
	/**
	 * Returns a {@link List} of positions, where the {@link Ship} is placed on.
	 * @return
	 * 			{@link List} of positions
	 */
	public List<Field> getPositions() {
		return positions;
	}

}
