package model;

import java.util.ArrayList;

public class Board implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8260314857254020443L;
	Square[] square ;
	int[] cover;
	Hint hints = null;
	ArrayList<Piece> piece = new ArrayList<Piece>();
	int squareLeft;
	
	/**
	 * Create an example Board with 6 x 6 squares
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
	
	public void coverBoard(Piece[] piece,Square[] square ){
		//...
	}
	public Square[] getSquare(){
		return square; //get the array square 
	}
	public Hint getHint(){
		return hints;
	}
	
	public ArrayList<Piece> getpiece(){
		return piece;
	}
	
	public void sethint(Hint hints){
		this.hints = hints;	
	}
	
	public boolean addpiece(Piece p){
		if(this.piece.add(p)){
			
			
			return true;
		}else{
			return false;
		}
		
		//return this.piece.add(p);
	}
	
	public boolean removepiece(Piece p){
		return this.piece.remove(p);
	}
	
	public void initializeCover(){
		cover = new int[square.length];
		for(int i = 0;i<square.length;i++){
			cover[i] = 0;
		}
	}
	
	public int[] getCover(){
		return cover;
	}
}
