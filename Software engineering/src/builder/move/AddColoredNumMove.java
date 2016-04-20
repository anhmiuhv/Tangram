package builder.move;

import java.awt.Color;

import javax.swing.JTextField;

import builder.model.LevelEditor;
import builder.model.Release;
import builder.view.JReleaseColoredNum;

/**
 * This class represent the move to add the colored number to the board
 * @author anhmiuhv
 *
 */
public class AddColoredNumMove implements IMove {
	LevelEditor lvle;
	JTextField textField;
	JReleaseColoredNum jrc;
	int position;
	public AddColoredNumMove(LevelEditor lvle, JTextField textField, JReleaseColoredNum jrc){
		this.lvle = lvle;
		this.textField = textField;
		this.jrc = jrc;
	}
	
	int[] squareNum;
	Color[] colorNum;
	@Override
	public boolean isMoveValid(LevelEditor level) {
		Release r = (Release) lvle;
		squareNum = r.getSquareNum();
		colorNum = r.getColorNum();
		position = Integer.parseInt(textField.getText());
		if (position > 143 || position < 0) return false; 
		
		return true;
	}

	@Override
	public boolean doMove(LevelEditor level) {
		if (!isMoveValid(level)) return false;
		Release r = (Release) lvle;
		String key = jrc.getColorString();
		int prev = r.getColoredNum().get(key + textField.getName()).getPosition();
		colorNum[prev] = null;
		squareNum[prev] = 0;
		r.getColoredNum().get(key + textField.getName()).setPosition(position);
		squareNum[position] = Integer.parseInt(textField.getName());
		colorNum[position] = jrc.getColorNum();
		return true;
	}

	@Override
	public boolean undo(LevelEditor level) {
		// TODO Auto-generated method stub
		return false;
	}

}
