package model;

import java.awt.Color;

public class Bullpen implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4002796328568793576L;
	Piece[] piece;

	/**
	 * Create sample data for Bullpen
	 */
	public Bullpen(){
	}
	
	/**
	 * create a bull pen from array of piece
	 * @param piece
	 */
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
