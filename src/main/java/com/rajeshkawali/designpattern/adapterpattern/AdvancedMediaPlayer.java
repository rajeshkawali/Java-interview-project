package com.rajeshkawali.designpattern.adapterpattern;
/**
 * 
 * @author Rajesh_Kawali
 *
 */
public class AdvancedMediaPlayer {
	public void playVlc(String fileName) {
		System.out.println("Playing vlc file. Name: " + fileName);
	}

	public void playMp4(String fileName) {
		System.out.println("Playing mp4 file. Name: " + fileName);
	}
}
