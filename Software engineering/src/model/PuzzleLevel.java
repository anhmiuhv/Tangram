package model;

import java.io.File;

import move.Move;

public class PuzzleLevel extends Level {
	int allowedMove;
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
	public boolean doMove(Move m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void loadLevel(File f) {
		// TODO Auto-generated method stub
		
	}

}
