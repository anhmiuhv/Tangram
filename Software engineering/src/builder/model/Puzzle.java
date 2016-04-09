package builder.model;

public class Puzzle extends LevelEditor {
	int allowedMove;
	public Puzzle(PieceContainer container, PieceCreator pc, BoardCreator bc, int allowedMove) {
		super(container, pc, bc);
		this.allowedMove = allowedMove;
	}

}
