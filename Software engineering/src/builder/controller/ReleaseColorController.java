package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import builder.model.LevelEditor;
import builder.model.Release;
import builder.move.IMove;
import builder.move.ReleaseColorMove;
import builder.view.JReleaseColoredNum;
import builder.view.LevelEditorView;

public class ReleaseColorController implements ActionListener {
	JReleaseColoredNum lev;
	JComboBox box;
	LevelEditor editor;
	public ReleaseColorController(JComboBox comboBox,
			JReleaseColoredNum lev, LevelEditor editor2) {
		this.lev = lev;
		this.box = comboBox;
		this.editor = editor2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		IMove m = new ReleaseColorMove(editor, lev, box);
		m.doMove(editor);
		lev.update();
		lev.repaint();
	}

}
