package battleship.utilities;

//imports necessary libraries
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: This class is used to buffer all the ingame resources
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class Resources {
  
  /**
   * Boolean of whether or not resources are buffered
   */
  public static boolean resourcesBuffered = false;
  
  /**
   * Menu resource for the logo
   */
  public static BufferedImage menuLogo;
  
  /**
   * Menu resource for the artwork
   */
  public static BufferedImage menuPicture;
  
  /**
   * Menu resource for the victory screen
   */
  public static BufferedImage menuVictory;
  
  /**
   * Menu resource for the defeat screen
   */
  public static BufferedImage menuDefeat;
  
  /**
   * Menu resource for the victory screen text
   */
  public static BufferedImage menuVictoryText;
  
  /**
   * Menu resource for the defeat screen text
   */
  public static BufferedImage menuDefeatText;
  
  
  /**
   * Game resource for the status icon
   */
  public static BufferedImage gameStatusIcon;
  
  /**
   * Game resource for the target
   */
  public static BufferedImage gameTarget;
  
  /**
   * Game resource for the hit icon
   */
  public static BufferedImage gameHit;
  
  /**
   * Game resource for the miss icon
   */
  public static BufferedImage gameMiss;
  
  /**
   * Game resource for the horizontal carrier
   */
  public static BufferedImage gameCarrierHorizontal;
  
  /**
   * Game resource for the horizontal battleship
   */
  public static BufferedImage gameBattleshipHorizontal;
  
  /**
   * Game resource for the horizontal cruiser
   */
  public static BufferedImage gameCruiserHorizontal;
  
  /**
   * Game resource for the horizontal patrol boat
   */
  public static BufferedImage gamePatrolBoatHorizontal;
  
  /**
   * Game resource for the horizontal submarine
   */
  public static BufferedImage gameSubmarineHorizontal;
  
  /**
   * Game resource for the vertical carrier
   */
  public static BufferedImage gameCarrierVertical;
  
  /**
   * Game resource for the vertical battleship
   */
  public static BufferedImage gameBattleshipVertical;
  
  /**
   * Game resource for the vertical cruiser
   */
  public static BufferedImage gameCruiserVertical;
  
  /**
   * Game resource for the vertical patrol boat
   */
  public static BufferedImage gamePatrolBoatVertical;
  
  /**
   * Game resource for the vertical submarine
   */
  public static BufferedImage gameSubmarineVertical;
  
  
  /**
   * Buffers program resources
   */
  public static void bufferResources() {
    if (!resourcesBuffered) {
      try {
        menuLogo = ImageIO.read(getClass().getResource("battleship/resources/images/menu/logo.png"));
        menuPicture = ImageIO.read(new File("battleship/resources/images/menu/menuPicture.png"));
        menuVictory = ImageIO.read(new File("battleship/resources/images/menu/victory.png"));
        menuDefeat = ImageIO.read(new File("battleship/resources/images/menu/defeat.png"));
        menuVictoryText = ImageIO.read(new File("battleship/resources/images/menu/victoryText.png"));
        menuDefeatText = ImageIO.read(new File("battleship/resources/images/menu/defeatText.png"));
        gameStatusIcon = ImageIO.read(new File("battleship/resources/images/game/status.png"));
        gameTarget = ImageIO.read(new File("battleship/resources/images/game/target.png"));
        gameHit = ImageIO.read(new File("battleship/resources/images/game/hit.png"));
        gameMiss = ImageIO.read(new File("battleship/resources/images/game/miss.png"));
        gameCarrierHorizontal = ImageIO.read(new File("battleship/resources/images/game/carrierHorizontal.png"));
        gameBattleshipHorizontal = ImageIO.read(new File("battleship/resources/images/game/battleshipHorizontal.png"));
        gameCruiserHorizontal = ImageIO.read(new File("battleship/resources/images/game/cruiserHorizontal.png"));
        gamePatrolBoatHorizontal = ImageIO.read(new File("battleship/resources/images/game/patrolBoatHorizontal.png"));
        gameSubmarineHorizontal = ImageIO.read(new File("battleship/resources/images/game/submarineHorizontal.png"));
        gameCarrierVertical = ImageIO.read(new File("battleship/resources/images/game/carrierVertical.png"));
        gameBattleshipVertical = ImageIO.read(new File("battleship/resources/images/game/battleshipVertical.png"));
        gameCruiserVertical = ImageIO.read(new File("battleship/resources/images/game/cruiserVertical.png"));
        gamePatrolBoatVertical = ImageIO.read(new File("battleship/resources/images/game/patrolBoatVertical.png"));
        gameSubmarineVertical = ImageIO.read(new File("battleship/resources/images/game/submarineVertical.png"));
      }  catch (IOException e) {
        Dialogs.error("IOException while buffering resources; not all images may be displayed correctly.");
      }
      resourcesBuffered = true;
    }
  }
  
}