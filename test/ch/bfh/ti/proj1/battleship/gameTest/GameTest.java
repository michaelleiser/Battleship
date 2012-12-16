package ch.bfh.ti.proj1.battleship.gameTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import ch.bfh.ti.proj1.battleship.common.ShipType;
import ch.bfh.ti.proj1.battleship.game.Game;
import ch.bfh.ti.proj1.battleship.game.GameMode;

public class GameTest {
	
	private Game g1;
	
	@Before
	public void before(){
		g1 = new Game();
		g1.enterName("Player 1");
		g1.hostGame(11111);
		g1.setOptions(10, 10, 1, 1, 1, 1, GameMode.ALTERNATIVELY);
		g1.showGameFrame();
	}
	
	@Test
	public void testPlaceShips(){
		assertFalse(g1.allShipsPlaced());
		g1.placeShip(ShipType.BATTLESHIP, 0, 0, 0);
		g1.placeShip(ShipType.SUBMARINE, 0, 2, 0);
		g1.placeShip(ShipType.DESTROYER, 0, 4, 0);
		g1.placeShip(ShipType.CRUISER, 0, 6, 0);
		assertTrue(g1.allShipsPlaced());
	}
	
	@Test
	public void testPlaceShipsOnSamePosition(){
		assertFalse(g1.allShipsPlaced());
		g1.placeShip(ShipType.BATTLESHIP, 0, 0, 0);
		g1.placeShip(ShipType.SUBMARINE, 0, 0, 0);
		g1.placeShip(ShipType.DESTROYER, 0, 0, 0);
		g1.placeShip(ShipType.CRUISER, 0, 0, 0);
		assertFalse(g1.allShipsPlaced());
	}
	
	@Test
	public void testPlaceShipsRemoveShips(){
		assertFalse(g1.allShipsPlaced());
		g1.placeShip(ShipType.BATTLESHIP, 0, 0, 0);
		g1.placeShip(ShipType.SUBMARINE, 0, 2, 0);
		g1.placeShip(ShipType.DESTROYER, 0, 4, 0);
		g1.placeShip(ShipType.CRUISER, 0, 6, 0);
		assertTrue(g1.allShipsPlaced());
		
		g1.removeShip(0, 0);
		assertFalse(g1.allShipsPlaced());
		
		g1.placeShip(ShipType.BATTLESHIP, 0, 8, 0);
		assertTrue(g1.allShipsPlaced());
		
		g1.removeShip(0, 2);
		assertFalse(g1.allShipsPlaced());
		
		g1.placeShip(ShipType.SUBMARINE, 0, 0, 0);
		assertTrue(g1.allShipsPlaced());
	}
	
	@Test
	public void testShoot(){
		g1.placeShip(ShipType.BATTLESHIP, 0, 0, 0);
		g1.placeShip(ShipType.SUBMARINE, 0, 2, 0);
		g1.placeShip(ShipType.DESTROYER, 0, 4, 0);
		g1.placeShip(ShipType.CRUISER, 0, 6, 0);
		assertFalse(g1.allShipsSunk());
		
		g1.checkShoot(0, 0);
		g1.checkShoot(1, 0);
		g1.checkShoot(2, 0);
		g1.checkShoot(3, 0);
		g1.checkShoot(4, 0);
		assertFalse(g1.allShipsSunk());
		
		g1.checkShoot(0, 2);
		g1.checkShoot(1, 2);
		g1.checkShoot(2, 2);
		g1.checkShoot(3, 2);
		assertFalse(g1.allShipsSunk());
		
		g1.checkShoot(0, 4);
		g1.checkShoot(1, 4);
		g1.checkShoot(2, 4);
		assertFalse(g1.allShipsSunk());
		
		g1.checkShoot(0, 6);
		g1.checkShoot(1, 6);
		assertTrue(g1.allShipsSunk());
	}
	
	

}
