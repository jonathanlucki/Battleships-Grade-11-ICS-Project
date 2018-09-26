package battleship.graphics.elements.misc;

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
 * Class Description: This class is a screen element which creates the loading screen
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class Loading implements Element {
  
  private Font loadingFont = new Font("Courier New", Font.BOLD, 32);

  //draws screen element
  public void draw (Graphics g, int width, int height) {
    
    g.setColor(Color.black);
    g.fillRect(0, 0, width, height);
    
    g.setColor(Color.WHITE);
    g.setFont(loadingFont);
    FontMetrics fm = g.getFontMetrics();
    double x = (width / 2) - (fm.stringWidth("Loading...") / 2);
    double y = (height / 2) + (fm.getHeight() / 3);
    g.drawString("Loading...", (int)x, (int)y);
    
  }
  
  //called when mouse is clicked
  public void mouseClick() {
  }
  
}