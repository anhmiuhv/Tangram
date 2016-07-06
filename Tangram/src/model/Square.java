package model;

/**
 * Representation of a Square in the model.
 * @author jshen3, kdai, xwang11
 */
public class Square implements java.io.Serializable{

	private static final long serialVersionUID = -8741905149170920342L;
	int sRow;
	int sColumn;
	boolean visited = false;
	
	/**
	 * Create the square using given data.
	 * @param sColumn
	 * @param sRow
	 */
	public Square(int sColumn, int sRow){
		this.sColumn = sColumn;
		this.sRow = sRow;		
	}
	
	/**
	 * Return the column of the square.
	 * @return int
	 */
	public int getColumn(){
		return sColumn;
	}
	
	/**
	 * Return the row of the square.
	 * @return int
	 */
	public int getRow(){
		return sRow;
	}
	
	/**
	 * A flage if the square is visited.
	 * @return boolean
	 */
	public boolean getVisit(){
		return this.visited;
	}
	
	/**
	 * Set the flag if the square is visited.
	 * @param to
	 */
	public void changeVisited(boolean to){
		this.visited = to;
	}
	
	/**
	 * Return true if this square is square to the given square. 
	 * @param sq
	 * @return boolean
	 */
	public boolean isEqual(Square sq){
		return ((this.sColumn == sq.sColumn)&&(this.sRow == sq.sRow));
	}
	
	/**
	 * Set the value of the column of the square.
	 * @param sColumn
	 */
	public void setColumn(int sColumn){
		this.sColumn = sColumn;		
	}
	
	/**
	 * Set the value of the row of the square.
	 * @param sRow
	 */
	public void setRow(int sRow){
		this.sRow = sRow;		
	}

}
