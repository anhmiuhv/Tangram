package model;

import java.awt.Color;
import java.io.File;

import move.*;

public class PuzzleLevel extends Level {
	/**
	 * Generated serialized
	 */
	private static final long serialVersionUID = -4071396056939768290L;
	int allowedMove = 0;
	int usedMove = 0;
	
	public PuzzleLevel(int LevelNumber, String LevelType, Board b, Bullpen p, int allowedMove) {
		super(LevelNumber, LevelType, b, p);
		this.allowedMove = allowedMove;
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
	
	public int getAllowedMove(){
		return allowedMove;
	}
	
	public int getUsedMove(){
		return usedMove;
	}
	
	public void incrementUsedMove(){
		usedMove++;
	}

	@Override
	public void createLevelState() {
		this.levelState = new LevelState(this.LevelNumber, this.LevelType, this.b, 
				this.allowedMove, -1, this.locked, this.star, this.p, new int[0], new Color[0]);
		
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
		this.allowedMove = levelState.getAllowedMove();

		
	}

	@Override
	public void checkAchievement() {
		int totalCover = 0;
		for(int i = 0;i<b.getCover().length;i++){
			if(b.getCover()[i] == 1){
				totalCover++;
			}
		}
		
		if(totalCover == b.getpiece().size() - 2*6){
			this.star.setAchievement(1);
		}else if(totalCover == b.getpiece().size() - 1*6){
			this.star.setAchievement(2);
		}else if(totalCover == b.getpiece().size()){
			this.star.setAchievement(3);
			//end level
		}else{
			this.star.setAchievement(0);
		}
	}



}
