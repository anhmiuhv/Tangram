package builder.model;

public class PieceCreator {
	Square base[] = new Square[36];
	Piece piece;
	boolean[] selectedSquare = new boolean[36];
	
	public PieceCreator(){
	}
	
	boolean validPiece(){
		return false;
	}
	
	void createPiece(){
		
	}
	
	Piece getPiece(){
		return this.piece;
	}
	
}
