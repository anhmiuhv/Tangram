package controller;

import java.awt.event.MouseEvent;

import model.Board;
import model.Piece;
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
		movingPiece.setpColumn(diffx+levelView.getDiffx());
		movingPiece.setpRow(diffy+levelView.getDiffy());
		getHeadSquareInBoard();
		board.addpiece(movingPiece);
		levelView.reDrawBoard();
		levelView.repaint();
	}
	
	public int[] getHeadSquareInBoard(){
		int closedColumn =diffx+levelView.getDiffx()/30;
		int closedRow = diffy+levelView.getDiffy()/30;
		int[] returnInt = new int[2];
		
		for(int i=0;i<board.getSquare().length;i++){
			if ((closedColumn == board.getSquare()[i].getColumn())&&(closedRow == board.getSquare()[i].getRow())){
				
				System.out.println("dzk");
			}
		}
		
		return returnInt;
	}
	
	public boolean doMove(){
		
		return false;
	}
}
