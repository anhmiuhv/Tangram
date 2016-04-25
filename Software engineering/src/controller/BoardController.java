package controller;

import java.awt.event.MouseEvent;

import model.Board;
import model.Piece;
import view.JPieceView;

public class BoardController extends java.awt.event.MouseAdapter{
	
	int diffx;
	int diffy;
	
	Board board;
	Piece movingPiece;
	
	public BoardController(Board board,Piece movingPiece){
		this.board = board;
		this.movingPiece = movingPiece;
	}
	
	public void updateDiffxy(){
	}
	
	@Override
	public void mousePressed(MouseEvent me) {
		System.out.println("1");
	    
	}
	

	@Override
	public void mouseReleased(MouseEvent me) {
		
	}
}
