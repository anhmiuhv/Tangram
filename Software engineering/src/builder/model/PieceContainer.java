package builder.model;
import model.Piece;
import java.util.ArrayList;

public class PieceContainer implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2705956955185785315L;
	ArrayList<Piece> pieces;
	
	public PieceContainer(){
		this.pieces = new ArrayList<Piece>();
	}
	
	public PieceContainer(ArrayList<Piece> piece){
		this.pieces = piece;
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
