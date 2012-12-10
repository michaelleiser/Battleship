package org.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.bfh.ti.proj1.battleship.client.Field;
import ch.bfh.ti.proj1.battleship.client.Ship;
import ch.bfh.ti.proj1.battleship.client.ShipType;

public class FieldTest {

	@Test
	public void testField(){
		Field f = new Field(0, 0);
		f.placeShip(new Ship(ShipType.BATTLESHIP));
		assertFalse(f.isHit());
		f.shoot();
		assertTrue(f.isHit());
	}

}
