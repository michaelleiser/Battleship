package ch.bfh.ti.proj1.battleship.networkTest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import ch.bfh.ti.proj1.battleship.game.Game;
import ch.bfh.ti.proj1.battleship.game.GameMode;
import ch.bfh.ti.proj1.battleship.network.Client;
import ch.bfh.ti.proj1.battleship.network.Message;
import ch.bfh.ti.proj1.battleship.network.Server;

public class ConnectionTest {

	private Server s;
	private Client c1, c2;
	private Game g1, g2;
	
	@Before
	public void before(){
		s = new Server(4444);
		c1 = new Client(4444, "localhost");
		g1 = new Game();
		g1.showCoordinateFrame();
		c1.setGame(g1);
		c2 = new Client(4444, "localhost");
		g2 = new Game();
		g2.showCoordinateFrame();
		c2.setGame(g2);
	}
	
	@Test
	public void test() {
		assertTrue(g1.getNbrOfRows() == 10);
		assertTrue(g1.getNbrOfColoumns() == 10);
		assertTrue(g1.getNbrOfBattleships() == 1);
		assertTrue(g1.getNbrOfSubmarines() == 2);
		assertTrue(g1.getNbrOfDestroyers() == 3);
		assertTrue(g1.getNbrOfCruisers() == 4);
		
		g2.getClient().sendMessage(Message.COORDINATE_OPTIONS + " " + "20" + " " + "20" + " " + "2" + " " + "4" + " " + "6" + " " + "8" + " " + GameMode.ALTERNATIVELY);
		
		assertTrue(g1.getNbrOfRows() == 20);
	}

}
