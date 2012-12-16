package ch.bfh.ti.proj1.battleship.commonTest;

import static org.junit.Assert.*;
import org.junit.Test;
import ch.bfh.ti.proj1.battleship.common.Field;
import ch.bfh.ti.proj1.battleship.common.Ship;
import ch.bfh.ti.proj1.battleship.common.ShipType;

public class ShipTest {

	@Test
	public void testBattleship(){
		Ship battleship = new Ship(ShipType.BATTLESHIP);
		assertTrue(battleship.getShipType() == ShipType.BATTLESHIP);
		assertTrue(battleship.getSize() == 5);
	}

	@Test
	public void testSubmarine(){
		Ship battleship = new Ship(ShipType.SUBMARINE);
		assertTrue(battleship.getShipType() == ShipType.SUBMARINE);
		assertTrue(battleship.getSize() == 4);
	}

	@Test
	public void testDestroyer(){
		Ship battleship = new Ship(ShipType.DESTROYER);
		assertTrue(battleship.getShipType() == ShipType.DESTROYER);
		assertTrue(battleship.getSize() == 3);
	}

	@Test
	public void testCruiser(){
		Ship battleship = new Ship(ShipType.CRUISER);
		assertTrue(battleship.getShipType() == ShipType.CRUISER);
		assertTrue(battleship.getSize() == 2);
	}

	@Test
	public void testBattleshipIsSunk(){
		Ship battleship = new Ship(ShipType.BATTLESHIP);
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
	public void testSubmarineIsSunk(){
		Ship submarine = new Ship(ShipType.SUBMARINE);
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
	public void testDestroyerIsSunk(){		
		Ship destroyer = new Ship(ShipType.DESTROYER);
		assertFalse(destroyer.isSunk());
		destroyer.shoot();
		assertFalse(destroyer.isSunk());
		destroyer.shoot();
		assertFalse(destroyer.isSunk());
		destroyer.shoot();
		assertTrue(destroyer.isSunk());
	}
	
	@Test
	public void testCruiserIsSunk(){		
		Ship cruiser = new Ship(ShipType.CRUISER);
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
