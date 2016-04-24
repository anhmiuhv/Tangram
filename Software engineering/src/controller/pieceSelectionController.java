package controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Bullpen;
import model.Piece;
import model.Square;
import view.JBullPenView;
import view.JPieceView;
import view.LevelView;

public class pieceSelectionController implements MouseListener{
	
	JPieceView pv;
	LevelView levelview;
	Bullpen bullpen;

	public pieceSelectionController(LevelView levelview, Bullpen bp){
		this.levelview = levelview;
		this.bullpen = bp;
	}
	
	@Override
	public void mouseClicked (MouseEvent me) {
		
		int pieceN = 0;
		
		int x = 0;
		if(me.getX() > 185){
			x = 1; 
		}else{
			x = 2;
		}
		
	    pieceN = ((me.getY()/185)+1)*2 - x;
	    bullpen.setPieceSelected(pieceN);
	    
	    levelview.reDrawBullpan(bullpen);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
