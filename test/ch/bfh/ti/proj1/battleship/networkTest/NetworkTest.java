package ch.bfh.ti.proj1.battleship.networkTest;

import static org.junit.Assert.*;
import org.junit.Test;
import ch.bfh.ti.proj1.battleship.game.Game;

public class NetworkTest {

	@Test
	public void testHostGame0Port(){
		Game g1 = new Game();
		g1.enterName("Player 1");
		
		g1.hostGame(0);
		assertTrue(g1.getServer().isAvailable());
	}
	
	@Test
	public void testHostGame1023Port(){
		Game g1 = new Game();
		g1.enterName("Player 1");
		
		g1.hostGame(1023);
		assertTrue(g1.getServer().isAvailable());
	}
	
	@Test
	public void testHostGameLowestPort(){
		Game g1 = new Game();
		g1.enterName("Player 1");
		
		g1.hostGame(1024);
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
		
		g1.hostGame(21111);
		assertTrue(g1.getServer().isAvailable());
		
		Game g2 = new Game();
		g2.enterName("Player 2");
		
		g2.hostGame(21111);
		assertFalse(g2.getServer().isAvailable());
		
		g2.hostGame(21199);
		assertTrue(g2.getServer().isAvailable());
	}
	
	@Test
	public void testHostAndJoinGameChangingIPNotAnIP(){
		Game g1 = new Game();
		g1.enterName("Player 1");
		g1.hostGame(22222);

		Game g2 = new Game();
		g2.enterName("Player 2");
		
		g2.joinGame(22222, "thisIsNotAnIP");
		assertFalse(g2.getClient().isConnected());
	}
	
	@Test
	public void testHostAndJoinGameChangingIPUnreachableIP(){
		Game g1 = new Game();
		g1.enterName("Player 1");
		g1.hostGame(23333);

		Game g2 = new Game();
		g2.enterName("Player 2");
		
		g2.joinGame(23333, "1.2.3.4");
		assertFalse(g2.getClient().isConnected());
	}
	
	@Test
	public void testHostAndJoinGameChangingIPInvalidIP(){
		Game g1 = new Game();
		g1.enterName("Player 1");
		g1.hostGame(24444);

		Game g2 = new Game();
		g2.enterName("Player 2");
		
		g2.joinGame(24444, "999.888.777.666");
		assertFalse(g2.getClient().isConnected());
	}
	
	@Test
	public void testHostAndJoinGameChangingIPLocalhost(){
		Game g1 = new Game();
		g1.enterName("Player 1");
		g1.hostGame(25555);

		Game g2 = new Game();
		g2.enterName("Player 2");
			
		g2.joinGame(25555, "localhost");
		assertTrue(g2.getClient().isConnected());
	}
	
	@Test
	public void testHostAndJoinGameChangingIP127001(){
		Game g1 = new Game();
		g1.enterName("Player 1");
		g1.hostGame(26666);

		Game g2 = new Game();
		g2.enterName("Player 2");
			
		g2.joinGame(26666, "127.0.0.1");
		assertTrue(g2.getClient().isConnected());
	}
	
	@Test
	public void testHostAndJoinGameChangingPortInvalidPort(){
		Game g1 = new Game();
		g1.enterName("Player 1");
		g1.hostGame(27777);
		
		Game g2 = new Game();
		g2.enterName("Player 2");
		
		g2.joinGame(27799, "localhost");
		assertFalse(g2.getClient().isConnected());
	}

}
