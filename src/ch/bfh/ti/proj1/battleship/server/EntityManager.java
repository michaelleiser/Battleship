package ch.bfh.ti.proj1.battleship.server;

import ch.bfh.ti.proj1.battleship.client.Player;
import ch.bfh.ti.proj1.battleship.exception.BattleshipException;

/**
 * The Entity Manager is responsible to store 
 * all important data for the battleship game.
 * 
 * @author Daniel Kotlàris
 * @author Michael Leiser
 */
public class EntityManager {

	// the player on the same computer as the host
	private Player localPlayer;
	// the second player who connects to the server from a remote device
	private Player remotePlayer;
	
	private int serverPortNumber;
	
	
	// TODO: Add more entities...
	
	
	public EntityManager() {
		this.localPlayer = null;
		this.remotePlayer = null;
		this.serverPortNumber = 0;
		
		// TODO continue..
	}


	
	public Player getLocalPlayer() throws BattleshipException {
		if (this.localPlayer != null) {
			return localPlayer;
		} else {
			throw new BattleshipException("Local player does not exist yet!");
		}
	}


	public void setLocalPlayer(Player localPlayer) {
		this.localPlayer = localPlayer;
	}


	public Player getRemotePlayer() throws BattleshipException {
		if (this.remotePlayer != null) {
			return remotePlayer;
		} else {
			throw new BattleshipException("Remote player does not exist yet!");
		}
	}


	public void setRemotePlayer(Player remotePlayer) {
		this.remotePlayer = remotePlayer;
	}


	public int getServerPortNumber() throws BattleshipException {
		if (this.serverPortNumber != 0) {
			return serverPortNumber;
		} else {
			throw new BattleshipException("Server port number not set yet!");
		}
	}

	
	/**
	 * Validates if the provided port number to store is greater than 1024 and smaller than 65535.
	 * If this is true, the port number is stored otherwise an exception is thrown.
	 * 
	 * @param portNumber
	 * 						the port number of the player's computer
	 * @throws BattleshipException
	 * 						thrown if the provided port number is not a correct port number
	 */
	public void setServerPortNumber(int serverPortNumber) throws BattleshipException {
		if(serverPortNumber >= 1024 && serverPortNumber <= 65535) {
			this.serverPortNumber = serverPortNumber;
		} else {
			throw new BattleshipException("The provided Portnumber is not in between 1'024 and 65'535");
		}
	}

	
	
}
