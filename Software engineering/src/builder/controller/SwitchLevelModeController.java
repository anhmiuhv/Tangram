package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import builder.model.BoardCreator;
import builder.model.LevelEditor;
import builder.model.LevelEditorState;
import builder.model.PieceContainer;
import builder.model.PieceCreator;
import builder.model.Puzzle;
import builder.move.IMove;
import builder.move.SwitchModeMove;
import builder.view.LevelEditorView;

/**
 * THis class handle the switching of game mode
 * @author lthoang
 *
 */
public class SwitchLevelModeController implements ActionListener {

	LevelEditorView lv;
	LevelEditor editor;
	JComboBox b;
	public SwitchLevelModeController(LevelEditorView lv, LevelEditor editor, JComboBox b){
		this.lv = lv;
		this.editor = editor;
		this.b = b;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		IMove m = new SwitchModeMove(lv, editor, b);
		m.doMove(editor);
		lv.init();
	}
	
}
