package builder.model;

import java.util.ArrayList;
import java.util.Stack;

import model.Piece;
import builder.move.IMove;

public abstract class LevelEditor {
	PieceContainer container;
	PieceCreator pc;
	BoardCreator bc;
	int levelNum;
	LevelEditorState les;
	public LevelEditorState getLes() {
		return les;
	}
	String levelEditorType;
	
	Stack<IMove> undoStack = new Stack<IMove>(); 
	Stack<IMove> redoStack = new Stack<IMove>();
	
	
	public String getLevelEditorType() {
		return levelEditorType;
	}

	public LevelEditor(LevelEditorState les){
		this.loadLevelEditorState(les);
	}
	
	public LevelEditor(int levelNum, PieceContainer container, PieceCreator pc, BoardCreator bc){
		this.levelNum = levelNum;
		this.container = container;
		this.pc = pc;
		this.bc = bc;
	}
	
	public PieceCreator getPieceCreator(){
		return pc;
	}
	
	public PieceContainer getPieceContainer(){
		return container;
	}
	
	public BoardCreator getBoardCreator(){
		return bc;
	}
	
	public boolean pushUndo(IMove m){
		undoStack.push(m);
		return true;
	}
	
	public IMove popUndo(){
		return undoStack.pop();
	}
	
	public boolean pushRedo(IMove m){
		redoStack.push(m);
		return true;
	}
	
	public IMove popRedo(){
		return redoStack.pop();
	}
	
	public abstract void createLevelEditorState();
	public abstract void loadLevelEditorState(LevelEditorState les);
	
	
}
