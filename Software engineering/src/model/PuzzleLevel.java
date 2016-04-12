package model;

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
	public boolean doMove(IMove m) {
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



}
