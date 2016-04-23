package builder.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import model.LevelState;

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

	public boolean addPosition(int position){
		
		return pos.add(position);
	}
	
	public boolean removePosition(int position){
		return pos.remove(position);
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

	public HashMap<String, ColoredNumber> getColoredNum() {
		return coloredNum;
	}

	public void setColoredNum(HashMap<String, ColoredNumber> coloredNum) {
		this.coloredNum = coloredNum;
	}

	@Override
	public void createLevelEditorState() {
		this.les = new LevelEditorState(levelNum, LevelEditorState.RELEASE, -1, -1, container, 
				bc.getSelected(),bc.getBoard(), bc.getHints(), this.squareNum, this.colorNum, bc.getIsHintSquare(), this.coloredNum);
		
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
	public LevelState createLevelState() {
		// TODO Auto-generated method stub
		return null;
	}
}
