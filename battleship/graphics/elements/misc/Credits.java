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
 * Class Description: This class is a screen element which creates the credits screen
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class Credits implements Element {
  
  private Button menuButton = new Button("Return to Menu", "Menu");
  private Font creditsFont = new Font("Courier New", Font.BOLD, 24);
  private String[] creditsText = {"CREDITS", "", "Development by Jonathan Lucki", "", "", "Resources from:", 
    "www.silenthunteriii.com", "www.soundbible.com", "www.vgboxart.com", "www.opengameart.org", "www.iconfinder.com",
    "", "", "Thanks for playing battleship!"};
  
  //draws screen element
  public void draw (Graphics g, int width, int height) {
    g.setColor(Color.black);
    g.fillRect(0, 0, width, height);
    
    g.setFont(creditsFont);
    g.setColor(Color.white);
    for (int i = 0; i < creditsText.length; i++) {
      g.drawString(creditsText[i], 15, (i * 30) + 30);  
    }
    
    menuButton.setBounds(width / 2 - 200, height - 100, 400, 50);
    menuButton.draw(g, width, height);
    
  }
  
  //called when mouse is clicked
  public void mouseClick() {
    menuButton.mouseClick();
  }
  
}