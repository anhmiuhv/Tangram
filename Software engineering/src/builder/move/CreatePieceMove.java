package builder.move;

import builder.model.LevelEditor;
import builder.model.PieceContainer;
import builder.model.PieceCreator;

/**
 * this class represent a move to creat piece
 * @author lthoang
 *
 */
public class CreatePieceMove implements IMove{

	PieceCreator pc;
	PieceContainer container;
	public CreatePieceMove(PieceCreator pc, PieceContainer container){
		this.pc = pc;
		this.container = container;
	}
	@Override
	public boolean isMoveValid(LevelEditor level) {
		if (!pc.createPiece()) return false;
		if (container.getPieces().size() > 36) return false;
		if (!pc.validPiece()) return false;
		
		return true;
	}

	@Override
	public boolean doMove(LevelEditor level) {
		if (!isMoveValid(level)) return false;
		container.addPiece(pc.getPiece());
		return true;
	}

	@Override
	public boolean undo(LevelEditor level) {
		// TODO Auto-generated method stub
		return false;
	}

}
