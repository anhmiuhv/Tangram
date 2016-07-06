package model;

import java.io.File;
import java.util.ArrayList;

/**
 * Representation of a level in the model.
 * @author jshen3, kdai, xwang11
 */
public abstract class Level{

	int LevelNumber;
	String LevelType;
	Board b;
	Bullpen p;
	ArrayList<Piece> bullpenPiece;
	boolean locked;
	Achievement star;
	LevelState levelState;

	/**
	 * Create a level read from file.
	 * @param levelState
	 */
	public Level(LevelState levelState){
		this.loadLevelState(levelState);
	}

	/**
	 * Create a level by assigning parameters.
	 * @param LevelNumber
	 * @param LevelType
	 * @param b
	 * @param p
	 */
	public Level(int LevelNumber, String LevelType, Board b, Bullpen p){
		this.LevelNumber = LevelNumber;
		this.LevelType = LevelType;
		this.b = b;
		this.p = p;
		this.bullpenPiece = new ArrayList<Piece>();
		for (Piece piece: this.p.getPieces()){
			this.bullpenPiece.add(piece);
		}
	}

	/**
	 * Return the LevelState(raw data read from file).
	 * @return LevelState
	 */
	public LevelState getLevelState(){
		return levelState;
	}

	/**
	 * Return the type of level.
	 * @return int
	 */
	public int getlevelTypeNum(){
		if(LevelType.equals("puzzle")){
			return 0;
		}
		else if(LevelType.equals("lightning")){
			return 1;
		}
		else{
			return 2;
		}
	}

	/**
	 * Return the achievement of the level. 
	 * @return Achievement
	 */
	public Achievement getAchievement(){
		return star;
	}

	/**
	 * Return the bullpen of the level.
	 * @return Bullpen
	 */
	public Bullpen getBullpen(){
		return p;
	}

	/**
	 * Return the board of the level.
	 * @return Board
	 */
	public Board getBoard(){
		return b;
	}

	/**
	 * Return the type of the level.
	 * @return String
	 */
	public String getLevelType(){
		return LevelType;
	}

	/**
	 * Return the type of the level.
	 * @return int
	 */
	public int getLevelNumber(){
		return LevelNumber;
	}

	/**
	 * Return if you win the game.
	 * @return boolean
	 */
	abstract public boolean hasWon();
	
	/**
	 * Load level from file.
	 * @param f
	 */
	abstract public void loadLevel(File f);
	
	/**
	 * Request the level to judge the achievement.
	 */
	abstract public void checkAchievement();
	/**
	 * this func create a levelstate file for a level
	 */
	abstract public void createLevelState();

	/**
	 * this func replace the level with the level in the levelState
	 * @param levelState
	 */
	abstract public void loadLevelState(LevelState levelState);

	/**
	 * Set the star number.
	 * @param star
	 */
	public void updateLevelStar(Achievement star) {
		// TODO Auto-generated method stub
		this.star = star;
	}
	
	/**
	 * Return if the level is locked.
	 * @return boolean
	 */
	public boolean isLocked() {
		return locked;
	}

	/**
	 * Set the lock state of the level.
	 * @param locked
	 */
	public void setLocked(boolean locked) {
		this.locked = locked;
	}


}
