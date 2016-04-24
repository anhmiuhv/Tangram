package builder.move;

import builder.model.Board;
import builder.model.BoardCreator;
import builder.model.LevelEditor;

/**
 * this class represent a move to create board
 * @author lthaong
 *
 */
public class CreateBoardMove implements IMove {
	
	BoardCreator bc;
	Board oldBoard;
	public CreateBoardMove(BoardCreator bc){
		this.bc = bc;
		if (bc.getBoard() != null){
			this.oldBoard = new Board(bc.getBoard().getSquares());
		}
	}

	@Override
	public boolean isMoveValid(LevelEditor level) {
		return bc.createBoard();
	}

	@Override
	public boolean doMove(LevelEditor level) {
		return isMoveValid(level);
	}

	@Override
	public boolean undo(LevelEditor level) {
		bc.setBoard(oldBoard);;
		return true;
	}

}
