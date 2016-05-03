package model;

import java.util.ArrayList;

/**
 * Representation of a bullpen in the model.
 * @author jshen3, kdai, xwang11
 */
public class Bullpen implements java.io.Serializable{
	
	private static final long serialVersionUID = 4002796328568793576L;
	ArrayList<Piece> piece;
	int pieceSelected = 0;

	/**
	 * Create sample data for Bullpen.
	 */
	public Bullpen(){

	}
	
	/**
	 * create a bull pen from array of piece
	 * @param piece
	 */
	public Bullpen(ArrayList<Piece> piece){
		this.piece = piece;

	}

	/**
	 * Return the Pieces in the bullpen.
	 * @return ArrayList<Piece>
	 */
	public ArrayList<Piece> getPieces(){
		return piece;
	}
	
	/**
	 * Remove piece from the bullpen(piece array).
	 * Return true is the piece is removed.
	 * @param p
	 * @return boolean
	 */
	public boolean removepiece(Piece p){
		return this.piece.remove(p);
	}

	/**
	 * Add piece to the bullpen(piece array).
	 * Return true is the piece is added.
	 * @param p
	 * @return boolean
	 */
	public boolean addpiece(Piece p){
		return this.piece.add(p);
	}
	
	/**
	 * Set the value of pieceSelected.
	 * Stored is the Piece number in the piece arraylist.
	 * @param p
	 */
	public void setPieceSelected(int p){
		pieceSelected = p;
	}
	
	/**
	 * Return the number(index in piece arraylist) of the piece that is selected. 
	 * @return int
	 */
	public int getPieceSelected(){
		return pieceSelected;
	}
	
	/**
	 * Remove a piece in the piece arraylist. 
	 * @param pNum
	 */
	public void removePiece(int pNum){
		piece.remove(pNum);		
	}
}
