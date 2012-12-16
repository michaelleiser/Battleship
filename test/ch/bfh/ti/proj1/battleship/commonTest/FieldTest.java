package ch.bfh.ti.proj1.battleship.commonTest;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import ch.bfh.ti.proj1.battleship.common.Field;
import ch.bfh.ti.proj1.battleship.common.Ship;
import ch.bfh.ti.proj1.battleship.common.ShipType;

public class FieldTest {

	@Test
	public void testFieldxy1(){
		Field f = new Field(0, 1);
		assertTrue(f.getXPos() == 0);
		assertTrue(f.getYPos() == 1);
	}
	
	@Test
	public void testFieldxy2(){
		Field f = new Field(2, 1);
		assertTrue(f.getXPos() == 2);
		assertTrue(f.getYPos() == 1);
	}
	
	@Test
	public void testShootOnEmptyField(){
		Field f = new Field(0, 0);
		assertFalse(f.isHit());
		f.shoot();
		assertTrue(f.isHit());
	}
	
	@Test
	public void testShootOnCoveredField(){
		Field f = new Field(0, 0);
		f.placeShip(new Ship(ShipType.BATTLESHIP));
		assertFalse(f.isHit());
		f.shoot();
		assertTrue(f.isHit());
	}

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
	public void testGetShip(){
		Field f = new Field(0, 0);
		assertTrue(f.getShip() == null);
		f.placeShip(new Ship(ShipType.BATTLESHIP));
		assertTrue(f.getShip() != null);
	}
	
	@Test
	public void testPlaceRemoveShip(){
		Field f1 = new Field(0, 0);
		Field f2 = new Field(0, 0);
		Ship ship = new Ship(ShipType.CRUISER);
		assertFalse(ship.isPlaced());
		f1.placeShip(ship);
		assertFalse(ship.isPlaced());
		f2.placeShip(ship);
		assertTrue(ship.isPlaced());
		f1.removeShip();
		assertFalse(ship.isPlaced());
		f2.removeShip();
		assertFalse(ship.isPlaced());
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
