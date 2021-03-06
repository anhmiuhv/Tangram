package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import builder.model.LevelEditor;
import builder.move.CreatePieceMove;
import builder.move.IMove;
import builder.view.JPieceContainerView;
import builder.view.JPieceCreatorView;

/**
 * This class managa the Piece Creator
 * @author lthoang
 *
 */
public class CreatePieceController implements ActionListener {

	LevelEditor lvle;
	JPieceContainerView containerView;
	JPieceCreatorView pcView;
	/**
	 * construct a controller for the add piece button
	 * @param lvle
	 * @param pcView
	 * @param containerView
	 */
	public CreatePieceController(LevelEditor lvle, JPieceCreatorView pcView, JPieceContainerView containerView){
		this.lvle = lvle;
		this.containerView = containerView;
		this.pcView = pcView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		IMove m = new CreatePieceMove(lvle.getPieceCreator(), lvle.getPieceContainer());
		if (m.doMove(lvle)){
			lvle.pushUndo(m);
		} else {
			JOptionPane.showMessageDialog(pcView.getParent(),
					"Invalid Piece",
					"Invalid Piece",
					JOptionPane.WARNING_MESSAGE);
		}
		lvle.getRedoStack().removeAllElements();
		containerView.update();
		containerView.repaint();
		
	}

}
