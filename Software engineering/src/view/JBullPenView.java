package view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Bullpen;
import model.Piece;
import javax.swing.JScrollPane;

public class JBullPenView extends JPanel {

	Bullpen bp;
	
	JPieceView[] jp = new JPieceView[10];
	Piece[] pieces;
	int pNum = 0;
	int bpX;
	int bpY;
	
	//JScrollPane scrollPane = new JScrollPane();
	
	public JBullPenView(Bullpen bp, int bpX, int bpY) {
		this.bp = bp;
		this.bpX = bpX;
		this.bpY = bpY;

		pieces = bp.getPieces();
		pNum = pieces.length;

		createJBullPenView();
	}
	
	public void createJBullPenView(){
		//scrollPane.setBounds(bpX,bpY,180,180*4);
		
		setBounds(bpX,bpY,180,180*4);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		setLayout(null);
		
		for(int i = 0; i< pNum;i++){
			jp[i] = new JPieceView(pieces[i],i*180+5,0+5);
			add(jp[i]);
		}
		
		//scrollPane.setViewportView(this);
	}
}
