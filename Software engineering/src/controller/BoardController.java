package controller;

import java.awt.event.MouseEvent;

import model.Board;
import model.Piece;
import view.LevelView;

public class BoardController extends java.awt.event.MouseAdapter{
	
	int diffx =80;
	int diffy =80;
	
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
		movingPiece.setpColumn(diffx);
		movingPiece.setpRow(diffy);
		board.addpiece(movingPiece);
		levelView.reDrawBoard();
		levelView.repaint();
	}
}
