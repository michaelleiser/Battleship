package ch.bfh.ti.proj1.battleship.sound;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import ch.bfh.ti.proj1.battleship.common.Player;

/**
 * The class sound is responsible for playing background music
 * and for the sounds during the game.
 * 
 * @author Daniel Kotlàris
 * @author Michael Leiser
 */
public class Sound {
	
	private static Clip gameSoundClip, soundClip;
//	private static Clip backGroundSoundClip;
//	private static boolean bgSoundPlaying = true;
	
	public enum Sounds {
		WATER, HIT, SUNK, GAMESOUND_0, GAMESOUND_1, GAMESOUND_2, WINNER, LOSER
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

	
//	/**
//	 * Plays the background sound form the start of the application until the
//	 * player start to play the official game.
//	 * 
//	 * @param soundFile
//	 *            the file to play
//	 * @throws Exception
//	 *             if the file could not be read or anything else goes wrong
//	 */
//	public static void playBackGroundSound() {
//		try {
//			bgSoundPlaying = true;
//			
//			while(bgSoundPlaying) {
//				backGroundSoundClip = AudioSystem.getClip();
//				Random random = new Random();
//				AudioInputStream ais = AudioSystem.getAudioInputStream(new File("wav/background" + random.nextInt(3) + ".wav"));
//				backGroundSoundClip.open(ais);
//				try {
//					backGroundSoundClip.start();
//					Thread.sleep(1000);
//					backGroundSoundClip.stop();
//					Thread.sleep(random.nextInt(5000) + 2500);
//					
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	/**
//	 * Stops the game sound.
//	 */
//	public static void stopBackgroundSound() {
//		bgSoundPlaying = false;
//		backGroundSoundClip.stop();
//	}
	
	
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
		case GAMESOUND_0:
			soundFile = new File("wav/gamesound0.wav");
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
	
//	/**
//	 * Plays the background sound during the battle (waves etc.)
//	 * @param random
//	 * 				a random number specifying the sound to play
//	 */
//	public static void playBackgroundSound(int random) {		
//		File soundFile;
//		switch (random) {
//		case 0:
//			soundFile = new File("wav/background0.wav");
//			try {
//				playGameSound(soundFile);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			break;
//		case 1:
//			soundFile = new File("wav/background1.wav");
//			try {
//				playGameSound(soundFile);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			break;
//		case 2:
//			soundFile = new File("wav/background2.wav");
//			try {
//				playGameSound(soundFile);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			break;
//		default:
//			break;
//		}
//	}
}
