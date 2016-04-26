package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;


import view.Application;
import view.LevelSelection;
import view.SplashScreen;

public class Kabasuji {
	Level[] levels;


	public static void main(String[] args) {
		// Throw a nice little title page up on the screen first

		SplashScreen splash = new SplashScreen(500);
		// Normally, we'd call splash.showSplash() and get on with the program.
		// But, since this is only a test...
		splash.showSplashAndExit();
		
		/*
		LevelState createAlevel = new LevelState();
		createAlevel.loadState("puzzle1.sav");
		PuzzleLevel p = new PuzzleLevel(0, null, null, null, 0);
		p.loadLevelState(createAlevel);
		Level[] l = new Level[1];
		l[0] = p;
		*/
		//Application app = new Applicaiton();
		LevelSelection levelSec = new LevelSelection( createPhaseTwoLevel());
	}



	public Kabasuji(Level[] level){
		this.levels = level;
		LevelSelection levelSec = new LevelSelection(level);
	}


	private void initializeControllers() {

	}

	public static Level[] createPhaseTwoLevel(){
		Level[] testLevels = new Level[1];
		
		Square Level1Piece1[] = new Square[6]; 
		Level1Piece1[0] = new Square(0,0);
		Level1Piece1[1] = new Square(1,0);
		Level1Piece1[2] = new Square(2,0);
		Level1Piece1[3] = new Square(3,0);
		Level1Piece1[4] = new Square(4,0);
		Level1Piece1[5] = new Square(5,0);		
		
		Square Level1Piece2[] = new Square[6]; 
		Level1Piece2[0] = new Square(0,1);
		Level1Piece2[1] = new Square(0,0);
		Level1Piece2[2] = new Square(1,0);
		Level1Piece2[3] = new Square(2,0);
		Level1Piece2[4] = new Square(3,0);
		Level1Piece2[5] = new Square(4,0);		
		
		Square Level1Piece3[] = new Square[6]; 
		Level1Piece3[0] = new Square(0,0);
		Level1Piece3[1] = new Square(0,1);
		Level1Piece3[2] = new Square(0,2);
		Level1Piece3[3] = new Square(1,0);
		Level1Piece3[4] = new Square(1,1);
		Level1Piece3[5] = new Square(1,2);		
		
		Square Level1Piece4[] = new Square[6]; 
		Level1Piece4[0] = new Square(0,0);
		Level1Piece4[1] = new Square(1,0);
		Level1Piece4[2] = new Square(1,1);
		Level1Piece4[3] = new Square(1,2);
		Level1Piece4[4] = new Square(1,3);
		Level1Piece4[5] = new Square(2,3);
		
		Square Level1Piece5[] = new Square[6]; 
		Level1Piece5[0] = new Square(2,0);
		Level1Piece5[1] = new Square(2,1);
		Level1Piece5[2] = new Square(1,1);
		Level1Piece5[3] = new Square(0,1);
		Level1Piece5[4] = new Square(0,2);
		Level1Piece5[5] = new Square(1,2);	
		
		Square Level1Piece6[] = new Square[6]; 
		Level1Piece6[0] = new Square(2,0);
		Level1Piece6[1] = new Square(2,1);
		Level1Piece6[2] = new Square(1,1);
		Level1Piece6[3] = new Square(0,1);
		Level1Piece6[4] = new Square(1,2);
		Level1Piece6[5] = new Square(2,2);	
		
		Piece bullPenPiece= new Piece(0,0,Level1Piece1,Level1Piece1[0],2);
		bullPenPiece.setColor(new Color(0,0,0));
		
		ArrayList<Piece> bullPenPieceArray=new ArrayList<Piece>();
		bullPenPieceArray.add(new Piece(0,0,Level1Piece1,Level1Piece1[0],2));
		bullPenPieceArray.get(0).setColor(Color.BLUE);
		bullPenPieceArray.add(new Piece(0,0,Level1Piece2,Level1Piece2[0],2));
		bullPenPieceArray.get(1).setColor(Color.GREEN);
		bullPenPieceArray.add(new Piece(0,0,Level1Piece3,Level1Piece3[0],2));
		bullPenPieceArray.get(2).setColor(Color.YELLOW);
		bullPenPieceArray.add(new Piece(0,0,Level1Piece4,Level1Piece4[0],2));
		bullPenPieceArray.get(3).setColor(Color.ORANGE);
		bullPenPieceArray.add(new Piece(0,0,Level1Piece5,Level1Piece5[0],2));
		bullPenPieceArray.get(4).setColor(Color.RED);
		bullPenPieceArray.add(new Piece(0,0,Level1Piece6,Level1Piece6[0],2));
		bullPenPieceArray.get(5).setColor(Color.PINK);
		Bullpen bp = new Bullpen(bullPenPieceArray);
		
		
		Square[] sq = new Square[36]; 
		for (int i1=0;i1<6;i1++){
			for (int j=0;j<6;j++){
				sq[i1*6+j] = new Square(i1,j);
			}
		}
		Square hitSquares[] = new Square[6]; 
		hitSquares[0] = new Square(0,0);
		hitSquares[1] = new Square(1,0);
		hitSquares[2] = new Square(2,0);
		hitSquares[3] = new Square(3,0);
		hitSquares[4] = new Square(4,0);
		hitSquares[5] = new Square(5,0);	
		Hint hints = new Hint(hitSquares);
		Board bd = new Board(sq);
		bd.sethint(hints);
		
		testLevels[0] = new PuzzleLevel(0,GetLevelTpye(0%3),bd,bp,20);
		testLevels[0].updateLevelStar(new Achievement(0));
		
		return testLevels;
	}
	
	@SuppressWarnings("null")
	public static Level[] createTestLevel(){
		Level[] testLevels = new Level[16];
		int[] squareNum = new int[144];
	
		Color[] cl = new Color[144];
		
		

		
		for (int i=0;i<144;i++){
			squareNum[i] =0;
			cl[i]=null;
		}
		int count18=0;
		for (int i=1;i<4;i++){
			for (int j=1;j<7;j++){
				squareNum[count18] =j;
				if (i==1){
					cl[count18]=Color.RED;
				}
				else if (i==2){
					cl[count18]=Color.YELLOW;
				}
				else if (i==3){
					cl[count18]=Color.GREEN;
				}
				count18=count18+5;
			}
		}


		Square bullPenSquare1[] = new Square[6]; 
		bullPenSquare1[0] = new Square(1,3);
		bullPenSquare1[1] = new Square(0,1);
		bullPenSquare1[2] = new Square(0,2);
		bullPenSquare1[3] = new Square(0,3);
		bullPenSquare1[4] = new Square(0,4);
		bullPenSquare1[5] = new Square(0,5);		
		
		Square bullPenSquare2[] = new Square[6]; 
		bullPenSquare2[0] = new Square(0,0);
		bullPenSquare2[1] = new Square(1,0);
		bullPenSquare2[2] = new Square(2,0);
		bullPenSquare2[3] = new Square(2,1);
		bullPenSquare2[4] = new Square(2,2);
		bullPenSquare2[5] = new Square(1,2);		

		Square bullPenSquare3[] = new Square[6]; 
		bullPenSquare3[0] = new Square(1,1);
		bullPenSquare3[1] = new Square(0,1);
		bullPenSquare3[2] = new Square(0,2);
		bullPenSquare3[3] = new Square(0,3);
		bullPenSquare3[4] = new Square(0,4);
		bullPenSquare3[5] = new Square(0,5);		
		
		Square bullPenSquare4[] = new Square[6]; 
		bullPenSquare4[0] = new Square(1,1);
		bullPenSquare4[1] = new Square(2,1);
		bullPenSquare4[2] = new Square(3,1);
		bullPenSquare4[3] = new Square(3,2);
		bullPenSquare4[4] = new Square(3,3);
		bullPenSquare4[5] = new Square(3,4);		

		Square bullPenSquare5[] = new Square[6]; 
		bullPenSquare5[0] = new Square(0,2);
		bullPenSquare5[1] = new Square(1,2);
		bullPenSquare5[2] = new Square(2,2);
		bullPenSquare5[3] = new Square(3,2);
		bullPenSquare5[4] = new Square(4,2);
		bullPenSquare5[5] = new Square(5,2);	
		
		Square bullPenSquare6[] = new Square[6]; 
		bullPenSquare6[0] = new Square(0,0);
		bullPenSquare6[1] = new Square(0,1);
		bullPenSquare6[2] = new Square(0,2);
		bullPenSquare6[3] = new Square(0,3);
		bullPenSquare6[4] = new Square(0,4);
		bullPenSquare6[5] = new Square(0,5);	
		
		Piece bullPenPiece= new Piece(0,0,bullPenSquare1,bullPenSquare1[0],2);
		bullPenPiece.setColor(new Color(0,0,0));


		ArrayList<Piece> bullPenPieceArray=new ArrayList<Piece>();
		bullPenPieceArray.add(new Piece(0,0,bullPenSquare1,bullPenSquare1[0],2));
		bullPenPieceArray.get(0).setColor(Color.BLUE);
		bullPenPieceArray.add(new Piece(0,0,bullPenSquare2,bullPenSquare2[0],2));
		bullPenPieceArray.get(1).setColor(Color.GREEN);
		bullPenPieceArray.add(new Piece(0,0,bullPenSquare3,bullPenSquare3[0],2));
		bullPenPieceArray.get(2).setColor(Color.YELLOW);
		bullPenPieceArray.add(new Piece(0,0,bullPenSquare4,bullPenSquare4[0],2));
		bullPenPieceArray.get(3).setColor(Color.ORANGE);
		bullPenPieceArray.add(new Piece(0,0,bullPenSquare5,bullPenSquare5[0],2));
		bullPenPieceArray.get(4).setColor(Color.RED);
		bullPenPieceArray.add(new Piece(0,0,bullPenSquare6,bullPenSquare6[0],2));
		bullPenPieceArray.get(5).setColor(Color.PINK);


		Bullpen bp = new Bullpen(bullPenPieceArray);
		//Bullpen bp = new Bullpen();



		Square[] boardSquare = new Square[144]; 
		for (int i1=0;i1<12;i1++){
			for (int j=0;j<12;j++){

				boardSquare[i1*12+j] = new Square(i1,j);
			}
		}

		Square hitSquares[] = new Square[6]; 
		hitSquares[0] = new Square(6,4);
		hitSquares[1] = new Square(5,2);
		hitSquares[2] = new Square(5,3);
		hitSquares[3] = new Square(5,4);
		hitSquares[4] = new Square(5,5);
		hitSquares[5] = new Square(5,6);	

		Hint hints = new Hint(hitSquares);

		Board testBoard = new Board(boardSquare);
		testBoard.sethint(hints);
		
		////// add remove test
		//bullPenPiece.setColor(Color.PINK);
		//bp.removepiece(bullPenPieceArray.get(5));
		//testBoard.addpiece(bullPenPiece);
		///test over
		
		for (int i=0;i<15;i++){
			if (i%3==0){
				testLevels[i] = new PuzzleLevel(i,GetLevelTpye(i%3),testBoard,bp,20);
				testLevels[i].updateLevelStar(new Achievement(new Random().nextInt(3) + 1));
			}
			else if (i%3==1){
				testLevels[i] = new LightningLevel(i,GetLevelTpye(i%3),testBoard,bp,30);
				testLevels[i].updateLevelStar(new Achievement(new Random().nextInt(3) + 1));
			}
			else {
				testLevels[i] = new ReleaseLevel(i,GetLevelTpye(i%3),testBoard,bp,squareNum,cl);
				testLevels[i].updateLevelStar(new Achievement(new Random().nextInt(3) + 1));
			}

		}
		testLevels[13].updateLevelStar(new Achievement(0));
		testLevels[14].updateLevelStar(new Achievement(-1));

		
		
		
		//---------------------------------------------- 
		int[] sixNum = new int[36];
		Color[] sixcolor  = new Color[36];
		for (int i=0;i<36;i++){
			sixNum[i] =0;
			sixcolor[i]=null;
		}
		int count1=0;
		for (int i=1;i<4;i++){
			for (int j=1;j<7;j++){
				squareNum[count1] =j;
				if (i==1){
					cl[count1]=Color.RED;
				}
				else if (i==2){
					cl[count1]=Color.YELLOW;
				}
				else if (i==3){
					cl[count1]=Color.GREEN;
				}
				count1=count1+1;
			}
		}
		Square[] sixBoardSquare = new Square[36]; 
		for (int i1=0;i1<6;i1++){
			for (int j=0;j<6;j++){

				sixBoardSquare[i1*6+j] = new Square(i1,j);
			}
		}
		Square sixhint[] = new Square[6]; 
		sixhint[0] = new Square(0,0);
		sixhint[1] = new Square(0,1);
		sixhint[2] = new Square(0,2);
		sixhint[3] = new Square(0,3);
		sixhint[4] = new Square(0,4);
		sixhint[5] = new Square(0,5);	

		Hint sixhints = new Hint(sixhint);

		Board sixBoard = new Board(sixBoardSquare);
		sixBoard.sethint(sixhints);
		
		testLevels[15] = new ReleaseLevel(15,GetLevelTpye(14%3),sixBoard,bp,sixNum,sixcolor);
		testLevels[15].updateLevelStar(new Achievement(1));
		//--------------------------------------------
		
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
