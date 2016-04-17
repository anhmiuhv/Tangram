package builder.move;

import builder.model.BoardCreator;
import builder.model.LevelEditor;

public class CreateBoardMove implements IMove {
	
	BoardCreator bc;
	public CreateBoardMove(BoardCreator bc){
		this.bc = bc;
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
		// TODO Auto-generated method stub
		return false;
	}

}
