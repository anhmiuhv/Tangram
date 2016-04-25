package controller;

import java.util.TimerTask;

import model.Level;
import model.LightningLevel;
import view.LevelSelection;
import view.LevelView;

public class TimerController extends TimerTask {
	
	LevelView levelview;
	Level level;
	LevelSelection levelselect;
	int timeCount ;	
	
	public TimerController(LevelSelection levelselect,LevelView levelview,Level level){
		this.levelselect =levelselect;
		this.levelview =levelview;
		this.level = level;
		this.timeCount = ((LightningLevel) level).getAllowedTime();

	}
	
	@Override  
	public void run() {  
		timeCount = timeCount-1;
		((LightningLevel) level).setUsedTime(timeCount);

		levelview.reDrawBlueStripe();
		if (timeCount==0){
			
			levelview.closeWindowsFlag = true;
			new GoMenuController(levelselect,levelview,level).actionPerformed();
			levelview.close();
		}
  }  

}