package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Piece;
import view.JSquareView.MyPanel;

public class JPieceView extends JPanel{
	Piece piece;
	
	JPanel piecePanel = new JPanel();
	JFrame pieceFrame = new JFrame();
	
	public JPieceView(Piece piece,JFrame pieceFrame){
		this.piece = piece;
		this.pieceFrame = pieceFrame;
	}
	
	
	
	
	public void createPieceView(){

	    for (int i=0; i<6;i++){
			JSquareView js = new JSquareView(piece.getSquares()[i],Color.BLACK);
			piecePanel = js.new MyPanel();
		     pieceFrame.add(piecePanel);
		     pieceFrame.setVisible(true);
	    }

	}
	
}
