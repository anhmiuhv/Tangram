package model;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

public class PuzzleLevel extends Level {
	int allowedMove;
	int usedMove;
	public PuzzleLevel(LevelState ls){
		super(ls);
	}
	
	public PuzzleLevel(int LevelNumber, String LevelType, Board b, Bullpen p, int allowedMove) {
		super(LevelNumber, LevelType, b, p);
		this.allowedMove = allowedMove;
		this.usedMove = 0;
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
		Board b = new Board(this.getBoard().getSquare());
		b.sethint(this.getBoard().getHint());
		Bullpen bp = new Bullpen(bullpenPiece);
		this.levelState = new LevelState(this.LevelNumber, this.LevelType, b, 
				this.allowedMove, -1, this.isLocked(), this.star, bp, new int[0], new Color[0]);
		
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
		this.bullpenPiece = new ArrayList<Piece>();
		for (Piece piece: this.p.getPieces()){
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
		
		if(totalCover == (getBullpen().getPieces().size())*6 - 2*6){
			updateLevelStar(new Achievement(1));
		}else if(totalCover == (getBullpen().getPieces().size())*6 - 1*6){
			updateLevelStar(new Achievement(2));
		}else if(totalCover == (getBullpen().getPieces().size())*6){
			updateLevelStar(new Achievement(3));
			//end level
		}else{
			updateLevelStar(new Achievement(0));
		}
	}



}
