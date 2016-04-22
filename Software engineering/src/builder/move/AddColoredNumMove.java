package builder.move;

import java.awt.Color;

import javax.swing.JTextField;

import builder.model.ColoredNumber;
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
	int prev;
	public AddColoredNumMove(LevelEditor lvle, JTextField textField, JReleaseColoredNum jrc){
		this.lvle = lvle;
		this.textField = textField;
		this.jrc = jrc;
	}

	int[] squareNum;
	Color[] colorNum;
	ColoredNumber c;
	@Override
	public boolean isMoveValid(LevelEditor level) {
		Release r = (Release) lvle;
		squareNum = r.getSquareNum();
		colorNum = r.getColorNum();
		try {
			position = Integer.parseInt(textField.getText());
		} catch (Exception e){
			return false;
		}
		if (position > 143 || position < 0) return false; 
		boolean[] selected = lvle.getBoardCreator().getSelected();
		if (selected[position] == false) return false;
		if (!r.addPosition(position)) return false;
		return true;
	}

	@Override
	public boolean doMove(LevelEditor level) {
		if (!isMoveValid(level)) return false;
		Release r = (Release) lvle;
		String key = jrc.getColorString();
		prev = r.getColoredNum().get(key + textField.getName()).getPosition();
		if (prev != -1){
			colorNum[prev] = null;
			squareNum[prev] = 0;
			r.removePosition(prev);
		} 
		c = r.getColoredNum().get(key + textField.getName());
		c.setPosition(position);
		squareNum[position] = Integer.parseInt(textField.getName());
		colorNum[position] = jrc.getColorNum();
		return true;
	}

	@Override
	public boolean undo(LevelEditor level) {
		Release r = (Release) lvle;
		if (prev != -1){
			colorNum[prev] = c.getC();
			squareNum[prev] = c.getI();
			r.addPosition(prev);
		}
		r.removePosition(position);
		c.setPosition(prev);
		squareNum[position] = 0;
		colorNum[position] = null;
		
		return true;
	}

}
