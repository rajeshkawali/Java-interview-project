package com.rajeshkawali.designpattern.adapterpattern;
/**
 * 
 * @author Rajesh_Kawali
 *
 */
public class AudioPlayer implements MediaPlayer {

	MediaPlayerAdapter mediaPlayerAdapter;

	@Override
	public void play(String audioType, String fileName) {
		if (audioType.equalsIgnoreCase("mp3")) {
			System.out.println("Playing mp3 file. Name: " + fileName);
		} else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
			mediaPlayerAdapter = new MediaPlayerAdapter(audioType);
			mediaPlayerAdapter.play(audioType, fileName);
		} else {
			System.out.println("Invalid media. " + audioType + " format not supported");
		}
	}
}