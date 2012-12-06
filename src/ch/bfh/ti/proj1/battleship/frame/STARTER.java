package ch.bfh.ti.proj1.battleship.frame;

/**
 * @author Daniel Kotlàris
 * @author Michael Leiser
 */
public class STARTER {

	public static void main(String[] args) {
		new Game();
	}	
}


/**
*
*TODO Liste
* - Beim spielen, nach einem Schuss das Feld deaktivieren und erst vom Gegener aktivieren lassen
* - Startbild und Endbild
* - Winner/Loser Frame mit Sound
* - Message an anderen, dass anderer geschlossen => Message und dann auch schliessen => JEDES FRAME!!!
* - Beim Platzieren des Schiffes, auf dem Spielfeld bereits andeuten
* - Fields eventuell als JPanel statt JButton
* - History aktiver Player ist beim gegner verdreht 
* - Sounds einbinden
* 		- Sounds bei sich selber implementieren
* 		- Background Musik bei beiden
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