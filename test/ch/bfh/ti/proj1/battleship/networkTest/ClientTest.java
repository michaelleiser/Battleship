package ch.bfh.ti.proj1.battleship.networkTest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import ch.bfh.ti.proj1.battleship.game.Game;
import ch.bfh.ti.proj1.battleship.network.Client;
import ch.bfh.ti.proj1.battleship.network.Server;

public class ClientTest {

	@Before
	public void before(){
		new Server(4444);
	}
	
	@Test
	public void test1() {
		Client c = new Client(4444, "localhost");
		c.setGame(new Game());
		assertFalse(c.isConnected());
	}
	
	@Test
	public void test2() {
		Client c1 = new Client(4444, "localhost");
		c1.setGame(new Game());
		assertFalse(c1.isConnected());
		
		Client c2 = new Client(4444, "localhost");
		c2.setGame(new Game());
		assertTrue(c1.isConnected());
		assertTrue(c2.isConnected());
	}

}
