package builder.move;

import javax.swing.JComboBox;

import builder.model.LevelEditor;
import builder.model.LevelEditorState;
import builder.view.LevelEditorView;

public class SwitchModeMove implements IMove{

	LevelEditorView lv;
	LevelEditor le;
	JComboBox b;
	public SwitchModeMove(LevelEditorView lv, LevelEditor lvle, JComboBox b){
		this.lv = lv;
		this.le = lvle;
		this.b = b;
	}
	
	@Override
	public boolean isMoveValid(LevelEditor level) {
		return true;
	}

	@Override
	public boolean doMove(LevelEditor level) {
		// TODO Auto-generated method stub
		String m = (String) b.getSelectedItem();
		switch (m){
		case "Puzzle Level":
			m = LevelEditorState.PUZZLE;
			break;
		case "Lightning Level":
			m = LevelEditorState.LIGHTNING;
			break;
		case "Release Level":
			m = LevelEditorState.RELEASE;
			break;
		}
		
		if (!le.getLevelEditorType().equals(m)){
			switch (m){
			case LevelEditorState.PUZZLE:
				 
			}
				
		}
		return true;
	}

	@Override
	public boolean undo(LevelEditor level) {
		// TODO Auto-generated method stub
		return false;
	}

}
