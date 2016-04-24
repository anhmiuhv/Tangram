package builder.move;
import model.Piece;
import builder.model.PieceContainer;
import builder.model.LevelEditor;

/**
 * This class represent a delete piece move
 * @author lthoang
 *
 */
public class DeletePieceMove implements IMove {

	PieceContainer pc;
	int order;
	Piece oldPiece;
	public DeletePieceMove(PieceContainer pc, int order){
		this.pc = pc;
		this.order = order;
	}
	@Override
	public boolean isMoveValid(LevelEditor level) {
		if (pc.getPieces().isEmpty()) return false;
		return true;
	}

	@Override
	public boolean doMove(LevelEditor level) {
		if (!isMoveValid(level)) return false;
		try{
			oldPiece = pc.getPieces().remove(order);
			return true;
		} catch (Exception e){
			return false;
		}
		
	}

	@Override
	public boolean undo(LevelEditor level) {
		pc.getPieces().add(oldPiece);
		return true;
	}

}
