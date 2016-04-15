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
		Square bullPenSquare[] = new Square[6]; 
		bullPenSquare[0] = new Square(1,3);
		bullPenSquare[1] = new Square(0,1);
		bullPenSquare[2] = new Square(0,2);
		bullPenSquare[3] = new Square(0,3);
		bullPenSquare[4] = new Square(0,4);
		bullPenSquare[5] = new Square(0,5);		


		Piece bullPenPiece= new Piece(0,0,bullPenSquare,bullPenSquare[0],2);
		bullPenPiece.setColor(new Color(0,0,0));


		Piece[] bullPenPieceArray = new Piece[6];
		bullPenPieceArray[0] = new Piece(0,0,bullPenSquare,bullPenSquare[0],2);
		bullPenPieceArray[0].setColor(Color.BLUE);
		bullPenPieceArray[1] = new Piece(0,0,bullPenSquare,bullPenSquare[0],2);
		bullPenPieceArray[1].setColor(Color.GREEN);
		bullPenPieceArray[2] = new Piece(0,0,bullPenSquare,bullPenSquare[0],2);
		bullPenPieceArray[2].setColor(Color.YELLOW);
		bullPenPieceArray[3] = new Piece(0,0,bullPenSquare,bullPenSquare[0],2);
		bullPenPieceArray[3].setColor(Color.ORANGE);
		bullPenPieceArray[4] = new Piece(0,0,bullPenSquare,bullPenSquare[0],2);
		bullPenPieceArray[4].setColor(Color.RED);
		bullPenPieceArray[5] = new Piece(0,0,bullPenSquare,bullPenSquare[0],2);
		bullPenPieceArray[5].setColor(Color.PINK);


		this.piece = bullPenPieceArray;
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
