package controller;
import model.Bullpen;

import model.Piece;
import model.Square;

import view.LevelView;


/**
 * the controller for rotate the piece vertical flip
 * @author jshen3, kdai, xwang11
 *
 */
public class VerticalFlipController  extends java.awt.event.MouseAdapter{
	
	Piece piece;
	Square[] Squares;
	Bullpen bullpen;
	LevelView levelview;
	/**
	 * constructor
	 * @param levelview
	 * @param bullpen
	 * @param piece
	 */
	public VerticalFlipController(LevelView levelview , Bullpen bullpen,Piece piece){

		this.bullpen =bullpen;
		this.levelview= levelview;
		this.piece= bullpen.getPieces().get(bullpen.getPieceSelected());
	}
	/**
	 * make the piece vertical flip
	 */
	public void actionPerformed(){
		Squares  = piece.getSquares();
		for (int i=0;i<6;i++){
	
		Squares[i].setRow(5 - Squares[i].getRow());
		
		}

	
		levelview.reDrawBullpan();
	}	
	
}