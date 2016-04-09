package model;

import java.awt.Color;

public class Piece {
	int pRow;
	int pColumn;
	Color cl;
	boolean isMarked;
	Square[] square = new Square[6];
	Square head;
	
	public Piece(int pRow, int pColumn,Square[] square, Square head){
		this.pColumn = pColumn;
		this.pRow = pRow;
		this.square = square;
		this.head = head;
		}
	
	
}
