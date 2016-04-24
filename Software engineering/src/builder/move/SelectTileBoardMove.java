package builder.move;

import java.awt.Color;

import model.Square;
import builder.model.LevelEditor;
import builder.view.*;

/**
 * THis class represent a move to select a tile in the board creator
 * @author lthoang
 *
 */
public class SelectTileBoardMove implements IMove{

	JSquareView square;

	public SelectTileBoardMove(JSquareView square){
		this.square = square;
	}
	@Override
	public boolean isMoveValid(LevelEditor level) {
		return true;
	}


	@Override
	public boolean doMove(LevelEditor level) {
		if (square.getColor().equals(Color.BLACK)){
			Square s = square.getSquare();
			level.getBoardCreator().deselectSquare(s.getColumn() + s.getRow() * 12);
			square.setColor(Color.WHITE);
		} else {
			Square s = square.getSquare();
			level.getBoardCreator().selectSquare(s.getColumn() + s.getRow() * 12);
			square.setColor(Color.BLACK);
		}
		return true;

	}

	@Override
	public boolean undo(LevelEditor level) {
		if (square.getColor().equals(Color.BLACK)){
			Square s = square.getSquare();
			level.getBoardCreator().deselectSquare(s.getColumn() + s.getRow() * 12);
			square.setColor(Color.WHITE);
		} else {
			Square s = square.getSquare();
			level.getBoardCreator().selectSquare(s.getColumn() + s.getRow() * 12);
			square.setColor(Color.BLACK);
		}
		return true;
	}

}
