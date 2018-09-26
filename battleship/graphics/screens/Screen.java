package battleship.graphics.screens;

//imports necessary libraries
import battleship.graphics.elements.Element;
import java.awt.Graphics;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: This is the parent class for all screen classes
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public abstract class Screen {
  
  protected Element[] elements; //array of elements to make up screen

  //draws the screen made form elements
  public void draw(Graphics g, int width, int height) {
    for (int i=0; i<elements.length; i++) {
      elements[i].draw(g, width, height);
    }
  }
  
  //invokes mouseclick method in all elements
  public void mouseClick() {
    for (int i=0; i<elements.length; i++) {
      elements[i].mouseClick();
    }
  }
  
}