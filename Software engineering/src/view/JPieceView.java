package view;

import java.awt.Color;

import javax.swing.JPanel;

import model.Piece;

public class JPieceView extends JPanel{
	Piece piece;
	
	JPanel piecePanel = new JPanel();
	
	public JPieceView(Piece piece){
		this.piece = piece;
	}
	
	public void createPieceView(){
		for(int i = 0;i<6;i++){
			JSquareView(piece.squares[i],piece.color);
			piecePanel.paint(null);
		}
	}
	
}
