package org.game;

public class PlayingField {

	private Field[][] fields;

	public PlayingField() {
		fields = new Field[10][10];
		init();
	}

	private void init() {
		for(int i = 0 ; i < 10 ; i++){
			for(int j = 0 ; j < 10 ; j++){
				fields[i][j] = new Field();
			}
		}
	}

	public void placeShip(Ship ship, int x, int y, int k) {
		if (k == 0) {
			for (int i = 0; i < ship.size(); i++) {
				fields[x+i][y].placeShip(ship);
			}
		} else if (k == 1) {
			for (int i = 0; i < ship.size(); i++) {
				fields[x][y+i].placeShip(ship);
			}
		}
	}

	public void removeShip(int x, int y) {

	}

	public void shootAt(int x, int y) {
		Field f = fields[x][y];
		if(!f.isHit()){
			f.shoot();
		}
	}


}
