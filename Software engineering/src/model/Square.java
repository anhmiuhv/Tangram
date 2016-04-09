package model;

public class Square {
	int sRow;
	int sColumn;
	
	public Square(int sColumn, int sRow){
		this.sColumn = sColumn;
		this.sRow = sRow;		
	}
	
	public int getColumn(){
		return sColumn;
	}
	
	public int getRow(){
		return sRow;
	}
}
