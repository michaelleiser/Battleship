package org.test;

import org.junit.Test;
import ch.bfh.ti.proj1.battleship.frame.Game;

public class GameTest {
	
	@Test
	public void testHostGame(){
		Game g1 = new Game();
		g1.enterName("Player 1");
		g1.hostGame(4444);
		
		Game g2 = new Game();
		g2.enterName("Player 1");
		g2.joinGame(4444, "localhost");
		
		
		
	}
	

}
