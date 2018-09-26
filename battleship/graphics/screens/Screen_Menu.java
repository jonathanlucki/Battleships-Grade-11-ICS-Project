package battleship.graphics.screens;

//imports necessary libraries
import battleship.graphics.elements.menu.*;
import battleship.graphics.elements.Element;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description:  This class constructs the menu screen from screen elements
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class Screen_Menu extends Screen {
  
  //menu screen constructor
  public Screen_Menu() {
    elements = new Element[]{new Art(),
      new Header(),
      new Footer()};
  }
  
}