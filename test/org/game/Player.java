package org.game;

import ch.bfh.ti.proj1.battleship.client.Ship;

public class Player {

	private Game g;
	
	public Player() {
		g = new Game();
		g.startGame();
	}

	public void placeShip(Ship ship, int x, int y, int k) {
		g.placeShip(ship, x, y, k);
	}

	public void removeShip(int x , int y) {
		g.removeShip(x, y);
	}

	public void shootAt(int x, int y) {
		g.shootAt(x, y);
	}

}
