package ch.bfh.ti.proj1.battleship.client;

import java.net.InetAddress;
import java.net.UnknownHostException;

import ch.bfh.ti.proj1.battleship.exception.BattleshipException;

/**
 * One of the two players who plays the battleship game.
 * 
 * @author Daniel Kotlàris
 * @author Michael Leiser
 */
public class Player {
	
	private String name;
	InetAddress ipAddress;
	//private String ipAddress;
	private int portNumber;
	
	
	/**
	 * Constructor for remote player
	 */
	public Player(String name, InetAddress ipAddress, int portNumber)
			throws BattleshipException {
		this.name = name;
		this.setIpAddress(ipAddress);
		this.setPortNumber(portNumber);
	}

	/**
	 * Constructor for local player
	 */
	public Player(String name, int portNumber)
			throws BattleshipException {
		this.name = name;
		this.setLocalIpAddress();
		this.setPortNumber(portNumber);
	}
	
	/**
	 * Get Player's name
	 * @param name
	 * 			the Player's name
	 */
	public String getName() {
		return name;
	}


	/**
	 * Set Player's name
	 * @param name
	 * 			the Player's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the stored IP-Address of the Player's computer
	 * 
	 * @return
	 * 			the stored IP-Address of the Player's computer
	 */
	public InetAddress getIpAddress() {
		return ipAddress;
	}


	public void setIpAddress(InetAddress ipAddress)
			throws BattleshipException {		
		this.ipAddress = ipAddress;
	}
	
	/**
	 * Gets the ip address of the local computer of the user
	 * and stores this address for the player. 
	 * 
	 * From {@link http://www.exampledepot.com/egs/java.net/Local.html}
	 * 
	 * @throws BattleshipException
	 * 				thrown if local ip address could not be extracted and stored.
	 */
	public void setLocalIpAddress() throws BattleshipException {		
		// tries to get the local host's IP address.
		try {
			this.ipAddress = InetAddress.getLocalHost();
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}		
	}


	/**
	 * Returns the stored reserved port number of the player's computer.
	 * 
	 * @return
	 * 				the stored reserved port number of the player's computer
	 * @throws BattleshipException 
	 * 				thrown if the port number for the player (client) is not set yet
	 */
	public int getPortNumber() throws BattleshipException {
		if (this.portNumber != 0){
			return portNumber;
		} else {
			throw new BattleshipException("Port number not set yet!");
		}
	}


	/**
	 * Validates if the provided port number to store is greater than 1024 and smaller than 65535.
	 * If this is true, the port number is stored otherwise an exception is thrown.
	 * 
	 * @param portNumber
	 * 						the port number of the server computer
	 * @throws BattleshipException
	 * 						thrown if the provided port number is not a correct port number
	 */
	public void setPortNumber(int portNumber) throws BattleshipException {
		if(portNumber >= 1024 && portNumber <= 65535) {
			this.portNumber = portNumber;
		} else {
			throw new BattleshipException("The provided Portnumber is not in between 1'024 and 65'535");
		}
	}
}
