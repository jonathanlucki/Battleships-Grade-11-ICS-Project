package battleship.utilities;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: This class is used to return random values
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class Random {
  
  //method that takes a minmum and maximum value and gives a random integer between the two values
  public static int randomInt(int min, int max) {
    
    //returns the random number
    return (int) (Math.random() * ((max-min) + 1) ) + min;
    
  }
  
  //returns random boolean; true or false
  public static boolean randomBoolean() {
    
    if (randomInt(1, 2) == 1) {
      return true;
    } else {
      return false;
    }
    
  }
  
}