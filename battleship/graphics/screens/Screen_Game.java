package battleship.graphics.screens;

//imports necessary libraries
import battleship.graphics.elements.game.*;
import battleship.graphics.elements.Element;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description:  This class constructs the game screen from screen elements
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class Screen_Game extends Screen {
  
  //game screen constructor
  public Screen_Game() {
    elements = new Element[]{new Background(),
    new Header(),
    new Footer(),
    new Grid (true, "Your Fleet"),
    new Grid (false, "Enemy Fleet")};
  }
  
}