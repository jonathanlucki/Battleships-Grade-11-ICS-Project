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
 * Class Description: This class is used to play music
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class Music {
  
  /**
   * Array of music objects:
   * 0 - menu music
   * 1 - selection music
   */
  public static Music[] music = {new Music("battleship/resources/music/menu.wav"),
    new Music("battleship/resources/music/credits.wav"),
    new Music("battleship/resources/music/selection.wav"),
    new Music("battleship/resources/music/game.wav"),
  new Music("battleship/resources/music/victory.wav"),
  new Music("battleship/resources/music/defeat.wav")};
  
  private Clip clip; //clip object for music
  
  //stops all musiuc
  public static void stopMusic() {
    for (int i = 0; i < music.length; i++) {
      music[i].stop();
    }
  }
  
  //constrcuts music object
  public Music (String filePath) {
    try {
      
      //loads the music
      URL url = this.getClass().getClassLoader().getResource(filePath);
      AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
      clip = AudioSystem.getClip();
      clip.open(audioIn);
      
      //catches exceptions
    } catch (UnsupportedAudioFileException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (LineUnavailableException e) {
      e.printStackTrace();
    }
    
  }
  
  //starts music
  public void start() {
    if (!isActive()) {
      Music.stopMusic();
      clip.loop(Clip.LOOP_CONTINUOUSLY); 
    }
  }
  
  //stops music
  public void stop() {
    clip.stop(); 
  }
  
  //reutrns whetehr music is active
  public boolean isActive() {
    return clip.isActive(); 
  }
  
  }



