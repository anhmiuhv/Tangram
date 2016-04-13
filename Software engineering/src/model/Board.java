package model;

public class Board {
	Square[] square ;
	boolean cover;
	Hint hints;
	Piece[] piece;
	
	public Board(Square[] square){

		this.square = square;
	}
	
	public void coverBoard(Piece[] piece,Square[] square ){
		//...
	}
	public Square[] getSquare(){
		return square; //get the array square 
	}
	public Hint getHint(){
		return hints;
	}
	
	public void removepiece(Piece[] piece){
		
			
		}
	
	public void addpiece(Piece[] piece){
		//...
	}
	
}
