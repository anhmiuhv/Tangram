package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builder.model.LevelEditor;
import builder.move.DeletePieceMove;
import builder.move.IMove;
import builder.view.JPieceContainerView;

/**
 * This class handle the delete buttons for the pieces in the Piece Container
 * @author lthoang
 *
 */
public class DeletePieceController implements ActionListener {

	LevelEditor lvle;
	JPieceContainerView jpc;
	int order;
	public DeletePieceController(LevelEditor lvle, JPieceContainerView jpc, int order){
		this.lvle = lvle;
		this.jpc = jpc;
		this.order = order;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		IMove m = new DeletePieceMove(lvle.getPieceContainer(), order);
		if (m.doMove(lvle)){
			lvle.pushUndo(m);
		}
		lvle.getRedoStack().removeAllElements();
		jpc.update();
		jpc.repaint();
		
	}

}
