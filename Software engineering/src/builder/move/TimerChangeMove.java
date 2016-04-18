package builder.move;

import javax.swing.JTextField;

import builder.model.LevelEditor;
import builder.model.LevelEditorState;
import builder.model.Lightning;

public class TimerChangeMove implements IMove {

	Lightning lvle;
	JTextField timer;
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
		lvle.setAllowedTime(Integer.parseInt(timer.getText()));
		return true;
	}

	@Override
	public boolean undo(LevelEditor level) {
		// TODO Auto-generated method stub
		return false;
	}

}
