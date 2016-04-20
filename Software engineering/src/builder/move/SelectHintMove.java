package builder.move;

import model.Square;
import builder.model.LevelEditor;
import builder.view.JSquareView;

/**
 * This class represent a move to select a hint square
 * @author lthoang
 *
 */
public class SelectHintMove implements IMove {
	
	JSquareView view;
	
	public SelectHintMove(JSquareView view){
		this.view = view;
	}

	@Override
	public boolean isMoveValid(LevelEditor level) {
		Square s = view.getSquare();
		if (!level.getBoardCreator().getSelected()[s.getColumn() + s.getRow() * 12]) return false;
		return true;
	}

	@Override
	public boolean doMove(LevelEditor level) {
		if (!isMoveValid(level)) return false;
		if (view.isHint()){
			view.setHint(false);
			Square s = view.getSquare();
			level.getBoardCreator().deselectHintSquare(s.getColumn() + s.getRow() * 12);;
		} else {
			view.setHint(true);
			Square s = view.getSquare();
			level.getBoardCreator().selectHintSquare(s.getColumn() + s.getRow() * 12);;
		}
		return true;
	}

	@Override
	public boolean undo(LevelEditor level) {
		// TODO Auto-generated method stub
		return false;
	}

}
