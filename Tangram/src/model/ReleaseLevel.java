package model;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

/**
 * Representation of a ReleaseLevel in the model.
 * @author jshen3, kdai, xwang11
 */
public class ReleaseLevel extends Level{
	int Sets;

	int redCounter;
	int yellowCounter;
	int greenCounter;
	
	int[] squareNum;
	Color[] cl;
	
	/**
	 * Create a releaseLevel by reading from file.
	 * @param ls
	 */
	public ReleaseLevel(LevelState ls){
		super(ls);
	}
	
	/**
	 * Create a releaseLevel using given data.
	 * @param LevelNumber
	 * @param LevelType
	 * @param b
	 * @param p
	 * @param squareNum
	 * @param cl
	 */
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
	
	/**
	 * Return the numbers appar on the board.
	 * @return int[]
	 */
	public int[] getSquareNum(){
		return squareNum;
	}
	
	/**
	 * Return the color of the numbers appar on the board.
	 * @return Color[]
	 */
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
	
	/**
	 * Return the number of covered red numbers.
	 * @return int
	 */
	public int getRedCounter() {
		return redCounter;
	}
	
	/**
	 * Increment the value of redCounter.
	 */
	public void increamentRed(){
		redCounter++;
	}

	/**
	 * Return the number of covered yellow numbers.
	 * @return int
	 */
	public int getYellowCounter() {
		return yellowCounter;
	}
	
	/**
	 * Increment the value of yellowCounter.
	 */
	public void increamentYellow(){
		yellowCounter++;
	}

	/**
	 * Return the number of covered green numbers.
	 * @return int
	 */
	public int getGreenCounter() {
		return greenCounter;
	}
	
	/**
	 * Increment the value of greenCounter.
	 */
	public void increamentGreen(){
		greenCounter++;
	}

	/**
	 * Set the value of redCounter to a given number.
	 * @param redCounter 
	 */
	public void setRedCounter(int redCounter) {
		this.redCounter = redCounter;
	}

	/**
	 * Set the value of yellowCounter to a given number.
	 * @param redCounter 
	 */
	public void setYellowCounter(int yellowCounter) {
		this.yellowCounter = yellowCounter;
	}

	/**
	 * Set the value of greenCounter to a given number.
	 * @param redCounter 
	 */
	public void setGreenCounter(int greenCounter) {
		this.greenCounter = greenCounter;
	}

}
