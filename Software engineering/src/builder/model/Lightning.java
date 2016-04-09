package builder.model;

public class Lightning extends LevelEditor {
	int allowedTime;
	public Lightning(PieceContainer container, PieceCreator pc, BoardCreator bc, int allowedTime) {
		super(container, pc, bc);
		this.allowedTime = allowedTime;
	}

}
