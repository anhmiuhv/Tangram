package controller;

import java.awt.event.MouseEvent;

import model.Bullpen;
import model.LightningLevel;
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
	
	boolean fromBullpen = false;
	
	public BullpenController(LevelView levelview, Bullpen bp){
		this.levelview = levelview;
		this.bullpen = bp;
	}
	
	@Override
	public void mousePressed(MouseEvent me) {
		fromBullpen = true;
		int x = 0;
		if(me.getX() > 185){
			x = 1; 
		}else{
			x = 2;
		}	
	    pieceN = ((me.getY()/185)+1)*2 - x;
	    
	    
	    diffx = me.getX() - levelview.getJBullPenView().getPieceView()[pieceN].getX() -20;
	    diffy = me.getY() - levelview.getJBullPenView().getPieceView()[pieceN].getY() -140;
	    
	    levelview.setDiffx(diffx);
	    levelview.setDiffy(diffy);
	    bullpen.setPieceSelected(pieceN);
	    draggingPiece = bullpen.getPieces().get(pieceN);
	    levelview.setDraggingPiece(draggingPiece);
	    
	    if (levelview.getLevel() instanceof LightningLevel){
	    	Piece ranpiece =new Piece();
	    	ranpiece.setColor(bullpen.getPieces().get(pieceN).getColor());
	    	  bullpen.getPieces().set(pieceN,ranpiece);
	    	  
	    }
	    else{
	    	bullpen.getPieces().set(pieceN,null);
	    }
	    
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
		if(fromBullpen && me != null){
			int mex = me.getX();
			int mey = me.getY();
			
			if(mex>=430 && mey>=70){
				if(mex<=levelview.getBoardView().getWidth() + 430 && mey<=levelview.getBoardView().getHeight() + 70){
					levelview.getTopPanel().remove(levelview.getDraggingPieceView());
					levelview.setDraggingPieceView(null);
					levelview.reDrawBullpan();

					MouseEvent newme = new MouseEvent(me.getComponent(), me.getID(), me.getWhen(), me.getModifiers(), 
							me.getX()-430, me.getY()-70, me.getClickCount(), false);				
					levelview.getBoardController().mouseReleased(newme);
					fromBullpen = false;
					return;
				}			
			}
			
		}
		if(!fromBullpen && me != null){
			System.out.println("111");
			int x = 0;
			if(me.getX() > 185){
				x = 1; 
			}else{
				x = 2;
			}	
		    pieceN = ((me.getY()/185)+1)*2 - x;
		    System.out.println(pieceN);
		    if(bullpen.getPieces().get(pieceN) != null){
		    	levelview.getBoardController().mouseReleased(null);
		    	System.out.println("aaa");
		    	return;
		    }
			
		}
		bullpen.getPieces().set(pieceN,levelview.getDraggingPiece());
		if(me != null){
			levelview.getTopPanel().remove(levelview.getDraggingPieceView());
		}
		levelview.setDraggingPieceView(null);
		levelview.reDrawBullpan();
		levelview.repaint();
		
		fromBullpen = false;
	}
 

}
