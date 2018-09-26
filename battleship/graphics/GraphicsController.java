package battleship.graphics;

//imports necessary libraries
import battleship.graphics.screens.*;
import battleship.graphics.sprites.SpriteController;
import battleship.utilities.Resources;
import battleship.utilities.Music;
import battleship.utilities.Dialogs;
import battleship.data.GameData;
import battleship.data.GameController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: This class is used to control all graphics in the program
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class GraphicsController extends JPanel implements MouseMotionListener, MouseListener {
  
  public static final int FRAME_RATE = 24; //program frame rate
  public static int activeScreen; //the index number of the active screen from the screen array to be drawn to screen
  public static int mouseX, mouseY; //coordinates of mouse location
  
  //array of screen objects
  private Screen[] screen = {new Screen_Menu(), //menu screen; array index 0
    new Screen_Credits(), //credits screen; array index 1
    new Screen_Selection(), //selection screen; array index 2
    new Screen_Game(), //game screen; array index 3
    new Screen_Victory(), //victory screen; array index 4
    new Screen_Defeat(),//failure screen; array index 5
    new Screen_Loading(), //loading screen; array index 6
    new Screen_Help()}; //help screen; array index 7
  
  private SpriteController sprites = new SpriteController(); //sprite object for sprites
  
  
  //constructor for GraphicsController
  public GraphicsController() {
    GameData.setUpGameData();
    setScreen("Loading");
    startFrameUpdater();
    Resources.bufferResources();
    addMouseMotionListener(this);
    addMouseListener(this);
    setScreen("Menu");
  }
  
  
  //frame timer
  private void startFrameUpdater() {
    ActionListener listener = new ActionListener() {                             
      @Override
      public void actionPerformed(ActionEvent e) {
        
        //updates game prior to repainting each frame
        GameController.updateGame();
        
        //repaints according to frame rate
        repaint();
        
      }
    };
    
    //creates timer for method
    Timer timerFrameUpdate = new Timer((1000 / FRAME_RATE), listener);
    timerFrameUpdate.setInitialDelay(0);
    timerFrameUpdate.start();
    
  }   
  
  //method sets the active screen which the graphics controller draws
  public static void setScreen(String screen) {
    switch (screen) {
      case "Menu":
        Music.music[0].start();
        activeScreen = 0;
        break;
      case "Credits":
        Music.music[1].start();
        activeScreen = 1;
        break;
      case "Selection":
        GameData.resetGameData();
        Music.music[2].start();
        activeScreen = 2;
        break;
      case "Game":
        Music.music[3].start();
        activeScreen = 3;
        break;
      case "Victory":
        Music.music[4].start();
        activeScreen = 4;
        break;
      case "Defeat":
        Music.music[5].start();
        activeScreen = 5;
        break;
      case "Loading":
        activeScreen = 6;
        break;
      case "Help":
        Music.music[0].start();
        activeScreen = 7;
        break;
      case "Quit":
        System.exit(0);
      default:
        Dialogs.criticalError("Critical Error: Invalid screen set by program.");
        throw new IllegalArgumentException("Invalid Screen Set");
    }
  }
  
  //returns if game is active
  public static boolean gameActive() {
    if (activeScreen == 2 || activeScreen == 3) {
      return true;
    } else {
      return false;
    }
  }
  
  //updates mouse position variables everytime mouse is moved
  public void mouseMoved(MouseEvent e) {
    mouseX = e.getX();
    mouseY = e.getY();
  }
  
  
  //invokes whenever mouse is clicked
  public void mouseClicked(MouseEvent e) {
    screen[activeScreen].mouseClick();
  }
  
  
  //required implimentation for MouseMotionListener & mouseListener; does nothing
  public void mouseDragged(MouseEvent e){}
  public void mousePressed(MouseEvent e) {}
  public void mouseReleased(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}
  
  
  //paint component to draw to screen
  public void paintComponent(Graphics g) {
    
    int width = getSize().width;
    int height = getSize().height;
    
    screen[activeScreen].draw(g, width, height); //draws active screen
    
    sprites.draw(g, width, height); //draws active sprites
    
    g.dispose(); //disposes graphics object
  }
  
}