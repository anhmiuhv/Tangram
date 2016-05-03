package model;

/**
 * Representation of hint on the board in model.
 * @author jshen3, kdai, xwang11
 */
public class Hint implements java.io.Serializable{

	private static final long serialVersionUID = -1954472508848657347L;
	Square[] square;
	
	/**
	 * Create a example of hint.
	 */
	public Hint(){
		Square hitSquares[] = new Square[6]; 
		hitSquares[0] = new Square(6,4);
		hitSquares[1] = new Square(5,2);
		hitSquares[2] = new Square(5,3);
		hitSquares[3] = new Square(5,4);
		hitSquares[4] = new Square(5,5);
		hitSquares[5] = new Square(5,6);	

		this.square = hitSquares;
	}
	
	/**
	 * Create hint according the the piece.
	 * @param square
	 */
	public Hint(Square[] square){
		this.square=square;
	}
	
	/**
	 * Return the square array of the hint.
	 * @return Square[]
	 */
	public Square[] getHintSquares(){
		return square;
	}
}
