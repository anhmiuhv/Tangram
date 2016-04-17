package builder.move;

import builder.model.LevelEditor;



public interface IMove {
	boolean isMoveValid(LevelEditor level);
	boolean doMove(LevelEditor level);
	boolean undo(LevelEditor level);
	
}
