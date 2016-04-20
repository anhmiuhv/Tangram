package builder.controller;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import builder.model.LevelEditor;
import builder.move.IMove;
import builder.move.SelectTileMove;
import builder.view.JSquareView;

/**
 * This class handles the individual squares of piece creator
 * @author lthoang
 *
 */
public class SelectPieceTileController implements MouseListener{
	
	LevelEditor lvle;
	JSquareView view;
	public SelectPieceTileController(LevelEditor lvle, JSquareView view){
		this.lvle = lvle;
		this.view = view;
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		IMove m = new SelectTileMove(view);
		m.doMove(lvle);
		view.paintColor();
		view.repaint();
		
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
