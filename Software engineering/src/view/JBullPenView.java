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
	int BullPenXcount =0;
	int BullPenycount =0;
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

		setBounds(bpX,bpY,180*2+15,180*3+20);

		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		setLayout(null);
		
		for(int i = 0; i< pNum;i++){
			if (i%2==0){
				BullPenXcount=0;
			}
			jp[i] = new JPieceView(pieces[i],(180+5)*BullPenXcount+5,((int)(i/2))*(180+5)+5);
			BullPenXcount++;
			add(jp[i]);
			System.out.println((int)(i/2));
		}
		
		//scrollPane.setViewportView(this);
	}
}

