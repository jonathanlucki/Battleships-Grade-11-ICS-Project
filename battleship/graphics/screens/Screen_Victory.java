package battleship.graphics.screens;

//imports necessary libraries
import battleship.graphics.elements.game.*;
import battleship.graphics.elements.Element;
import battleship.graphics.elements.misc.Victory;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: This class constructs the victory screen from screen elements
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class Screen_Victory extends Screen {
  
  //victory screen constructor
  public Screen_Victory() {
    elements = new Element[]{new Victory()};
  }
  
}