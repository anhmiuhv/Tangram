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
	public Piece[] removepiece(Piece p){
		Piece[] piece2 = new Piece[(piece.length)-1];
	 for(int n = 0;n < piece.length;n++){
		 if(p.getname() != piece[n].getname()){
			 piece2[n]=piece[n];
		}
	 }
	 return piece2;
	}

	public Piece[] addpiece(Piece p){
		Piece[] piece3 = new Piece[(piece.length)+1];
	for(int n = 0; n < piece.length;n++){
	    piece3[n] = piece[n];
	    
	}
	piece3[piece.length+1] = p;
	return piece3;	
	}
	
}
