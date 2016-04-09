package builder.view;

import java.awt.EventQueue;

import builder.model.Builder;

public class BuilderApplication {
	levelBuilder lvlBuilder;
	Builder builder;
	
	public BuilderApplication(Builder builder){
		this.builder = builder;
		this.lvlBuilder = new levelBuilder();
		init();
	}
	
	 public void init() {
		    // Throw a nice little title page up on the screen first
		    SplashScreen splash = new SplashScreen(1000);
		    // Normally, we'd call splash.showSplash() and get on with the program.
		    // But, since this is only a test...
		    splash.showSplashAndExit();
		   // LevelView levelSec = new LevelView();
//			nw.LevelSelectStart();
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						levelBuilder frame = new levelBuilder();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		  }
}
