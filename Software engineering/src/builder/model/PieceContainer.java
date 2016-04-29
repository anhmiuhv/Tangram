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
		this.selected = new ArrayList<PlacedPiece>();
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

	/**
	 * get chosen piece
	 * @return chosen piece
	 */
	public Piece getChosen() {
		return chosen;
	}

	/**
	 * set chosen piece
	 */
	public void setChosen(Piece chosen) {
		this.chosen = chosen;
	}

	/**
	 * get active piece
	 * @return
	 */
	public PlacedPiece getActive() {
		return active;
	}
	
	/**
	 * set active piece
	 * @param pp active piece
	 */
	public void setActive(PlacedPiece pp) {
		this.active = pp;
	}

	/**
	 * get the dragging piece
	 * @return dragging piece
	 */
	public PlacedPiece getDraggingPiece() {
		return draggingPiece;
	}

	/**
	 * set the dragging piece
	 * @param draggingPiece
	 */
	public void setDraggingPiece(PlacedPiece draggingPiece) {
		this.draggingPiece = draggingPiece;
	}
	
	/**
	 * clear all of the placed piece
	 */
	public void clearPlacedPiece(){
		this.selected = new ArrayList<PlacedPiece>();
		this.active = null;
		this.chosen = null;
	}
	

	
	
	
	
}
