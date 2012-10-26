package org.game;

public class Game {
	
	private GameBoard gb;
	
	public Game() {
		gb = new GameBoard();
	}

	public void startGame() {
		
	}

	public void placeShip(Ship ship, int x, int y, int k) {
		gb.placeShip(ship, x, y, k);
	}

	public void removeShip(int x, int y) {
		gb.removeShip(x, y);
	}

	public void shootAt(int x, int y) {
		gb.shootAt(x, y);
	}

}
