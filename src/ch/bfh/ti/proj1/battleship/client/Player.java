package ch.bfh.ti.proj1.battleship.client;

import ch.bfh.ti.proj1.battleship.exception.BattleshipException;

/**
 * One of the two players who plays the battleship game.
 * 
 * @author Daniel Kotlàris
 * @author Michael Leiser
 */
public class Player {
	
	private String name;
	private String ipAddress;
	private int portNumber;
	
	
	public Player(String name, String ipAddress, int portNumber)
			throws BattleshipException {
		this.name = name;
		this.setIpAddress(ipAddress);
		this.setPortNumber(portNumber);
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getIpAddress() {
		return ipAddress;
	}


	public void setIpAddress(String ipAddress) throws BattleshipException {
		// validates first if the provided ip address is a real ip address (v4)		
		String val = ipAddress;
		// TODO: Validate the ip address of the player
		
		this.ipAddress = val;
	}
	
	public void setLocalIpAddress() throws BattleshipException {
		// TODO: Get the local ip address of this computer and set it.
	}


	public int getPortNumber() {
		return portNumber;
	}


	/**
	 * Validates if the provided port number to store is
	 * greater than 1024 and smaller than 65535.
	 * 
	 * @param portNumber
	 * @throws BattleshipException
	 */
	public void setPortNumber(int portNumber) throws BattleshipException {
		// TODO validate if the number is within possible range of port numbers
		if(portNumber >= 1024 && portNumber <= 65535) {
			this.portNumber = portNumber;
		} else {
			throw new BattleshipException("The provided Portnumber is not in between 1'024 and 65'535");
		}
		
	}


}
