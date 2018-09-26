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
 * Class Description: This class is a screen element which creates the menu art
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class Art implements Element {

  //draws screen element
  public void draw (Graphics g, int width, int height) {
    g.setColor(Color.black);
    g.fillRect(0, 0, width, height);
    if (width < (height * 1.7)) {
    g.drawImage(Resources.menuPicture, ((width / 2) - ((int)(height * 1.7) / 2)), 100, (int)(height * 1.7), (height - 200), null);
    } else {
      g.drawImage(Resources.menuPicture, 0, 100, width, (height - 200), null);
    }
  }
  
  
  //called when mouse is clicked
  public void mouseClick() {}
  
}