package builder.move;
import builder.model.PieceContainer;
import builder.model.LevelEditor;

public class DeletePieceMove implements IMove {

	PieceContainer pc;
	int order;
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
			pc.getPieces().remove(order);
			return true;
		} catch (Exception e){
			return false;
		}
		
	}

	@Override
	public boolean undo(LevelEditor level) {
		// TODO Auto-generated method stub
		return false;
	}

}
