package model;

public class Hint implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1954472508848657347L;
	Square[] square;
	public Hint(Square[] square){
		this.square=square;
	}
	
	public Square[] getHintSquares(){
		return square;
	}
}
