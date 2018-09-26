package battleship.graphics.elements.menu;

//imports necessary libraries
import battleship.graphics.elements.Element;
import battleship.utilities.Resources;
import java.awt.*;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: This class is a screen element which creates the menu header
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class Header implements Element {

  //draws screen element
  public void draw (Graphics g, int width, int height) {
    g.setColor(Color.black);
    g.fillRect(0, 0, width, 100); 
    g.drawImage(Resources.menuLogo, (width / 2) - 225, 0, 450, 100, null);
  }
  
  
  //called when mouse is clicked
  public void mouseClick() {}
  
}