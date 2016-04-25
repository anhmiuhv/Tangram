package view;

import java.awt.Color;

import javax.swing.JPanel;

import model.Board;
import model.Piece;
import model.Square;

public class JBoardView extends JPanel {
	Board board ;
	int bX;
	int bY;
	JSquareView js;
	
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
		showPieces();
		
	
	}
	public void createSquareView(){

		 for (int i=0; i< board.getSquare().length;i++){

				js = new JSquareView(board.getSquare()[i],Color.WHITE);
				add(js);
		 }
		 setLayout(null);
	}


	public void showPieces(){
		if  (board.getpiece()!=null){
			for(int i=0;i<board.getpiece().size();i++){
				showPiece(board.getpiece().get(i));
			}
		}
		
	}
	
	public void showPiece(Piece p){
		Square[] squares = new Square[6];
		squares = p.getSquares();
		JSquareView[] sv = new JSquareView[6];
		for(int i=0;i<6;i++){
			sv[i] = new JSquareView(squares[i],p.getColor());
			sv[i].setBounds(squares[i].getColumn()*30,squares[i].getRow()*30 , 30, 30);
			add(sv[i]);

		}
	}
	
}
