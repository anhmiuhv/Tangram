package controller;

import java.util.TimerTask;

import view.LevelView;

public class TimerController extends TimerTask {
	
	LevelView levelview;
	
	
	public TimerController(LevelView levelview){
		this.levelview =levelview;
		
	}
	
	@Override  
	public void run() {  
	    System.out.println("dddd");  
  }  

}
