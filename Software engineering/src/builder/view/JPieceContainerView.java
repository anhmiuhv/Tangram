package builder.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Piece;
import view.JPieceView;
import builder.model.*;

public class JPieceContainerView extends JPanel {

	LevelEditor lvl;
	PieceContainer pc;
	JPieceView[] jp = new JPieceView[10];
	ArrayList<Piece> pieces;
	int pNum = 0;
	int PCXcount =0;
	int PCycount =0;
	int bpX;
	int bpY;
	
	//JScrollPane scrollPane = new JScrollPane();
	
	public JPieceContainerView(LevelEditor lvl) {
		this.lvl = lvl;
		pc = lvl.getPieceContainer();
		createJBullPenView();
	}
	
	public void createJBullPenView(){

		//setBounds(bpX,bpY,180*2+15,180*3+20);
		setPreferredSize(new Dimension(180*2+15,180*4+20));

		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		setLayout(null);
		
		pieces = pc.getPieces();
		pNum = pieces.size();
		
		for(int i = 0; i< pNum;i++){
			if (i % 2 == 0){
				PCXcount=0;
			}
			jp[i] = new JPieceView(pieces.get(i), (180+5) * PCXcount + 5, ((int)(i/2))*(180+5)+5);
			PCXcount++;
			add(jp[i]);
		}
		
		//scrollPane.setViewportView(this);
	}
}
