package controller;

import java.util.TimerTask;

import model.Level;
import model.LightningLevel;
import view.LevelSelection;
import view.LevelView;
/**
 * controller for counting the time
 * @author jshen3, kdai, xwang11
 *
 */
public class TimerController extends TimerTask {
	
	LevelView levelview;
	Level level;
	LevelSelection levelselect;
	int timeCount ;	
	/**
	 * constructor
	 * @param levelselect
	 * @param levelview
	 * @param level
	 */
	public TimerController(LevelSelection levelselect,LevelView levelview,Level level){
		this.levelselect =levelselect;
		this.levelview =levelview;
		this.level = level;
		this.timeCount = ((LightningLevel) level).getAllowedTime();

	}
	
	@Override  
	/**
	 * counting time
	 */
	public void run() {  
		timeCount = timeCount-1;
		((LightningLevel) level).setUsedTime(timeCount);

		levelview.reDrawBlueStripe();
		if (timeCount==0){
			
			//levelview.closeWindowsFlag = true;
			//new GoMenuController(levelselect,levelview,level).actionPerformed();
			//levelview.close();
	
			new AchievementController(levelselect,levelview,levelview.getLevel().getAchievement()).actionPerformed();
			
		}
  }  

}
