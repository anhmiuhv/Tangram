package builder.model;
import model.Square;


public class Board implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8029643701095122688L;
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
	public Board(Square[] squares){
		this.squares = squares;
	}
}
