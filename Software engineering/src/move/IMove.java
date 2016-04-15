package move;

import model.Level;

public interface IMove {
	boolean isMoveValid();
	void doMove(Level level);
	void undo(Level level);
	
}
