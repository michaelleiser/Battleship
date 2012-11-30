package ch.bfh.ti.proj1.battleship.sound;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class GameSound implements Runnable {

	@Override
	public void run() {
		File soundFile = new File("wav/gamesound0.wav");
		Clip clip;
		try {
			clip = AudioSystem.getClip();
			AudioInputStream ais;
			ais = AudioSystem.getAudioInputStream(soundFile);
			clip.open(ais);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	


}
