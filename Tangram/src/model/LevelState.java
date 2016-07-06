package model;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Raw data of level loaded from file.
 * @author lthoang
 */
public class LevelState implements java.io.Serializable{

	private static final long serialVersionUID = 758901305732397174L;	
	
	//Name of level type
	public static final String PUZZLE = "puzzle";
	public static final String LIGHTNING = "lightning";
	public static final String RELEASE = "release";
	
	int levelNum;
	String levelType;
	Board board;
	int allowedMove;
	int allowedTime;
	boolean locked;
	Achievement achievements;
	Bullpen bullpen;
	String levelName;
	int[] squareNum;
	Color[] cl;
	
	/**
	 * Create a default level state
	 */
	public LevelState(){
		this.levelNum = 1;
		this.levelType = "puzzle";
		this.board = new Board();
		this.allowedMove = 6;
		this.locked = false;
		this.achievements = new Achievement(0);
		this.bullpen = new Bullpen();
		levelName = "level" + levelNum;
	}
	
	/**
	 * Create a level from the given data.
	 * @param levelNum
	 * @param levelType
	 * @param board
	 * @param allowedMove
	 * @param allowedTime
	 * @param locked
	 * @param achievements
	 * @param bullpen
	 * @param squareNum
	 * @param cl
	 */
	public LevelState(int levelNum, String levelType, Board board, int allowedMove, int allowedTime, boolean locked, 
			Achievement achievements,Bullpen bullpen, int[] squareNum, Color[] cl){
		this.levelNum = levelNum;
		this.levelType = levelType;
		this.board = board;
		this.allowedMove = allowedMove;
		this.allowedTime = allowedTime;
		this.locked = locked;
		this.achievements = achievements;
		this.bullpen = bullpen;	
		this.squareNum = squareNum;
		this.cl =cl;
		levelName = "level" + levelNum;
	}
	
	/**
	 * Return the type of level.
	 * @return int
	 */
	public int getLevelNum(){
		return levelNum;
	}
	
	/**
	 * Set level number.
	 * @param levelNum
	 */
	public void setLevelNum(int levelNum) {
		this.levelNum = levelNum;
	}

	/**
	 * Return the type of level.
	 * @return String
	 */
	public String getLevelType(){
		return levelType;
	}
	
	/**
	 * Set the type of level.
	 * @param levelType
	 */
	public void setLevelType(String levelType) {
		this.levelType = levelType;
	}

	/**
	 * Return the board of the level.
	 * @return Board
	 */
	public Board getBoard(){
		return board;
	}
	
	/**
	 * Set the board as given board.
	 * @param board
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

	/**
	 * Return allowed Move of puzzle level.
	 * @return int
	 */
	public int getAllowedMove(){
		return allowedMove;
	}
	
	/**
	 * Set all allowed Move of puzzle level.
	 * @param allowedMove
	 */
	public void setAllowedMove(int allowedMove) {
		this.allowedMove = allowedMove;
	}

	/**
	 * Return allowed time limite of lightning level.
	 * @return int
	 */
	public int getAllowedTime(){
		return allowedTime;
	}
	
	/**
	 * Set allowed time limite of lightning level.
	 * @param allowedTime
	 */
	public void setAllowedTime(int allowedTime) {
		this.allowedTime = allowedTime;
	}

	/**
	 * Return if the level is locked.
	 * @return boolean
	 */
	public boolean getLocked(){
		return locked;
	}
	
	/**
	 * Set if the level is locked.
	 * @param locked
	 */
	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	/**
	 * Return the achievement of the level.
	 * @return Achievement
	 */
	public Achievement getAchievement(){
		return achievements;
	}

	/**
	 * Set the achievement of the level.
	 * @param achievements
	 */
	public void setAchievements(Achievement achievements) {
		this.achievements = achievements;
	}

	/**
	 * Return the bullpen of the level.
	 * @return Bullpen
	 */
	public Bullpen getBullpen(){
		return bullpen;
	}

	/**
	 * Set the bullpen of the level.
	 * @param bullpen
	 */
	public void setBullpen(Bullpen bullpen) {
		this.bullpen = bullpen;
	}
	
	/**
	 * Return the number appear on the board in release level.
	 * @return int[]
	 */
	public int[] getSquareNum() {
		return squareNum;
	}

	/**
	 * Set the number appear on the board in release level.
	 * @param squareNum
	 */
	public void setSquareNum(int[] squareNum) {
		this.squareNum = squareNum;
	}

	/**
	 * Return the color of the number appear on the board in release level.
	 * @return Color[]
	 */
	public Color[] getCl() {
		return cl;
	}

	/**
	 * Set the color of the number appear on the board in release level.
	 * @param cl
	 */
	public void setCl(Color[] cl) {
		this.cl = cl;
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
			f = new File("levels/" + levelName.concat(".sav"));
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
	 * Loads a LevelState object from [fileName].sav in the levels directory
	 * @param fileName
	 */
	public void loadState(String fileName) {
		File f;
		FileInputStream saveFile;
		ObjectInputStream save;
		try{
			
			f = new File("levels/" + fileName);
			//System.out.println("../LevelBuilder/Levels/" + fileName);
			//System.out.println(f.exists());
			// Open file to read from
			saveFile = new FileInputStream(f);
			
			// Create an ObjectInputStream to get objects from save file.
			save = new ObjectInputStream(saveFile);

			// Now we do the restore.
			LevelState lvlst = (LevelState) save.readObject();
			
			this.levelNum = lvlst.levelNum;
			this.levelType = lvlst.levelType;
			this.levelName = lvlst.levelName;
			this.board = lvlst.board;
			this.achievements = lvlst.achievements;
			this.bullpen = lvlst.bullpen;
			this.locked = lvlst.locked;
			this.allowedMove = lvlst.allowedMove;
			this.allowedTime = lvlst.allowedTime;
			this.squareNum = lvlst.squareNum;
			this.cl = lvlst.cl;
			
			// Close the file.
			save.close(); // This also closes saveFile.
		}
		catch(Exception exc){
			exc.printStackTrace(); // If there was an error, print the info.
		}
	}
	
}
