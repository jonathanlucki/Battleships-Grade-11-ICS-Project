package battleship.graphics.elements.misc;

//imports necessary libraries
import battleship.graphics.elements.Element;
import battleship.utilities.Resources;
import battleship.graphics.GraphicsController;
import battleship.graphics.elements.misc.Button;
import java.awt.*;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: This class is a screen element which creates the victory screen
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class Victory implements Element {
  
  private Button menuButton = new Button("Return to Menu", "Menu");
  
  //draws screen element
  public void draw (Graphics g, int width, int height) {
    
    if (width < (height * 1.4)) {
      g.drawImage(Resources.menuVictory, ((width / 2) - ((int)(height * 1.47) / 2)), 0, (int)(height * 1.4), height, null);
    } else {
      g.drawImage(Resources.menuVictory, 0, 0, width, (height), null);
    }
    
    g.drawImage(Resources.menuVictoryText, width / 2 - 300,  50, 600, 200, null);
    
    menuButton.setBounds(width / 2 - 200, height - 100, 400, 50);
    menuButton.draw(g, width, height);
    
  }
  
  //called when mouse is clicked
  public void mouseClick() {
    menuButton.mouseClick();
  }
  
}