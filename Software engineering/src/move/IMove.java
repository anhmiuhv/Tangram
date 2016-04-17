package move;

import model.Level;

public interface IMove {
	boolean isMoveValid(Level level);
	boolean doMove(Level level);
	boolean undo(Level level);
	
}
