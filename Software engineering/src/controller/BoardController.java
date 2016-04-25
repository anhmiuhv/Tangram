package controller;

import java.awt.event.MouseEvent;

import model.Board;
import model.Piece;
import view.JPieceView;
import view.LevelView;

public class BoardController extends java.awt.event.MouseAdapter{
	
	int diffx =0;
	int diffy =0;
	
	LevelView levelView;
	Board board;
	Piece movingPiece;
	
	public BoardController(LevelView levelView,Board board,Piece movingPiece){
		this.board = board;
		this.movingPiece = movingPiece;
		this.levelView =levelView;
	}
	
	public void updateDiffxy(){
	}
	
	@Override
	public void mousePressed(MouseEvent me) {
		System.out.println("1");
	    
	}
	

	@Override
	public void mouseReleased(MouseEvent me) {
		System.out.println("2");
		movingPiece.setpColumn(0);
		movingPiece.setpRow(0);
		board.addpiece(movingPiece);
		levelView.reDrawBoard();
		levelView.repaint();
	}
}
