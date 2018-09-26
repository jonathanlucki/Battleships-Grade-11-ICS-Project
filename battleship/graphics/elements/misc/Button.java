package battleship.graphics.elements.misc;

//imports necessary libraries
import battleship.graphics.elements.Element;
import battleship.graphics.GraphicsController;
import battleship.utilities.Sound;
import java.awt.*;


/**
 * Assignment: Individual Summative Project
 * <p>
 * Program Description: This program creates the game battleship in java
 * <p>
 * Class Description: This class is a screen element which creates buttons
 * @author Jonathan Lucki
 * @version Last modified on 15/06/2016
 */ 


public class Button implements Element {
  
  private Rectangle buttonRect = new Rectangle();
  private String buttonText;
  private Font buttonFont = new Font("Georgia", Font.BOLD, 24);
  private Color buttonColour;
  private Color textColour;
  private String screenChange;
  private int x, y, buttonWidth, buttonHeight;
  private boolean selectionRotateButton = false;
  
  public Button(String buttonText, String screenChange) {
    this.buttonText = buttonText;
    this.screenChange = screenChange;
  }
  
  
  public Button(String buttonText, boolean selectionRotateButton) {
    this.buttonText = buttonText;
    this.selectionRotateButton = selectionRotateButton;
  }
  
  
  //sets boudsn for button
  public void setBounds(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    buttonWidth = width;
    buttonHeight = height;
  }
  
  
  //draws button to screen
  public void draw (Graphics g, int width, int height) {
    
    int mouseX = battleship.graphics.GraphicsController.mouseX;
    int mouseY = battleship.graphics.GraphicsController.mouseY;
    
    Graphics2D g2d = (Graphics2D)g; //constructs graphics 2D object
    
    buttonRect.setBounds(x, y, buttonWidth, buttonHeight);
    
    if(buttonRect.contains(mouseX, mouseY)){
      buttonColour = Color.white;
      textColour = Color.black;
    } else {
      buttonColour = Color.black;
      textColour = Color.white;
    }
    
    //draws button
    g2d.setColor(buttonColour); //sets colour
    g2d.fill(buttonRect); //draws rectangular button
    
    //draws button text
    g2d.setColor(textColour);
    g2d.setFont(buttonFont);
    FontMetrics fm = g2d.getFontMetrics();
    double x = buttonRect.getX() + (buttonRect.getWidth() / 2) - (fm.stringWidth(buttonText) / 2);
    double y = buttonRect.getY() + (buttonRect.getHeight() / 2) + (fm.getHeight() / 3);
    g2d.drawString(buttonText, (float)x, (float)y);
    
    //g2d.dispose(); //disposes of the Graphics2D object
    
  }
  
  
  //called when mouse is clicked
  public void mouseClick() {
    
    int mouseX = battleship.graphics.GraphicsController.mouseX;
    int mouseY = battleship.graphics.GraphicsController.mouseY;
    
    if(buttonRect.contains(mouseX, mouseY)){
      Sound.button.play();
      if (selectionRotateButton) {
        battleship.data.GameData.changeRotation();
      } else {
        battleship.graphics.GraphicsController.setScreen(screenChange);
      }
    }
  }
  
}