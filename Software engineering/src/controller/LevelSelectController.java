package controller;

import java.awt.event.MouseEvent;

import model.Level;
import view.LevelSelection;
import view.LevelView;

public class LevelSelectController  extends java.awt.event.MouseAdapter{
	
	LevelSelection levelselect;
	Level level;
	public LevelSelectController(LevelSelection levelselect, Level level){
		this.level=level;
		this.levelselect=levelselect;
	}
	
	public void actionPerformed(){
		LevelView nw = new LevelView(level,levelselect);
		levelselect.setVisible(false);
	}

	
	
	
}
