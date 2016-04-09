package view;

import java.awt.Color;

import javax.swing.JPanel;

import model.Piece;

public class JPieceView extends JPanel{
	Piece piece;
	
	public JPieceView(Piece piece){
		
		for(int i = 0;i<6;i++){
			JSquareView(piece.squares[i]);
		}
		
	}
}
