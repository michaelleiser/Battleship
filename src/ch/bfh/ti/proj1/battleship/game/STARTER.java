package ch.bfh.ti.proj1.battleship.game;

import ch.bfh.ti.proj1.battleship.view.StarterFrame;

/**
 * This class starts the application.
 * 
 * @author Michael Leiser
 * @author Daniel Kotlàris
 */
public class STARTER {

	public static void main(String[] args) {
		new StarterFrame();
	}
}


/**
*TODO Liste
* - Klassen sauber strukturieren
* - Sounds einbinden
* 		- Background Musik bei beiden (synchronisiert)
* 		- GameSound ab CoordinateFrame bis Spielstart => ab dann BackgroundSound bis Spiel fertig (Winner/Loser oder Restart)
* 
*/