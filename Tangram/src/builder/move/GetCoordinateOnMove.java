package builder.move;

import java.awt.Color;

import javax.swing.JButton;

import builder.model.LevelEditor;
import builder.view.JBoardCreatorView;
import builder.view.JReleaseColoredNum;
import builder.view.LevelEditorView;

/**
 * This class represent a move to turn on get coordinate mode
 * @author lthoang
 *
 */
public class GetCoordinateOnMove implements IMove {

	LevelEditorView view;
	JButton button;
	JReleaseColoredNum jrc;
	JBoardCreatorView jbc;
	public GetCoordinateOnMove(LevelEditorView view, JButton button, JReleaseColoredNum jrc) {
		this.view = view;
		this.button = button;
		this.jrc = jrc;
		this.jbc = view.getJbc();
	}

	@Override
	public boolean isMoveValid(LevelEditor level) {
		return true;
	}

	@Override
	public boolean doMove(LevelEditor level) {
		jbc.setGetCoordinate(true);
		jrc.setChosenNumber(Integer.parseInt(button.getText()));
		System.out.println("choosen number" + jrc.getChosenNumber());
		jrc.setBackgroundButton();
		button.setBackground(Color.MAGENTA);
		return true;
	}

	@Override
	public boolean undo(LevelEditor level) {
		// TODO Auto-generated method stub
		return false;
	}

}
