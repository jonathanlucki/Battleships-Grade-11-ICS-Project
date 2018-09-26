package battleship.graphics.elements.menu;

//imports necessary libraries
import battleship.graphics.elements.Element;
import battleship.graphics.GraphicsController;
import battleship.utilities.Resources;
import battleship.graphics.elements.misc.Button;
import java.awt.*;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: This class is a screen element which creates the menu footer
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class Footer implements Element {
  
  private String[] buttonStrings = {"Play Game", "Help", "Credits", "Quit Game"}; //strings for footer buttons
  private String[] buttonScreens = {"Selection", "Help", "Credits", "Quit"}; //screen changes for footer buttons
  private int buttonNum = buttonStrings.length; //number of buttons
  private Button[] menuButton = new Button[buttonNum]; //button objects for footer buttons
  
  //constructs footer object
  public Footer () {
    
    for (int i=0; i<buttonNum; i++) {
      menuButton[i] = new Button(buttonStrings[i], buttonScreens[i]);
    }
    
  }
  
  //draws screen element to screen
  public void draw (Graphics g, int width, int height) {
    
    int buttonWidth = width / buttonNum;
    
    for (int i=0; i<buttonNum; i++) {
      
      menuButton[i].setBounds((buttonWidth * i), (height - 100), buttonWidth, 100);
      menuButton[i].draw(g, width, height);
      
    }
    
  }
  
  
  //listens for when the mouse is clicked
  public void mouseClick() {
    
    for (int i=0; i<buttonNum; i++) {
      
      menuButton[i].mouseClick();
      
    }
  }
  
}

