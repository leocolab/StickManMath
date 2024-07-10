import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Music class will be used to play all types of music that we want in the
 * background of our game.
 * 
 * @param no parameters taken
 * @author Manuel Saldivar
 *
 */
public class Music {
	private Clip clip;

	/**
	 * constructor for the Music class
	 * 
	 * @param song which will be a .wav file of the song a person wishes to play
	 * @return none
	 * @author Manuel Saldivar
	 */
	public Music(URL song) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(song);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * PlayMusic method will play any .wav music file given in its parameters
	 * 
	 * @param repeat a true or false statement if you want the song to loop or not
	 * @throws UnsupportedAudioFileException
	 * @throws IOException
	 * @throws LineUnavailableException
	 * @author Manuel Saldivar
	 */
	public void PlayMusic(boolean repeat) {
		try {
			if (repeat == true)
				clip.loop(clip.LOOP_CONTINUOUSLY);
			clip.start();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * this method will stop playing the music
	 * 
	 * @param none
	 * @returns nothing
	 * @author Manuel Saldivar
	 */
	public void StopMusic() {
		if (clip != null && clip.isRunning()) {
			clip.stop();
		}
	}

	/**
	 * this method will reset the song to the beggining of it
	 * 
	 * @param none
	 * @return none
	 * @author Manuel Saldivar
	 */
	public void reset() {
		clip.stop();
		clip.setFramePosition(0);
	}
}
