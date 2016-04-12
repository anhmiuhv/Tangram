package builder.view;

import java.awt.Color;
import java.awt.Transparency;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Piece;



public class JPieceView extends JPanel{

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
		setOpaque(false);
		setLayout(null);		
		
		 for (int i=0; i<6;i++){
				JSquareView js = new JSquareView(piece.getSquares()[i],Color.YELLOW);
				add(js);
		 }

	}
	
}
