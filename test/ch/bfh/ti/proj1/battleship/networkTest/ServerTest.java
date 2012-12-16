package ch.bfh.ti.proj1.battleship.networkTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.bfh.ti.proj1.battleship.network.Server;

public class ServerTest {

	@Test
	public void testLowestPort() {
		Server s = new Server(0);
		assertTrue(s.isAvailable());
	}
	
	@Test
	public void testHighestPort() {
		Server s = new Server(65535);
		assertTrue(s.isAvailable());
	}
	
	@Test (expected = Exception.class)
	public void testInvaliPortIllegalArgumentException() {
		Server s = new Server(65536);
		assertFalse(s.isAvailable());
	}

}
