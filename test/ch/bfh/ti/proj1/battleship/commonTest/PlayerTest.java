package ch.bfh.ti.proj1.battleship.commonTest;

import static org.junit.Assert.*;
import org.junit.Test;
import ch.bfh.ti.proj1.battleship.common.Player;

public class PlayerTest {

	@Test
	public void test() {
		Player p = new Player("Player");
		p.setName("New Player");
		assertTrue(p.getName().equals("New Player"));
	}

}
