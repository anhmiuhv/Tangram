package builder.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import builder.model.PieceCreator;
import model.*;
import builder.model.LevelEditor;

public class test1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		test1 t = new test1();
		t.contentPane.repaint();
	}

	/**
	 * Create the frame.
	 */
	public test1() {
		getContentPane().setLayout(null);
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1000,1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		
		Square s[] = new Square[6]; 
		s[0] = new Square(1,4);
		s[1] = new Square(0,0);
		s[2] = new Square(0,1);
		s[3] = new Square(0,2);
		s[4] = new Square(0,3);
		s[5] = new Square(0,4);		
		contentPane.setLayout(null);

		
		Piece p = new Piece(0, 0, s, s[0], 0);
		p.setColor(new Color(0,0,0));
		

		JPieceView pieceView = new JPieceView(p, 40, 40);
		Rectangle[] r = pieceView.getRectange();
		pieceView.setBounds(0, 0, 0, 0);
		DrawPolyPanel drawPolyPanel = new DrawPolyPanel(r);
		drawPolyPanel.setBounds(144, 93, 226, 214);
		contentPane.add(pieceView);
		
		JPieceView pieceView_1 = new JPieceView(p, 0, 0);
		pieceView_1.setBounds(437, 159, 255, 168);
		contentPane.add(drawPolyPanel);
		contentPane.add(pieceView_1);
	
	}
}

