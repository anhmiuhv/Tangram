package builder.controller;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import builder.model.LevelEditor;
import builder.move.IMove;
import builder.move.SelectTileBoardMove;

import builder.view.JBoardCreatorView;
import builder.view.JSquareView;

public class SelectBoardTileController implements MouseListener{
	
	LevelEditor lvle;
	JSquareView view;
	JBoardCreatorView jbc;
	public SelectBoardTileController(LevelEditor lvle, JBoardCreatorView jbc, JSquareView view){
		this.lvle = lvle;
		this.view = view;
		this.jbc = jbc;
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		IMove m = new SelectTileBoardMove(view);
		m.doMove(lvle);
		view.paintColor();
		jbc.update();
		jbc.repaint();
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
