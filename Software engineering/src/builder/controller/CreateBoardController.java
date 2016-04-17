package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builder.model.LevelEditor;
import builder.move.CreateBoardMove;
import builder.move.CreatePieceMove;
import builder.move.IMove;
import builder.view.JBoardCreatorView;
import builder.view.JPieceContainerView;
import builder.view.JPieceCreatorView;

public class CreateBoardController implements ActionListener {

	LevelEditor lvle;
	JBoardCreatorView view;
	public CreateBoardController(LevelEditor lvle, JBoardCreatorView view){
		this.lvle = lvle;
		this.view= view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		IMove m = new CreateBoardMove(lvle.getBoardCreator());
		m.doMove(lvle);
		view.update();
		view.repaint();
		
	}

}
