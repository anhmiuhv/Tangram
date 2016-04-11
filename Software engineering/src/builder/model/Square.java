package builder.model;

public class Square {
	int sRow;
	int sColumn;
	
	public Square(int sRow, int sColumn){
		this.sColumn = sColumn;
		this.sRow = sRow;
	}
	
	public int getRow() {
		return sRow;
	}
	
	public int getColumn(){
		return sColumn;
	}
}
