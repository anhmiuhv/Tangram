package builder.move;

import java.awt.Color;

import javax.swing.JComboBox;

import builder.model.LevelEditor;
import builder.model.LevelEditorState;
import builder.model.Lightning;
import builder.model.Puzzle;
import builder.model.Release;
import builder.view.LevelEditorView;

/**
 * This class represent a move to switch mode in the builder
 * @author lthoang
 *
 */
public class SwitchModeMove implements IMove{

	LevelEditorView lv;
	LevelEditor le;
	JComboBox<String> b;
	LevelEditor oldle;
	/**
	 * creating a switching mode move
	 * @param lv
	 * @param lvle
	 * @param b
	 */
	public SwitchModeMove(LevelEditorView lv, LevelEditor lvle, JComboBox<String> b){
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
		oldle = lv.getEditor();
		oldle.pushRedo(this);
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
				this.lv.setEditor(new Puzzle(le.getLevelNum(), le.getPieceContainer(), le.getPieceCreator(), le.getBoardCreator(), 0));
				break;
			case LevelEditorState.LIGHTNING:
				this.lv.setEditor(new Lightning(le.getLevelNum(), le.getPieceContainer(), le.getPieceCreator(), le.getBoardCreator(), 0));
				break;
			case LevelEditorState.RELEASE:
				this.lv.setEditor(new Release(le.getLevelNum(), le.getPieceContainer(), le.getPieceCreator(), 
						le.getBoardCreator(), new int[144], new Color[144], Release.createEmptyListOfColoredNum()));
				break;
			}

		}
		lv.removeshit();
		lv.init();
		lv.getEditor().pushUndo(this);
		return true;
	}

	@Override
	public boolean undo(LevelEditor level) {
		lv.setEditor(oldle);
		lv.removeshit();
		lv.init();
		return true;
	}

}
