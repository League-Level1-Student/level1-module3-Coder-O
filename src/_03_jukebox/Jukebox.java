package _03_jukebox;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */


import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import javazoom.jl.player.advanced.AdvancedPlayer;

/*   If you don't have javazoom.jar in your project, you can download it from here: http://bit.ly/javazoom
 *   Right click your project and add it as a JAR (Under Java Build Path > Libraries).*/

public class Jukebox implements Runnable, ActionListener {
JButton play;
JButton playZelda;
Song zeldaSong;
Song lostSong;
Song currentSong;
    public void run() {

		// 1. Find an mp3 on your computer or on the Internet.
		// 2. Create a Song object for that mp3
    	zeldaSong = new Song("01 Prelude of Time.mp3");
		lostSong = new Song("18 Lost Woods.mp3");
    	// 3. Play the Song
    	
    	currentSong = zeldaSong;
    	

		/*
		 * 4. Create a user interface for your Jukebox so that the user can to
		 * choose which song to play. You can use can use a different button for
		 * each song, or a picture of the album cover. When the button or album
		 * cover is clicked, stop the currently playing song, and play the one
		 * that was selected.
		 */
    	JFrame frame = new JFrame();
    	JPanel panel = new JPanel();
    	play = new JButton();
    	playZelda = new JButton();
    	
    	play.setText("Pause");
    	
    	URL imageURL = getClass().getResource("Ocarina_of_time.jpg");
		Icon icon = new ImageIcon(imageURL);
		
		//ImageIcon icon = new ImageIcon(new ImageIcon("Ocarina_of_time.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		
		
		playZelda.setIcon(icon);
    	playZelda.setSize(50, 50);
    	playZelda.addActionListener(this);
    	
    	play.addActionListener(this);
    	
    	frame.add(panel);
    	panel.add(play);
    	panel.add(playZelda);
    	
    	frame.pack();
    	frame.setVisible(true);
    }
    
    
	/* Use this method to add album covers to your Panel. */
	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(play)) {
			if(play.getText().equals("Play")) {
				currentSong.play();
				play.setText("Pause");
			} else {
				currentSong.stop();
				play.setText("Play");
			}
		} else if (e.getSource().equals(playZelda)) {
			currentSong.stop();
			if(!currentSong.equals(zeldaSong)) {
				currentSong = zeldaSong;
			} else {
				currentSong = lostSong;
			}
			currentSong.play();
			play.setText("Pause");
		}
	}

}

class Song {

	private int duration;
	private String songAddress;
	private AdvancedPlayer mp3Player;
	private InputStream songStream;

	/**
	 * Songs can be constructed from files on your computer or Internet
	 * addresses.
	 * 
	 * Examples: <code> 
	 * 		new Song("everywhere.mp3"); 	//from default package 
	 * 		new Song("/Users/joonspoon/music/Vampire Weekend - Modern Vampires of the City/03 Step.mp3"); 
	 * 		new	Song("http://freedownloads.last.fm/download/569264057/Get%2BGot.mp3"); 
	 * </code>
	 */
	public Song(String songAddress) {
		this.songAddress = songAddress;
	}

	public void play() {
		loadFile();
		if (songStream != null) {
			loadPlayer();
			startSong();
		} else
			System.err.println("Unable to load file: " + songAddress);
	}

	public void setDuration(int seconds) {
		this.duration = seconds * 100;
	}

	public void stop() {
		if (mp3Player != null)
			mp3Player.close();
	}

	private void startSong() {
		Thread t = new Thread() {
			public void run() {
				try {
					if (duration > 0)
						mp3Player.play(duration);
					else
						mp3Player.play();
				} catch (Exception e) {
				}
			}
		};
		t.start();
	}

	private void loadPlayer() {
		try {
			this.mp3Player = new AdvancedPlayer(songStream);
		} catch (Exception e) {
		}
	}

	private void loadFile() {
		if (songAddress.contains("http"))
			this.songStream = loadStreamFromInternet();
		else
			this.songStream = loadStreamFromComputer();
	}

	private InputStream loadStreamFromInternet() {
		try {
			return new URL(songAddress).openStream();
		} catch (Exception e) {
			return null;
		}
	}

	private InputStream loadStreamFromComputer() {
		try {
			return new FileInputStream(songAddress);
		} catch (FileNotFoundException e) {
			return this.getClass().getResourceAsStream(songAddress);
		}
	}
}

