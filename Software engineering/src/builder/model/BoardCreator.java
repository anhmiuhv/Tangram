package builder.model;
import model.*;
public class BoardCreator {
	Square[] squares = new Square[144];
	Board board;
	boolean[] selectedSquare = new boolean[144];
	Hint hints;
	
	public BoardCreator(){
		
	}
	
	public boolean[] getSelected(){
		return selectedSquare;
		
	}
	
	public void setSelected(boolean[] selected){
		this.selectedSquare = selected;
	}
	
	boolean validBoard(){
		return false;
	}
}
