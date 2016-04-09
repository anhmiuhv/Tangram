package model;

public class Board {
	Piece[] piece;
	Square[] square;
	boolean cover;
	Hint hints;
	public Board(Piece[] piece, Square[] square){
		this.piece = piece;
		this.square = square;
	}

}
