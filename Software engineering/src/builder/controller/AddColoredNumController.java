package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import builder.model.LevelEditor;
import builder.model.Release;
import builder.move.AddColoredNumMove;
import builder.move.IMove;
import builder.view.JReleaseColoredNum;
import builder.view.LevelEditorView;

/**
 * This class represent the controller for the input coordination of the colored number on the board
 * @author lthoang
 * 
 *
 */
public class AddColoredNumController implements ActionListener {

	JReleaseColoredNum jrc;
	LevelEditor editor;
	LevelEditorView view;
	JTextField textField;
	/**
	 * contruct a controller for the button in the Release colored number panel
	 * @param jrc
	 * @param editor
	 * @param view
	 * @param textField
	 */
	public AddColoredNumController(JReleaseColoredNum jrc, LevelEditor editor, LevelEditorView view, JTextField textField){
		this.jrc = jrc;
		this.editor = editor;
		this.view = view;
		this.textField = textField;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		IMove m =new AddColoredNumMove(editor, textField, jrc);
		if (m.doMove(editor)){
			editor.pushUndo(m);
		}
		editor.getRedoStack().removeAllElements();
		System.out.println(((Release) editor).getSquareNum()); 
		jrc.update();
		view.update();
		view.repaint();
	}
	
}
