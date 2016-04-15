package builder.model;
import java.util.ArrayList;

import model.Square;
import model.Hint;
public class BoardCreator {
	Square[] squares = new Square[144];
	Board board;
	boolean[] selectedSquare = new boolean[144];
	Hint hints;
	int selected;
	
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

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Hint getHints() {
		return hints;
	}

	public void setHints(Hint hints) {
		this.hints = hints;
	}

	public void setSquares(Square[] squares) {
		this.squares = squares;
	}

	public int getNumSelect(){
		return selected;
	}
	
	/**
	 * select square of i coordinate
	 * @param i coordinate
	 */
	public void selectSquare(int i){
		selectedSquare[i] = true;
		selected++;
	}
	
	/**
	 * deselect square of i coordinate
	 * @param i
	 */
	public void deselectSquare(int i){
		selectedSquare[i] = false;
		selected--;
	}
	
	/**
	 * create board from the selected squares
	 */
	public void createBoard(){
		int row = 0;
		int col = 0;
		ArrayList<Square> s = new ArrayList<Square>();
		for (int i = 0; i < 144; i++){
			if (selectedSquare[i]){
				Square n = new Square(col, row);
				s.add(n);
			}
			col++;
			if (col > 11){
				col = 0;
				row++;
			}
		}
		
		Square[] result = (Square[]) s.toArray();
		board = new Board(result);
		
	}

}
