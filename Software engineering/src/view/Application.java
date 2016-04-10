package view;

public class Application {
	
	
	
	
	
	  public static void main(String[] args) {
		    // Throw a nice little title page up on the screen first
		    SplashScreen splash = new SplashScreen(1000);
		    // Normally, we'd call splash.showSplash() and get on with the program.
		    // But, since this is only a test...
		    splash.showSplashAndExit();
		     LevelSelection levelSec = new LevelSelection();
		     levelSec.LevelSelectStart();
		  }
		  
}
