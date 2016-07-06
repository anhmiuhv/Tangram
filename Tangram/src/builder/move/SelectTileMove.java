package builder.move;

import java.awt.Color;

import model.Square;
import builder.model.LevelEditor;
import builder.view.*;

/**
 * This class represent a move to select a square in the piece creator
 * @author lthoang
 *
 */
public class SelectTileMove implements IMove{

	JSquareView square;
	
	public SelectTileMove(JSquareView square){
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
			level.getPieceCreator().getSelected()[s.getColumn() + s.getRow() * 6] = false;
			square.setColor(Color.WHITE);
		} else {
			Square s = square.getSquare();
			level.getPieceCreator().getSelected()[s.getColumn() + s.getRow() * 6] = true;
			square.setColor(Color.BLACK);
		}
		return true;
		
	}

	@Override
	public boolean undo(LevelEditor level) {
		if (square.getColor().equals(Color.BLACK)){
			Square s = square.getSquare();
			level.getPieceCreator().getSelected()[s.getColumn() + s.getRow() * 6] = false;
			square.setColor(Color.WHITE);
		} else {
			Square s = square.getSquare();
			level.getPieceCreator().getSelected()[s.getColumn() + s.getRow() * 6] = true;
			square.setColor(Color.BLACK);
		}
		return true;
	}

}
