package builder.view;

import java.awt.Rectangle;
import javax.swing.JPanel;

import model.Piece;

/**
 * this class represent a piece
 * @author lthoang
 *
 */

public class JPieceView extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5670441735627374567L;

	Piece piece;

	/**
	 * position of the Piece
	 */
	int pX;
	/**
	 * position of the Piece
	 */
	int pY;
	int size = 30;

	/**
	 * get size of the piece
	 */
	public int getsize() {
		return size;
	}

	/**
	 * set size of the piece
	 * @param size
	 */
	public void setsize(int size) {
		this.size = size;
	}

	JSquareView[] array = new JSquareView[6];

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

		for (int i=0; i<6;i++){
			array[i] = new JSquareView(piece.getSquares()[i],this.piece.getColor());

			add(array[i]);
		}

	}

	

	/**
	 * get the rectangle shape of the piece
	 * @return
	 */
	public Rectangle[] getRectange(){
		Rectangle[] r = new Rectangle[6];
		for (int i = 0;i < 6; i++){
			r[i] = new Rectangle(piece.getSquares()[i].getColumn() * size, piece.getSquares()[i].getRow() * size, size, size);
		}
		return r;
	}

	public Piece getPiece() {
		// TODO Auto-generated method stub
		return piece;
	}


}
