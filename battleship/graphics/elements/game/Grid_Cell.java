package battleship.graphics.elements.game;

//imports necessary libraries
import battleship.graphics.elements.Element;
import battleship.utilities.Resources;
import battleship.graphics.GraphicsController;
import java.awt.*;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: This class is used to draw and hold data on the individual grid cells
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class Grid_Cell implements Element {
  
  private Color cellColour = new Color(65, 105, 225); //colour of cell
  private Rectangle cellRect = new Rectangle(); //rectangle object for cell
  
  
  //sets bounds of cell
  public void setBounds (int x, int y, int width, int height) {
    cellRect.setBounds(x, y, width, height);
  }
  
  
  //draws the cell
  public void draw (Graphics g, int width, int height) {
    
    Graphics2D g2d = (Graphics2D)g; //constructs graphics 2D object
    
    g2d.setColor(cellColour);
    g2d.fill(cellRect);
    
    g2d.setColor(Color.BLACK);
    g2d.draw(cellRect);
    
  }
  
  
  //draws the target
  public void drawTarget (Graphics g, int width, int height) {
    g.drawImage(Resources.gameTarget, getX(), getY(), getLength(), getLength(), null);
  }
  
  
  //draws the hit icon
  public void drawHit (Graphics g, int width, int height) {
    g.drawImage(Resources.gameHit, getX(), getY(), getLength(), getLength(), null);
  }
  
  
  //draws the miss icon
  public void drawMiss (Graphics g, int width, int height) {
    g.drawImage(Resources.gameMiss, getX(), getY(), getLength(), getLength(), null);
  }
  
  
  //returns the x location of the cell
  public int getX() {
   return (int)cellRect.getX(); 
  }
  
  
  //returns the y location of the cell
  public int getY() {
   return (int)cellRect.getY(); 
  }
  
  
  //returns the length of the cell
  public int getLength() {
   return (int)cellRect.getWidth(); 
  }
  
  
  //returns whether or not the cell contains coordinates
  public boolean contains(int x, int y) {
    if (cellRect.contains(x, y)) {
      return true;
    } else {
      return false;
    }
  }
  
  
  //called on mouse click
  public void mouseClick() {}
  
}