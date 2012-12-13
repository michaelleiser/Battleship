package org.test;

import static org.junit.Assert.*;
import org.junit.Test;
import ch.bfh.ti.proj1.battleship.frame.Game;

public class NetworkTest {

	@Test
	public void testHostGameLowestPort(){
		Game g1 = new Game();
		g1.enterName("Player 1");
		
		g1.hostGame(0);
		assertTrue(g1.getServer().isAvailable());
	}
	
	@Test
	public void testHostGameHighestPort(){
		Game g1 = new Game();
		g1.enterName("Player 1");
		
		g1.hostGame(65535);
		assertTrue(g1.getServer().isAvailable());
	}
	
	@Test(expected = Exception.class)
	public void testHostGameOutOfBoundPort(){
		Game g1 = new Game();
		g1.enterName("Player 1");
		
		g1.hostGame(65536);
	}
	
	@Test
	public void testHostGameTwice(){
		Game g1 = new Game();
		g1.enterName("Player 1");
		
		g1.hostGame(5555);
		assertTrue(g1.getServer().isAvailable());
		
		Game g2 = new Game();
		g2.enterName("Player 2");
		
		g2.hostGame(5555);
		assertFalse(g2.getServer().isAvailable());
		
		g2.hostGame(6666);
		assertTrue(g2.getServer().isAvailable());
	}
	
	@Test
	public void testHostAndJoinGameChangingIPNotAnIP(){
		Game g1 = new Game();
		g1.enterName("Player 1");
		g1.hostGame(6666);

		Game g2 = new Game();
		g2.enterName("Player 2");
		
		g2.joinGame(6666, "thisIsNotAnIP");
		assertFalse(g2.getClient().isConnected());
	}
	
	@Test
	public void testHostAndJoinGameChangingIPUnreachableIP(){
		Game g1 = new Game();
		g1.enterName("Player 1");
		g1.hostGame(6666);

		Game g2 = new Game();
		g2.enterName("Player 2");
		
		g2.joinGame(6666, "1.2.3.4");
		assertFalse(g2.getClient().isConnected());
	}
	
	@Test
	public void testHostAndJoinGameChangingIPInvalidIP(){
		Game g1 = new Game();
		g1.enterName("Player 1");
		g1.hostGame(6666);

		Game g2 = new Game();
		g2.enterName("Player 2");
		
		g2.joinGame(6666, "999.888.777.666");
		assertFalse(g2.getClient().isConnected());
	}
	
	@Test
	public void testHostAndJoinGameChangingIPLocalhost(){
		Game g1 = new Game();
		g1.enterName("Player 1");
		g1.hostGame(6666);

		Game g2 = new Game();
		g2.enterName("Player 2");
			
		g2.joinGame(6666, "localhost");
		assertTrue(g2.getClient().isConnected());
	}
	
	@Test
	public void testHostAndJoinGameChangingIP127001(){
		Game g1 = new Game();
		g1.enterName("Player 1");
		g1.hostGame(6666);

		Game g2 = new Game();
		g2.enterName("Player 2");
			
		g2.joinGame(6666, "127.0.0.1");
		assertTrue(g2.getClient().isConnected());
	}
	
	@Test
	public void testHostAndJoinGameChangingPortInvalidPort(){
		Game g1 = new Game();
		g1.enterName("Player 1");
		g1.hostGame(7777);
		
		Game g2 = new Game();
		g2.enterName("Player 2");
		
		g2.joinGame(3333, "localhost");
		assertFalse(g2.getClient().isConnected());
	}

}
