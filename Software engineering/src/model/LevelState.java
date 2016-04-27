package model;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LevelState implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 758901305732397174L;

	/**
	 * 
	 */
	


	/**
	 * 
	 */
	

	public static void main(String[] args){
		LevelState n = new LevelState();
		n.saveState();
		LevelState a = new LevelState();
		a.loadState("puzzle1.sav");
		//System.out.println(a.levelName);
	}
	
	
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
	 * Create a level state
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
	
	public int getLevelNum(){
		return levelNum;
	}
	
	public void setLevelNum(int levelNum) {
		this.levelNum = levelNum;
	}

	public String getLevelType(){
		return levelType;
	}
	
	public void setLevelType(String levelType) {
		this.levelType = levelType;
	}

	public Board getBoard(){
		return board;
	}
	
	public void setBoard(Board board) {
		this.board = board;
	}

	public int getAllowedMove(){
		return allowedMove;
	}
	
	public void setAllowedMove(int allowedMove) {
		this.allowedMove = allowedMove;
	}

	public int getAllowedTime(){
		return allowedTime;
	}
	
	public void setAllowedTime(int allowedTime) {
		this.allowedTime = allowedTime;
	}

	public boolean getLocked(){
		return locked;
	}
	
	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public Achievement getAchievement(){
		return achievements;
	}

	public void setAchievements(Achievement achievements) {
		this.achievements = achievements;
	}

	public Bullpen getBullpen(){
		return bullpen;
	}

	public void setBullpen(Bullpen bullpen) {
		this.bullpen = bullpen;
	}
	
	public int[] getSquareNum() {
		return squareNum;
	}

	public void setSquareNum(int[] squareNum) {
		this.squareNum = squareNum;
	}

	public Color[] getCl() {
		return cl;
	}

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
