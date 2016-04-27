package builder.model;
import model.Square;

/**
 * This class represents a game board
 * @author lthoang
 * @author jchen5
 *
 */
public class Board implements java.io.Serializable {
	/**
	 * For storing
	 */
	private static final long serialVersionUID = 8029643701095122688L;
	/** Representing as an array of squares */
	Square[] squares;
	
	/**
	 * Create an example Board with 6 x 6 squares
	 */
	public Board(){
		int row = 0;
		int col = 0;
		squares = new Square[36];
		for (int i = 0; i < 36; i++){
			squares[i] = new Square(col, row);
			col++;
			if (col > 5){
				col = 0;
				row++;
			}
 		}
	}
	
	/**
	 * Create a custom board
	 * @param squares the array of squares representing a board
	 */
	public Board(Square[] squares){
		this.squares = squares;
	}

	/**
	 * Return the squares making the board
	 * @return array of squares making up the board
	 */
	public Square[] getSquares() {
		// TODO Auto-generated method stub
		return squares;
	}
	
	public boolean containSquare(Square sq){
		for(int i = 0;i < squares.length;i++){
			if(squares[i].getVisit() == false){
				if(squares[i].isEqual(sq)){				
					squares[i].changeVisited(true);;
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean allVisited(){
		for(int i = 0;i < squares.length;i++){
			if(squares[i].getVisit() == false){
				return false;
			}
		}		
		return true;
	}
}
