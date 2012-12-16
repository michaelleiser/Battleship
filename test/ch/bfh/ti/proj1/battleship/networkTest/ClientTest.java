package ch.bfh.ti.proj1.battleship.networkTest;

import org.junit.Test;
import ch.bfh.ti.proj1.battleship.network.Client;
import ch.bfh.ti.proj1.battleship.network.Server;

public class ClientTest {

	@Test
	public void test() {
		new Server(4444);
		new Client(4444, "localhost");
	}

}
