package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import builder.model.LevelEditor;
import builder.model.Lightning;
import builder.model.Puzzle;
import builder.move.IMove;
import builder.move.MoveChangeMove;
import builder.move.TimerChangeMove;

public class MoveInfoController implements ActionListener {

	LevelEditor editor;
	JTextField t;
	public MoveInfoController(LevelEditor editor, JTextField t){
		this.editor = editor;
		this.t = t;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		IMove m = new MoveChangeMove(t, (Puzzle) editor);
		m.doMove(editor);
		System.out.println(((Puzzle) editor).getAllowedMove() + "hhhhhhh");
	}

}
