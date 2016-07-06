package builder.move;

import javax.swing.JTextField;

import model.Square;
import builder.model.LevelEditor;
import builder.view.JBoardCreatorView;
import builder.view.JReleaseColoredNum;
import builder.view.JSquareView;
/**
 * This class represent a move to get the coordinate from the clicked tile on the board
 * @author lthoang
 *
 */
public class GetCoordinateMove implements IMove {

	JSquareView view;
	JReleaseColoredNum jrc;
	JBoardCreatorView jbc;
	JTextField t;
	public GetCoordinateMove(JSquareView view, JReleaseColoredNum jrc, JBoardCreatorView jbc){
		this.view = view;
		this.jrc = jrc;
		this.jbc = jbc;
	}
	
	@Override
	public boolean isMoveValid(LevelEditor level) {
		return true;
	}

	@Override
	public boolean doMove(LevelEditor level) {
		t = jrc.getTextField();
		Square s = view.getSquare();
		System.out.println("release " + jrc);
		System.out.println("text field " + jrc.getChosenNumber());
		t.setText(Integer.toString(s.getColumn() + s.getRow() * 12));
		t.postActionEvent();
		jbc.setGetCoordinate(false);
		jrc.setBackgroundButton();
		return true;
	}

	@Override
	public boolean undo(LevelEditor level) {
		// TODO Auto-generated method stub
		return false;
	}

}
