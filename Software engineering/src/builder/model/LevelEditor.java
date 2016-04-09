package builder.model;

public abstract class LevelEditor {
	PieceContainer container;
	PieceCreator pc;
	BoardCreator bc;
	
	public LevelEditor(PieceContainer container, PieceCreator pc, BoardCreator bc){
		this.container = container;
		this.pc = pc;
		this.bc = bc;
	}
}
