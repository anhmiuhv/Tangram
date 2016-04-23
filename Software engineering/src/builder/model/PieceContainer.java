package builder.model;
import model.Piece;
import java.util.ArrayList;

/**
 * This class represent a piece container
 * @author lthoang
 *
 */
public class PieceContainer implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2705956955185785315L;
	ArrayList<Piece> pieces;
	
	/**
	 * create an empty container
	 */
	public PieceContainer(){
		this.pieces = new ArrayList<Piece>();
	}
	
	/**
	 * create a loaded container
	 * @param piece array of piece to load
	 */
	public PieceContainer(ArrayList<Piece> piece){
		this.pieces = piece;
	}
	
	/**
	 * return te array of pieces
	 * @return array of pieces
	 */
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
