package battleship.graphics.sprites;

//imports necessary libraries
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: This class is used to create sprites for the projectiles; it extends the sprite parent class
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class Sprite_Projectile extends Sprite {
  
  /**
   * Reference to the projectile object containing the projectiles information
   */
  Rectangle projectile;
  
  
  /**
   * Constructs a new projectile sprite
   * @param upperLeftStartPoint the starting point of the upper left corner of the projectile
   * @param projectileWidth the width of the projectile
   * @param projectileHieght the height of the projectile
   * @param projectileColour the colour of the projectile
   */
  public Sprite_Projectile(Point upperLeftStartPoint, int projectileWidth, int projectileHieght, Color projectileColour) {
    
    //sets colour
    colour = projectileColour;
    
    //sets centre point
    centrePoint = new Point(upperLeftStartPoint.x + (projectileWidth / 2), 
                            upperLeftStartPoint.y + (projectileHieght / 2));
    
    //sets height/width variables
    spriteWidth = projectileWidth;
    spriteHeight = projectileHieght;
    
    //constructs rectangle object
    projectile = new Rectangle(upperLeftStartPoint.x, upperLeftStartPoint.y, projectileWidth, projectileHieght);
    
  }
  
  
  /**
   * Draws the projectile with its given transformations (if any)
   * @param g the Graphics object to draw the projectile too
   */
  public void draw(Graphics g) {
    
    //constructs graphics 2D object
    Graphics2D g2d = (Graphics2D)g;
    
    //sets colour for projectile
    g2d.setColor(colour);
    
    //updates sprite based on transformations it has been given
    update(g2d);
    
    //draws projectile
    g2d.fill(projectile);
    
    //disposes of transformations in the Graphics2D object
    g2d.dispose();
    
  }
  
}