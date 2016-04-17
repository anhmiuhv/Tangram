package builder.model;

public abstract class LevelEditor {
	PieceContainer container;
	PieceCreator pc;
	BoardCreator bc;
	int levelNum;
	LevelEditorState les;
	String levelEditorType;
	
	public LevelEditor(LevelEditorState les){
		this.loadLevelEditorState(les);
	}
	
	public LevelEditor(int levelNum, PieceContainer container, PieceCreator pc, BoardCreator bc){
		this.levelNum = levelNum;
		this.container = container;
		this.pc = pc;
		this.bc = bc;
	}
	
	public PieceCreator getPieceCreator(){
		return pc;
	}
	
	public PieceContainer getPieceContainer(){
		return container;
	}
	
	public BoardCreator getBoardCreator(){
		return bc;
	}
	
	public abstract void createLevelEditorState();
	public abstract void loadLevelEditorState(LevelEditorState les);
	
	
}
