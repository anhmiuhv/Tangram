package view;

import java.awt.Color;

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

		//setBackground(Color.GREEN);
		setBounds(pX, pY, 180, 180);
		setLayout(null);
		setOpaque(false);
		
		setSize(180, 180);
		
		
		 for (int i=0; i<6;i++){
				JSquareView js = new JSquareView(piece.getSquares()[i],Color.YELLOW);
				add(js);
		 }
				//JPanel js = new JPanel();
				//js.setBounds(63, 35, 161, 76);
				//piecePanel.add(piecePanel);
		  //  }
	
	}
	
}
