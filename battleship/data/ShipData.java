package battleship.data;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: The class is used to hold information on the ships
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class ShipData {
  
   //the cell location of the ship on the grid
  public int cellX;
  public int cellY;
  
  public boolean vertical; //whether or not ship is vertical
  
  public boolean placed; //whether or not the ship is placed
  
  
  //constructor for ship data
  public ShipData () {
   cellX = -1;
   cellY = -1;
   vertical = true;
   placed = false;
  }
  
  
  //sets location of the ship
  public void setLocation (int x, int y) {
    cellX = x;
    cellY = y;
  }
  
  
  //sets vertical variable
  public void setVertical (boolean isVertical) {
   vertical = isVertical; 
  }
  
  
  //sets placed variable
  public void setPlaced (boolean isPlaced) {
   placed = isPlaced; 
  }
  
  
  //returns x location of ship on grid
  public int getX() {
   return cellX;
  }
  
  
  //returns y location of ship on grid
  public int getY() {
   return cellY; 
  }
  
  
  //returns whether or not ship is vertical
  public boolean isVertical() {
    if (vertical) {
      return true;
    } else {
      return false;
    }
  }
  
  //returns whether or not ship is placed
  public boolean isPlaced() {
    if (placed) {
      return true;
    } else {
      return false;
    }
  }
  
}