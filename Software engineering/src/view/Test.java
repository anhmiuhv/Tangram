package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Bullpen;
import model.Piece;
import model.Square;

public class Test extends JFrame{

	
	public static void main(String[] args) {
		
		 JFrame frame = new JFrame("JFrame Color Example");
		 frame.setVisible(true);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame. setBounds(100, 100, 800, 800);
		 JPanel contentPane = new JPanel();
		 contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		 frame.setContentPane(contentPane);
		 contentPane.setLayout(null);
		 contentPane.setVisible(true);
		 
		 
		 
		 
		Square s[] = new Square[6]; 
		s[0] = new Square(1,1);
		s[1] = new Square(0,1);
		s[2] = new Square(0,2);
		s[3] = new Square(0,3);
		s[4] = new Square(0,4);
		s[5] = new Square(0,5);		
		
		Piece p = new Piece(0,0,s,s[0]);
		p.setColor(new Color(0,0,0));
		
		
		Piece[] ps = new Piece[1];
		ps[0] = p;
		
		Bullpen bp = new Bullpen(ps);
		
		JBullPenView jbp = new JBullPenView(bp,10,10);
		contentPane.add(jbp);

		
	}
	

}


