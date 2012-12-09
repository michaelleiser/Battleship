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
*
* - Fehler bei mehrfach Server erzeugung mit gleichem Port
* - Fehler bei Client erzeugung mit falscher ip-adresse und port
* - Message an anderen, dass anderer geschlossen => Message und dann auch schliessen => JEDES FRAME!!!
* - Beim Platzieren des Schiffes, auf dem Spielfeld bereits andeuten
* - Fields eventuell als JPanel statt JButton
* - History aktiver Player ist beim gegner verdreht 
* - Winner/Loser Frame mit Sound
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