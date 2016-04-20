package controller;
import model.Bullpen;

import model.Piece;
import model.Square;

import view.LevelView;



public class VerticalFlipController  extends java.awt.event.MouseAdapter{
	
	Piece piece;
	Square[] Squares;
	Bullpen bullpen;
	LevelView levelview;
	
	public VerticalFlipController(LevelView levelview , Bullpen bullpen,Piece piece){
		this.piece=piece;
		this.bullpen =bullpen;
		this.levelview= levelview;
	}
	
	public void actionPerformed(){
		Squares  = piece.getSquares();
		for (int i=0;i<6;i++){
	
		Squares[i].setRow(5 - Squares[i].getRow());
		System.out.println(Squares[i].getRow());
		}

	
		levelview.reDrawBullpan(bullpen);
		
	}	
	
}