package controller;

import java.awt.event.MouseEvent;

import model.Board;
import model.Piece;
import model.PuzzleLevel;
import view.LevelView;

public class BoardController extends java.awt.event.MouseAdapter{
	
	int mouseAndHeadX =0;
	int mouseAndHeadY =0;
	
	LevelView levelView;
	Board board;
	Piece movingPiece;
	
	public BoardController(LevelView levelView,Board board){
		this.board = board;
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
		movingPiece = levelView.getDraggingPiece();
		if (movingPiece!= null){
			mouseAndHeadX = levelView.getDiffx()+20 - 30*movingPiece.getSquares()[0].getColumn();
			mouseAndHeadY = levelView.getDiffy()+140 - 30*movingPiece.getSquares()[0].getRow();

			double dx= (double)(me.getX()-mouseAndHeadX)/30 +0.5;
			double dy=	(double)(me.getY()-mouseAndHeadY)/30 +0.5;
		movingPiece.setpColumn((int)dx);
		movingPiece.setpRow((int)dy);
		//getHeadSquareInBoard();
		board.addpiece(movingPiece);
		//cover
		if(levelView.getLevel() instanceof PuzzleLevel){
			((PuzzleLevel)levelView.getLevel()).incrementUsedMove();
		}
		levelView.getLevel().checkAchievement();
		levelView.reDrawBoard();
		levelView.repaint();
		}
	}
	
	public int[] getHeadSquareInBoard(){
		int closedColumn =mouseAndHeadX+levelView.getDiffx()/30;
		int closedRow = mouseAndHeadY+levelView.getDiffy()/30;
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
