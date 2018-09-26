package battleship.graphics.screens;

//imports necessary libraries
import battleship.graphics.elements.game.*;
import battleship.graphics.elements.Element;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: This class constructs the selection screen from screen elements
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class Screen_Selection extends Screen {
  
  //selection screen constructor
  public Screen_Selection() {
    elements = new Element[]{new Background(),
    new Header(),
    new Footer(),
      new Grid (true, true, "Fleet Placement")};
  }
  
}