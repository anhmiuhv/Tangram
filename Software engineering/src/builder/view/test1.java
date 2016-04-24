package builder.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import builder.model.PieceCreator;
import model.*;

public class test1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		PieceCreator pc = new PieceCreator();
		pc.selectSquare(0, 0);
		pc.selectSquare(3, 4);
		pc.selectSquare(2, 1);
		pc.selectSquare(4, 2);
		pc.selectSquare(5, 0);
		pc.selectSquare(1, 3);
		pc.createPiece();
		System.out.println(pc.validPiece());
	}

	/**
	 * Create the frame.
	 */
	public test1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		Square s[] = new Square[6]; 
		s[0] = new Square(1,4);
		s[1] = new Square(0,0);
		s[2] = new Square(0,1);
		s[3] = new Square(0,2);
		s[4] = new Square(0,3);
		s[5] = new Square(0,4);		

		
		Piece p = new Piece(2, 5, s, s[0], 0);
		p.setColor(new Color(0,0,0));
		JPieceView pieceView = new JPieceView(p, 0, 0);
		contentPane.add(pieceView, BorderLayout.CENTER);
	}

}
