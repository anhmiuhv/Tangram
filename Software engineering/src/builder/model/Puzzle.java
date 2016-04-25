package builder.model;

import java.awt.Color;

import model.LevelState;

/**
 * THis class represent an Puzzle editor
 * @author lthoang
 *
 */
public class Puzzle extends LevelEditor {
	/** allowed move in puzzle*/
	int allowedMove;
	
	
	
	public Puzzle(int levelNum, PieceContainer container, PieceCreator pc, BoardCreator bc, int allowedMove) {
		super(levelNum, container, pc, bc);
		this.allowedMove = allowedMove;
		this.levelEditorType = LevelEditorState.PUZZLE;
	}
	public Puzzle(LevelEditorState tmp) {
		super(tmp);
	}
	
	@Override
	public void createLevelEditorState() {
		this.les = new LevelEditorState(levelNum, LevelEditorState.PUZZLE, -1, allowedMove, container, 
				bc.getSelected(),bc.getBoard(), bc.getHints(), new int[0], new Color[0], bc.getIsHintSquare(), null, null, null);
		
	}
	@Override
	public void loadLevelEditorState(LevelEditorState les) {
		this.container = les.getPc();
		this.levelNum = les.getLevelNum();
		this.bc = new BoardCreator();
		this.bc.setSelected(les.getSelectedSquare());
		this.bc.setIsHintSquare(les.getIsHintSquare());
		this.bc.setBoard(les.getBoard());
		this.bc.setHints(les.getHint());
		this.allowedMove = les.getAllowedMove();
		this.pc = new PieceCreator();
		this.levelEditorType = les.getLevelType();
	}
	
	/**
	 * get the allowed move
	 * @return allowed move
	 */
	public int getAllowedMove() {
		return allowedMove;
	}
	
	/**
	 * set the allowed move
	 * @param allowedMove allowed move
	 */
	public void setAllowedMove(int allowedMove) {
		this.allowedMove = allowedMove;
	}
	@Override
	public LevelState createLevelState() {
		// TODO Auto-generated method stub
		return null;
	}
}
