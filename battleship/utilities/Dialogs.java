package battleship.utilities;

//imports necessary libraries
import javax.swing.JOptionPane;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: This class is used to create dialog messages
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class Dialogs {
  
  //shows plain dialog
  public static void plain (String message) {
    JOptionPane.showMessageDialog(null,
                                  message,
                                  "Info",
                                  JOptionPane.PLAIN_MESSAGE);
  }
  
  
  //shows error dialog
  public static void error (String message) {
    JOptionPane.showMessageDialog(null,
                                  message,
                                  "Error",
                                  JOptionPane.WARNING_MESSAGE);
  }
  
  
  //shows critical error dialog; closes program
  public static void criticalError (String message) {
    JOptionPane.showMessageDialog(null,
                                  message,
                                  "Critical Error",
                                  JOptionPane.ERROR_MESSAGE);
    System.exit(0);
  }
  
}