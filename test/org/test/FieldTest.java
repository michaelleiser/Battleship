package org.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ch.bfh.ti.proj1.battleship.client.Field;
import ch.bfh.ti.proj1.battleship.client.Ship;
import ch.bfh.ti.proj1.battleship.client.ShipType;

public class FieldTest {

	@Test
	public void testPlaceShip(){
		Ship ship = new Ship(ShipType.BATTLESHIP);
		assertFalse(ship.isPlaced());
		new Field(0, 0).placeShip(ship);
		new Field(0, 0).placeShip(ship);
		new Field(0, 0).placeShip(ship);
		new Field(0, 0).placeShip(ship);
		new Field(0, 0).placeShip(ship);
		assertTrue(ship.isPlaced());
	}
	
	@Test
	public void testPlaceRemoveShip(){
		Field f1 = new Field(0, 0);
		Field f2 = new Field(0, 0);
		Ship ship = new Ship(ShipType.CRUISER);
		assertFalse(ship.isPlaced());
		f1.placeShip(ship);
		f2.placeShip(ship);
		assertTrue(ship.isPlaced());
		f1.removeShip();
		f2.removeShip();
		assertFalse(ship.isPlaced());
	}
	
	@Test
	public void testHitShip(){
		Field f = new Field(0, 0);
		f.placeShip(new Ship(ShipType.BATTLESHIP));
		assertFalse(f.isHit());
		f.shoot();
		assertTrue(f.isHit());
	}
	
	@Test
	public void testGetPositions(){
		Field f1 = new Field(0,0);
		Field f2 = new Field(1,1);
		
		Ship ship = new Ship(ShipType.CRUISER);
		
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
