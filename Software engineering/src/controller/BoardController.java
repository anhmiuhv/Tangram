package controller;

import java.awt.event.MouseEvent;

import model.Board;
import model.Piece;
import model.PuzzleLevel;
import view.JPieceView;
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

		double dx= (double)(me.getX())/30 ;
		double dy=	(double)(me.getY())/30 ;
		int pressColumn = ((int)dx);
		int pressRow = ((int)dy);
		boolean found = false;

	    Piece pressedPiece =null;
		for (int i=0;i< board.getpiece().size();i++){
			for(int j=0;j<6;j++){
				int squareX = board.getpiece().get(i).getpColumn() +board.getpiece().get(i).getSquares()[j].getColumn() - board.getpiece().get(i).getSquares()[0].getColumn();
				int squareY = board.getpiece().get(i).getpRow() +board.getpiece().get(i).getSquares()[j].getRow() - board.getpiece().get(i).getSquares()[0].getRow();
				if ((squareX == pressColumn)&& (squareY == pressRow)){
					pressedPiece = board.getpiece().get(i);
					found = true;
				}
			}

		}
		
		if(found == false){
			movingPiece = null;
			
		}
		else{
			movingPiece = pressedPiece;
			levelView.setDiffx(0);
			levelView.setDiffy(0);
			
			levelView.setDraggingPiece(pressedPiece);
			levelView.setDraggingPieceView(new JPieceView(pressedPiece, 450+me.getX() ,210+me.getY() ));
			levelView.getTopPanel().add(levelView.getDraggingPieceView());

			//board.removepiece(movingPiece);
			
		}

	}
	
	@Override
	public void mouseReleased(MouseEvent me) {
		movingPiece = levelView.getDraggingPiece();
		if (movingPiece!= null){
			mouseAndHeadX = levelView.getDiffx()+20 - 30*movingPiece.getSquares()[0].getColumn();
			mouseAndHeadY = levelView.getDiffy()+140 - 30*movingPiece.getSquares()[0].getRow();

			double dx= (double)(me.getX()-mouseAndHeadX)/30 +0.5;
			double dy=	(double)(me.getY()-mouseAndHeadY)/30 +0.5;

		//getHeadSquareInBoard();
		
			
		if (doMove((int)dx,(int)dy,movingPiece)== true){
			movingPiece.setpColumn((int)dx);
			movingPiece.setpRow((int)dy);
			board.addpiece(movingPiece);
			coverSquare((int)dx,(int)dy,movingPiece);
			
			if(levelView.getLevel() instanceof PuzzleLevel){
				((PuzzleLevel)levelView.getLevel()).incrementUsedMove();
				levelView.updateBS();
			}
			levelView.getLevel().checkAchievement();
			//System.out.println(levelView.getLevel().getS);
			levelView.updateAchievement();
			levelView.reDrawBoard();
			levelView.repaint();
		}
		else{

			levelView.getBullpenController().mouseReleased(null);
		}
	
		//cover

		}
	}
	
	public int[] getHeadSquareInBoard(){
		int closedColumn =mouseAndHeadX+levelView.getDiffx()/30;
		int closedRow = mouseAndHeadY+levelView.getDiffy()/30;
		int[] returnInt = new int[2];
		
		for(int i=0;i<board.getSquare().length;i++){
			if ((closedColumn == board.getSquare()[i].getColumn())&&(closedRow == board.getSquare()[i].getRow())){

			}
		}
		
		return returnInt;
	}
	
	public void coverSquare(int testColumn, int testRow, Piece testPiece){
		for (int i =0;i<6;i++){
			int findx;
			int findy;
			findx=testColumn+ testPiece.getSquares()[i].getColumn()- testPiece.getSquares()[0].getColumn();
			findy = testRow + testPiece.getSquares()[i].getRow()- testPiece.getSquares()[0].getRow();
			for (int j =0;j<board.getSquare().length;j++){
				if ((board.getSquare()[j].getColumn()==findx)&&(board.getSquare()[j].getRow()==findy)){
					board.getCover()[j]=1;
				}
			}
		}
	}
	
	
	public boolean doMove(int testColumn, int testRow, Piece testPiece){
		int findx;
		int findy;

		for (int i =0;i<6;i++){
			findx=testColumn+ testPiece.getSquares()[i].getColumn()- testPiece.getSquares()[0].getColumn();
			findy = testRow + testPiece.getSquares()[i].getRow()- testPiece.getSquares()[0].getRow();
			int flag= 0;
			for (int j =0;j<board.getSquare().length;j++){
				if ((board.getSquare()[j].getColumn()==findx)&&(board.getSquare()[j].getRow()==findy)){
					if ( board.getCover()[j] !=0){
						return false;
					}
					flag = 1;
				}
			}
			if (flag == 0){

				return false;
			}
		}
		return true;
	}
	
	
	

}
