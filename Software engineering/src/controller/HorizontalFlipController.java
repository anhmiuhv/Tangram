package controller;
import java.awt.event.MouseEvent;

import model.Level;
import model.Piece;
import model.Square;
import view.LevelSelection;
import view.LevelView;


public class HorizontalFlipController  extends java.awt.event.MouseAdapter{
	
	Piece piece;
	Square[] Squares;
	public HorizontalFlipController(Piece piece){
		this.piece=piece;
	}
	
	public void actionPerformed(){
		Squares  = piece.getSquares();
		
	}	
	
}
