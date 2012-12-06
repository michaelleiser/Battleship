package org.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ch.bfh.ti.proj1.battleship.client.Field;
import ch.bfh.ti.proj1.battleship.client.Ship;
import ch.bfh.ti.proj1.battleship.client.ShipType;
import ch.bfh.ti.proj1.battleship.frame.Game;

public class TESTER {

	@Test
	public void test() {
//		
//		Game g = new Game();
//		g.showNetworkFrame();
//		g.hostGame(4444);
//		g.showCoordinateFrame();
//		g.showGameFrame();
//		
//		Game g2 = new Game();
//		g2.showNetworkFrame();
//		g2.joinGame(4444, "localhost");
//		g2.showCoordinateFrame();
//		g2.showGameFrame();
//		
//		Ship ship = new Ship(ShipType.BATTLESHIP);
//		assertFalse(ship.isPlaced());
//		g.placeShip(ship, 0, 0, 0);	
//		assertTrue(ship.isPlaced());
		
	}
	
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
	public void testField(){
		Field f = new Field(0, 0);
		f.placeShip(new Ship(ShipType.BATTLESHIP));
		assertFalse(f.isHit());
		f.shoot();
		assertTrue(f.isHit());
	}
	
	@Test
	public void testGame(){
		Game g = new Game();
		g.showNetworkFrame();
		g.enterName("hell");
		g.hostGame(4444);
		Game g2 = new Game();
		g2.showNetworkFrame();
		g2.enterName("he");
		
		assertFalse(g2.getClient().isConnected());
		g2.joinGame(4444, "localhost");
		assertTrue(g2.getClient().isConnected());
		
		
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
