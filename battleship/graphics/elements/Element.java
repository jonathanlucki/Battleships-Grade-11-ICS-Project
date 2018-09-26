package battleship.graphics.elements;

//imports necessary libraries
import java.awt.Graphics;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Interface Description: This interface is implemented on all screen elements
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public interface Element {
  
  public abstract void draw(Graphics g, int width, int height); //draws screen element
  public abstract void mouseClick(); //called when mouse is clicked
  
}