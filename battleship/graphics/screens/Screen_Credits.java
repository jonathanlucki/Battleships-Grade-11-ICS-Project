package battleship.graphics.screens;

//imports necessary libraries
import battleship.graphics.elements.misc.Credits;
import battleship.graphics.elements.Element;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: This class constructs the credits screen from screen elements
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class Screen_Credits extends Screen {
  
  //credits screen constructor
  public Screen_Credits() {
    elements = new Element[]{new Credits()};
  }
  
}