package org.game;

public class GameBoard {
	
	private PlayingField pf1;
	//private PlayingField pf2;

	public GameBoard() {
		pf1 = new PlayingField();
		//pf2 = new PlayingField();
	}

	public void placeShip(Ship ship, int x, int y, int k) {
		pf1.placeShip(ship, x, y, k);
	}

	public void removeShip(int x, int y) {
		pf1.removeShip(x, y);
	}

	public void shootAt(int x, int y) {
		pf1.shootAt(x, y);
	}

}
