package view;

import java.awt.Color;

import javax.swing.JPanel;

import model.Board;
import model.Piece;

public class JBoardView extends JPanel {
	Board board ;
	int bX;
	int bY;
	
	public JBoardView(int bX, int bY, Board board){
		this.board = board;
		this.bX = bX;
		this.bY = bY;
		createBoardView();
		
	}
	public void createBoardView(){

		//setBackground(Transparency.TRANSLUCENT);

		setBounds(bX, bY, 360, 360);
		setOpaque(false);
		setLayout(null);
		
		//setSize(500, 500);
		
		JPanel panel = new JPanel();

		 for (int i=0; i< board.getSquare().length;i++){
				JSquareView js = new JSquareView(board.getSquare()[i],Color.WHITE);
				add(js);
		 }
				//JPanel js = new JPanel();
				//js.setBounds(63, 35, 161, 76);
				//piecePanel.add(piecePanel);
		  //  }
	
	}
}
