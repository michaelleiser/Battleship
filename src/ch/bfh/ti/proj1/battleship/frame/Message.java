package ch.bfh.ti.proj1.battleship.frame;

/**
 * @author Daniel Kotlàris
 * @author Michael Leiser
 */
public class Message {

	private String message;
	
	public Message(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return this.message;
	}

}
