package battleship.data;

//imports necessary libraries
import battleship.graphics.GraphicsController;
import battleship.graphics.sprites.SpriteController;
import battleship.utilities.Random;
import battleship.utilities.Sound;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: This class is used to control the main functions of the game
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class GameController {
  
  
  /**
   * Updates the game with new information
   */
  public static void updateGame() {
    
    if (GraphicsController.gameActive()) { //checks if game is active
      if (!GameData.allShipsPlaced(true)) { //checks if all ships have been placed
        
        //if not all ships has been placed, changes status to match the currently being placed ship
        switch (GameData.shipsPlaced(true)) {
          case 0: setStatus("Ahoy Admiral. Please click a spot on the grid to deploy your aircraft carrier.");
          break;
          case 1: setStatus("Excellent Sir! Now please click a spot on the grid to deploy your battleship.");
          break;
          case 2: setStatus("Excellent choice! Next deploy your cruiser by clicking a spot on the grid once again.");
          break;
          case 3: setStatus("Genius location Sir! Now click a pot on the grid to deploy your patrol boat.");
          break;
          case 4: setStatus("Almost done sir! Finally we need to deploy our submarine. Click a spot on the grid to do so.");
          break;
          default: battleship.utilities.Dialogs.criticalError("GameData.shipsPlaced() has an illegal value.");
          break;
        }
        
        //switches to game once player is done selecting
      } else if (GameData.playerSelecting) {
        GameData.playerSelecting = false;
        GraphicsController.setScreen("Game");
        
        //sets status according to whether or not player is taking their turn
      } else if (!GameData.playerTurn) {
        setStatus("The enemy is currently taking their shot sir.");
      } else {
        setStatus("Sir, please click a location on the enemy grid to take a shot.");
      }
      
      
      //checks if player has lost
      if (!GameData.playerTurn) {
        if (GameData.allShipsSunk(true)) {
          GraphicsController.setScreen("Defeat"); 
        }
      }
      
      //checks if player has own
      if (GameData.playerTurn) {
        if (GameData.allShipsSunk(false)) {
          GraphicsController.setScreen("Victory"); 
        }
      }
      
      //pauses turns while projectile sprites are animated
      if (GameData.turnComplete && !SpriteController.spritesActive()) {
        if (GameData.playerTurn) {
          Sound.explosion.play();
          GameData.setPlayerTurn(false); 
          GameData.setTurnComplete(false);
        } else {
          Sound.explosion.play();
          GameData.setPlayerTurn(true); 
          GameData.setTurnComplete(false);
        }
      }
      
    }
  }

  
  /**
   * Sets status message
   */
  public static void setStatus (String status) {
    GameData.statusMessage = status;
  }
  
  
}