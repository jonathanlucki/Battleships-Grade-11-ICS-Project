package battleship.utilities;

//imports necessary libraries
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: The game is used to play all the ingame sound effects
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class Sound {
  
  /**
   * Sound object for the fire sound effect
   */
  public static Sound fire = new Sound("battleship/resources/sound/fire.wav");
  
  /**
   * Sound object for the button sound effect
   */
  public static Sound button = new Sound("battleship/resources/sound/button.wav");
  
  /**
   * Sound object for the ship placing sound effect
   */
  public static Sound place = new Sound("battleship/resources/sound/place.wav");
  
  /**
   * Sound object for the explosion sound effect
   */
  public static Sound explosion = new Sound("battleship/resources/sound/explosion.wav");
  
  /**
   * String that holds the file path of the sound effect files
   */
  private String filePath; 
  
  
  /**
   * Constructs the sound object for sound effects
   * @param filePath the file path of the sound effect
   */
  public Sound (String filePath) {
    this.filePath = filePath;
  }
  
  
  /**
   * Plays the sound effect
   */
  public void play() {
    try {
      
      //loads the music
      URL url = this.getClass().getClassLoader().getResource(filePath);
      AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
      Clip clip = AudioSystem.getClip();
      clip.open(audioIn);
      clip.start();
      
      //catches exceptions
    } catch (UnsupportedAudioFileException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (LineUnavailableException e) {
      e.printStackTrace();
    }
  }
  
}



