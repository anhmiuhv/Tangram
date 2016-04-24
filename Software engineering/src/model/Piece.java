package model;

import java.awt.Color;

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
	Square head;
	int name;
	
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
}

