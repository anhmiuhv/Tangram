package builder.model;

import java.util.Stack;

import model.LevelState;
import builder.move.IMove;

/**
 * THis class represent an editor
 * @author lthoang
 * @author jchen5 
 *
 */
public abstract class LevelEditor {
	PieceContainer container;
	PieceCreator pc;
	BoardCreator bc;
	int levelNum;
	LevelEditorState les;
	LevelState ls;
	/**
	 * return the level editor state (save class)
	 * @return level editor state
	 */
	public LevelEditorState getLes() {
		return les;
	}
	String levelEditorType;
	
	Stack<IMove> undoStack = new Stack<IMove>(); 
	Stack<IMove> redoStack = new Stack<IMove>();
	
	/**
	 * return the level type
	 * @return level type
	 */
	public String getLevelEditorType() {
		return levelEditorType;
	}

	/**
	 * load level from level editor state
	 * @param les level editor state
	 */
	public LevelEditor(LevelEditorState les){
		this.loadLevelEditorState(les);
	}
	
	/**
	 * create an leveleditor
	 * @param levelNum level number
	 * @param container piece container
	 * @param pc piece creator
	 * @param bc board creator
	 */
	public LevelEditor(int levelNum, PieceContainer container, PieceCreator pc, BoardCreator bc){
		this.levelNum = levelNum;
		this.container = container;
		this.pc = pc;
		this.bc = bc;
	}
	
	/**
	 * return piece container
	 * @return piece contaienr
	 */
	public PieceCreator getPieceCreator(){
		return pc;
	}
	
	/**
	 * return level num
	 * @return level num
	 */
	public int getLevelNum() {
		return levelNum;
	}

	/**
	 * return piece container
	 * @return piece contaienr
	 */
	public PieceContainer getPieceContainer(){
		return container;
	}
	
	/**
	 * return board creator
	 * @return board creator
	 */
	public BoardCreator getBoardCreator(){
		return bc;
	}
	
	/**
	 * return the undo stack
	 * @return undo stack
	 */
	public Stack<IMove> getUndoStack() {
		return undoStack;
	}

	/**
	 * Set the undo stack
	 * @param undoStack
	 */
	public void setUndoStack(Stack<IMove> undoStack) {
		this.undoStack = undoStack;
	}
	
	/**
	 * Get the redo stack
	 * @return redo stack
	 */
	public Stack<IMove> getRedoStack() {
		return redoStack;
	}
	
	/**
	 * Set the redo stack
	 * @param redoStack
	 */
	public void setRedoStack(Stack<IMove> redoStack) {
		this.redoStack = redoStack;
	}

	/**
	 * Push move into undo stack
	 * @param m undo stack
	 * @return true if success
	 */
	public boolean pushUndo(IMove m){
		undoStack.push(m);
		return true;
	}
	
	/**
	 * pop a move from the undo stack
	 * @return top most move
	 */
	public IMove popUndo(){
		return undoStack.pop();
	}
	
	/**
	 * push the move into the redo stack
	 * @param m move
	 * @return true if success
	 */
	public boolean pushRedo(IMove m){
		redoStack.push(m);
		return true;
	}
	
	/**
	 * pop the move from the redo stack
	 * @return the move
	 */
	public IMove popRedo(){
		return redoStack.pop();
	}
	/**
	 * create a level editor state for the level
	 */
	public abstract void createLevelEditorState();
	
	/**
	 * load the level editor state for the editor
	 * @param les level editor state to load
	 */
	public abstract void loadLevelEditorState(LevelEditorState les);
	
	/**
	 * create the level state object for save
	 * @return level state
	 */
	public abstract boolean createLevelState();
	
	
}
