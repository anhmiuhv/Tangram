package controller;
import model.Bullpen;

import model.Piece;
import model.Square;

import view.LevelView;


/**
 * controller for making the HorizontalFlip
 * @author jshen3, kdai, xwang11
 *
 */
public class HorizontalFlipController  extends java.awt.event.MouseAdapter{
	
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
	public HorizontalFlipController(LevelView levelview , Bullpen bullpen,Piece piece){

		this.bullpen =bullpen;
		this.levelview= levelview;
		this.piece= bullpen.getPieces().get(bullpen.getPieceSelected());
	}
	/**
	 * make the piece horizontally flip
	 */
	public void actionPerformed(){
		Squares  = piece.getSquares();
		for (int i=0;i<6;i++){
			
		Squares[i].setColumn(5 - Squares[i].getColumn());
		}

	
		levelview.reDrawBullpan();
		
	}	
	
}
