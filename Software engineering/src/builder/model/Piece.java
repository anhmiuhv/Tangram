package builder.model;

import java.awt.Color;

public class Piece {
	Square[] square;
	Square head;
	Color color;
	int pRow;
	int pColumn;
	public Piece(Square[] square, Square head, int pRow, int pColumn){
		this.square = square;
		this.head = head;
		this.pRow = pRow;
		this.pColumn = pColumn;
	}
}
