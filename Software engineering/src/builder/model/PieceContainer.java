package builder.model;
import model.*;
import java.util.ArrayList;

public class PieceContainer {
	ArrayList<Piece> pieces;
	
	public PieceContainer(){
		this.pieces = new ArrayList<Piece>();
	}
	
	public ArrayList<Piece> getPieces(){
		return pieces;
	}
	
	public void setPieces(ArrayList<Piece> pieces){
		this.pieces = pieces;
	}
	
	public void deletePieces(int i){
		pieces.remove(i);
	}
	
	public void addPiece(Piece piece){
		pieces.add(piece);
	}
}
