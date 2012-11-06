package ch.bfh.ti.proj1.battleship.frame;

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
