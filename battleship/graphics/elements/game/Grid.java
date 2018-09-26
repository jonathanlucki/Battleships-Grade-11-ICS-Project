package battleship.graphics.elements.game;

//imports necessary libraries
import battleship.graphics.elements.Element;
import battleship.utilities.Resources;
import battleship.graphics.GraphicsController;
import battleship.graphics.elements.misc.Button;
import battleship.utilities.Random;
import battleship.graphics.sprites.*;
import battleship.data.*;
import battleship.utilities.Sound;
import java.awt.*;
import java.awt.image.*;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: This class is a screen element which creates the ingame grids
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class Grid implements Element {
  
  private boolean selection; //whether or not board is a selection board
  private boolean playerBoard; //whether or not board is a player board
  private String title; //title of the board
  private Rectangle gridRect = new Rectangle(); //rectangle object for grid rectangle
  private Rectangle textRect = new Rectangle(); //rectangle object for text rectangle
  private Font titleFont = new Font("Courier New", Font.BOLD, 20); //font for title
  private Button rotateButton = new Button("Rotate Ship", true); //button object for rotate button
  private int screenWidth = 0; //width of screen
  
  
  //array of Grid_Cell objects for graphical data for grid
  private Grid_Cell[][] gridCell = new Grid_Cell[GameData.GRID_CELL_SIZE][GameData.GRID_CELL_SIZE];
  
  
  //constructor for the grid
  public Grid (boolean playerBoard, String title) {
    this.selection = false; 
    this.playerBoard = playerBoard;
    this.title = title;
    
    for (int x = 0; x < gridCell.length; x++) {
      for (int y = 0; y < gridCell[x].length; y++) {
        gridCell[x][y] = new Grid_Cell();
      }
    }
    
  }
  
  
  //constructor for the grid
  public Grid (boolean playerBoard, boolean selection, String title) {
    this.selection = selection; 
    this.playerBoard = playerBoard;
    this.title = title;
    
    for (int x = 0; x < gridCell.length; x++) {
      for (int y = 0; y < gridCell[x].length; y++) {
        gridCell[x][y] = new Grid_Cell();
      }
    }
    
  }
  
  
  //draws the grid
  public void draw (Graphics g, int width, int height) {
    
    Graphics2D g2d = (Graphics2D)g; //constructs graphics 2D object
    
    if (!playerBoard && GameData.shipsPlaced(playerBoard) == 0 && GraphicsController.gameActive()) {
      randomizeShips(playerBoard);
    }
    
    screenWidth = width; //sets screen width variable
    
    
    //determines bounds of the grid and applies them to the grid rectangle object
    int maxGridHeight = height - 200;
    int maxGridWidth = 0;
    int gridSize = 0;
    int gridX = 0;
    int gridY = 0;
    
    if (selection) {
      maxGridWidth = width - 20;
    } else {
      maxGridWidth = (width / 2) - 20;
    }
    
    if (maxGridHeight > maxGridWidth) {
      gridSize = maxGridWidth;
      gridY = (height / 2) - (gridSize / 2) + 40;
    } else {
      gridSize = maxGridHeight;
      gridY = (height - gridSize) - 60;
    }
    
    if (selection) {
      gridX = (width / 2) - (gridSize / 2);
    } else if (playerBoard) {
      gridX = ((width / 4) - (gridSize / 2));
    } else if (!playerBoard) {
      gridX = ((width / 4) - (gridSize / 2)) + (width / 2);
    }
    
    
    //draw grid tiles
    int cellSize = gridSize / GameData.GRID_CELL_SIZE;
    for (int x = 0; x < gridCell.length; x++) {
      for (int y = 0; y < gridCell[x].length; y++) {
        int cellX = gridX + (cellSize * x);
        int cellY = gridY + (cellSize * y);
        gridCell[x][y].setBounds(cellX, cellY, cellSize, cellSize);
        gridCell[x][y].draw(g, width, height);
      }
    }
    
    int gridSideLength = (cellSize * GameData.GRID_CELL_SIZE);
    
    //sets bounds for grid border
    gridRect.setBounds(gridX - 1, gridY - 1, gridSideLength + 2, gridSideLength + 2);
    
    //draws grid border
    g2d.setColor(Color.BLACK);
    g2d.draw(gridRect);
    
    
    //draws text
    textRect.setBounds(gridX, gridY - 25, gridSideLength, 25);
    g2d.setColor(Color.WHITE);
    g2d.setFont(titleFont);
    FontMetrics fm = g2d.getFontMetrics();
    double stringX = textRect.getX() + (textRect.getWidth() / 2) - (fm.stringWidth(title) / 2);
    double stringY = textRect.getY() + (textRect.getHeight() / 2) + (fm.getHeight() / 3);
    g2d.drawString(title, (float)stringX, (float)stringY);
    
    //draws rotate button if a selection grid
    if (selection) {
      rotateButton.setBounds(width - 305, height - 100, 305, 50);
      rotateButton.draw(g, width, height);
    }
    
    
    
    
    //draws ships that are placed
    if (playerBoard) {
      drawShip(g, "Carrier");
      drawShip(g, "Battleship");
      drawShip(g, "Cruiser");
      drawShip(g, "PatrolBoat");
      drawShip(g, "Submarine");
    }
    
    
    //draws target on enemy grid
    if (!playerBoard) {
      if (!SpriteController.spritesActive()) {
        if (GameData.playerTurn) {
          for (int x = 0; x < gridCell.length; x++) {
            for (int y = 0; y < gridCell[x].length; y++) {
              if (gridCell[x][y].contains(GraphicsController.mouseX, GraphicsController.mouseY)) {
                if (!GameData.cpuGridCellData[x][y].firedUpon()) {
                  gridCell[x][y].drawTarget(g, width, height);
                }
              }
            }
          }
        }
      }
    }
    
    //draws hit or miss symbols
    for (int x = 0; x < gridCell.length; x++) {
      for (int y = 0; y < gridCell[x].length; y++) {
        if (playerBoard) {
          if (GameData.playerGridCellData[x][y].firedUpon()) {
            if (GameData.playerGridCellData[x][y].hasShip()) {
              gridCell[x][y].drawHit(g, width, height);
            } else {
              gridCell[x][y].drawMiss(g, width, height);
            }
          }
        } else {
          if (GameData.cpuGridCellData[x][y].firedUpon()) {
            if (GameData.cpuGridCellData[x][y].hasShip()) {
              gridCell[x][y].drawHit(g, width, height);
            } else {
              gridCell[x][y].drawMiss(g, width, height);
            }
          }
        }
      }
    }
    
    //plays cpu turn if it is its turn
    if (playerBoard) {
      if (!GameData.playerTurn && !GameData.turnComplete) {
        cpuTurn(); 
      }
    }
    
  }
  
  
  //draws ships on the grid
  private void drawShip(Graphics g, String ship) {
    
    ShipData shipData = GameData.getShipData(ship, playerBoard);
    int shipSize = GameData.shipSize(ship);
    BufferedImage shipVertical = null;
    BufferedImage shipHorizontal = null;
    
    switch (ship) {
      case "Carrier": shipVertical = Resources.gameCarrierVertical;
      shipHorizontal = Resources.gameCarrierHorizontal;
      break;
      case "Battleship": shipVertical = Resources.gameBattleshipVertical;
      shipHorizontal = Resources.gameBattleshipHorizontal;
      break;
      case "Cruiser": shipVertical = Resources.gameCruiserVertical;
      shipHorizontal = Resources.gameCruiserHorizontal;
      break;
      case "PatrolBoat": shipVertical = Resources.gamePatrolBoatVertical;
      shipHorizontal = Resources.gamePatrolBoatHorizontal;
      break;
      case "Submarine": shipVertical = Resources.gameSubmarineVertical;
      shipHorizontal = Resources.gameSubmarineHorizontal;
      break;
      default:
        break;
        
    }
    
    
    if (GameData.shipPlaced(ship, playerBoard)) {
      int cellX = gridCell[shipData.getX()][shipData.getY()].getX();
      int cellY = gridCell[shipData.getX()][shipData.getY()].getY();
      int cellLength = gridCell[shipData.getX()][shipData.getY()].getLength();
      if (shipData.isVertical()) {
        g.drawImage(shipVertical, cellX, cellY, cellLength, cellLength * shipSize, null);
      } else {
        g.drawImage(shipHorizontal, cellX, cellY, cellLength * shipSize, cellLength, null);
      }
    } else if (GameData.activeShipSelection(playerBoard).equals(ship) && selection) {
      for (int x = 0; x < gridCell.length; x++) {
        for (int y = 0; y < gridCell[x].length; y++) {
          if (gridCell[x][y].contains(GraphicsController.mouseX, GraphicsController.mouseY)) {
            if (GameData.acceptableBounds(ship, x, y, playerBoard)) {
              int cellX = gridCell[x][y].getX();
              int cellY = gridCell[x][y].getY();
              int cellLength = gridCell[x][y].getLength();
              if (GameData.verticalPlacement) {
                g.drawImage(shipVertical, cellX, cellY, cellLength, cellLength * shipSize, null);
              } else {
                g.drawImage(shipHorizontal, cellX, cellY, cellLength * shipSize, cellLength, null);
              }
            }
          }
        }
      }
    }
    
  }
  
  
  //randomizes the placement of ships
  private void randomizeShips(boolean playerBoard) {
    
    for (int i = 0; i < 5; i++) {
      
      if (Random.randomBoolean()) {
        GameData.changeRotation();
      }
      
      if (!playerBoard) {
        switch (GameData.shipsPlaced(playerBoard)) {
          case 0: placeShip("Carrier", playerBoard);
          break;
          case 1: placeShip("Battleship", playerBoard);
          break;
          case 2: placeShip("Cruiser", playerBoard);
          break;
          case 3: placeShip("PatrolBoat", playerBoard);
          break;
          case 4: placeShip("Submarine", playerBoard);
          break;
          default:
            battleship.utilities.Dialogs.criticalError("Illegal value for GameData.shipsPlaced() in Grid.randomizeCPUShips()");
            break;
        }
      }
    }
  }
  
  
  //places ships on grid
  private void placeShip(String ship, boolean playerBoard) {
    
    int shipSize = GameData.shipSize(ship);
    
    if (playerBoard) {
      for (int x = 0; x < gridCell.length; x++) {
        for (int y = 0; y < gridCell[x].length; y++) {
          if (gridCell[x][y].contains(GraphicsController.mouseX, GraphicsController.mouseY)) {
            if (GameData.acceptableBounds(ship, x, y, playerBoard)) {
              Sound.place.play();
              GameData.placeShip(ship, x, y, playerBoard);
            }
          }
        }
      }
    } else {
      while (true) {
        int x = Random.randomInt(0, 9);
        int y = Random.randomInt(0, 9);
        if (GameData.acceptableBounds(ship, x, y, playerBoard)) {
          GameData.placeShip(ship, x, y, playerBoard);
          break;
        }
      }
      
    }
  }
  
  
  //finds distance from side to point on grid for projectiles
  private int distanceFromSide (int x, boolean playerBoard) {
    double distance = 0;
    if (!playerBoard) {
      distance = screenWidth - (gridRect.getX() + (gridCell[0][0].getLength() * x) + (gridCell[0][0].getLength() / 2));
    } else {
      distance = (gridRect.getX() + (gridCell[0][0].getLength() * x) + (gridCell[0][0].getLength() / 2));
    }
    return (int)distance;
  }
  
  
  //plays the cpu turn
  private void cpuTurn() {
    
    int chance = Random.randomInt(1, 3);
    
    while (true) {
      
      int x = Random.randomInt(0, 9);
      int y = Random.randomInt(0, 9);
      
      if (chance == 1) {
        if (!GameData.playerGridCellData[x][y].hasShip()) {
          break;
        }
      }
      
      if (!GameData.playerGridCellData[x][y].firedUpon()) {
        Sound.fire.play();
        SpriteController.createSprite(new Sprite_Projectile(new Point(-100, 
                                                                      gridCell[x][y].getY() 
                                                                        + (gridCell[x][y].getLength() / 2)),
                                                            20,
                                                            20,
                                                            Color.BLACK), 
                                      new Vector[]{
          new Vector_Translate(0, 0.4, (distanceFromSide(x, playerBoard) + 100)), 
            new Vector_Rotate(1, 0.4, -1)});
        GameData.fire(x, y, true);
        break;
      }
    }
    
  }
  
  //called whenever mouse is clicked
  public void mouseClick() {
    
    if (!SpriteController.spritesActive()) {
      
      if (selection) {
        
        rotateButton.mouseClick();
        
        switch (GameData.shipsPlaced(playerBoard)) {
          case 0: placeShip("Carrier", playerBoard);
          break;
          case 1: placeShip("Battleship", playerBoard);
          break;
          case 2: placeShip("Cruiser", playerBoard);
          break;
          case 3: placeShip("PatrolBoat", playerBoard);
          break;
          case 4: placeShip("Submarine", playerBoard);
          break;
          default:
            battleship.utilities.Dialogs.criticalError("Illegal value for GameData.shipsPlaced() in Grid.mouseClick()");
            break;
        }
      }
      
      if(!playerBoard) {
        if (GameData.playerTurn) {
          
          for (int x = 0; x < gridCell.length; x++) {
            for (int y = 0; y < gridCell[x].length; y++) {
              if (gridCell[x][y].contains(GraphicsController.mouseX, GraphicsController.mouseY)) {
                if (!GameData.cpuGridCellData[x][y].firedUpon()) {
                  Sound.fire.play();
                  SpriteController.createSprite(new Sprite_Projectile(new Point(screenWidth + 100, 
                                                                                gridCell[x][y].getY() 
                                                                                  + (gridCell[x][y].getLength() / 2)),
                                                                      20,
                                                                      20,
                                                                      Color.BLACK), 
                                                new Vector[]{
                    new Vector_Translate(180, 0.4, (distanceFromSide(x, playerBoard) + 100)), 
                      new Vector_Rotate(1, 0.4, -1)});
                  GameData.fire(x, y, playerBoard);
                }
              }
            }
          }
          
        }
      }
      
    }
    
  }
  
  
}