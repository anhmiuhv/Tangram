package model;

import java.io.File;
import java.io.Serializable;
import move.*;
public abstract class Level implements Serializable{
	
	
	int LevelNumber;
	String LevelType;
	Board b;
	Bullpen p;
	boolean locked;
	Achievement star;
	public Level(int LevelNumber, String LevelType, Board b, Bullpen p){
		this.LevelNumber = LevelNumber;
		this.LevelType = LevelType;
		this.b = b;
		this.p = p;
	}
	
	public int levelTypeNum(){
		if(LevelType.compareTo("puzzle")==0){
		return 0;
		}
		else if(LevelType.compareTo("lightning")==0){
		return 1;
		}
		else{
		return 2;
		}
	}
	
	 public Bullpen getBullpen(){
		 return p;
	 }
	 
	 public Board getBoard(){
		 return b;
	 }
	
	abstract public boolean hasWon();
	abstract public boolean doMove(IMove m);
	abstract public void loadLevel(File f);
}
