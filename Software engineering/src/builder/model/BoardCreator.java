package builder.model;

public class BoardCreator {
	Square[] squares = new Square[144];
	Board board;
	boolean[] selectedSquare;
	Hint hints;
	
	public BoardCreator(boolean[] selectedSquare){
		this.selectedSquare = selectedSquare;
		
	}
	
	boolean validBoard(){
		return false;
	}
}
