package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Piece;
import model.Square;

public class Test extends JFrame{

	public static void main(String[] args) {
		
		Square s[] = new Square[6]; 
		s[0] = new Square(0,0);
		s[1] = new Square(0,1);
		s[2] = new Square(0,2);
		s[3] = new Square(0,3);
		s[4] = new Square(0,4);
		s[5] = new Square(0,5);		
		
		Piece p = new Piece(0,0,s,s[0]);
		p.setColor(new Color(0,0,0));
		 
		
		JPanel f = new JPanel();

		
		f.setSize(1000, 1000);
		f.setVisible(true);
	
		Graphics g = f.getGraphics()
		
		JSquareView js = new JSquareView(s[0],Color.BLACK);
		js.paint(g);

		
		


	}
	
	

}
