package ch.bfh.ti.proj1.battleship.frame;

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
* - GameSound ab CoordinateFrame bis Spielstart => ab dann BackgroundSound bis Spiel fertig
* - Bildergrösse (Winner/Loser) und coolere Darstellung mit Text (cooler Seemannsspruch!)
* - Klassen sauber strukturieren
* - Sounds einbinden
* 		- Sounds bei sich selber implementieren
* 		- Background Musik bei beiden (synchronisiert)
* 		- Startmusik vom Starten des Programms bis zum Beginn des Spiels
* 		- Fehlersound wenn falsch geklickt
* 		- Ocean Sound während Spiel (zufällig) [Möven, Strand, Wellen,...]
* 		- Ship sink
* 		- Ship hit
* 		- Water hit
* 		- Game won (kurzer Jingle und dann Sigesmusik bis Spieler auf Ok gedrückt hat)
* 		- Game lost (kurzer Jingle und dann Losermusik bis Sieger auf Ok gedrückt hat)
*
*/