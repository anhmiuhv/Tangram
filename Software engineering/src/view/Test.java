package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Piece;
import model.Square;
import view.JSquareView.MyPanel;

public class Test extends JFrame{

	
	public static void main(String[] args) {
		
		
	    JFrame.setDefaultLookAndFeelDecorated(true);
	    JFrame frame = new JFrame("JFrame Color Example");
	    frame.setSize(800,800);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyPanel panel = null;
		
		
		Square s[] = new Square[6]; 
		s[0] = new Square(1,1);
		s[1] = new Square(0,1);
		s[2] = new Square(0,2);
		s[3] = new Square(0,3);
		s[4] = new Square(0,4);
		s[5] = new Square(0,5);		
		
		Piece p = new Piece(0,0,s,s[0]);
		p.setColor(new Color(0,0,0));
		
		
		JPieceView jp = new JPieceView(p,frame);
		jp.createPieceView();
		

		

		

		    // create a basic JFrame

		 
	
		   
		    
		//Graphics g = f.getGraphics();
		
	//JSquareView js = new JSquareView(s[0],Color.BLACK);
		//f.JSquareView();
	}
	

}


