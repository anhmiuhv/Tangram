package view;

import javax.swing.JPanel;
import model.Piece;



public class JPieceView extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 705044680974999768L;

	Piece piece;

	int pX;
	int pY;
	
	public JPieceView(Piece piece, int pX, int pY){


		this.piece = piece;
		this.pX = pX;
		this.pY = pY;
		createPieceView();
	}
	
	
	public void createPieceView(){

		setBounds(pX, pY, 180, 180);
		setOpaque(true);
		setLayout(null);		
		
		if(piece != null){
		 for (int i=0; i<6;i++){
				JSquareView js = new JSquareView(piece.getSquares()[i], piece.getColor());
				add(js);
		 }
		}
	}


	public Piece getPiece() {
		return piece;
	}


	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
}
