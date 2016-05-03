
package controller;
import model.Bullpen;

import model.Piece;
import model.Square;

import view.LevelView;


/**
 * the controller handling rotate the piece left
 * @author jshen3, kdai, xwang11
 *
 */
public class RotateLeftController  extends java.awt.event.MouseAdapter{
	
	Piece piece;
	Square[] Squares;
	Bullpen bullpen;
	LevelView levelview;
	/**
	 * constructor
	 * @param levelview
	 * @param bullpen
	 */
	public RotateLeftController(LevelView levelview , Bullpen bullpen){

		this.bullpen =bullpen;
		this.levelview= levelview;
		this.piece= bullpen.getPieces().get(bullpen.getPieceSelected());
	}
	/**
	 * make the piece rotate left
	 */
	public void actionPerformed(){
		Squares  = piece.getSquares();
		
		int  rl_x, rl_y ;
		int halfX = 5;
		int halfY = 5;
		for (int i=0;i<6;i++){
			rl_x = 	2*Squares[i].getColumn()-halfX;
			rl_y = 	halfY - 2* Squares[i].getRow();
			
			rl_y = -rl_y;
	
			Squares[i].setColumn((halfX+rl_y)/2);
			Squares[i].setRow((halfY-rl_x)/2);
		}

	
		levelview.reDrawBullpan();
		
	}	
	
}