package model;

import java.io.File;

import move.*;

public class ReleaseLevel extends Level{
	/**
	 * Generated serrialized
	 */
	private static final long serialVersionUID = 4710492805516683152L;
	int Sets;
	int[] redCounter;
	int[] yellowCounter;
	int[] blueCounter;
	
	
	public ReleaseLevel(int LevelNumber, String LevelType, Board b, Bullpen p) {
		super(LevelNumber, LevelType, b, p);
		// TODO Auto-generated constructor stub
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

}