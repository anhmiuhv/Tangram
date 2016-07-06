package model;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

/**
 * Representation of a LightningLevel in the model.
 * @author jshen3, kdai, xwang11
 */
public class LightningLevel extends Level{
	int allowedTime;
	int usedTime;
	
	/**
	 * Create the LightningLevel read from file.
	 * @param ls
	 */
	public LightningLevel(LevelState ls){
		super(ls);
	}
	
	/**
	 * Create the LightningLevel using given data.
	 * @param LevelNumber
	 * @param LevelType
	 * @param b
	 * @param p
	 * @param allowedTime
	 */
	public LightningLevel(int LevelNumber, String LevelType, Board b, Bullpen p, int allowedTime) {
		super(LevelNumber, LevelType, b, p);
		this.allowedTime = allowedTime;
	}

	/**
	 * Return allowed time limite of this level.
	 * @return int
	 */
	public int getAllowedTime(){
		return allowedTime;
	}
	
	/**
	 * Return time used when playing.
	 * @return int
	 */
	public int getUsedTime(){
		return usedTime;
	}
	
	/**
	 * Set time used in this level.
	 * @param num
	 */
	public void setUsedTime(int num){
		this.usedTime = num;
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

	
	
	@Override
	public void createLevelState() {
		Board b = new Board(this.getBoard().getSquare());
		b.sethint(this.getBoard().getHint());
		Bullpen bp = new Bullpen(bullpenPiece);
		System.out.println(bullpenPiece.get(0).getColor());
		this.levelState = new LevelState(this.LevelNumber, this.LevelType, b, -1,
				this.allowedTime, this.isLocked(), this.star, bp, new int[0], new Color[0]);
		
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
		this.allowedTime = levelState.getAllowedTime();
		this.bullpenPiece = new ArrayList<Piece>();
		for (Piece piece: this.p.getPieces()){
			//System.out.println(piece.getColor());
			this.bullpenPiece.add(piece);
		}
	}


	@Override
	public void checkAchievement() {
		int totalCover = 0;
		for(int i = 0;i<b.getCover().length;i++){
			if(b.getCover()[i] == 1){
				totalCover++;
			}
		}

		if(	totalCover == b.getCover().length){
			updateLevelStar(new Achievement(3));
		}else if(totalCover >= b.getCover().length - 1*6){
			updateLevelStar(new Achievement(2));
		}else if(totalCover >= b.getCover().length - 2*6){
			updateLevelStar(new Achievement(1));
			//end level
		}else{
			updateLevelStar(new Achievement(0));
		}
		
	}
	
}
