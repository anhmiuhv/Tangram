package view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Board;
import model.Hint;

public class HintView {
	JBoardView bv;
	JPanel[] sv ;
	int numofSquares = 0;
	Board b;
	Hint h;
	
	public HintView (JBoardView bv, Board b){
		this.bv = bv;
		this.b = b;
		
		h = b.getHint();
		numofSquares = h.getHintSquares().length;

		createHintView();
	}
	
	public void createHintView(){
			sv = new JPanel[numofSquares];
		for(int i=0;i<numofSquares;i++){
			sv[i] = new JPanel();
			sv[i].setBackground(Color.white);

			sv[i].setBounds(h.getHintSquares()[i].getColumn()*30,h.getHintSquares()[i].getRow()*30,30,30);
			sv[i].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			bv.add(sv[i]);
		}
	}
	
}
