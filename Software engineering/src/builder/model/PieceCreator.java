package builder.model;
import model.*;

public class PieceCreator {
	Square base[] = new Square[36];
	Piece piece;
	boolean[] selectedSquare = new boolean[36];
	
	public PieceCreator(){
		init();
	}
	
	private void init(){
		int row = 0;
		int col = 0;
		for (int i = 0; i < 36; i++){
			base[i] = new Square(row, col);
			col++;
			if (col > 5){
				col = 0;
				row++;
			}
			
		}
	}
	
	boolean validPiece(){
		return false;
	}
	
	void createPiece(){
		
	}
	
	public Square[] getSquares(){
		return base;
	}
	
	public boolean[] getSelected(){
		return selectedSquare;
	}
	public Piece getPiece(){
		return this.piece;
	}
	
	public void selectSquare(int row, int column){
		this.selectedSquare[row * 6 + column] = true;
	}
}
