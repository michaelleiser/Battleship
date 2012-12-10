package org.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.bfh.ti.proj1.battleship.frame.Game;

public class GameTest {

	@Test
	public void testGame(){
		Game g = new Game();
		g.enterName("hell");
		g.hostGame(4444);
		
		Game g2 = new Game();
		g2.enterName("he");
		
		g2.joinGame(3333, "localhost");
		assertFalse(g2.getClient().isConnected());
		
		g2.joinGame(4444, "thisIsNotAnIP");
		assertFalse(g2.getClient().isConnected());
		
		g2.joinGame(4444, "localhost");
		assertTrue(g2.getClient().isConnected());
	}

}
