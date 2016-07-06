package model;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;
import java.util.Set;

import view.JSquareView;

/**
 * Representation of a Piece in the model.
 * @author jshen3, kdai, xwang11
 */
public class Piece implements java.io.Serializable{
	
	private static final long serialVersionUID = 8376887428934251501L;
	int pRow;
	int pColumn;
	Color cl;
	boolean isMarked;
	public JSquareView[] boardViewSquare;
	Square[] squares = new Square[6];
	/**
	 * The head of the square is always the highest row(row 0 is highest) square , 
	 * if there are multiple squares on the highest row then the leftmost square will be chosen as the head
	 */
	Square head;
	int name;
	int ranPieceNum =99;
	/**
	 * This set contains the offsets of all the other squares from the head squares
	 * For example: if the head is Square(0,0) then the Square (1,1) 's offset from the head is Point(-1,-1) 
	 */
	Set<Point> offset;
	
	/**
	 * Create a Piece using given data.
	 * @param pRow
	 * @param pColumn
	 * @param square
	 * @param head
	 * @param name
	 */
	public Piece(int pRow, int pColumn,Square[] square, Square head, int name){
		this.pColumn = pColumn;
		this.pRow = pRow;
		this.squares = square;
		this.head = head;
		this.name = name;
		}
	
	/**
	 * Create a random piece.
	 */
	public Piece(){
		int ranColumn = 5;
		int ranRow = 5;
		Square[] ranSquare = new Square[6];
		ranSquare[0] = new Square(ranColumn,ranRow);
		boolean repeat = false;
		for(int  i = 1;i<6;i++){
			while(repeat == false){
			int randomNum = new Random().nextInt(4);
			if (randomNum==0){
				ranColumn++;
			}
			else if (randomNum==1){
				ranColumn--;
			}
			else if (randomNum==2){
				ranRow++;
			}
			else{
				ranRow--;
			}
			repeat =true;
			for (int  j = 0;j<i;j++){
				if ((ranSquare[j].getColumn()==ranColumn)&&(ranSquare[j].getRow()==ranRow)){
					repeat =false;
				}
			}
			if (repeat == false){
				if (randomNum==0){
					ranColumn--;
				}
				else if (randomNum==1){
					ranColumn++;
				}
				else if (randomNum==2){
					ranRow--;
				}
				else{
					ranRow++;
				}
			}
			
			}
			ranSquare[i] = new Square(ranColumn,ranRow);
			repeat =false;
		}
		
		boolean minusOne = true;
		while (minusOne ==true){
			for (int  i = 0;i<6;i++){
				if (ranSquare[i].getColumn()-1<0){
					minusOne = false;
				}
			}
			if (minusOne == true){
				for (int  i = 0;i<6;i++){
					ranSquare[i].setColumn(ranSquare[i].getColumn()-1);
				}
			}
		}
		minusOne = true;
		while (minusOne ==true){
			for (int  i = 0;i<6;i++){
				if (ranSquare[i].getRow()-1<0){
					minusOne = false;
				}
			}
			if (minusOne == true){
				for (int  i = 0;i<6;i++){
					ranSquare[i].setRow(ranSquare[i].getRow()-1);
				}
			}
		}
		
		/*for (int  i = 0;i<6;i++){
			System.out.println(ranSquare[i].getColumn());
			System.out.println(ranSquare[i].getRow());
		}
		*/
		
		ranPieceNum++;
		
		this.pColumn = 0;
		this.pRow = 0;
		this.squares = ranSquare;
		this.head = ranSquare[0];
		this.name = ranPieceNum;

	}
	
	/**
	 * Return the squares of this piece.
	 * @return Square[]
	 */
	public Square[] getSquares(){
		return squares;
	}
	
	/**
	 * Return the name of the piece.
	 * @return int
	 */
	public int getname(){
		return name;
	}
	
	/**
	 * Return color the the piece.
	 * @return Color
	 */
	public Color getColor(){
		return cl;
	}
	
	/**
	 * Set the color of the piece.
	 * @param c
	 */
	public void setColor(Color c){
		this.cl = c;
	}
	
	/**
	 * Return the row of the piece on board.
	 * @return int
	 */
	public int getpRow(){
		return pRow;
	}
	
	/**
	 * Return the column of the piece on board.
	 * @return int
	 */
	public int getpColumn(){
		return pColumn;
	}
	
	/**
	 * Set the row of the piece on board.
	 * @param pRow
	 */
	public void setpRow(int pRow){
		this.pRow = pRow;
	}
	
	/**
	 * Set column row of the piece on board.
	 * @param pColumn
	 */
	public void setpColumn(int pColumn){
		this.pColumn= pColumn;
	}
	
	/**
	 * Return the head square of the piece.
	 * @return Square
	 */
	public Square getHead(){
		return this.head;
	}
	
	/**
	 * Return true if the piece contain this square.
	 * @param sq
	 * @return boolean
	 */
	public boolean containSquare(Square sq){
		for(int i = 0;i<6;i++){
			if(squares[i].visited == false){
				if(squares[i].isEqual(sq)){				
					squares[i].visited = true;
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Return true of all square in the piece is visited.
	 * @return boolean
	 */
	public boolean allVisited(){
		for(int i = 0;i<6;i++){
			if(squares[i].visited == false){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Return true if the piece is not null.
	 * @return boolean
	 */
	public boolean isPiece(){
		
		for(int i = 0;i<6;i++){
			if(squares[i] == null){
				return false;
			}
		}
		return true;
	}

	/**
	 * return the offset
	 * @return Set<Point>
	 */
	public Set<Point> getOffset() {
		return offset;
	}

	/**
	 * set the offset
	 * @param offset
	 */
	public void setOffset(Set<Point> offset) {
		this.offset = offset;
	}
}

