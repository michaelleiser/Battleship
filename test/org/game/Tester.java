package org.game;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tester {

	@Test
	public void test() {
		Player p1 = new Player();
		//Player p2 = new Player();
		
		Ship s = new Ship();
		
		p1.placeShip(s, 0, 0, 0);
		p1.removeShip(0, 0);
		p1.shootAt(0, 0);
		p1.shootAt(1, 0);
		p1.shootAt(2, 0);
		assertTrue(s.isSunk());
	}

}
