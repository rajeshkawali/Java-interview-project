package com.rajeshkawali.designpattern.adapterpattern;

/**
 * 
 * @author Rajesh_Kawali
 *
 */
public class AdapterMain {
	/*
	The Adapter design pattern is a structural pattern that allows you to 
	adapt an interface of an existing class to a different interface. 
	The Adapter pattern is useful when you want to reuse an existing 
	class in a new context and the existing class does not conform 
	to the interface expected by the new context.
	
	The Adapter design pattern that allows two incompatible objects to work together. 
	It acts as a bridge between two objects, 
	providing a standard interface for communication between them. 
	The adapter pattern is useful in situations where an existing class 
	cannot be used as is and requires modification to be used with another class.
	*/
	public static void main(String[] args) {
		AudioPlayer audioPlayer = new AudioPlayer();

		audioPlayer.play("mp3", "beyond the horizon.mp3");
		audioPlayer.play("mp4", "alone.mp4");
		audioPlayer.play("vlc", "far far away.vlc");
		audioPlayer.play("avi", "mind me.avi");
	}
}
/*
In this example, the MediaPlayer interface defines a single method, play(String audioType, String fileName), 
that plays a file of the specified type and name. The AudioPlayer class is a class that plays audio 
files of different types such as mp3, mp4, vlc and avi.

The AdvancedMediaPlayer class is an existing class that plays advanced audio files such as vlc and mp4. 
But the AudioPlayer class does not know how to play these advanced audio files. 
The MediaPlayerAdapter class is used to adapt the AdvancedMediaPlayer class to the MediaPlayer interface. 
The MediaPlayerAdapter class holds a reference to the AdvancedMediaPlayer object and 
its play(String audioType, String fileName) method calls the appropriate method of the AdvancedMediaPlayer class, 
depending on the audioType passed to it. The AudioPlayer class only knows how to play mp3 files, 
but it can still play other types of files such as vlc and mp4 by using the MediaPlayerAdapter class. 
The MediaPlayerAdapter class acts as an intermediary between the AudioPlayer class and the 
AdvancedMediaPlayer class, translating the requests from the AudioPlayer class into a format 
that the AdvancedMediaPlayer class can understand.

In this example, the MediaPlayer interface is the Target Interface, the AudioPlayer class is 
the client that is using the Target Interface, the AdvancedMediaPlayer class is the existing 
class that does not conform to the Target Interface, and the MediaPlayerAdapter is the Adapter 
that adapt the AdvancedMediaPlayer class to the MediaPlayer interface.
*/