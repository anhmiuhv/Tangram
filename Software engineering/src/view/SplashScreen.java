package view;
// SplashScreen.java
// A simple application to show a title screen in the center of the screen
// for the amount of time given in the constructor.  This class includes
// a sample main() method to test the splash screen, but it's meant for use
// with other applications.
//

import java.awt.*;
import javax.swing.*;

public class SplashScreen extends JWindow {
  /**
	 * 
	 */
	private static final long serialVersionUID = 4269604548453140157L;
private int duration;
  public SplashScreen(int d) {
    duration = d;
  }

  
  // A simple little method to show a title screen in the center
  // of the screen for the amount of time given in the constructor
  public void showSplash() {
    JPanel content = (JPanel)getContentPane();
    content.setBackground(Color.white);
    

    // Set the window's bounds, centering the window
    int width = 1000;
    int height = 500;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (screen.width-width)/2;
    int y = (screen.height-height)/2;
    setBounds(x,y,width,height);
    

    // Build the splash screen
    

    Color oraRed = new Color(156, 20, 20,  255);
    content.setBorder(BorderFactory.createLineBorder(oraRed, 10));
    

    SplashS Names = new SplashS();
    content.add(Names, BorderLayout.CENTER);
    
   
    
    


    // Display it
    setVisible(true);

    // Wait a little while, maybe while loading resources
    try { Thread.sleep(duration); } catch (Exception e) {}

    setVisible(false);
  }
  public void showSplashAndExit() {
    showSplash();
  }
  

  

}