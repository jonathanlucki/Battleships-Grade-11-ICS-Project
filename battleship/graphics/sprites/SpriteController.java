package battleship.graphics.sprites;

//imports necessary libraries
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Point;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: This class controls all sprites in the program
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class SpriteController extends JPanel {
  
  /**
   * An array (ArrayList) of sprite objects
   */
  private static ArrayList<Sprite> spriteArray = new ArrayList<Sprite>();
  
  /**
   * Graphics object which is used to provide individual transformtions to sprites
   */
  private Graphics g1;
  
  
  //used create sprites
  public static void createSprite(Sprite sprite, Vector[] vector) {
    
    int index = spriteArray.size();
    //adds sprite objects to the sprite array
    spriteArray.add(index, sprite);
    
    for (int i=0; i < vector.length; i++) {
      spriteArray.get(index).addTransform(vector[i]);
    }
    
  }
  
  //returns whether or not there are active sprites on screen
  public static boolean spritesActive() {
    if (spriteArray.size() == 0) {
      return false;
    } else {
      return true;
    }
  }
  
  
  /**
   * Paint component for the frame
   * @param g the Graphics object drawing to the frame
   */
  public void draw(Graphics g, int width, int height){
    
    //draws all sprites in the sprite array
    for (int i=0; i < spriteArray.size(); i++) {
      if (!spriteArray.get(i).doneTranslating()) {
        g1 = g.create();
        spriteArray.get(i).draw(g1);
        g1.dispose();
      } else {
        spriteArray.remove(i); //removes sprites if they are done translating
      }
    }
    
  }
  
  
}