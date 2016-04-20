package builder.model;

import java.awt.Color;

/**
 * This class represent a release editor
 * @author lthoang
 *
 */
public class Release extends LevelEditor{
	/** location of the number*/
	int[] squareNum;
	/** color of the num*/
	Color[] colorNum;
	
	public Release(int levelNum, PieceContainer container, PieceCreator pc, BoardCreator bc, int[] squareNum, Color[] colorNum) {
		super(levelNum, container, pc, bc);
		this.squareNum = squareNum;
		this.colorNum = colorNum;
		this.levelEditorType = LevelEditorState.RELEASE;
	}

	public Release(LevelEditorState les){
		super(les);
	}
	public Color[] getColorNum() {
		return colorNum;
	}

	public void setColorNum(Color[] colorNum) {
		this.colorNum = colorNum;
	}

	public int[] getSquareNum() {
		return squareNum;
	}

	public void setSquareNum(int[] squareNum) {
		this.squareNum = squareNum;
	}

	@Override
	public void createLevelEditorState() {
		this.les = new LevelEditorState(levelNum, LevelEditorState.RELEASE, -1, -1, container, 
				bc.getSelected(),bc.getBoard(), bc.getHints(), this.squareNum, this.colorNum, bc.getIsHintSquare());
		
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
		this.squareNum = les.getSquareNum();
		this.colorNum = les.getColor();
		this.pc = new PieceCreator();
		this.levelEditorType = les.getLevelType();
	}
}
