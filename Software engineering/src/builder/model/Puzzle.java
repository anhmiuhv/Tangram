package builder.model;

import java.awt.Color;

public class Puzzle extends LevelEditor {
	int allowedMove;
	public Puzzle(int levelNum, PieceContainer container, PieceCreator pc, BoardCreator bc, int allowedMove) {
		super(levelNum, container, pc, bc);
		this.allowedMove = allowedMove;
		this.levelEditorType = LevelEditorState.PUZZLE;
	}
	@Override
	public void createLevelEditorState() {
		this.les = new LevelEditorState(levelNum, LevelEditorState.PUZZLE, -1, allowedMove, container, bc.getSelected(),bc.getBoard(), bc.getHints(), new int[0], new int[0]);
		
	}
	@Override
	public void loadLevelEditorState(LevelEditorState les) {
		this.container = les.getPc();
		this.levelNum = les.getLevelNum();
		this.bc = new BoardCreator();
		this.bc.setSelected(les.getSelectedSquare());
		this.bc.setBoard(les.getBoard());
		this.bc.setHints(les.getHint());
		this.allowedMove = les.getAllowedMove();
	}

	
}
