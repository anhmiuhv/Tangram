package model;

public class Square implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8741905149170920342L;
	int sRow;
	int sColumn;
	boolean visited = false;
	
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
	
	public boolean getVisit(){
		return this.visited;
	}
	
	public boolean isEqual(Square sq){
		return ((this.sColumn == sq.sColumn)&&(this.sRow == sq.sRow));
	}
	

}
