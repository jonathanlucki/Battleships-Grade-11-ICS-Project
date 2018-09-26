package battleship.graphics.sprites;

//imports necessary libraries
import java.awt.Graphics2D;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: This is the vector abstract class; all vector objects extend this class
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public abstract class Vector {
  
  /**
   * The direction of the vector (Please refer the the Vector child classes to find out what this variable represents)
   */
  double direction;
  
  
  /**
   * The speed of the vector (Please refer the the Vector child classes to find out what this variable represents)
   */
  double speed;
  
  
  /**
   * The magnitude of the vector (Please refer the the Vector child classes to find out what this variable represents)
   */
  double magnitude;
  
  
  /**
   * The current magnitude of the vector from the applied transformations
   */
  int currentMagnitude = 0;
  
  
  /**
   * Applies the transformations from the vector to the sprite
   * @param g2d the Graphics2D object to apply transformations too
   * @param millisElapsed the time in milliseconds that have elapsed since the transformations were last applied
   * @param centreX the location of the centre of the sprite on the x-axis
   * @param centreY the location of the centre of the sprite on the y-axis
   */
  public abstract void apply(Graphics2D g2d, int millisElapsed, int centreX, int centreY);
  
  
  /**
   * Returns whether or not the current magnitude has reached the set magnitude as a boolean
   * @return if the vector has finished applying its transformations
   */
  protected boolean doneMoving() {
    if ( magnitude == -1 || currentMagnitude < magnitude ){
      return false;
    } else {
    return true;
    }
  }
  
}