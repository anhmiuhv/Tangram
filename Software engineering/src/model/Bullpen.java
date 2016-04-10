package model;

public class Bullpen {
	Piece[] piece;
	
	//num of pieces
	
	public Bullpen(Piece[] piece){
		this.piece = piece;
		
	}
	
	
	public Piece[] getPieces(){
		return piece;
	}

}
