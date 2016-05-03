package builder.view;


import builder.model.Builder;
/**
 * Top level view
 * @author lthoang
 *
 */
public class BuilderApplication {
	levelBuilder lvlBuilder;
	Builder builder;
	boolean splasher;

	/**
	 * initiate builder
	 * @param builder the parent builder model
	 * @param splasher if using splash screen
	 */
	public BuilderApplication(Builder builder, boolean splasher){
		this.builder = builder;
		this.lvlBuilder = new levelBuilder(builder.getKBuilder());
		this.splasher = splasher;
		init();
	}

	/**
	 * initiate builder
	 * @param builder builder model
	 */
	public BuilderApplication(Builder builder){
		this.builder = builder;
		this.lvlBuilder = new levelBuilder(builder.getKBuilder());
		this.splasher = true;
		init();
	}

	public void init() {
		if (splasher){

			SplashScreen splash = new SplashScreen(5000);

			splash.showSplashAndExit();
		}
		lvlBuilder.setVisible(true);
	}

	/**
	 * get the level builder view
	 * @return level builder view
	 */
	public levelBuilder getLvlBuilder() {
		return lvlBuilder;
	}

}