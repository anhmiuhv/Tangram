package model;

import java.awt.Color;
import java.awt.Point;
import java.util.Set;

public class Piece implements java.io.Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8376887428934251501L;
	int pRow;
	int pColumn;
	Color cl;
	boolean isMarked;
	Square[] squares = new Square[6];
	/**
	 * The head of the square is always the highest row(row 0 is highest) square , 
	 * if there are multiple squares on the highest row then the leftmost square will be chosen as the head
	 */
	Square head;
	int name;
	/**
	 * This set contains the offsets of all the other squares from the head squares
	 * For example: if the head is Square(0,0) then the Square (1,1) 's offset from the head is Point(-1,-1) 
	 */
	Set<Point> offset;
	
	public Piece(int pRow, int pColumn,Square[] square, Square head, int name){
		this.pColumn = pColumn;
		this.pRow = pRow;
		this.squares = square;
		this.head = head;
		this.name = name;
		}
	
	public Square[] getSquares(){
		return squares;
	}
	public int getname(){
		return name;
	}
	
	public Color getColor(){
		return cl;
	}
	
	public void setColor(Color c){
		this.cl = c;
	}
	
	public int getpRow(){
		return pRow;
	}
	
	public int getpColumn(){
		return pColumn;
	}
	
	public Square getHead(){
		return this.head;
	}
	
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
	
	public boolean allVisited(){
		for(int i = 0;i<6;i++){
			if(squares[i].visited == false){
				return false;
			}
		}
		return true;
	}
	
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
	 * @return
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

