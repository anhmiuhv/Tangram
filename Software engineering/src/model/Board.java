package model;

public class Board {
	Piece[] piece;
	Square[] square;
	boolean cover;
	Hint hints;
	
	public Board(Square[] square){
		this.piece = piece;
		this.square = square;
	}
	
	public Square[] getSquare(){
		return square;
	}
	

}
