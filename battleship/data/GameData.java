package battleship.data;

//imports necessary libraries
import battleship.utilities.Dialogs;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: This class holds all the data used in running the game
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class GameData {
  
  public static String statusMessage; //in game status message
  
  public static final int GRID_CELL_SIZE = 10; //grid cell length; constant
  
  public static boolean playerSelecting = true; //whether or not player is placing ships
  
  public static boolean playerTurn = true; //whether or not it is the players turn
  
  public static boolean turnComplete = false; //whether or not the player has fired a shot yet
  
  //cell data array for the player grid
  public static CellData[][] playerGridCellData = new CellData[GRID_CELL_SIZE][GRID_CELL_SIZE];
  
  //cell data array for the cpu grid
  public static CellData[][] cpuGridCellData = new CellData[GRID_CELL_SIZE][GRID_CELL_SIZE];
  
  //ship data objects for player ships
  public static ShipData playerCarrier;
  public static ShipData playerBattleship;
  public static ShipData playerCruiser;
  public static ShipData playerPatrolBoat;
  public static ShipData playerSubmarine;
  
  
  //ship data objects for cpu ships
  public static ShipData cpuCarrier;
  public static ShipData cpuBattleship;
  public static ShipData cpuCruiser;
  public static ShipData cpuPatrolBoat;
  public static ShipData cpuSubmarine;
  
  
  public static boolean verticalPlacement = true; //whether or not ships are placed vertically
  
  
  //sets up game data
  public static void setUpGameData() {
    resetGameData(); 
  }
  
  
  //resets all game data to default values
  public static void resetGameData() {
    
    statusMessage = "";
    
    for (int x = 0; x < playerGridCellData.length; x++) {
      for (int y = 0; y < playerGridCellData.length; y++) {
        playerGridCellData[x][y] = new CellData();
      }
    }
    
    for (int x = 0; x < cpuGridCellData.length; x++) {
      for (int y = 0; y < cpuGridCellData.length; y++) {
        cpuGridCellData[x][y] = new CellData();
      }
    }
    
    playerSelecting = true;
    
    playerTurn = true;
    
    turnComplete = false;
    
    playerCarrier = new ShipData();
    playerBattleship = new ShipData();
    playerCruiser = new ShipData();
    playerPatrolBoat = new ShipData();
    playerSubmarine = new ShipData();
    
    cpuCarrier = new ShipData();
    cpuBattleship = new ShipData();
    cpuCruiser = new ShipData();
    cpuPatrolBoat = new ShipData();
    cpuSubmarine = new ShipData();
    
    verticalPlacement = true;
    
  }
  
  
  //returns shipdata object for any ship
  public static ShipData getShipData(String ship, boolean playerShip) {
    
    switch (ship) {
      case "Carrier":
        if (playerShip) {
        return playerCarrier;
      } else {
        return cpuCarrier;
      }
      case "Battleship":
        if (playerShip) {
        return playerBattleship;
      } else {
        return cpuBattleship;
      }
      case "Cruiser":
        if (playerShip) {
        return playerCruiser;
      } else {
        return cpuCruiser;
      }
      case "PatrolBoat":
        if (playerShip) {
        return playerPatrolBoat;
      } else {
        return cpuPatrolBoat;
      }
      case "Submarine":
        if (playerShip) {
        return playerSubmarine;
      } else {
        return cpuSubmarine;
      }
      default:
        Dialogs.criticalError("Critical Error: Invalid Ship inputted to method GameData.getShipData()");
        throw new IllegalArgumentException("Invalid Ship inputted to method GameData.getShipData()");
    }
    
  }
  
  
  //returns boolean on whether or not a ship has been placed
  public static boolean shipPlaced(String ship, boolean playerShip) {
    
    ShipData shipData = getShipData(ship, playerShip);
    
    if (shipData.getX() != -1 && shipData.getY() != -1) {
      return true; 
    } else {
      return false; 
    }
    
  }
  
  
  //returns the number of ships current placed
  public static int shipsPlaced(boolean playerShips) {
    if (shipPlaced("Carrier", playerShips) && shipPlaced("Battleship", playerShips) && shipPlaced("Cruiser", playerShips) && shipPlaced("PatrolBoat", playerShips) && shipPlaced("Submarine", playerShips)) {
      return 5;
    } else if (shipPlaced("Carrier", playerShips) && shipPlaced("Battleship", playerShips) && shipPlaced("Cruiser", playerShips) && shipPlaced("PatrolBoat", playerShips)) {
      return 4;
    } else if (shipPlaced("Carrier", playerShips) && shipPlaced("Battleship", playerShips) && shipPlaced("Cruiser", playerShips)) {
      return 3;
    } else if (shipPlaced("Carrier", playerShips) && shipPlaced("Battleship", playerShips)) {
      return 2;
    } else if (shipPlaced("Carrier", playerShips)) {
      return 1;
    } else {
      return 0;
    }
  }
  
  //returns boolean on whether or not all ships have been placed
  public static boolean allShipsPlaced(boolean playerShips) {
    if (shipsPlaced(playerShips) == 5) {
      return true;
    } else {
      return false;
    }
  }
  
  
  //returns a boolean on whether or not it is acceptable for a ship to be placed in the x,y location
  public static boolean acceptableBounds (String ship, int x, int y, boolean playerShip) {
    
    int shipSize = shipSize(ship);
    
    CellData[][] gridCellData = new CellData[GRID_CELL_SIZE][GRID_CELL_SIZE];
    
    if (playerShip) {
      gridCellData = new CellData[playerGridCellData.length][playerGridCellData.length];
      for (int cellX = 0; cellX < playerGridCellData.length; cellX++) {
        for (int cellY = 0; cellY < playerGridCellData.length; cellY++) {
          gridCellData[cellX][cellY] = playerGridCellData[cellX][cellY];
        }
      }
    } else {
      gridCellData = new CellData[cpuGridCellData.length][cpuGridCellData.length];
      for (int cellX = 0; cellX < cpuGridCellData.length; cellX++) {
        for (int cellY = 0; cellY < cpuGridCellData.length; cellY++) {
          gridCellData[cellX][cellY] = cpuGridCellData[cellX][cellY];
        }
      }
    }
    
    if (verticalPlacement) {
      if (y + (shipSize) <= GRID_CELL_SIZE) {
        for (int i = y; i < y + (shipSize); i++) {
          if (gridCellData[x][i].hasShip()) {
            return false; 
          }
        }
      } else {
        return false;
      }
    } else {
      if (x + (shipSize) <= GRID_CELL_SIZE) {
        for (int i = x; i < x + (shipSize); i++) {
          if (gridCellData[i][y].hasShip()) {
            return false; 
          }
        }
      } else {
        return false;
      }
    }
    return true;
  }
  
  
  //changes the ship rotation
  public static void changeRotation() {
    if (verticalPlacement) {
      verticalPlacement = false;
    } else {
      verticalPlacement = true; 
    }
  }
  
  
  //completes the turn of a player
  public static void changeTurn() {
    turnComplete = true;
  }
  
  
  //sets the turn complete variable
  public static void setTurnComplete (boolean turnComplete) {
   GameData.turnComplete = turnComplete; 
  }
  
  
  //sets the player turn variable
  public static void setPlayerTurn (boolean playerTurn) {
   GameData.playerTurn = playerTurn; 
  }
  
  
  //returns the size of ships
  public static int shipSize(String ship) {
    
    switch (ship) {
      case "Carrier":
        return 5;
      case "Battleship":
        return 4;
      case "Cruiser":
        return 3;
      case "PatrolBoat":
        return 2;
      case "Submarine":
        return 3;
      default:
        Dialogs.criticalError("Critical Error: Invalid Ship inputted to method GameData.shipSize()");
        throw new IllegalArgumentException("Invalid Ship inputted to method GameData.shipSize");
    }
    
  }
  
  
  //returns the active ship currently being placed
  public static String activeShipSelection(boolean playerShips) {
    
    switch (shipsPlaced(playerShips)) {
      case 0: return "Carrier";
      case 1: return "Battleship";
      case 2: return "Cruiser";
      case 3: return "PatrolBoat";
      case 4: return "Submarine";
      default: return "";
    }
    
  }
  
  
  //places ships on the grid
  public static void placeShip(String ship, int x, int y, boolean playerShip) {
    
    ShipData shipData = getShipData(ship, playerShip);
    
    if (verticalPlacement) {
      shipData.setVertical(true);
    } else {
      shipData.setVertical(false);
    }
    
    shipData.setLocation(x, y);
    
    
    int shipSize = shipSize(ship);
    
    
    if (verticalPlacement) {
      for (int i = y; i < y + (shipSize); i++) {
        if (playerShip) {
          playerGridCellData[x][i].setHasShip(true);
        } else {
          cpuGridCellData[x][i].setHasShip(true);
        }
      }
    } else {
      for (int i = x; i < x + (shipSize); i++) {
        if (playerShip) {
          playerGridCellData[i][y].setHasShip(true);
        } else {
          cpuGridCellData[i][y].setHasShip(true);
        }
      }
    }
    
    shipData.setPlaced(true);
    
  }
  
  
  //fires shots at grid locations
  public static void fire(int x, int y, boolean playerBoard) {
    
    if (playerBoard) {
      playerGridCellData[x][y].setFiredUpon(true);
      changeTurn();
    } else {
      cpuGridCellData[x][y].setFiredUpon(true);
      changeTurn();
    }
    
  }
  
  
  //returns a boolean on whether or not a ship is sunk
  public static boolean shipSunk(String ship, boolean playerShip) {
    
    ShipData shipData = getShipData(ship, playerShip);
    
    if (shipData.isPlaced()) {
      
      int shipSize = shipSize(ship);
      
      CellData[][] gridCellData = new CellData[GRID_CELL_SIZE][GRID_CELL_SIZE];
      
      if (playerShip) {
        gridCellData = new CellData[playerGridCellData.length][playerGridCellData.length];
        for (int cellX = 0; cellX < playerGridCellData.length; cellX++) {
          for (int cellY = 0; cellY < playerGridCellData.length; cellY++) {
            gridCellData[cellX][cellY] = playerGridCellData[cellX][cellY];
          }
        }
      } else {
        gridCellData = new CellData[cpuGridCellData.length][cpuGridCellData.length];
        for (int cellX = 0; cellX < cpuGridCellData.length; cellX++) {
          for (int cellY = 0; cellY < cpuGridCellData.length; cellY++) {
            gridCellData[cellX][cellY] = cpuGridCellData[cellX][cellY];
          }
        }
      }
      
      if (shipData.isVertical()) {
        for (int i = shipData.getY(); i < shipData.getY() + (shipSize); i++) {
          if (!gridCellData[shipData.getX()][i].firedUpon()) {
            return false; 
          } else {
            return true;
          }
        }
        
      } else {
        for (int i = shipData.getX(); i < shipData.getX() + (shipSize); i++) {
          if (!gridCellData[i][shipData.getY()].firedUpon()) {
            return false; 
          } else {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  
  //returns a boolean on whether or not all ships have been sunk
  public static boolean allShipsSunk (boolean playerBoard) {
    
    if (shipSunk("Carrier", playerBoard) && shipSunk("Battleship", playerBoard) && shipSunk("Cruiser", playerBoard) && shipSunk("PatrolBoat", playerBoard) && shipSunk("Submarine", playerBoard)) {
      return true; 
    } else {
      return false;
    }
    
  }
  
  
}

