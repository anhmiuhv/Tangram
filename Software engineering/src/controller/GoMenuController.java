package controller;


import model.Level;
import view.LevelSelection;
import view.LevelView;

public class GoMenuController  extends java.awt.event.MouseAdapter{
	
	LevelSelection levelselect;
	LevelView levelview;
	Level level;
	public GoMenuController(LevelSelection levelselect, LevelView levelview,Level level){
		this.levelview=levelview;
		this.levelselect=levelselect;
		this.level = level;
	}
	
	public void actionPerformed(){

		level.createLevelState();
		level.getLevelState().saveState();
		
		levelselect.reloadLevel();
		levelselect.setVisible(true);
		
		
		if (level.getlevelTypeNum()==1){
		levelview.getTimer().cancel();
		}
		levelview.close();
	}

	
	
	
}