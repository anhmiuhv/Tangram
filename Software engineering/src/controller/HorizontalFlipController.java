package controller;
import java.awt.event.MouseEvent;

import model.Bullpen;
import model.Level;
import model.Piece;
import model.Square;
import view.JBullPenView;
import view.LevelView;



public class HorizontalFlipController  extends java.awt.event.MouseAdapter{
	
	Piece piece;
	Square[] Squares;
	Bullpen bullpen;
	LevelView levelview;
	
	public HorizontalFlipController(LevelView levelview , Bullpen bullpen,Piece piece){
		this.piece=piece;
		this.bullpen =bullpen;
		this.levelview= levelview;
	}
	
	public void actionPerformed(){
		Squares  = piece.getSquares();
		for (int i=0;i<6;i++){
			
		Squares[i].setColumn(5 - Squares[i].getColumn());
		}
		System.out.println(bullpen.getPieces().get(1).getpColumn());
	
		levelview.reDrawBullpan(bullpen);
		
		//JBullPenView bullpenView = new JBullPenView(bullpen,bpX,bpY);
	}	
	
}
