package view;

import javax.swing.JPanel;
import model.Piece;

/**
 * represent a piece
  * @author kdai
 * @author jshen3
 * @author xwang111 
 *
 */

public class JPieceView extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 705044680974999768L;

	Piece piece;

	int pX;
	int pY;
	
	/**
	 * create the piece view
	 * @param piece piece to draw
	 * @param pX position of the piece
	 * @param pY position of the piece
	 */
	public JPieceView(Piece piece, int pX, int pY){


		this.piece = piece;
		this.pX = pX;
		this.pY = pY;
		createPieceView();
	}
	
	
	private void createPieceView(){

		setBounds(pX, pY, 180, 180);
		setOpaque(false);
		setLayout(null);		
		
		if(piece != null){
		 for (int i=0; i<6;i++){
				JSquareView js = new JSquareView(piece.getSquares()[i], piece.getColor());
				add(js);
		 }
		}
	}

	/**
	 * get the piece
	 * @return the piece
	 */
	public Piece getPiece() {
		return piece;
	}

	/**
	 * set the piece
	 * @param piece the piece
	 */
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
}
