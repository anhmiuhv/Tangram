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
	    
	    
	    diffx = me.getX() - levelview.getJBullPenView().getPieceView()[pieceN].getX() -20;
	    diffy = me.getY() - levelview.getJBullPenView().getPieceView()[pieceN].getY() -140;
	    
	    System.out.println(diffx);
	    System.out.println(diffy);
	    
	    levelview.setDiffx(diffx);
	    levelview.setDiffy(diffy);
	    bullpen.setPieceSelected(pieceN);
	    draggingPiece = bullpen.getPieces().get(pieceN);
	    levelview.setDraggingPiece(draggingPiece);
	    System.out.println("111");
	    bullpen.getPieces().set(pieceN,null);
	    levelview.setDraggingPieceView(new JPieceView(draggingPiece, me.getPoint().x - diffx, me.getPoint().y - diffy));
	    levelview.getTopPanel().add(levelview.getDraggingPieceView());
	    //levelview.setComponentZOrder(levelview.draggingPiece, 0);
	    levelview.reDrawBullpan();
	    levelview.repaint();
	    
	}
	

	@Override
	public void mouseReleased(MouseEvent me) {
		draggingPiece = levelview.getDraggingPiece();
		if(draggingPiece == null){
			System.out.println("Nothing being dragged");
			return;
		}
		
		int mex = me.getX();
		int mey = me.getY();
		
		if(mex>=430 && mey>=70){
			if(mex<=levelview.getBoardView().getWidth() + 430 && mey<=levelview.getBoardView().getHeight() + 70){
				levelview.getTopPanel().remove(levelview.getDraggingPieceView());
				levelview.setDraggingPieceView(null);
				levelview.reDrawBullpan();
				MouseEvent newme = new MouseEvent(me.getComponent(), me.getID(), me.getWhen(), me.getModifiers(), 
						me.getX()-430, me.getY()-70, me.getClickCount(), false);				
				levelview.getBoardController().mouseReleased(newme);;
				return;
			}			
		}
		
		bullpen.getPieces().set(pieceN,draggingPiece);
		levelview.getTopPanel().remove(levelview.getDraggingPieceView());
		levelview.setDraggingPieceView(null);
		levelview.reDrawBullpan();
		levelview.repaint();
	}
 

}
