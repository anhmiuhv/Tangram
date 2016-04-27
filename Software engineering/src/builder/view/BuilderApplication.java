package builder.view;


import builder.model.Builder;
/**
 * Top level view
 * @author lthoang
 *
 */
public class BuilderApplication {
	public levelBuilder lvlBuilder;
	Builder builder;
	
	public BuilderApplication(Builder builder){
		this.builder = builder;
		this.lvlBuilder = new levelBuilder(builder.getKBuilder());
		init();
	}
	
	 public void init() {
		    // Throw a nice little title page up on the screen first
		    SplashScreen splash = new SplashScreen(5000);
		    // Normally, we'd call splash.showSplash() and get on with the program.
		    // But, since this is only a test...
		    splash.showSplashAndExit();
		   // LevelView levelSec = new LevelView();
//			nw.LevelSelectStart();
			lvlBuilder.setVisible(true);
		  }
	 
}