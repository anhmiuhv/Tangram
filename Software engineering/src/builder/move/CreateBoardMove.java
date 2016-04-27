package builder.move;

import builder.model.Board;
import builder.model.BoardCreator;
import builder.model.LevelEditor;
import builder.model.LevelEditorState;
import builder.model.Release;

/**
 * this class represent a move to create board
 * @author lthaong
 *
 */
public class CreateBoardMove implements IMove {
	LevelEditor lvle;
	BoardCreator bc;
	Board oldBoard;
	public CreateBoardMove(LevelEditor lvle){
		this.lvle = lvle;
		this.bc = lvle.getBoardCreator();
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
		
		if (isMoveValid(level)){
			if (lvle.getLevelEditorType().equals(LevelEditorState.RELEASE)){
				((Release) lvle).createActualSquareNum(bc.getBoard());
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean undo(LevelEditor level) {
		bc.setBoard(oldBoard);
		if (lvle.getLevelEditorType().equals(LevelEditorState.RELEASE)){
			((Release) lvle).createActualSquareNum(oldBoard);
		}
		return true;
	}

}
