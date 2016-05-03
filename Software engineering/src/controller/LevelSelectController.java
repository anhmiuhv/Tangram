package controller;



import model.Level;
import view.LevelSelection;
import view.LevelView;
/**
 * the controller for selecting levels
 * @author jshen3, kdai, xwang11
 *
 */
public class LevelSelectController  extends java.awt.event.MouseAdapter{
	
	LevelSelection levelselect;
	Level level;
	public LevelSelectController(LevelSelection levelselect, Level level){
		this.level=level;
		this.levelselect=levelselect;
	}
	/**
	 * handling selecting the level
	 */
	public void actionPerformed(){
		@SuppressWarnings("unused")
		LevelView nw = new LevelView(level,levelselect);
		levelselect.setVisible(false);
	}

	
	
	
}
