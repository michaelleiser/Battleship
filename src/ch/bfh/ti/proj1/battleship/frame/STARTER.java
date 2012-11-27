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
*
* - Beim Platzieren des Schiffes, auf dem Spielfeld bereits andeuten
* - Fields im Spiel immer sichtbar
* - Fields eventuell als JPanel statt JToggleButton
* - YourFields im Spiel, Status(farben) darstellen
* - Sounds einbinden
* - Statistik aktiver Player verdreht
* - Sounds einbinden
* 		- Startmusik vom Starten des Programms bis zum Beginn des Spiels
* 		- Fehlersound wenn falsch geklickt
* 		- Ocean Sound w�hrend Spiel (zuf�llig) [M�ven, Strand, Wellen,...]
* 		- Ship sink
* 		- Ship hit
* 		- Water hit
* 		- Game won (kurzer Jingle und dann Sigesmusik bis Spieler auf Ok gedr�ckt hat)
* 		- Game lost (kurzer Jingle und dann Losermusik bis Sieger auf Ok gedr�ckt hat)
* - Chat mit VK_ENTER
* - Beim gewinnen / verlieren nicht sofort wieder in CoordinateFrame, sondern erst nach klick auf ok
*
*/