package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;

import builder.model.LevelEditor;
import builder.move.IMove;
import builder.view.LevelEditorView;
/**
 * This class coordinate the undo event
 * @author lthoang
 *
 */
public class UndoController implements ActionListener {
	LevelEditorView lev;
	LevelEditor editor;
	/**
	 * controller for undo
	 * @param levelEditorView
	 * @param editor
	 */
	public UndoController(LevelEditorView levelEditorView, LevelEditor editor) {
		this.lev = levelEditorView;
		this.editor = editor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			IMove m = editor.popUndo();
			m.undo(editor);
			lev.update();
			lev.repaint();
			editor.pushRedo(m);
		} catch (EmptyStackException except){
			java.awt.Toolkit.getDefaultToolkit().beep();
		}

	}

}
