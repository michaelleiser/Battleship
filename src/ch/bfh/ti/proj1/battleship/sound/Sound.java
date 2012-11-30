package ch.bfh.ti.proj1.battleship.sound;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

	public enum Sounds {
		WATER, HIT, SUNK, GAMESOUND_0, GAMESOUND_1, GAMESOUND_2, WINNER, LOSER
	}

	public static void playGameSound(File f) throws Exception {
		Clip clip = AudioSystem.getClip();
		AudioInputStream ais;
		ais = AudioSystem.getAudioInputStream(f);
		clip.open(ais);
		Long l = clip.getMicrosecondLength();
//		clip.loop(Clip.LOOP_CONTINUOUSLY);
		clip.start();
		Thread.sleep(l / 1000);
		clip.stop();
	}
	
	public static void playingSound(Sounds sound) {
		File soundFile;
		switch (sound) {
		case HIT:
			soundFile = new File("wav/hit.wav");
			try {
				playGameSound(soundFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case SUNK:
			soundFile = new File("wav/sunk.wav");
			try {
				playGameSound(soundFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case WATER:
			soundFile = new File("wav/water.wav");
			try {
				playGameSound(soundFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case WINNER:
			soundFile = new File("wav/win.wav");
			try {
				playGameSound(soundFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case LOSER:
			soundFile = new File("wav/lose.wav");
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
	
	public static void playBackgroundSound(int random) {		
		File soundFile;
		switch (random) {
		case 0:
			soundFile = new File("wav/background0.wav");
			try {
				playGameSound(soundFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 1:
			soundFile = new File("wav/background1.wav");
			try {
				playGameSound(soundFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 2:
			soundFile = new File("wav/background2.wav");
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
