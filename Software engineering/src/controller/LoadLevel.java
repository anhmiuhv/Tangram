package controller;

import java.awt.Color;
import java.util.Random;

import model.Achievement;
import model.Board;
import model.Bullpen;
import model.Level;
import model.LightningLevel;
import model.Piece;
import model.PuzzleLevel;
import model.ReleaseLevel;
import model.Square;


public class LoadLevel {

	
	public LoadLevel() {
		
	}
	
	  public static Level[] createTestLevel(){
			Level[] testLevels = new Level[15];
			for (int i=0;i<15;i++){
				Square bullPenSquare[] = new Square[6]; 
				bullPenSquare[0] = new Square(1,3);
				bullPenSquare[1] = new Square(0,1);
				bullPenSquare[2] = new Square(0,2);
				bullPenSquare[3] = new Square(0,3);
				bullPenSquare[4] = new Square(0,4);
				bullPenSquare[5] = new Square(0,5);		
				
				Piece bullPenPiece = new Piece(0,0,bullPenSquare,bullPenSquare[0],2);
				bullPenPiece.setColor(new Color(0,0,0));
				
				
				Piece[] bullPenPieceArray = new Piece[6];
				bullPenPieceArray[0] = bullPenPiece;
				bullPenPieceArray[1] = bullPenPiece;
				bullPenPieceArray[2] = bullPenPiece;
				bullPenPieceArray[3] = bullPenPiece;
				bullPenPieceArray[4] = bullPenPiece;
				bullPenPieceArray[5] = bullPenPiece;
				
				Bullpen bp = new Bullpen(bullPenPieceArray);
				
				
				
				Square[] boardSquare = new Square[144]; 
				for (int i1=0;i1<12;i1++){
					for (int j=0;j<12;j++){
				
						boardSquare[i1*12+j] = new Square(i1,j);
					}
				}
				
				Board testBoard = new Board(boardSquare);
				
				if (i%3==0){
				testLevels[i] = new PuzzleLevel(i,GetLevelTpye(i%3),testBoard,bp,20);
				testLevels[i].updateLevelStar(new Achievement(new Random().nextInt(3) + 1));
				}
				else if (i%3==1){
				testLevels[i] = new LightningLevel(i,GetLevelTpye(i%3),testBoard,bp,20);
				testLevels[i].updateLevelStar(new Achievement(new Random().nextInt(3) + 1));
				}
				else {
				testLevels[i] = new ReleaseLevel(i,GetLevelTpye(i%3),testBoard,bp);
				testLevels[i].updateLevelStar(new Achievement(new Random().nextInt(3) + 1));
				}
			}
			testLevels[13].updateLevelStar(new Achievement(0));
			testLevels[14].updateLevelStar(new Achievement(-1));
			
			return testLevels;
			/*
			public Level(int LevelNumber, String LevelType, Board b, Bullpen p){
				this.LevelNumber = LevelNumber;
				this.LevelType = LevelType;
				this.b = b;
				this.p = p;
			}
		
			*/
		}
		public static String GetLevelTpye(int levelNum){
			if(levelNum==0){
				return "puzzle";
			}
			else if(levelNum==1){
				return "lightning";
			}
			else {
				return "release";
			}
		}

}

