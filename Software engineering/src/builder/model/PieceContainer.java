package builder.model;
import model.Piece;

import java.util.ArrayList;
import java.util.HashMap;

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
	
	Piece chosen;
	ArrayList<PlacedPiece> selected ;
	PlacedPiece active;
	PlacedPiece draggingPiece;
	/**
	 * create an empty container
	 */
	public PieceContainer(){
		this.pieces = new ArrayList<Piece>();
		this.selected = new ArrayList<PlacedPiece>();
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
	
	/**
	 * set the pieces in the container
	 * @param pieces
	 */
	public void setPieces(ArrayList<Piece> pieces){
		this.pieces = pieces;
	}
	
	/**
	 * delete the i piece in the contaienr
	 * @param i order
	 */
	public void deletePieces(int i){
		pieces.remove(i);
	}
	
	/**
	 * add the piece to the container
	 * @param piece
	 */
	public void addPiece(Piece piece){
		pieces.add(piece);
	}

	/**
	 * return the selected Piece
	 * @return
	 */
	public ArrayList<PlacedPiece> getSelected() {
		return selected;
	}

	/**
	 * add the selected piece
	 * @param order
	 */
	public void addSelected(PlacedPiece pp) {
		this.selected.add(pp);
	}
	
	/**
	 * remove the selected pieces
	 * @param order
	 */
	public void removeSelected(int order){
		this.selected.remove(order);
	}

	public Piece getChosen() {
		return chosen;
	}

	public void setChosen(Piece chosen) {
		this.chosen = chosen;
	}

	public PlacedPiece getActive() {
		return active;
	}
	
	public void setActive(PlacedPiece pp) {
		this.active = pp;
	}

	public PlacedPiece getDraggingPiece() {
		return draggingPiece;
	}

	public void setDraggingPiece(PlacedPiece draggingPiece) {
		this.draggingPiece = draggingPiece;
	}

	

	
	
	
	
}
