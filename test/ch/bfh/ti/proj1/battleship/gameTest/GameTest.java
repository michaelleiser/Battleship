package ch.bfh.ti.proj1.battleship.gameTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.bfh.ti.proj1.battleship.common.ShipType;
import ch.bfh.ti.proj1.battleship.game.Game;
import ch.bfh.ti.proj1.battleship.game.GameMode;

public class GameTest {
	
	@Test
	public void testPlaceShips(){
		Game g1 = new Game();
		g1.enterName("Player 1");
		g1.hostGame(11111);
		g1.setOptions(10, 10, 1, 1, 1, 1, GameMode.ALTERNATIVELY);
		g1.showGameFrame();
		
//		Game g2 = new Game();
//		g2.enterName("Player 1");
//		g2.joinGame(4444, "localhost");
//		g2.setOptions(10, 10, 1, 1, 1, 1, GameMode.ALTERNATIVELY);
//		g2.showGameFrame();
		
		assertFalse(g1.allShipsPlaced());
		g1.placeShip(ShipType.BATTLESHIP, 0, 0, 0);
		g1.placeShip(ShipType.SUBMARINE, 0, 2, 0);
		g1.placeShip(ShipType.DESTROYER, 0, 4, 0);
		g1.placeShip(ShipType.CRUISER, 0, 6, 0);
		assertTrue(g1.allShipsPlaced());
	}
	
	@Test
	public void testPlaceShipsOnSamePosition(){
		Game g1 = new Game();
		g1.enterName("Player 1");
		g1.hostGame(12222);
		g1.setOptions(10, 10, 1, 1, 1, 1, GameMode.ALTERNATIVELY);
		g1.showGameFrame();
		
		assertFalse(g1.allShipsPlaced());
		g1.placeShip(ShipType.BATTLESHIP, 0, 0, 0);
		g1.placeShip(ShipType.SUBMARINE, 0, 0, 0);
		g1.placeShip(ShipType.DESTROYER, 0, 0, 0);
		g1.placeShip(ShipType.CRUISER, 0, 0, 0);
		assertFalse(g1.allShipsPlaced());
	}
	
	@Test
	public void testPlaceShipsRemoveShips(){
		Game g1 = new Game();
		g1.enterName("Player 1");
		g1.hostGame(13333);
		g1.setOptions(10, 10, 1, 1, 1, 1, GameMode.ALTERNATIVELY);
		g1.showGameFrame();
		
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
		Game g1 = new Game();
		g1.enterName("Player 1");
		g1.hostGame(14444);
		g1.setOptions(10, 10, 1, 1, 1, 1, GameMode.ALTERNATIVELY);
		g1.showGameFrame();
		
		g1.placeShip(ShipType.BATTLESHIP, 0, 0, 0);
		g1.placeShip(ShipType.SUBMARINE, 0, 2, 0);
		g1.placeShip(ShipType.DESTROYER, 0, 4, 0);
		g1.placeShip(ShipType.CRUISER, 0, 6, 0);

		
	}
	
	

}
