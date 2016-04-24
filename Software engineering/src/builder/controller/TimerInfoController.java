package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import builder.model.LevelEditor;
import builder.model.Lightning;
import builder.move.IMove;
import builder.move.TimerChangeMove;
import builder.view.LevelEditorView;
/**
 * This class handles the timer information for LIGHTNING level
 * @author lthoang
 *
 */
public class TimerInfoController implements ActionListener {

	LevelEditor editor;
	JTextField t;
	LevelEditorView view;
	public TimerInfoController(LevelEditor editor, JTextField t, LevelEditorView view){
		this.editor = editor;
		this.t = t;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		IMove m = new TimerChangeMove(t, (Lightning) editor);
		if (m.doMove(editor)){
			editor.pushUndo(m);
		}
		editor.getRedoStack().removeAllElements();
		view.update();
		view.repaint();

	}

}
