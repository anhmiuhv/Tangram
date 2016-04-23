
package controller;
import model.Bullpen;

import model.Piece;
import model.Square;

import view.LevelView;



public class RotateLeftController  extends java.awt.event.MouseAdapter{
	
	Piece piece;
	Square[] Squares;
	Bullpen bullpen;
	LevelView levelview;
	
	public RotateLeftController(LevelView levelview , Bullpen bullpen,Piece piece){
		this.piece=piece;
		this.bullpen =bullpen;
		this.levelview= levelview;
	}
	
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

	
		levelview.reDrawBullpan(bullpen);
		
	}	
	
}