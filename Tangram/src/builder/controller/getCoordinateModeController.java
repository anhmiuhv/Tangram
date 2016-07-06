package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import builder.model.LevelEditor;
import builder.move.GetCoordinateOnMove;
import builder.move.IMove;
import builder.view.JReleaseColoredNum;
import builder.view.LevelEditorView;

/**
 * This class represent a move to turn on the coordinate mode
 * @author anhmiuhv
 *
 */
public class getCoordinateModeController implements ActionListener {
	LevelEditorView view;
	JButton button;
	LevelEditor level;
	JReleaseColoredNum jrc;
	/**
	 * contruct a controller for the turn coordinate on mode
	 * @param view
	 * @param button
	 * @param level
	 * @param jrc
	 */
	public getCoordinateModeController(LevelEditorView view, JButton button, LevelEditor level, JReleaseColoredNum jrc){
		this.view = view;
		this.button = button;
		this.level = level;
		this.jrc = jrc;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		IMove m = new GetCoordinateOnMove(view, button,jrc);
		m.doMove(level);
	}

}
