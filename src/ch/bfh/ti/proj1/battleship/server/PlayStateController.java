package ch.bfh.ti.proj1.battleship.server;

import ch.bfh.ti.proj1.battleship.client.Player;

/**
 * This class controls that the right player can play and 
 * the other player is blocked until it is his turn.
 * 
 * @author Daniel Kotlàris
 * @author Michael Leiser
 */
public class PlayStateController {
	
	Player localPlayer;
	Player remotePlayer;
	
	public PlayStateController() {
		// get the players from the entity manager on the server
		
	}
	
	// also controls that the right text is displayed in the text field "Play State" after every turn.
	// So both players know who's turn it is, what field was shot, if a ship has sunk etc.

}
