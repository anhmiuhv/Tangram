package builder.model;
import java.util.ArrayList;

import model.Square;
import model.Hint;

/**
 * This class represent a board creator
 * @author lthoang
 *
 */
public class BoardCreator {

	/**The biggest board possible*/
	Square[] squares = new Square[144];
	/**The resulting board created*/
	Board board;
	/**Selected squares by the builder*/
	boolean[] selectedSquare = new boolean[144];
	/**Hint to store inside the board*/
	Hint hints = new Hint();
	/**Number of selected squares*/
	int selected = 0;
	/**indicating whether if hint square*/
	boolean[] isHintSquare = new boolean[144];
	/**
	 * Create a board creator
	 */
	public BoardCreator(){
		int row = 0;
		int col = 0;
		for (int i = 0; i < 144; i++){
			squares[i] = new Square(col, row);
			col++;
			if (col > 11){
				col = 0;
				row++;
			}

		}
	}

	/**
	 * Return the array of selected square
	 * @return the selected squares
	 */
	public boolean[] getSelected(){
		return selectedSquare;

	}

	/**
	 * Set the selected squares
	 * @param selected the selected squares
	 */
	public void setSelected(boolean[] selected){
		this.selectedSquare = selected;
		for (int i = 0; i < 144; i++){
			if (selectedSquare[i]){
				this.selected++;
			}
		}
	}

	public boolean[] getIsHintSquare() {
		return isHintSquare;
	}

	public void setIsHintSquare(boolean[] isHintSquare) {
		this.isHintSquare = isHintSquare;
	}

	/**
	 * return the building platform
	 * @return the building platform
	 */
	public Square[] getSquares() {
		return squares;
	}

	/**
	 * Return the board craeted
	 * @return the board created
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Set the board created
	 * @param board the board created
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

	/**
	 * Get the hint created
	 * @return the hint created
	 */
	public Hint getHints() {
		return hints;
	}

	/**
	 * Set the hint for the board
	 * @param hints the hint
	 */
	public void setHints(Hint hints) {
		this.hints = hints;
	}

	/**
	 * Set the squares for the biggest board can be created
	 * @param squares the squares
	 */
	public void setSquares(Square[] squares) {
		this.squares = squares;
	}

	/**
	 * Return the number of square selected
	 * @return the number of square created
	 */
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
	 * @param i order
	 */
	public void deselectSquare(int i){
		selectedSquare[i] = false;
		selected--;
	}

	/**
	 * select hint square
	 */
	
	public void selectHintSquare(int i){
		isHintSquare[i] = true;
	}
	
	/**
	 * deselect hint square
	 * @param i order
	 */
	public void deselectHintSquare(int i){
		isHintSquare[i] = false;
	}
	
	/**
	 * create board from the selected squares
	 * @return true if board created
	 */
	public boolean createBoard(){
		if (selected % 6 != 0) {
			this.board = null;
			this.hints = null;
			return false;
		}
		int count = 0;
		for (boolean b: isHintSquare){
			if (b) {
				count++;
			}
		}
		if (count != 6) {
			this.board = null;
			this.hints = null;
			return false;
		}
		
		int row = 0;
		int col = 0;
		ArrayList<Square> s = new ArrayList<Square>();
		ArrayList<Square> h = new ArrayList<Square>();
		for (int i = 0; i < 144; i++){
			if (selectedSquare[i]){
				Square n = new Square(col, row);
				s.add(n);
			}
			if (isHintSquare[i]){
				Square hint = new Square(col,row);
				h.add(hint);
			}
			col++;
			if (col > 11){
				col = 0;
				row++;
			}
		}
		Square[] resultHint = h.toArray(new Square[h.size()]);
		Square[] result = s.toArray(new Square[s.size()]);
		hints = new Hint(resultHint);
		board = new Board(result);
		return true;
	}

	/**
	 * return whether a board has been created
	 * @return is board created?
	 */
	public String isBoardCreated(){
		if (this.board != null && this.hints != null){
			return "created";
		}
		return "not created";
	}



}
