package main;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

//Here is where the sound is handled and where any error in the sound files will be handled
public class PlaySound {
	// Creates a global Clip
	public Clip clip;

	public void play(String file) {
		// This stops any currently running sounds so there's no overlap
		try {
			clip.stop();
			clip.close();
		} catch (Exception exc) {
			System.out.println(exc);
		}
		// Plays the selected file
		try {
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(new File(file)));
			clip.start();
		} catch (Exception exc) {
			System.out.println("The specified audio file is not supported.");
		}
	}
}