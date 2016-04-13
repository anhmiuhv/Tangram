package model;

public class Board {
	Square[] square ;
	boolean cover;
	Hint hints = null;
	Piece[] piece =null;
	
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
	
	public Piece[] getpiece(){
		return piece;
	}
	
	public void sethint(Hint hints){
		this.hints = hints;
		
	}
	
	public void addpiece(Piece piece){
		if (piece==null){
			this.piece = new Piece[1];
			//this.piece[0] = new Piece();
		}
		else{
			this.piece = new Piece[1];
		}
	}
	
}
