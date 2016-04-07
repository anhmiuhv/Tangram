package model;

import java.io.File;

import move.Move;

public class LightningLevel extends Level{
	int allowedTime;
	public LightningLevel(int LevelNumber, String LevelType, Board b, Bullpen p, int allowedTime) {
		super(LevelNumber, LevelType, b, p);
		this.allowedTime = allowedTime;
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
