package builder.model;

public class Release extends LevelEditor{
	int[] squareNum;
	int[] colorNum;
	public Release(PieceContainer container, PieceCreator pc, BoardCreator bc, int[] squareNum, int[] colorNum) {
		super(container, pc, bc);
		this.squareNum = squareNum;
		this.colorNum = colorNum;
	}

}
