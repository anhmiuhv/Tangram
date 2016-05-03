package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;

import model.Board;
import model.LightningLevel;
import model.Piece;
import model.PuzzleLevel;
import model.ReleaseLevel;
import view.JPieceView;
import view.LevelView;
/**
 * Representation of the controller of the Board
 * @author jshen3, kdai, xwang11
 */
public class BoardController extends java.awt.event.MouseAdapter{
	
	int mouseAndHeadX =0;
	int mouseAndHeadY =0;
	
	LevelView levelView;
	Board board;
	Piece movingPiece;

	boolean fromBoard = false;
	
	int dbouardX =0;
	int dbouardY =0;
	/**
	 * the constructor of BoardController
	 * @param levelView
	 * @param board
	 */
	
	public BoardController(LevelView levelView,Board board){
		this.board = board;
		this.levelView =levelView;

	}
	/**
	 * set the value of x and y
	 */
	public void updateDiffxy(){
	}
	

	@Override
	/**
	 * mousePress event capture
	 * @mouse
	 */
	public void mousePressed(MouseEvent me) {
		fromBoard = true;
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
		
		if(levelView.getLevel() instanceof LightningLevel){
			found = false;
		}
		
		if(found == false){
			movingPiece = null;
			levelView.setDraggingPiece(pressedPiece);
			levelView.setDraggingPieceView(null);
		}
		else{
			movingPiece = pressedPiece;
			levelView.setDraggingPiece(pressedPiece);
			levelView.setDraggingPieceView(new JPieceView(pressedPiece, 450+movingPiece.getpColumn()*30,210+movingPiece.getpRow()*30 ));
			levelView.getTopPanel().add(levelView.getDraggingPieceView());
			levelView.setDiffx(me.getX()-450-movingPiece.getpColumn()*30);
			levelView.setDiffy(me.getY()-210-movingPiece.getpRow()*30);
			dbouardX = me.getX() - movingPiece.getpColumn()*30;
			dbouardY = me.getY() - movingPiece.getpRow()*30;

			board.removepiece(movingPiece);
			removeCoverSquare(movingPiece.getpColumn(),movingPiece.getpRow(),movingPiece);
			//levelView.reDrawBoard();
			levelView.getBoardView().removePieceView(movingPiece);
			levelView.getBoardView().repaint();
		}
	}
	
	@Override
	/**
	 * mouseRelease event capture
	 * @mouse
	 */
	public void mouseReleased(MouseEvent me) {
			if (me ==null){
				markgreen(movingPiece);
				board.addpiece(movingPiece);
				coverSquare(movingPiece.getpColumn(),movingPiece.getpRow(),movingPiece);
				
				levelView.getLevel().checkAchievement();
				//System.out.println(levelView.getLevel().getS);
				levelView.updateAchievement();
				
				if (levelView.getDraggingPieceView() != null){
				levelView.getTopPanel().remove(levelView.getDraggingPieceView());
				}

				levelView.setDraggingPieceView(null);
				
				levelView.reDrawBoard();
				levelView.repaint();
			}
			else{
		movingPiece = levelView.getDraggingPiece();
		
		//mouse release in bullpen
		if(me.getX()>=-430 && me.getY()>=-70 && me.getX()<= -55 && me.getY() <= 670){
			

			levelView.getTopPanel().remove(levelView.getDraggingPieceView());
			levelView.setDraggingPieceView(null);
			levelView.getJBullPenView().repaint();
			
			MouseEvent newme = new MouseEvent(me.getComponent(), me.getID(), me.getWhen(), me.getModifiers(), 
					me.getX()+430, me.getY()+70, me.getClickCount(), false);
			
			levelView.getBullpenController().mouseReleased(newme);
			return;
		}
		
		
		if (movingPiece!= null){
			double dx=0;
			double dy=0;
			if (fromBoard ==false){
			mouseAndHeadX = levelView.getDiffx()+20 - 30*movingPiece.getSquares()[0].getColumn();
			mouseAndHeadY = levelView.getDiffy()+140 - 30*movingPiece.getSquares()[0].getRow();
			dx= (double)(me.getX()-mouseAndHeadX)/30 +0.5;
			dy=	(double)(me.getY()-mouseAndHeadY)/30 +0.5;
			}
			else{
				dx = (double)(me.getX()- dbouardX)/30+0.5;
				dy = (double)(me.getY()- dbouardY)/30+0.5 ;
			}

		//getHeadSquareInBoard();
		
			
		if (doMove((int)dx,(int)dy,movingPiece)== true){
			movingPiece.setpColumn((int)dx);
			movingPiece.setpRow((int)dy);
			Piece greenPiece = markgreen(movingPiece);
			board.addpiece(greenPiece);
			coverSquare((int)dx,(int)dy,movingPiece);
			
			if(levelView.getLevel() instanceof PuzzleLevel){
				((PuzzleLevel)levelView.getLevel()).incrementUsedMove();
				levelView.updateBS();
			}else if(levelView.getLevel() instanceof ReleaseLevel){
				coverColor((int)dx,(int)dy,movingPiece);
			}
			levelView.getLevel().checkAchievement();
			levelView.updateAchievement();
			
			if (levelView.getDraggingPieceView() != null){
			levelView.getTopPanel().remove(levelView.getDraggingPieceView());
			}

			levelView.setDraggingPieceView(null);
			
			levelView.reDrawBoard();
			levelView.repaint();
		}
		else{
			if(!fromBoard){
				levelView.getBullpenController().mouseReleased(null);
			}else{
				this.mouseReleased(null);
			}
			if (levelView.getDraggingPieceView() != null){
				levelView.getTopPanel().remove(levelView.getDraggingPieceView());
			}
			levelView.setDraggingPieceView(null);
			levelView.repaint();
		}
	
		//cover

		}
		//levelView.remove(levelView.getDraggingPieceView());
		fromBoard = false;
		//levelView.repaint();
			}
	}
	/**
	 * get the head square in the Board
	 * @return returnInt
	 */
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
	/**
	 * indicates that this piece is not covered
	 * @param testColumn
	 * @param testRow
	 * @param testPiece
	 */
	public void removeCoverSquare(int testColumn, int testRow, Piece testPiece){	
		for (int i =0;i<6;i++){
			int findx;
			int findy;
			findx=testColumn+ testPiece.getSquares()[i].getColumn()- testPiece.getSquares()[0].getColumn();
			findy = testRow + testPiece.getSquares()[i].getRow()- testPiece.getSquares()[0].getRow();
			for (int j =0;j<board.getSquare().length;j++){
				if ((board.getSquare()[j].getColumn()==findx)&&(board.getSquare()[j].getRow()==findy)){
					board.getCover()[j]=0;
				}
			}
		}
	}
	/**
	 * cover the square that need to be covered
	 * @param testColumn
	 * @param testRow
	 * @param testPiece
	 */
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
	/**
	 * to find that if the color is coverd or not
	 * @param testColumn
	 * @param testRow
	 * @param testPiece
	 */
	public void coverColor(int testColumn, int testRow, Piece testPiece){
		for (int i =0;i<6;i++){
			int findx;
			int findy;
			findx=testColumn+ testPiece.getSquares()[i].getColumn()- testPiece.getSquares()[0].getColumn();
			findy = testRow + testPiece.getSquares()[i].getRow()- testPiece.getSquares()[0].getRow();
			for (int j =0;j<board.getSquare().length;j++){
				if ((board.getSquare()[j].getColumn()==findx)&&(board.getSquare()[j].getRow()==findy)){
					if(((ReleaseLevel)levelView.getLevel()).getCl()[j] == null){
						continue;
					}
					if(((ReleaseLevel)levelView.getLevel()).getCl()[j].equals(Color.pink)){
						((ReleaseLevel)levelView.getLevel()).increamentRed();
					}else if(((ReleaseLevel)levelView.getLevel()).getCl()[j].equals(Color.orange)){
						((ReleaseLevel)levelView.getLevel()).increamentGreen();
					}else if(((ReleaseLevel)levelView.getLevel()).getCl()[j].equals(Color.yellow)){
						((ReleaseLevel)levelView.getLevel()).increamentYellow();
					}
				}
			}
		}
	}
	
	/**
	 * make the move
	 * @param testColumn
	 * @param testRow
	 * @param testPiece
	 * @return boolean
	 */
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
					    if (levelView.getLevel() instanceof LightningLevel){
					    	
					    }
					    else{
					    	return false;
					    }
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
	/**
	 * change the square to color green
	 * @param mp
	 * @return
	 */
	public Piece markgreen(Piece mp){
		Piece newmp = new Piece(mp.getpRow(),mp.getpColumn(),mp.getSquares(),mp.getHead(),mp.getname());
		if(levelView.getLevel() instanceof LightningLevel){
			newmp.setColor(Color.GREEN);
		}else{
			newmp.setColor(mp.getColor());
		}
		return newmp;
	}
	

}
