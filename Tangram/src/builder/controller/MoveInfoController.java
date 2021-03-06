package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import builder.model.LevelEditor;
import builder.model.Puzzle;
import builder.move.IMove;
import builder.move.MoveChangeMove;
import builder.view.LevelEditorView;

/**
 * THis class handles the allowed move information for the puzzle level
 * @author lthoang
 *
 */
public class MoveInfoController implements ActionListener {

	LevelEditor editor;
	JTextField t;
	LevelEditorView view;
	/**
	 * contruct controller for the text field
	 * @param editor
	 * @param t
	 * @param view
	 */
	public MoveInfoController(LevelEditor editor, JTextField t, LevelEditorView view){
		this.editor = editor;
		this.t = t;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		IMove m = new MoveChangeMove(t, (Puzzle) editor);
		if (m.doMove(editor)){
			editor.pushUndo(m);
		}
		editor.getRedoStack().removeAllElements();
		view.update();
		view.repaint();
		System.out.println(((Puzzle) editor).getAllowedMove() + "hhhhhhh");
	}

}
