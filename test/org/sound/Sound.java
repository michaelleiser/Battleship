package org.sound;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	
	public enum Sounds{
		BEGIN, DEATH
	}

	public static void playSound(File f) throws Exception{
		Clip clip = AudioSystem.getClip();
		AudioInputStream ais = AudioSystem.getAudioInputStream(f);
		clip.open(ais);
		Long l = clip.getMicrosecondLength();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		Thread.sleep(l / 1000);
	}

	public static void playingSound(Sounds sound) throws Exception {
		switch(sound){
		case BEGIN:
			File f = new File("C:/Program Files/Eclipse/Workspace/AAA/begin.wav");
			playSound(f);
			break;
		case DEATH:
			File f2 = new File("C:/Program Files/Eclipse/Workspace/AAA/death.wav");
			playSound(f2);
			break;
		default:
			break;
		}
	}




}
