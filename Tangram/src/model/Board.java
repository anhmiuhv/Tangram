package model;

import java.util.ArrayList;

/**
 * Representation of a board in the model.
 * Board is made of squares.
 * @author jshen3, kdai, xwang11
 */
public class Board implements java.io.Serializable{
	
	private static final long serialVersionUID = 8260314857254020443L;
	Square[] square ;
	int[] cover;
	Hint hints = null;
	ArrayList<Piece> piece = new ArrayList<Piece>();
	int squareLeft;
	
	/**
	 * Create an example Board with 6 x 6 squares.
	 */
	public Board(){
		int row = 0;
		int col = 0;
		square = new Square[36];
		for (int i = 0; i < 36; i++){
			square[i] = new Square(col, row);
			col++;
			if (col > 5){
				col = 0;
				row++;
			}
 		}
		hints = new Hint();
		initializeCover();
	}
	
	/**
	 * Create board using the given array
	 * @param square
	 */
	public Board(Square[] square){

		this.square = square;
		initializeCover();
		
	}
	
	/**
	 * Return list of squares of the board.
	 * @return Square[]
	 */
	public Square[] getSquare(){
		return square; //get the array square 
	}
	
	/**
	 * Return the hint of the level on the board.
	 * @return Hint
	 */
	public Hint getHint(){
		return hints;
	}
	
	/**
	 * Return the list of piece covered on the board.
	 * @return ArrayList<Piece>
	 */
	public ArrayList<Piece> getpiece(){
		return piece;
	}
	
	/**
	 * Set the hint value of this class.
	 * @param hints
	 */
	public void sethint(Hint hints){
		this.hints = hints;	
	}
	
	/**
	 * Add piece to the board(piece array).
	 * Return true is the piece is added.
	 * @param p
	 * @return boolean
	 */
	public boolean addpiece(Piece p){		
		if(this.piece.add(p)){			
			return true;
		}else{
			return false;
		}
		
		//return this.piece.add(p);
	}
	
	/**
	 * Remove piece from the board(piece array).
	 * Return true is the piece is removed.
	 * @param p
	 * @return boolean
	 */
	public boolean removepiece(Piece p){
		return this.piece.remove(p);
	}

	/**
	 * Initialize cover[] to be all 0s, board is not covered with any piece.  
	 */
	public void initializeCover(){
		cover = new int[square.length];
		for(int i = 0;i<square.length;i++){
			cover[i] = 0;
		}
	}
	
	/**
	 * Return the Cover array of the board, indicating which square of the board is covered.
	 * @return int[]
	 */
	public int[] getCover(){
		return cover;
	}
}

