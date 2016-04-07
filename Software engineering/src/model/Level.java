package model;

import java.io.File;
import java.io.Serializable;
import move.*;
public abstract class Level implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int LevelNumber;
	String LevelType;
	Board b;
	Bullpen p;
	IMove move;
	boolean locked;
	Achievement star;
	public Level(int LevelNumber, String LevelType, Board b, Bullpen p){
		this.LevelNumber = LevelNumber;
		this.LevelType = LevelType;
		this.b = b;
		this.p = p;
	}
	abstract public boolean hasWon();
	abstract public boolean doMove(IMove m);
	abstract public void loadLevel(File f);
}
