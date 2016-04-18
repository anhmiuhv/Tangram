package builder.model;

public class Release extends LevelEditor{
	int[] squareNum;
	int[] colorNum;
	public Release(int levelNum, PieceContainer container, PieceCreator pc, BoardCreator bc, int[] squareNum, int[] colorNum) {
		super(levelNum, container, pc, bc);
		this.squareNum = squareNum;
		this.colorNum = colorNum;
		this.levelEditorType = LevelEditorState.RELEASE;
	}

	public Release(LevelEditorState les){
		super(les);
	}
	@Override
	public void createLevelEditorState() {
		this.les = new LevelEditorState(levelNum, LevelEditorState.RELEASE, -1, -1, container, bc.getSelected(),bc.getBoard(), bc.getHints(), this.squareNum, this.colorNum);
		
	}
	@Override
	public void loadLevelEditorState(LevelEditorState les) {
		this.container = les.getPc();
		this.levelNum = les.getLevelNum();
		this.bc = new BoardCreator();
		this.bc.setSelected(les.getSelectedSquare());
		this.bc.setBoard(les.getBoard());
		this.bc.setHints(les.getHint());
		this.squareNum = les.getSquareNum();
		this.colorNum = les.getColor();
		this.pc = new PieceCreator();
		this.levelEditorType = les.getLevelType();
	}
}
