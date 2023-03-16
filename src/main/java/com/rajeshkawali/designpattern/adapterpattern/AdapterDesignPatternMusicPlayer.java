package com.rajeshkawali.designpattern.adapterpattern;

/**
 * 
 * @author Rajesh_Kawali
 *
 */
interface Mp3Player {
	// Mp3Player interface
	public void play(String fileName);
}

interface FlacPlayer {
	// FlacPlayer interface
	public void playFlac(String fileName);
}
/*
example code for the adapter pattern in a scenario where we have two incompatible interfaces:-->

Suppose you have a music player application that plays music files in the "mp3" format. 
You want to add support for playing music files in the "flac" format, 
but your application only understands "mp3" format. To solve this problem, 
you can use the adapter pattern by creating a "FlacPlayer" class that implements the "Mp3Player" interface 
and adapts the "FlacPlayer" to the "Mp3Player" interface.
*/
class FlacPlayerAdapter implements Mp3Player {
	// FlacPlayerAdapter class
	private FlacPlayer flacPlayer;

	public FlacPlayerAdapter(FlacPlayer flacPlayer) {
		this.flacPlayer = flacPlayer;
	}

	@Override
	public void play(String fileName) {
		flacPlayer.playFlac(fileName);
	}
}


class Mp3PlayerImpl implements Mp3Player {
	// Mp3PlayerImpl class
	@Override
	public void play(String fileName) {
		// play mp3 file
		System.out.println("Playing mp3 file " + fileName);
	}
}


class FlacPlayerImpl implements FlacPlayer {
	// FlacPlayerImpl class
	@Override
	public void playFlac(String fileName) {
		// play flac file
		System.out.println("Playing flac file " + fileName);
	}
}

public class AdapterDesignPatternMusicPlayer {
	public static void main(String[] args) {
		// Create Mp3Player object
		Mp3Player mp3Player = new Mp3PlayerImpl();

		// Create FlacPlayer object
		FlacPlayer flacPlayer = new FlacPlayerImpl();

		// Create adapter object
		Mp3Player flacPlayerAdapter = new FlacPlayerAdapter(flacPlayer);

		// Play mp3 file using Mp3Player
		mp3Player.play("song.mp3");

		// Play flac file using FlacPlayer
		flacPlayer.playFlac("song.flac");

		// Play flac file using FlacPlayerAdapter
		flacPlayerAdapter.play("song.flac");
	}
}
/*
The Adapter pattern is a structural design pattern that allows incompatible interfaces of classes 
to work together by converting the interface of one class into another that the client expects. 
In other words, it acts as a bridge between two incompatible interfaces, making them work together seamlessly.

The Adapter pattern is useful in the following scenarios:-->

When you want to use an existing class, but its interface is not compatible with the rest of the code.
When you want to reuse an existing class, but its implementation doesn't match the design of the rest of the code.
When you want to create a reusable class that cooperates with classes that don't have compatible interfaces.
When you want to create a wrapper around a third-party library to simplify its usage in your code.

Overall, the Adapter pattern is useful in situations where you need to connect two classes or systems 
that are not compatible due to incompatible interfaces. It enables you to reuse existing code and make 
it work seamlessly with other code without having to modify the existing code.
*/


/*
In the example code above, we have two interfaces: "Mp3Player" and "FlacPlayer". 
The "Mp3Player" interface is used by the music player application to play music 
files in the "mp3" format, while the "FlacPlayer" interface is 
used to play music files in the "flac" format.

To adapt the "FlacPlayer" to the "Mp3Player" interface, 
we create a "FlacPlayerAdapter" class that implements the "Mp3Player" interface 
and adapts the "FlacPlayer" to the "Mp3Player" interface.

In the main method, we create an instance of the "Mp3PlayerImpl" class 
to play the mp3 file, an instance of the "FlacPlayerImpl" class to play the flac file, 
and an instance of the "FlacPlayerAdapter" class to adapt the "FlacPlayer" to the "Mp3Player" interface 
and play the flac file using the "Mp3Player" interface.

UML diagram for the Adapter Design Pattern :-->

            +-------------------+              	+-------------------------------+
            |    FlacPlayer   	|              	|    Mp3Player   				|
            +-------------------+              	+-------------------------------+
            | +playFlac(String)	|          		|+play(String)					|
            +--------+----------+              	+--------+----------------------+
                     ^                                ^					^
                     |                                |					|
+--------------------+--------------+ 		+-----------+--------+		|
|      FlacPlayerImpl               | 		|  Mp3PlayerImpl     |		|
+-----------------------------------+ 		+--------------------+		|
|+playFlac(String)                  | 		|+play(String)    	 |		|
+-----------------------------------+ 		+--------------------+		|
											 							|
                                             							|
                           					+-----------------+--------------------+
                           					|          FlacPlayerAdapter           |
                           					+--------------------------------------+
                           					|       - flacPlayer: FlacPlayer       |
                           					+--------------------------------------+
                           					|         +play(String) : void         |
                           					+--------------------------------------+


*/