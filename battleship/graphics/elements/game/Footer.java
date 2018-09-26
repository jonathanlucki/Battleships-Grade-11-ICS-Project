package battleship.graphics.elements.game;

//imports necessary libraries
import battleship.graphics.elements.Element;
import battleship.utilities.Resources;
import battleship.data.GameData;
import battleship.graphics.elements.misc.Button;
import java.awt.*;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: This class is a screen element which creates the ingame footer
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class Footer implements Element {
  
  private Color statusBoxColor = new Color(33, 144, 115); //status bar colour
  private Font statusFont = new Font("Courier New", Font.BOLD, 20); //status bar font
  
  private Button menuButton = new Button("Return to Menu", "Menu"); //button object for the menu button
  
  //draws screen element
  public void draw (Graphics g, int width, int height) {
    
    g.setColor(statusBoxColor);
    g.fillRect(0, height - 50, width - 300, 50);
    g.setColor(Color.BLACK);
    g.fillRect(0, height - 50, width - 300, 5);
    g.fillRect(0, height - 50, 5, 50);
    g.fillRect(0, height - 5, width - 300, 5);
    g.fillRect(width - 305, height - 50, 5, 50);
    
    menuButton.setBounds(width - 300, height - 50, 300, 50);
    menuButton.draw(g, width, height);
    
    g.drawImage(Resources.gameStatusIcon, 5, height - 45, 40, 40, null);
    
    g.setColor(Color.BLACK);
    g.setFont(statusFont);
    g.drawString(GameData.statusMessage, 50, height - 17);
    
  }
  
  
  //calle don mouse clicks
  public void mouseClick() {
    menuButton.mouseClick();
  }
  
}