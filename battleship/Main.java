package battleship;

//imports necessary libraries
import battleship.graphics.GraphicsController;
import javax.swing.JFrame;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: This is the main class of the program and contains the main method
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class Main {
  
  /**
   * Main method for the program
   * @param arg command line arguments
   */
  public static void main(String arg[]){
    
    //instantiates the JFrame
    JFrame frame = new JFrame("Battleship - Jonathan Lucki");
    
    //sets frame size
    frame.setSize(1000, 800);
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
    
    //sets frame content pane
    frame.setContentPane(new GraphicsController());
    
    //allows the user to close the program/frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //makes the frame visible
    frame.setVisible(true);
    
  } 
  
}