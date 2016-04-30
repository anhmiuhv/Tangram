package builder.model;

import java.awt.Color;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import model.Achievement;
import model.Board;
import model.Bullpen;
import model.LevelState;
import model.Square;

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
	HashMap<String, ColoredNumber> coloredNum;
	Set<Integer> pos;
	
	/** actual position of the square Num and the color*/
	int[] actualNum;
	Color[] actualColorNum;
	
	public Release(int levelNum, PieceContainer container, PieceCreator pc, BoardCreator bc
			, int[] squareNum, Color[] colorNum, HashMap<String, ColoredNumber> coloredNum) {
		super(levelNum, container, pc, bc);
		this.squareNum = squareNum;
		this.colorNum = colorNum;
		this.levelEditorType = LevelEditorState.RELEASE;
		this.coloredNum = coloredNum;
		this.pos = new HashSet<Integer>();
		for (ColoredNumber cn: coloredNum.values()){
			if (cn.position != -1){
				pos.add(cn.position);
			}
		}
	}

	/**
	 * add the position in the the position set
	 * @param position
	 * @return true if position has been added, false if the position exist
	 */
	public boolean addPosition(int position){
		
		return pos.add(position);
	}
	
	/**
	 * remove the position from the set
	 * @param position
	 * @return true if success
	 */
	public boolean removePosition(int position){
		return pos.remove(position);
	}
	public Release(LevelEditorState les){
		super(les);
	}
	
	/**
	 * get the color position in the board 
	 * @return color array have 144 elements
	 */
	public Color[] getColorNum() {
		return colorNum;
	}

	/**
	 * set the color position in the board
	 * @param colorNum color position
	 */
	public void setColorNum(Color[] colorNum) {
		this.colorNum = colorNum;
	}

	/**
	 * get the number position in the board
	 * @return the position
	 */
	public int[] getSquareNum() {
		return squareNum;
	}

	/**
	 * set the postion in the board
	 * @param squareNum position
	 */
	public void setSquareNum(int[] squareNum) {
		this.squareNum = squareNum;
	}

	/**
	 * get the colored number object array (this array is just for the validation of the release level)
	 * @return
	 */
	public HashMap<String, ColoredNumber> getColoredNum() {
		return coloredNum;
	}

	/**
	 * set the colored number object array
	 * @param coloredNum
	 */
	public void setColoredNum(HashMap<String, ColoredNumber> coloredNum) {
		this.coloredNum = coloredNum;
	}

	@Override
	public void createLevelEditorState() {
		container.clearPlacedPiece();
		this.les = new LevelEditorState(levelNum, LevelEditorState.RELEASE, -1, -1, container, 
				bc.getSelected(),bc.getBoard(), bc.getHints(), this.squareNum, this.colorNum, 
				bc.getIsHintSquare(), this.coloredNum, this.actualNum, this.actualColorNum);
		
	}
	
	public void createActualSquareNum(builder.model.Board b){
		Square[] s = b.getSquares();
		this.actualNum = new int[s.length];
		this.actualColorNum = new Color[s.length];
		int idx = 0;
		for (Square square: s){
			if (squareNum[square.getColumn() + square.getRow() * 12] != 0){
				actualNum[idx] = squareNum[square.getColumn() + square.getRow() * 12];
				actualColorNum[idx] = colorNum[square.getColumn() + square.getRow() * 12];
			}
			idx++;
		}
		return;
	}
	public static HashMap<String, ColoredNumber> createEmptyListOfColoredNum(){
		HashMap<String, ColoredNumber> r = new HashMap<String, ColoredNumber>();
		for (int i = 0; i < 6; i++){
			ColoredNumber cn1 = new ColoredNumber(i + 1, Color.YELLOW);
			ColoredNumber cn2 = new ColoredNumber(i + 1, Color.PINK);
			ColoredNumber cn3 = new ColoredNumber(i + 1, Color.ORANGE);
			r.put(cn1.toString(), cn1);
			r.put(cn2.toString(), cn2);
			r.put(cn3.toString(), cn3);
		}
		return r;
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
		this.actualColorNum = les.getActualColor();
		this.actualNum = les.getActualSquareNum();
		this.coloredNum = Release.createEmptyListOfColoredNum();
		for (int i = 0;i < 144; i++){
			if (squareNum[i] != 0){
				String s = new ColoredNumber(squareNum[i], colorNum[i]).toString();
				this.coloredNum.get(s).setPosition(i);;
			}
		}
		this.pos =  new HashSet<Integer>();
		for (ColoredNumber cn: coloredNum.values()){
			if (cn.position != -1){
				System.out.println(this.pos.add(cn.position));
			}
		}

	}

	
	@Override
	public boolean createLevelState() {
		for (ColoredNumber cn: this.coloredNum.values()){
			if (cn.getPosition() == -1) return false;
		}
	
		if (this.getBoardCreator().getBoard() == null) return false;
		model.Board b = new Board(this.getBoardCreator().getBoard().getSquares());
		b.sethint(this.getBoardCreator().getHints());
		
		LevelState n = new LevelState(100 + this.levelNum, LevelEditorState.RELEASE, b, 0, 0, false,
				new Achievement(0), new Bullpen(this.getPieceContainer().getPieces()), this.actualNum, this.actualColorNum);
		n.saveState();
		return true;
	}
}
