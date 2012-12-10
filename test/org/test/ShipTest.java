package org.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ch.bfh.ti.proj1.battleship.client.Field;
import ch.bfh.ti.proj1.battleship.client.Ship;
import ch.bfh.ti.proj1.battleship.client.ShipType;

public class ShipTest {

	@Test
	public void testShip(){
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
		
		Ship submarine = new Ship(ShipType.SUBMARINE);
		assertEquals(submarine.getSize(), 4);
		
		Ship destroyer = new Ship(ShipType.DESTROYER);
		assertEquals(destroyer.getSize(), 3);
		
		Ship cruiser = new Ship(ShipType.CRUISER);
		assertEquals(cruiser.getSize(), 2);
	}
	
	@Test
	public void testShipRemove(){
		Field f1 = new Field(0,0);
		Field f2 = new Field(1,1);
		
		Ship ship = new Ship(ShipType.BATTLESHIP);
		
		List<Field> l = ship.getPositions();
		assertFalse(l.contains(f1));
		
		f1.placeShip(ship);
		assertTrue(l.contains(f1));
		f2.placeShip(ship);
		assertTrue(l.contains(f2));
		f1.removeShip();
		assertFalse(l.contains(f1));
		f2.removeShip();
		assertFalse(l.contains(f2));
	}

}
