package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import builder.model.LevelEditor;
import builder.move.IMove;
import builder.move.ReleaseColorMove;
import builder.view.LevelEditorView;

public class ReleaseColorController implements ActionListener {
	LevelEditorView lev;
	JComboBox box;
	LevelEditor editor;
	public ReleaseColorController(JComboBox comboBox,
			LevelEditorView levelEditorView, LevelEditor editor) {
		this.lev = lev;
		this.box = comboBox;
		this.editor = editor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		IMove m = new ReleaseColorMove(editor, lev, box);
		m.doMove(editor);
	}

}
