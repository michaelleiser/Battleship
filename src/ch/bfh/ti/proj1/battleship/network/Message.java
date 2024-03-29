package ch.bfh.ti.proj1.battleship.network;

/**
 * Messages for the network communication and the game communication.
 * 
 * @author Daniel Kotl�ris
 * @author Michael Leiser
 */
public enum Message {

	COORDINATE_CHAT, 
	COORDINATE_SHOWGAMEFRAME, 
	COORDINATE_DISPOSE, 
	COORDINATE_OPTIONS, 
	COORDINATE_SETFIRST, 
	COORDINATE_ENABLE, 
	GAME_CHAT, 
	GAME_HISTORY, 
	GAME_SHOW, 
	GAME_ENABLECOMPONENTS, 
	GAME_ENABLE,
	GAME_DISABLE, 
	GAME_SHOOT, 
	GAME_HIT, 
	GAME_WATER, 
	GAME_SUNK, 
	GAME_WON, 
	GAME_START, 
	GAME_SOUND, 
	GAME_RESTART, 
	GAME_ACTIVEPLAYER,
	GAME_SOLUTION,
	CLOSECONNECTION,
	TESTCONNECTION,
	OPENCONNECTION

}
