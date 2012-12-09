package ch.bfh.ti.proj1.battleship.frame;

import ch.bfh.ti.proj1.battleship.view.StarterFrame;

/**
 * This class starts the application.
 * 
 * @author Michael Leiser
 * @author Daniel Kotl�ris
 */
public class STARTER {

	public static void main(String[] args) {
		new StarterFrame();
	}
}


/**
*TODO Liste
*
* - Fields eventuell als JPanel statt JButton
* - History aktiver Player ist beim gegner verdreht 
* - Sounds einbinden
* 		- Sounds bei sich selber implementieren
* 		- Background Musik bei beiden (synchronisiert)
* 		- Startmusik vom Starten des Programms bis zum Beginn des Spiels
* 		- Fehlersound wenn falsch geklickt
* 		- Ocean Sound w�hrend Spiel (zuf�llig) [M�ven, Strand, Wellen,...]
* 		- Ship sink
* 		- Ship hit
* 		- Water hit
* 		- Game won (kurzer Jingle und dann Sigesmusik bis Spieler auf Ok gedr�ckt hat)
* 		- Game lost (kurzer Jingle und dann Losermusik bis Sieger auf Ok gedr�ckt hat)
*
*/