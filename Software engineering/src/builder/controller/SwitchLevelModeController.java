package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import builder.model.LevelEditor;
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
	JComboBox<String> b;
	/**
	 * controller for switching mode
	 * @param lv
	 * @param editor
	 * @param b
	 */
	public SwitchLevelModeController(LevelEditorView lv, LevelEditor editor, JComboBox<String> b){
		this.lv = lv;
		this.editor = editor;
		this.b = b;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		IMove m = new SwitchModeMove(lv, editor, b);
		m.doMove(editor);
		lv.getEditor().pushUndo(m);

		lv.repaint();
	}
	
}
