package battleship.graphics.elements.game;

//imports necessary libraries
import battleship.graphics.elements.Element;
import battleship.utilities.Resources;
import java.awt.*;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: This class is a screen element which creates the ingame background
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class Background implements Element {
  
  private Color backgroundColour = new Color(10, 35, 70); //colour of background
  
  //draws screen element
  public void draw (Graphics g, int width, int height) {
    
    g.setColor(backgroundColour);
    g.fillRect(0, 0, width, height);
    
  }
  
  //when mouse is clicked
  public void mouseClick() {}
  
}