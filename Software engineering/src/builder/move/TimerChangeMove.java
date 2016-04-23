package builder.move;

import javax.swing.JTextField;

import builder.model.LevelEditor;
import builder.model.LevelEditorState;
import builder.model.Lightning;

/**
 * This class represent a move to change the time in the Lightning level
 * @author anhmiuhv
 *
 */
public class TimerChangeMove implements IMove {

	Lightning lvle;
	JTextField timer;
	int oldTime;
	public TimerChangeMove(JTextField timer, Lightning lvle){
		this.lvle = lvle;
		this.timer = timer;
	}
	@Override
	public boolean isMoveValid(LevelEditor level) {
		try{
			int t = Integer.parseInt(timer.getText());
			if (t < 0) return false;
		} catch(Exception e){
			return false;
		}

		if (!lvle.getLevelEditorType().equals(LevelEditorState.LIGHTNING)) return false;
		return true;
	}

	@Override
	public boolean doMove(LevelEditor level) {
		if (!isMoveValid(level)) return false;
		oldTime = lvle.getAllowedTime();
		lvle.setAllowedTime(Integer.parseInt(timer.getText()));
		return true;
	}

	@Override
	public boolean undo(LevelEditor level) {
		lvle.setAllowedTime(oldTime);
		return false;
	}

}
