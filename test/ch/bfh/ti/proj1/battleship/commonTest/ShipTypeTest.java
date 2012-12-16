package ch.bfh.ti.proj1.battleship.commonTest;

import static org.junit.Assert.*;
import org.junit.Test;
import ch.bfh.ti.proj1.battleship.common.Ship;
import ch.bfh.ti.proj1.battleship.common.ShipType;

public class ShipTypeTest {

	@Test
	public void testBattleship() {
		Ship battleship = new Ship(ShipType.BATTLESHIP);
		assertEquals(battleship.getSize(), 5);
	}
	
	@Test
	public void testSubmarine() {
		Ship battleship = new Ship(ShipType.SUBMARINE);
		assertEquals(battleship.getSize(), 4);
	}
	
	@Test
	public void testDestroyer() {
		Ship battleship = new Ship(ShipType.DESTROYER);
		assertEquals(battleship.getSize(), 3);
	}
	
	@Test
	public void testCruiser() {
		Ship battleship = new Ship(ShipType.CRUISER);
		assertEquals(battleship.getSize(), 2);
	}

}
