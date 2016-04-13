package builder.model;
import model.*;
public class BoardCreator {
	Square[] squares = new Square[144];
	Board board;
	boolean[] selectedSquare = new boolean[144];
	Hint hints;
	
	public BoardCreator(){
		int row = 0;
		int col = 0;
		for (int i = 0; i < 144; i++){
			squares[i] = new Square(row, col);
			col++;
			if (col > 5){
				col = 0;
				row++;
			}
			
		}
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

	public Square[] getSquares() {
		return squares;
	}


}
