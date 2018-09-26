package battleship.graphics.sprites;

//imports necessary libraries
import java.awt.Graphics2D;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: This class is for the rotational vector; it extends the vector parent class
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class Vector_Rotate extends Vector {
  
  /**
   * Constructs a new rotational vector
   * @param d the direction of the vector (1 for CLOCKWISE rotation, and any other value (like 0) for COUNTERCLOCKWISE rotation)
   * @param s the speed of the vector (speed of rotation in degrees per millisecond)
   * @param m the magnitude of the vector (magnitude of direction in degrees; use -1 for infinite magintidue)
   */
  public Vector_Rotate (double d, double s, double m) {
    
    //assigns variables
    direction = d;
    speed = s;
    magnitude = m;
    
  }
  
  
   /**
   * Applies the rotate transformation to the sprite
   * @param g2d the Graphics2D object to apply transformation too
   * @param millisElapsed the time in milliseconds that have elapsed since the transformation was last applied
   * @param centreX the location of the centre of the sprite on the x-axis
   * @param centreY the location of the centre of the sprite on the y-axis
   */
  public void apply(Graphics2D g2d, int millisElapsed, int centreX, int centreY) {
    if (!doneMoving()) {
    g2d.rotate(Math.toRadians(getAngleMovement(millisElapsed)), centreX, centreY);
    }
  }
  
  
  /**
   * Returns the amount of degrees for the transformation being applied as an int
   * It also updates the vector's current magnitude of applied transformations
   * @param millis the time in milliseconds since the last rotate transformation
   * @return the amount of degrees to be rotated
   */
  private int getAngleMovement (int millis) {
    
    double angleMovement = speed * millis;
    
    if (direction == 1) {
      currentMagnitude += (int)angleMovement;
      return (int)currentMagnitude;
    } else {
      currentMagnitude += (int)angleMovement;
      return (int)-currentMagnitude;
    } 
  }
  
  
}