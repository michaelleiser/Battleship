package ch.bfh.ti.proj1.battleship.frame;

/**
 * 
 * @author Daniel Kotl�ris
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
* - Startbild und Endbild
* - Winner/Loser Frame mit Sound
* - Message an anderen, dass anderer geschlossen => Message und dann auch schliessen => JEDES FRAME!!!
* - Beim Platzieren des Schiffes, auf dem Spielfeld bereits andeuten
* - Fields eventuell als JPanel statt JToggleButton
* - History aktiver Player beim gegner verdreht 
* - History Feld richtig aufl�sen bsp b1 a3..
* - Sounds einbinden
* 		- Sounds bei sich selber implementieren
* 		- Background Musik bei beiden
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