package model;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

import move.*;

public class ReleaseLevel extends Level{
	/**
	 * Generated serrialized
	 */
	private static final long serialVersionUID = 4710492805516683152L;
	int Sets;

	int redCounter;
	int yellowCounter;
	int greenCounter;
	
	int[] squareNum;
	Color[] cl;
	
	public ReleaseLevel(LevelState ls){
		super(ls);
	}
	
	public ReleaseLevel(int LevelNumber, String LevelType, Board b, Bullpen p,int[] squareNum,Color[] cl) {
		super(LevelNumber, LevelType, b, p);
		this.squareNum=squareNum;
		this.cl =cl;
		
		Sets = 0;
		redCounter = 0;
		yellowCounter = 0;
		greenCounter = 0;
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
		Board b = new Board(this.getBoard().getSquare());
		b.sethint(this.getBoard().getHint());
		Bullpen bp = new Bullpen(bullpenPiece);
		this.levelState = new LevelState(this.LevelNumber, this.LevelType, b, 
				-1, -1, this.isLocked(), this.star, bp, this.squareNum, this.cl);
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
		this.bullpenPiece = new ArrayList<Piece>();
		for (Piece piece: this.p.getPieces()){
			this.bullpenPiece.add(piece);
		}
		
	}

	@Override
	public void checkAchievement() {
		Sets = 0;
		if(redCounter == 6){
			Sets++;
		}
		if(greenCounter == 6){
			Sets++;
		}
		if(yellowCounter == 6){
			Sets++;
		}
		
		
		if(Sets == 1){
			updateLevelStar(new Achievement(1));
		}else if(Sets == 2){
			updateLevelStar(new Achievement(2));
		}else if(Sets == 3){
			updateLevelStar(new Achievement(3));
			//end level
		}else{
			updateLevelStar(new Achievement(0));
		}
		
	}
	
	public int getRedCounter() {
		return redCounter;
	}
	
	public void increamentRed(){
		redCounter++;
	}

	public int getYellowCounter() {
		return yellowCounter;
	}
	
	public void increamentYellow(){
		yellowCounter++;
	}

	public int getGreenCounter() {
		return greenCounter;
	}
	
	public void increamentGreen(){
		greenCounter++;
	}

	public void setRedCounter(int redCounter) {
		this.redCounter = redCounter;
	}

	public void setYellowCounter(int yellowCounter) {
		this.yellowCounter = yellowCounter;
	}

	public void setGreenCounter(int greenCounter) {
		this.greenCounter = greenCounter;
	}

}
