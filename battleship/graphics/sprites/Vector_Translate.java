package battleship.graphics.sprites;

//imports necessary libraries
import java.awt.Graphics2D;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: This class is for the translational vector; it extends the vector parent class
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class Vector_Translate extends Vector {
  
  /**
   * The amount of displacement from the sprites original position on the x-axis from translations
   */
  private int currentTranslatedX;
  
  
  /**
   * The amount of displacement from the sprites original position on the y-axis from translations
   */
  private int currentTranslatedY;
  
  
  /**
   * Constructs a new linear movement vector
   * @param d the direction of the vector (direction in degrees; 0 is 3'oclock)
   * @param s the speed of the vector (speed of movement in pxiels per millisecond)
   * @param m the magnitude of the vector (magnitude of movememnt in pixels; use -1 for infinite magintidue)
   */
  public Vector_Translate (double d, double s, double m) {
    
    //assigns variables
    direction = d;
    speed = s;
    magnitude = m;
    
  }
  
  
  /**
   * Applies the translate transformation to the sprite
   * @param g2d the Graphics2D object to apply transformation too
   * @param millisElapsed the time in milliseconds that have elapsed since the transformation was last applied
   * @param centreX the location of the centre of the sprite on the x-axis
   * @param centreY the location of the centre of the sprite on the y-axis
   */
  public void apply(Graphics2D g2d, int millisElapsed, int centreX, int centreY) {
    int xMovement = 0;
    int yMovement = 0;
    if (!doneMoving()) {
      xMovement = getXmovement(millisElapsed);
      yMovement = getYmovement(millisElapsed);
    }
    g2d.translate((currentTranslatedX + xMovement), (currentTranslatedY + yMovement));
    updateCurrentMagnitude(xMovement, yMovement);
    updateCurrentTranslated(xMovement, yMovement);
}


/**
 * Returns the displacement on the x-axis for the transformation being applied as an int
 * @param millis the time in milliseconds since the last translate transformation
 * @return the displacement on the x-axis to be translated
 */
private int getXmovement (int millis) {
  double vectDisplacement = millis * speed;
  double displacement = Math.cos(Math.toRadians(direction)) * vectDisplacement;
  return (int)displacement;
}


/**
 * Returns the displacement on the y-axis for the transformation being applied as an int
 * @param millis the time in milliseconds since the last translate transformation
 * @return the displacement on the y-axis to be translated
 */
private int getYmovement (int millis) {
  double vectDisplacement = millis * speed;
  double displacement = Math.sin(Math.toRadians(direction)) * vectDisplacement;
  return (int)displacement;
}


/**
 * Updates the vector's current magnitude of applied transformations
 * @param xDisplacement sprite displacement on the x-axis applied in the translation
 * @param yDisplacement sprite displacement on the y-axis applied in the translation
 */
private void updateCurrentMagnitude(int xDisplacement, int yDisplacement){
  currentMagnitude += (int) Math.sqrt((xDisplacement*xDisplacement)+(yDisplacement*yDisplacement));
}


/**
 * Updates the vector's current translated variables
 * @param xDisplacement sprite displacement on the x-axis applied in the translation
 * @param yDisplacement sprite displacement on the y-axis applied in the translation
 */
private void updateCurrentTranslated(int xDisplacement, int yDisplacement) {
  currentTranslatedX += xDisplacement;
  currentTranslatedY += yDisplacement;
}


}