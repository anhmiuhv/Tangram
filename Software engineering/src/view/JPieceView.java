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
	
	public JPieceView(Piece piece, int pX, int Py){
		this.piece = piece;
		this.pX = pX;
		this.pY = pY;
		createPieceView();
	}
	
/*
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JPanel panel = new JPanel();
	panel.setBackground(Color.GREEN);
	panel.setBounds(33, 48, 303, 136);
	contentPane.add(panel);
	panel.setLayout(null);
	
	JPanel panel_1 = new JPanel();
	panel_1.setBounds(63, 35, 161, 76);
	panel.add(panel_1);
	*/
	
	public void createPieceView(){

		//setBackground(Color.GREEN);
		setBounds(100, 100, 180, 180);
		setLayout(null);
		
		setSize(500, 500);
		
		JPanel panel = new JPanel();
		panel.setSize(500, 500);
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
