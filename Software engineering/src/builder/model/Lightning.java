package builder.model;

import java.awt.Color;

import model.Achievement;
import model.Board;
import model.Bullpen;
import model.LevelState;

/**
 * This class represent the LIghtning editor
 * @author lthoang
 *
 */
public class Lightning extends LevelEditor {
	/**Allowed time*/
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
		this.les = new LevelEditorState(levelNum, LevelEditorState.LIGHTNING, allowedTime, -1, container,
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
		this.allowedTime = les.getAllowedTime();
		this.pc = new PieceCreator();
		this.levelEditorType = les.getLevelType();
	}

	/**
	 * get the allowed time
	 * @return allowed time
	 */
	public int getAllowedTime() {
		return allowedTime;
	}
	
	/**
	 * set the allowed time
	 * @param allowedTime allowed time
	 */
	public void setAllowedTime(int allowedTime) {
		this.allowedTime = allowedTime;
	}


	@Override
	public boolean createLevelState() {
		if (this.getBoardCreator().getBoard() == null) return false;
		model.Board b = new Board(this.getBoardCreator().getBoard().getSquares());
		b.sethint(this.getBoardCreator().getHints());
		
		LevelState n = new LevelState(100 + this.levelNum, LevelEditorState.LIGHTNING, b, 0, this.allowedTime, false,
				new Achievement(0), new Bullpen(this.getPieceContainer().getPieces()), null, null);
		n.saveState();
		return true;	}

	

}
