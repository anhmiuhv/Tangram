package view;

import java.awt.Color;

import javax.swing.JPanel;

import model.Board;
import model.Piece;
import model.Square;

/**
 * represent a board
 * @author kdai
 * @author jshen3
 * @author xwang111 
 *
 */
public class JBoardView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5437116973071766436L;
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
	private void createBoardView(){

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
		Square[] squares;
		squares = p.getSquares();
		JSquareView[] sv = new JSquareView[6];
		p.boardViewSquare = sv;
		for(int i=0;i<6;i++){
			
			sv[i] = new JSquareView(squares[i],p.getColor());
			sv[i].setBounds((squares[i].getColumn()-squares[0].getColumn())*30+ p.getpColumn()*30,
					(squares[i].getRow()-squares[0].getRow())*30+p.getpRow()*30, 30, 30);
			add(sv[i]);

		}
	}
	
	public void removePieceView(Piece p){
		for(int i=0;i<6;i++){
			this.remove(p.boardViewSquare[i]);
		}
	}
	
}
