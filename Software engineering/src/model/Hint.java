package model;

public class Hint implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1954472508848657347L;
	Square[] square;
	
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
	
	public Hint(Square[] square){
		this.square=square;
	}
	
	public Square[] getHintSquares(){
		return square;
	}
}
