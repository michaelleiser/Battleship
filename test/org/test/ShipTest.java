package org.test;

import static org.junit.Assert.*;
import org.junit.Test;
import ch.bfh.ti.proj1.battleship.client.Field;
import ch.bfh.ti.proj1.battleship.client.Ship;
import ch.bfh.ti.proj1.battleship.client.ShipType;

public class ShipTest {

	@Test
	public void testBattleship(){
		Ship battleship = new Ship(ShipType.BATTLESHIP);
		assertEquals(battleship.getSize(), 5);
		
		assertFalse(battleship.isSunk());
		
		battleship.shoot();
		assertFalse(battleship.isSunk());
		
		battleship.shoot();
		assertFalse(battleship.isSunk());
		
		battleship.shoot();
		assertFalse(battleship.isSunk());
		
		battleship.shoot();
		assertFalse(battleship.isSunk());
		
		battleship.shoot();
		assertTrue(battleship.isSunk());
	}
	
	@Test
	public void testSubmarine(){
		Ship submarine = new Ship(ShipType.SUBMARINE);
		assertEquals(submarine.getSize(), 4);
		
		assertFalse(submarine.isSunk());
		
		submarine.shoot();
		assertFalse(submarine.isSunk());
		
		submarine.shoot();
		assertFalse(submarine.isSunk());
		
		submarine.shoot();
		assertFalse(submarine.isSunk());
		
		submarine.shoot();
		assertTrue(submarine.isSunk());
	}
	
	@Test
	public void testDestroyer(){		
		Ship destroyer = new Ship(ShipType.DESTROYER);
		assertEquals(destroyer.getSize(), 3);
		
		assertFalse(destroyer.isSunk());
		
		destroyer.shoot();
		assertFalse(destroyer.isSunk());
		
		destroyer.shoot();
		assertFalse(destroyer.isSunk());
		
		destroyer.shoot();
		assertTrue(destroyer.isSunk());
	}
	
	@Test
	public void testCruiser(){		
		Ship cruiser = new Ship(ShipType.CRUISER);
		assertEquals(cruiser.getSize(), 2);
		
		assertFalse(cruiser.isSunk());
		
		cruiser.shoot();
		assertFalse(cruiser.isSunk());
		
		cruiser.shoot();
		assertTrue(cruiser.isSunk());
	}
	
	@Test
	public void testAddPosition(){		
		Ship ship = new Ship(ShipType.BATTLESHIP);
		
		assertFalse(ship.isPlaced());
		
		ship.addPosition(new Field(0,0));
		assertFalse(ship.isPlaced());
		
		ship.addPosition(new Field(0,0));
		assertFalse(ship.isPlaced());
		
		ship.addPosition(new Field(0,0));
		assertFalse(ship.isPlaced());
		
		ship.addPosition(new Field(0,0));
		assertFalse(ship.isPlaced());
		
		ship.addPosition(new Field(0,0));
		assertTrue(ship.isPlaced());
	}
	
	
	@Test
	public void testAddRemovePosition(){
		Ship ship = new Ship(ShipType.BATTLESHIP);
		
		assertFalse(ship.isPlaced());
		
		Field f1 = new Field(0,0);
		ship.addPosition(f1);
		assertFalse(ship.isPlaced());
		
		Field f2 = new Field(0,0);
		ship.addPosition(f2);
		assertFalse(ship.isPlaced());
		
		Field f3 = new Field(0,0);
		ship.addPosition(f3);
		assertFalse(ship.isPlaced());
		
		Field f4 = new Field(0,0);
		ship.addPosition(f4);
		assertFalse(ship.isPlaced());
		
		Field f5 = new Field(0,0);
		ship.addPosition(f5);
		assertTrue(ship.isPlaced());
		
		ship.removePosition(f5);
		assertFalse(ship.isPlaced());
		
		ship.addPosition(f5);
		assertTrue(ship.isPlaced());
	}

}
