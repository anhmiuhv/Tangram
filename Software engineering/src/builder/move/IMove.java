package builder.move;

import builder.model.LevelEditor;


/**
 * this interface represent a move
 * @author anhmiuhv
 *
 */
public interface IMove {
	/**
	 * check if move valid
	 * @param level
	 * @return true if valid
	 */
	boolean isMoveValid(LevelEditor level);
	/**
	 * do the move
	 * @param level
	 * @return true if success
	 */
	boolean doMove(LevelEditor level);
	/**
	 * undo the move
	 * @param level
	 * @return true if success
	 */
	boolean undo(LevelEditor level);
	
}
