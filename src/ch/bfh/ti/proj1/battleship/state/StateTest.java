package ch.bfh.ti.proj1.battleship.state;

import org.junit.Test;
import static org.junit.Assert.*;

public class StateTest {

	@Test
	public void test() {
		Context c = new Context();
		assertTrue(c.getState() instanceof Idle);
		
		c.handle(Context.EventType.SelectGameType);
		assertTrue(c.getState() instanceof PlaceShips);
		
		c.handle(Context.EventType.Ready);
		assertTrue(c.getState() instanceof Start);
		
		c.handle(Context.EventType.Start);
		assertTrue(c.getState() instanceof Player1Turn);
		
		c.handle(Context.EventType.Hit);
		assertTrue(c.getState() instanceof Player1Turn);
		
		c.handle(Context.EventType.Sunk);
		assertTrue(c.getState() instanceof Player1Turn);
		
		c.handle(Context.EventType.Water);
		assertTrue(c.getState() instanceof Player2Turn);
		
		c.handle(Context.EventType.Hit);
		assertTrue(c.getState() instanceof Player2Turn);
		
		c.handle(Context.EventType.Sunk);
		assertTrue(c.getState() instanceof Player2Turn);
		
		c.handle(Context.EventType.Water);
		assertTrue(c.getState() instanceof Player1Turn);
		
		c.handle(Context.EventType.Won);
		assertTrue(c.getState() instanceof GameOver);
		
		c.handle(Context.EventType.Restart);
		assertTrue(c.getState() instanceof Idle);
		
	}

}
