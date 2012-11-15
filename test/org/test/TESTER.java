package org.test;

import static org.junit.Assert.*;

import org.junit.Test;

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
		assertEquals(battleship.size(), 5);
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
		assertEquals(submarine.size(), 4);
		
		Ship destroyer = new Ship(ShipType.DESTROYER);
		assertEquals(destroyer.size(), 3);
		
		Ship cruiser = new Ship(ShipType.CRUISER);
		assertEquals(cruiser.size(), 2);
	}

}
