package battleship.graphics.sprites;

//imports necessary libraries
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Point;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: This is the sprite parent class; it is abstract and all sprite objects extend it
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public abstract class Sprite {
  
  /**
   * The centre point of the sprite
   */
  Point centrePoint;
  
  
  /**
   * The width of the sprite
   */
  int spriteWidth;
  
  
  /**
   * The height of the sprite
   */
  int spriteHeight;
  
  /**
   * The colour of the sprite
   */
  Color colour;
  
  
  /**
   * The current system milliseconds of the last time the getMillisElapsed(boolean mark) method was called
   * It is used to calculate the amount of time elapsed between every frame update
   */
  long timeRef = System.currentTimeMillis();
  
  /**
   * An array (ArrayList) of vector objects that have been applied to the sprite
   */
  protected ArrayList<Vector> vectorArray = new ArrayList<Vector>();
  
  
  /**
   * Draws the sprite with its given transformations (if any)
   * @param g the Graphics object to draw the rectangle too
   */
  abstract void draw(Graphics g);
  
  
  /**
   * adds vector objects to the sprite's vector object array
   * @param vectorObject the vector object to be added to the array
   */
  public void addTransform (Vector vectorObject) {
    vectorArray.add(vectorObject);
  }
  
  
  /**
   * updates the sprite by applying the transformations that have been added to the vector object array
   * @param g2d the Graphics2D object drawing the sprite to the frame
   */
  protected void update(Graphics2D g2d) {
    
    //gets how many milliseconds have elapsed since last frame update
    int millisElapsed = getMillisElapsed(true);
    
    //applies all given transformations
    for (int i=0; i < vectorArray.size(); i++) {
      vectorArray.get(i).apply(g2d, millisElapsed, centrePoint.x, centrePoint.y);
    }
    
  }
  
  
  /**
   * Returns the amount of elapsed time in milliseconds since the last time the method was called and marked as an int
   * @param mark If true the timeRef variable will be marked and reset the elapsed time since method was last called
   * @return the elapsed in milliseconds since the last time the method was called and marked
   */
  private int getMillisElapsed(boolean mark){
    long elapsed = System.currentTimeMillis() - timeRef;
    if(mark) {
      timeRef = System.currentTimeMillis();
    }
    return (int)elapsed;
  }
  
  //returns whether or not program is done translating
  public boolean doneTranslating() {
    for (int i = 0; i < vectorArray.size(); i++) {
      if (vectorArray.get(i) instanceof Vector_Translate) {
        if (!vectorArray.get(i).doneMoving()) {
          return false;
        } else {
          return true;
        }
      }
    }
    return true;
  }
  
}