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
 * Class Description: This class is a screen element which creates the help screen
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class Help implements Element {
  
 private Button menuButton = new Button("Return to Menu", "Menu");
  private Font helpFont = new Font("Courier New", Font.BOLD, 24);
  private String[] helpText = {"HOW TO PLAY", "", "- At the start, you must choose a location on the 10x10 grid for each ship in your fleet",
  "- After choosing locations, you and the computer will then take turns shooting at eachother's fleet",
  "- To shoot, click a location on the enemies grid when prompted",
  "- The first one to sink eachothers entire fleet of 5 ships, wins the game!", "",
  "Thanks for playing battleship!"};
  
  //draws screen element
  public void draw (Graphics g, int width, int height) {
    g.setColor(Color.black);
    g.fillRect(0, 0, width, height);
    
    g.setFont(helpFont);
    g.setColor(Color.white);
    for (int i = 0; i < helpText.length; i++) {
      g.drawString(helpText[i], 15, (i * 30) + 30);  
    }
    
    menuButton.setBounds(width / 2 - 200, height - 100, 400, 50);
    menuButton.draw(g, width, height);
    
  }
  
  //called when mouse is clicked
  public void mouseClick() {
    menuButton.mouseClick();
  }
  
}