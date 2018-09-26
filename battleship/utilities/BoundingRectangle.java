package battleship.utilities;

//imports necessary libraries
import java.awt.Rectangle;
import java.lang.Math;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: This class is used to return bounding rectangles of shapes (not yet implemented)
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class BoundingRectangle {
  
  //returns bounding recangle for point
  public static Rectangle getPointRectangle (int x, int y) {
    return new Rectangle (x,
                          y,
                          1,
                          1);
  }
  
  
   //returns bounding recangle for line
  public static Rectangle getLineRectangle (int x1, int y1, int x2, int y2) {
    return new Rectangle (Math.min(x1, x2),
                          Math.min(y1, y2),
                          Math.max(x1, x2) - Math.min(x1, x2),
                          Math.max(y1, y2) - Math.min(y1, y2));
  }
  
  
   //returns bounding recangle for cirlce
  public static Rectangle getCircleRectangle (int x, int y, int radius) {
    return new Rectangle (x - radius,
                          y - radius,
                          2 * radius,
                          2 * radius);
  }
  
}