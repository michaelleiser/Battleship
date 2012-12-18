package ch.bfh.ti.proj1.battleship.sound;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * The class sound is responsible for playing background music
 * and for the sounds during the game.
 * 
 * @author Daniel Kotlàris
 * @author Michael Leiser
 */
public class Sound {
	
	private static Clip gameSoundClip, soundClip;
	
	public enum Sounds {
		WATER, HIT, SUNK, GAMESOUND, WINNER, LOSER
	}
	
	/**
	 * Plays the background sounds when a shoot hits the water, hits a ship, a ship is sunk, the winner and loser sound.
	 * 
	 * @param soundFile
	 *            the file to play
	 */
	public static void playSound(File soundFile) {
		try {
			soundClip = AudioSystem.getClip();
			AudioInputStream ais;
			ais = AudioSystem.getAudioInputStream(soundFile);
			soundClip.open(ais);
			soundClip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Plays the background sound form the start of the application until the
	 * end of the official {@link Game}.
	 * 
	 * @param soundFile
	 *            the file to play
	 */
	public static void playGameSound(File soundFile) {
		try {
			gameSoundClip = AudioSystem.getClip();
			AudioInputStream ais;
			ais = AudioSystem.getAudioInputStream(soundFile);
			gameSoundClip.open(ais);
			gameSoundClip.start();
			gameSoundClip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Stops the game sound.
	 */
	public static void stopGameSound() {
		gameSoundClip.stop();
	}
	
	/**
	 * Plays the specific sounds during the {@link Game} e.g. if a {@link Ship} was hit.
	 * 
	 * @param sound
	 *            the sound to play
	 */
	public static void playingSound(Sounds sound) {
		File soundFile;
		switch (sound) {
		case HIT:
			soundFile = new File("wav/hit.wav");
			try {
				playSound(soundFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case SUNK:
			soundFile = new File("wav/sunk.wav");
			try {
				playSound(soundFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case WATER:
			soundFile = new File("wav/water.wav");
			try {
				playSound(soundFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case WINNER:
			soundFile = new File("wav/win.wav");
			try {
				playSound(soundFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case LOSER:
			soundFile = new File("wav/lose.wav");
			try {
				playSound(soundFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case GAMESOUND:
			soundFile = new File("wav/gamesound.wav");
			try {
				playGameSound(soundFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}
	
}
