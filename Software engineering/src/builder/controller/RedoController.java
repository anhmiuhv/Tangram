package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;

import builder.model.LevelEditor;
import builder.move.IMove;
import builder.view.LevelEditorView;

public class RedoController implements ActionListener {
	LevelEditorView lev;
	LevelEditor editor;
	public RedoController(LevelEditorView levelEditorView, LevelEditor editor) {
		this.lev = levelEditorView;
		this.editor = editor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			IMove m = editor.popRedo();
			m.doMove(editor);
			lev.update();
			lev.repaint();
			editor.pushUndo(m);
		} catch (EmptyStackException except){
			java.awt.Toolkit.getDefaultToolkit().beep();
		}


	}

}
