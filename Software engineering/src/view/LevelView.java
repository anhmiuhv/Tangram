package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import model.Board;
import model.Bullpen;
import model.Piece;
import model.Square;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class LevelView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelView frame = new LevelView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void LevelPlayStart() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelView frame = new LevelView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void close(){
		WindowEvent	winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	
	/**
	 * Create the frame.
	 */
	public LevelView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 850);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		//-----
		Square[] s = new Square[144]; 
		for (int i=0;i<12;i++){
			for (int j=0;j<12;j++){
		
			s[i*12+j] = new Square(i,j);
			}
		}
		
		Board testBoard = new Board(s);
		JBoardView board = new JBoardView(450,210, testBoard);
		contentPane.add(board);

		
		Piece p = new Piece(0,0,s,s[0]);
		p.setColor(new Color(0,0,0));
		
	
		
		
		
		Square bullPenSquare[] = new Square[6]; 
		bullPenSquare[0] = new Square(1,1);
		bullPenSquare[1] = new Square(0,1);
		bullPenSquare[2] = new Square(0,2);
		bullPenSquare[3] = new Square(0,3);
		bullPenSquare[4] = new Square(0,4);
		bullPenSquare[5] = new Square(0,5);		
		
		Piece bullPenPiece = new Piece(0,0,s,s[0]);
		bullPenPiece.setColor(new Color(0,0,0));
		
		
		Piece[] bullPenPieceArray = new Piece[6];
		bullPenPieceArray[0] = bullPenPiece;
		bullPenPieceArray[1] = bullPenPiece;
		bullPenPieceArray[2] = bullPenPiece;
		bullPenPieceArray[3] = bullPenPiece;
		bullPenPieceArray[4] = bullPenPiece;
		bullPenPieceArray[5] = bullPenPiece;
		
		Bullpen bp = new Bullpen(bullPenPieceArray);
		
		JBullPenView jbp = new JBullPenView(bp,20,140);
		//contentPane.add(jbp);
		
		JScrollPane scrollPane = new JScrollPane();
	
		
		
		
		//---
		
		JButton btnNewButton = new JButton("Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LevelSelection nw = new LevelSelection();
				nw.LevelSelectStart();
				close();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(65)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(569, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(668, Short.MAX_VALUE))
		);
		
		contentPane.add(scrollPane);
		scrollPane.setBounds(20, 140, 180*2+35, 180*3+25);
		scrollPane.setViewportView(jbp);
		
		contentPane.setLayout(gl_contentPane);
		
	}
}
