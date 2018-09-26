package battleship.graphics.screens;

//imports necessary libraries
import battleship.graphics.elements.misc.Loading;
import battleship.graphics.elements.Element;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: This class constructs the loading screen from screen elements
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class Screen_Loading extends Screen {
  
  //loading screen constructor
  public Screen_Loading() {
    elements = new Element[]{new Loading()};
  }
  
}