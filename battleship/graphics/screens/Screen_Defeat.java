package battleship.graphics.screens;

//imports necessary libraries
import battleship.graphics.elements.game.*;
import battleship.graphics.elements.Element;
import battleship.graphics.elements.misc.Defeat;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: This class constructs the defeat screen from screen elements
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class Screen_Defeat extends Screen {
  
  //failure screen constructor
  public Screen_Defeat() {
    elements = new Element[]{new Defeat()};
  }
  
}