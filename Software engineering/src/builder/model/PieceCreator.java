package builder.model;
import java.awt.Color;
import java.awt.Point;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import model.Piece;
import model.Square;

/**
 * This class represent a piece container
 * @author lthoang
 *
 */
public class PieceCreator {
	Square base[] = new Square[36];
	Piece piece;
	boolean[] selectedSquare = new boolean[36];

	/**
	 * create a piece creator
	 */
	public PieceCreator(){
		init();
	}
	
	private void init(){
		int row = 0;
		int col = 0;
		for (int i = 0; i < 36; i++){
			base[i] = new Square(col, row);
			col++;
			if (col > 5){
				col = 0;
				row++;
			}
			
		}
	}
	
	/**
	 * check whether the piece is valid
	 * @return true if valid
	 */
	public boolean validPiece(){
		Set<Point> s = new HashSet<Point>();
		return (this.piece.isPiece())&&(dfsSquare(piece.getHead()));

	}
	
	/**
	 * for checking a valid piece
	 * @param head
	 * @return
	 */
	private boolean dfsSquare(Square head){
		Square tempsqRt = new Square(head.getColumn()+1, head.getRow());
		Square tempsqLt = new Square(head.getColumn()-1, head.getRow());
		Square tempsqUp = new Square(head.getColumn(), head.getRow()+1);
		Square tempsqDn = new Square(head.getColumn(), head.getRow()-1);
		if((piece.containSquare(tempsqRt))&& (!(tempsqRt.getVisit()))){
			dfsSquare(tempsqRt);
		}
		if((piece.containSquare(tempsqLt))&& (!(tempsqLt.getVisit()))){
			dfsSquare(tempsqLt);
		}
		if((piece.containSquare(tempsqDn))&& (!(tempsqDn.getVisit()))){
			dfsSquare(tempsqDn);
		}
		if((piece.containSquare(tempsqUp))&& (!(tempsqUp.getVisit()))){
			dfsSquare(tempsqUp);
		}
		
		return piece.allVisited();
		
	}
	
	
		
	
	/**
	 * create the piece from the selected square 
	 * @return true if success
	 */
	public boolean createPiece(){
		
		int counter = 0;
		int row = 0;
		int col = 0;
		Square[] s = new Square[6];
		for(int i = 0; i<36;i++){
			if(selectedSquare[i]){
				if (counter > 5) return false;
				s[counter] = new Square(col,row);
				counter++;
			}
			col++;
			if (col > 5){
				col = 0;
				row++;
			}
			
		}
		
		
		this.piece = new Piece(0, 0,s, s[0], 0);
		Random rand = new Random(); 
		this.piece.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
		
		return true;
	}
	
	/**
	 * return the bases of piece creator
	 * @return base of piece creator
	 */
	public Square[] getSquares(){
		return base;
	}
	
	/**
	 * return the selected squares
	 * @return selected squares
	 */
	public boolean[] getSelected(){
		return selectedSquare;
	}
	
	/**
	 * return the piece
	 * @return
	 */
	public Piece getPiece(){
		return this.piece;
	}
	
	/**
	 * select a square for creating a piece
	 * @param row
	 * @param column
	 */
	public void selectSquare(int row, int column){
		this.selectedSquare[row * 6 + column] = true;
	}
	
	
}
