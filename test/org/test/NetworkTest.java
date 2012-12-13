package org.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.bfh.ti.proj1.battleship.frame.Game;

public class NetworkTest {

	@Test
	public void testHostGame(){
		Game g1 = new Game();
		g1.enterName("Player 1");
		
		g1.hostGame(0);
		assertFalse(g1.getServer().isAvailable());
		
		g1.hostGame(123);
		assertFalse(g1.getServer().isAvailable());
		
		g1.hostGame(65536);
		assertFalse(g1.getServer().isAvailable());
		
		g1.hostGame(4444);
		assertTrue(g1.getServer().isAvailable());
	}
	
	@Test
	public void testHostGameTwice(){
		Game g1 = new Game();
		g1.enterName("Player 1");
		
		g1.hostGame(5555);
		assertTrue(g1.getClient().isConnected());
		
		Game g2 = new Game();
		g2.enterName("Player 2");
		
		g2.hostGame(5555);
		assertFalse(g2.getClient().isConnected());
		
		g2.hostGame(6666);
		assertTrue(g2.getClient().isConnected());
	}
	
	@Test
	public void testHostAndJoinGameChangingIP(){
		Game g1 = new Game();
		g1.enterName("Player 1");
		
		g1.hostGame(6666);
		assertTrue(g1.getClient().isConnected());
		Game g2 = new Game();
		g2.enterName("Player 2");
		
		g2.joinGame(6666, "thisIsNotAnIP");
		assertFalse(g2.getClient().isConnected());
		
		g2.joinGame(6666, "1.2.3.4");
		assertFalse(g2.getClient().isConnected());
		
		g2.joinGame(6666, "localhost");
		assertTrue(g2.getClient().isConnected());
	}
	
	@Test
	public void testHostAndJoinGameChangingPort(){
		Game g1 = new Game();
		g1.enterName("Player 1");
		
		g1.hostGame(7777);
		assertTrue(g1.getClient().isConnected());
		Game g2 = new Game();
		g2.enterName("Player 2");
		
		g2.joinGame(3333, "localhost");
		assertFalse(g2.getClient().isConnected());
		
		g2.joinGame(7777, "thisIsNotAnIP");
		assertFalse(g2.getClient().isConnected());
		
		g2.joinGame(7777, "1.2.3.4");
		assertFalse(g2.getClient().isConnected());
		
		g2.joinGame(7777, "localhost");
		assertTrue(g2.getClient().isConnected());
	}

}
