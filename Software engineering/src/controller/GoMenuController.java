package controller;


import model.Level;
import view.LevelSelection;
import view.LevelView;

public class GoMenuController  extends java.awt.event.MouseAdapter{
	
	LevelSelection levelselect;
	LevelView levelview;
	public GoMenuController(LevelSelection levelselect, LevelView levelview){
		this.levelview=levelview;
		this.levelselect=levelselect;
	}
	
	public void actionPerformed(){
		levelselect.setVisible(true);
		levelview.close();
	}

	
	
	
}