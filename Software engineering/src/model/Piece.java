package model;

import java.awt.Color;

public class Piece {
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
}

