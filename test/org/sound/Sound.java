package org.sound;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

	public enum Sounds {
		BEGIN, DEATH, UMBRELLA
	}

	public static void playSound(File f) throws Exception {

		Clip clip = AudioSystem.getClip();
		AudioInputStream ais;
		ais = AudioSystem.getAudioInputStream(f);
		clip.open(ais);
		Long l = clip.getMicrosecondLength();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		Thread.sleep(l / 1000);

	}

	public static void playingSound(Sounds sound) throws Exception {
		switch (sound) {
		case BEGIN:
			File f = new File(
					"wav/begin.wav");
			playSound(f);
			break;
		case DEATH:
			File f2 = new File(
					"wav/death.wav");
			playSound(f2);
			break;
		default:
			break;
		}
	}

}
