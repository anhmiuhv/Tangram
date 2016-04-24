package controller;

import java.awt.event.MouseEvent;

import model.Bullpen;
import model.Piece;
import view.JPieceView;
import view.LevelView;

public class BullpenController extends java.awt.event.MouseAdapter{
	
	JPieceView pv;
	LevelView levelview;
	Bullpen bullpen;
	
	Piece draggingPiece = null;
	
	int diffx;
	int diffy;
	int pieceN = 0;	
	
	public BullpenController(LevelView levelview, Bullpen bp){
		this.levelview = levelview;
		this.bullpen = bp;
	}
	
	@Override
	public void mousePressed(MouseEvent me) {
		int x = 0;
		if(me.getX() > 185){
			x = 1; 
		}else{
			x = 2;
		}	
	    pieceN = ((me.getY()/185)+1)*2 - x;
	    
	    
	    diffx = me.getX() - levelview.getJBullPenView().getPieceView()[pieceN].getX() - 20;
	    diffy = me.getY() - levelview.getJBullPenView().getPieceView()[pieceN].getY() - 140;
	    
	    levelview.diffx = diffx;
	    levelview.diffy = diffy;
	    bullpen.setPieceSelected(pieceN);
	    draggingPiece = bullpen.getPieces().get(pieceN);
	    bullpen.getPieces().set(pieceN,null);
	    levelview.draggingPiece = new JPieceView(draggingPiece, me.getPoint().x , me.getPoint().y );
	    levelview.getTopPanel().add(levelview.draggingPiece);
	    //levelview.setComponentZOrder(levelview.draggingPiece, 0);
	    levelview.reDrawBullpan();
	    
	}
	
	/*@Override
	public void mouseDragged(MouseEvent me) {
		levelview.getParent().add(pv);
		pv.setLocation(me.getPoint().x - diffx, me.getPoint().y - diffy);
		
		
    }*/
	@Override
	public void mouseReleased(MouseEvent me) {
		bullpen.getPieces().set(pieceN,draggingPiece);
		levelview.getTopPanel().remove(levelview.draggingPiece);
		levelview.draggingPiece = null;
		levelview.reDrawBullpan();
		levelview.repaint();
	}
 

}
