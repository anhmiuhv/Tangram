package model;

public class Board {
	Square[] square = new Square[144];
	boolean cover;
	Hint hints;
	public Board(Piece[] piece, Square[] square){
		this.piece = piece;
		this.square = square;
	}
	
	public void coverBoard(Piece[] piece,Square[] square ){
		//...
	}
	public Square[] getSquare(){
		return square; //get the array square 
	}
	public void removepiece(Piece[] piece){
		
			
		}
	}
	public void addpiece(Piece[] piece){
		//...
	}

}
