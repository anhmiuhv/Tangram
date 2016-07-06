package builder.move;

import javax.swing.JTextField;

import builder.model.LevelEditorState;
import builder.model.Puzzle;
import builder.model.LevelEditor;

/**
 * this class represent a move to change the allowed move of the puzzle mode
 * @author lthoang
 *
 */
public class MoveChangeMove implements IMove {

	JTextField timer;
	Puzzle editor;
	int oldMove;
	public MoveChangeMove(JTextField t, Puzzle editor) {
		this.timer = t;
		this.editor = editor;
	}

	@Override
	public boolean isMoveValid(LevelEditor level) {
		try{
			int t = Integer.parseInt(timer.getText());
			if (t < 0) return false;
		} catch(Exception e){
			return false;
		}

		if (!editor.getLevelEditorType().equals(LevelEditorState.PUZZLE)) return false;
		return true;
	}

	@Override
	public boolean doMove(LevelEditor level) {
		if (!isMoveValid(level)) return false;
		oldMove = editor.getAllowedMove();
		editor.setAllowedMove(Integer.parseInt(timer.getText()));
		return true;
	}

	@Override
	public boolean undo(LevelEditor level) {
		editor.setAllowedMove(oldMove);
		return true;
	}

}
