package builder.controller;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import builder.model.LevelEditor;
import builder.move.GetCoordinateMove;
import builder.move.IMove;
import builder.move.SelectHintMove;
import builder.move.SelectTileBoardMove;
import builder.view.JBoardCreatorView;
import builder.view.JReleaseColoredNum;
import builder.view.JSquareView;

/**
 * This class handles indidual square of the board creator
 * @author lthoang
 *
 */
public class SelectBoardTileController implements MouseListener{
	
	LevelEditor lvle;
	JSquareView view;
	JBoardCreatorView jbc;
	JReleaseColoredNum jrc;
	/**
	 * construct controller for individual tile of the board
	 * @param lvle
	 * @param jbc
	 * @param view
	 * @param jrc
	 */
	public SelectBoardTileController(LevelEditor lvle, JBoardCreatorView jbc, JSquareView view, JReleaseColoredNum jrc){
		this.lvle = lvle;
		this.view = view;
		this.jbc = jbc;
		this.jrc = jrc;
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		if (jbc.isHintMode()) {
			IMove m = new SelectHintMove(view);
			if (m.doMove(lvle)){
				lvle.pushUndo(m);
			}
			lvle.getRedoStack().removeAllElements();
			view.paintColor();
			jbc.update();
			jbc.repaint();
			view.repaint();
		} else if (jbc.isGetCoordinate()) {
			IMove m = new GetCoordinateMove(view, jrc, jbc);
			m.doMove(lvle);
		} else {
			IMove m = new SelectTileBoardMove(view);
			if (m.doMove(lvle)){
				lvle.pushUndo(m);
			}
			lvle.getRedoStack().removeAllElements();
			view.paintColor();
			jbc.update();
			jbc.repaint();
			view.repaint();
		}

		
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
