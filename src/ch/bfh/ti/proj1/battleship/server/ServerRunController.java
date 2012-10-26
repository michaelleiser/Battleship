package ch.bfh.ti.proj1.battleship.server;

/**
 * The Server Run Controller starts and stops the server and controls its behavior.
 * 
 * The Server has to be started when the player selects to "host a new game".
 * If the client "joins a hosted game", the server is not started.
 * 
 * @author Daniel Kotlàris
 * @author Michael Leiser
 */
public class ServerRunController {

	private boolean isStarted;
	
	public ServerRunController() {
		this.isStarted = false;	
	}
	
	
	/**
	 * Start the server
	 */
	public void startServer() {
		// TODO write method body!
		// TODO write method body!
		// TODO write method body!
		// TODO write method body!
		// TODO write method body!
		// TODO write method body!
		// TODO write method body!
		// TODO write method body!
		// TODO write method body!
		// TODO write method body!
		// TODO write method body!
		
		this.isStarted = true;
	}
	
	/**
	 * Stop the server
	 */
	public void stopServer() {
		// TODO write method body
		// TODO is this method needed?
		
		this.isStarted = false;
	}
	
	/**
	 * Returns if server is started
	 * 
	 * @return
	 * 			true if server is started
	 */
	public boolean serverStarted() {
		return this.isStarted;
	}

}
