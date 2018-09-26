  package battleship.data;
  

/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: This class is used told hold data for each grid cell
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 

  
  public class CellData {
    
    /**
     * Whether the cell has a ship on it or not
     */
    public boolean hasShip;
    
    /**
     * Whether the cell has been fired upon or not
     */
    public boolean firedUpon;
    
    
    /**
     * Returns whether or not the cell has a ship on it
     * @return if the cell has a ship on it
     */
    public boolean hasShip() {
      if (hasShip) {
        return true;
      } else {
        return false;
      }
    }
    
    
    /**
     * Returns whether or not the cell has been fired upon
     * @return if the cell has been fired upon
     */
    public boolean firedUpon() {
      if (firedUpon) {
        return true;
      } else {
        return false;
      }
    }
    
    
    /**
     * Sets hasShip for cell
     * @param hasShip whether or not the cell has a ship on it
     */
    public void setHasShip(boolean hasShip) {
     this.hasShip = hasShip; 
    }
    
    
    /**
     * Sets firedUpon for cell
     * #param firedUpon whether or not the cell has been fired upon
     */
    public void setFiredUpon(boolean firedUpon) {
     this.firedUpon = firedUpon; 
    }
    
    
  }