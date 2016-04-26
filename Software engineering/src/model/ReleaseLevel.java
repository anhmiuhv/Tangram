package model;

import java.awt.Color;
import java.io.File;

import move.*;

public class ReleaseLevel extends Level{
	/**
	 * Generated serrialized
	 */
	private static final long serialVersionUID = 4710492805516683152L;
	int Sets;
	int redCounter;
	int yellowCounter;
	int blueCounter;
	
	int[] squareNum;
	Color[] cl;
	
	public ReleaseLevel(LevelState ls){
		super(ls);
	}
	
	public ReleaseLevel(int LevelNumber, String LevelType, Board b, Bullpen p,int[] squareNum,Color[] cl) {
		super(LevelNumber, LevelType, b, p);
		this.squareNum=squareNum;
		this.cl =cl;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean hasWon() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void loadLevel(File f) {
		// TODO Auto-generated method stub
		
	}
	
	public int[] getSquareNum(){
		return squareNum;
	}
	
	public Color[] getCl(){
		return cl;
	}

	@Override
	public void createLevelState() {
		this.levelState = new LevelState(this.LevelNumber, this.LevelType, this.b, -1,
				-1, this.locked, this.star, this.p, this.squareNum, this.cl);
	}

	@Override
	public void loadLevelState(LevelState levelState) {
		this.levelState = levelState;
		this.LevelNumber = levelState.getLevelNum();
		this.LevelType = levelState.getLevelType();
		this.b = new Board(levelState.getBoard().getSquare());
		this.b.sethint(levelState.getBoard().getHint());
		this.p = levelState.getBullpen();
		this.locked = levelState.getLocked();
		this.star = levelState.getAchievement();
		this.squareNum = levelState.getSquareNum();
		this.cl = levelState.getCl();
		
	}

	@Override
	public void checkAchievement() {
		// TODO Auto-generated method stub
		
	}

}
