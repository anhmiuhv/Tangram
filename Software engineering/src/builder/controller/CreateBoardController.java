package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builder.model.LevelEditor;
import builder.move.CreateBoardMove;
import builder.move.IMove;
import builder.view.JBoardCreatorView;

/**
 * This class manage the action for Board Creator
 * @author lthoang
 *
 */
public class CreateBoardController implements ActionListener {

	LevelEditor lvle;
	JBoardCreatorView view;
	/**
	 * contruct a controller for the add board button
	 * @param lvle
	 * @param view
	 */
	public CreateBoardController(LevelEditor lvle, JBoardCreatorView view){
		this.lvle = lvle;
		this.view= view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		IMove m = new CreateBoardMove(lvle);
		if (m.doMove(lvle)){
			lvle.pushUndo(m);
		}
		lvle.getRedoStack().removeAllElements();
		view.update();
		view.repaint();
		
	}

}
