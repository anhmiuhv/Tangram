package controller;



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
		@SuppressWarnings("unused")
		LevelView nw = new LevelView(level,levelselect);
		levelselect.setVisible(false);
	}

	
	
	
}
