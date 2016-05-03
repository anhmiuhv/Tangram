package builder.model;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import model.Hint;

/**
 * THis class represent a level editor state
 * @author lthoang
 * @author jchen5
 *
 */
public class LevelEditorState implements java.io.Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 7037056491998374075L;

	public static void main(String[] args){
		LevelEditorState n = new LevelEditorState();
		n.saveState();
		LevelEditorState a = new LevelEditorState();
		a.loadState("les0.sav");
		System.out.println(a.levelName);
	}
	
	//Name of level type
	/**
	 * String representing puzzle level
	 */
	public static final String PUZZLE = "puzzle";
	/**
	 * String representing lightning level
	 */
	public static final String LIGHTNING = "lightning";
	/**
	 * String representing release level
	 */
	public static final String RELEASE = "release";
	
	int levelNum;
	String levelType;
	int allowedTime;
	int allowedMove;
	PieceContainer pc;
	boolean selectedSquare[];
	boolean isHintSquare[];
	Board board;
	Hint hint;
	int squareNum[];
	Color color[];
	int actualSquareNum[];
	Color actualColor[];
	String levelName;
	HashMap<String, ColoredNumber> coloredNum;
	
	/**
	 * Create a default level state
	 */
	public LevelEditorState(){
		this.levelNum = 0;
		this.levelType = LevelEditorState.PUZZLE;
		this.board = new Board();
		this.allowedMove = 6;
		selectedSquare = createExampleSelectedSquare();
		this.pc = new PieceContainer();
		levelName = "les" + levelNum;
		this.isHintSquare = new boolean[144];
	}
	
	/**
	 * Create LevelEditorState
	 * @param levelNum level number
	 * @param levelType level type
	 * @param allowedTime allowed time for lightning level
	 * @param allowedMove allowed move for puzzle level
	 * @param pc piece container
	 * @param selectedSquare selected squares on the board
	 * @param board the board created
	 * @param hint hint of the game
	 * @param squareNum numbers of the square
	 * @param color colors of the number of the square
	 * @param isHintSquare array of hint squares
	 * @param coloredNumber colored number object for release level
	 * @param actualSquareNum square num format for LevelState
	 * @param actualColor color format for LevelState
	 */
	public LevelEditorState(int levelNum, String levelType, int allowedTime,
			int allowedMove, PieceContainer pc, boolean[] selectedSquare,Board board, 
			Hint hint, int[] squareNum, Color[] color, boolean isHintSquare[], HashMap<String, ColoredNumber> coloredNum, int[] actualSquareNum, Color[] actualColor) {
		this.levelNum = levelNum;
		this.levelType = levelType;
		this.allowedTime = allowedTime;
		this.allowedMove = allowedMove;
		this.pc = pc;
		this.selectedSquare = selectedSquare;
		this.board = board;
		this.hint = hint;
		this.squareNum = squareNum;
		this.color = color;
		levelName = "les" + levelNum;
		this.isHintSquare = isHintSquare;
		this.coloredNum = coloredNum;
		this.actualSquareNum = actualSquareNum;
		this.actualColor = actualColor;
	}

	
	/**
	 * get the level Number
	 * @return level number
	 */
	public int getLevelNum() {
		return levelNum;
	}

	/**
	 * get the level type
	 * @return level type
	 */
	public String getLevelType() {
		return levelType;
	}

	/**
	 * get the allowed time
	 * @return allowed time
	 */
	public int getAllowedTime() {
		return allowedTime;
	}

	/**
	 * get the allowed move
	 * @return allowed move
	 */

	public int getAllowedMove() {
		return allowedMove;
	}

	/**
	 * get the editor hint squares
	 * @return editor hint squares
	 */
	public boolean[] getIsHintSquare() {
		return isHintSquare;
	}

	/**
	 * get the piece container
	 * @return piece container
	 */

	public PieceContainer getPc() {
		return pc;
	}

	/**
	 * 
	 * @return return the selectedSquare
	 */
	public boolean[] getSelectedSquare() {
		return selectedSquare;
	}

	/**
	 * 
	 * @return return the current board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * 
	 * @return get the current Hint
	 */
	public Hint getHint() {
		return hint;
	}

	/**
	 * 
	 * @return get the current square numbers
	 */
	public int[] getSquareNum() {
		return squareNum;
	}

	/**
	 * get actual square numbers
	 * @return actual square numbers
	 */
	public int[] getActualSquareNum() {
		return actualSquareNum;
	}

	/**
	 * get array of colors
	 * @return colors array
	 */
	public Color[] getColor() {
		return color;
	}

	/**
	 * get actual array of colors
	 * @return array of colors
	 */
	public Color[] getActualColor() {
		return actualColor;
	}

	/**
	 * 
	 * @return create a sample selectedSquare
	 */
	private boolean[] createExampleSelectedSquare(){
		boolean[] r = new boolean[144];
		int row = 0;
		int col = 0;
		for (int i = 0; i < 36; i++){
			r[row * 12 + col] = true;
			col++;
			if (col > 5){
				col = 0;
				row++;
			}
		}
		return r;
	}
	
	/**
	 * save the state in to a .sav file in levels, name of the file is "leveltype + levelnum"
	 */
	public void saveState(){
		File f;
		FileOutputStream saveFile;
		ObjectOutputStream save;
		try{// Catch errors in I/O if necessary.
			
			// Open a file to write to
			f = new File("leveleditor/" + levelName.concat(".sav"));
			if(!f.exists()){
				f.createNewFile();
			}
			
			saveFile=new FileOutputStream(f);
			
			// Create an ObjectOutputStream to put objects into save file.
			save = new ObjectOutputStream(saveFile);
			
			// Now we do the save.
			
			save.writeObject(this);
			
			// Close the file.
			save.close(); // This also closes saveFile.
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
	}
	
	/**
	 * Loads a LevelEditorState object from [fileName].sav in the levels directory
	 * @param fileName path to file
	 */
	public void loadState(String fileName) {
		File f;
		FileInputStream saveFile;
		ObjectInputStream save;
		try{
			
			f = new File("leveleditor/" + fileName);
		
			// Open file to read from
			saveFile = new FileInputStream(f);
			
			// Create an ObjectInputStream to get objects from save file.
			save = new ObjectInputStream(saveFile);

			// Now we do the restore.
			LevelEditorState lvlst = (LevelEditorState) save.readObject();
			
			this.levelNum = lvlst.levelNum;
			this.levelType = lvlst.levelType;
			this.levelName = lvlst.levelName;
			this.board = lvlst.board;
			this.pc = lvlst.pc;
			this.allowedMove = lvlst.allowedMove;
			this.allowedTime = lvlst.allowedTime;
			this.squareNum = lvlst.squareNum;
			this.color = lvlst.color;
			this.hint = lvlst.hint;
			this.selectedSquare = lvlst.selectedSquare;
			this.isHintSquare = lvlst.isHintSquare;
			this.coloredNum = lvlst.coloredNum;
			this.actualColor = lvlst.actualColor;
			this.actualSquareNum = lvlst.actualSquareNum;
			// Close the file.
			save.close(); // This also closes saveFile.
		}
		catch(Exception exc){
			exc.printStackTrace(); // If there was an error, print the info.
		}
	}

}
