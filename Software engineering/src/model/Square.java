package model;

public class Square implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8741905149170920342L;
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
	
	public void setColumn(int sColumn){
		this.sColumn = sColumn;		
	}
	
	public void setRow(int srow){
		this.sRow = sRow;		
	}
}
