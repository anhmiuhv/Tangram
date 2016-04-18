package builder.model;


public class Lightning extends LevelEditor {
	int allowedTime;
	public Lightning(int levelNum, PieceContainer container, PieceCreator pc, BoardCreator bc, int allowedTime) {
		super(levelNum, container, pc, bc);
		this.allowedTime = allowedTime;
		this.levelEditorType = LevelEditorState.LIGHTNING;
	}
	
	
	public Lightning(LevelEditorState les){
		super(les);
	}
	@Override
	public void createLevelEditorState() {
		this.les = new LevelEditorState(levelNum, LevelEditorState.LIGHTNING, allowedTime, -1, container, bc.getSelected(),bc.getBoard(), bc.getHints(), new int[0], new int[0]);
		
	}
	@Override
	public void loadLevelEditorState(LevelEditorState les) {
		this.container = les.getPc();
		this.levelNum = les.getLevelNum();
		this.bc = new BoardCreator();
		this.bc.setSelected(les.getSelectedSquare());
		this.bc.setBoard(les.getBoard());
		this.bc.setHints(les.getHint());
		this.allowedTime = les.getAllowedTime();
		this.pc = new PieceCreator();
		this.levelEditorType = les.getLevelType();
	}

	public int getAllowedTime() {
		return allowedTime;
	}

	public void setAllowedTime(int allowedTime) {
		this.allowedTime = allowedTime;
	}

	

}
