package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;


import model.Board;
import model.Bullpen;
import model.Piece;
import model.Level;
import model.Square;

import model.*;



import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class LevelView extends JFrame {

	JLabel moves = new JLabel();
	protected JPanel contentPane;
	BlueStripe bs;
	Level level;

	/**
	 * Launch the application.
	 */

	
	
	public void close(){
		WindowEvent	winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	
	/**
	 * Create the frame.
	 */
	public LevelView(Level level) {
		
		
		this.level = level;
		setTitle("Kabasuji");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 850);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		//----- manully design board

		
		JBoardView board = new JBoardView(450,210, level.getBoard());
		contentPane.add(board);
//----------- manully design bullpen 
		
/*		Piece p = new Piece(0,0,s,s[0],1);
		p.setColor(new Color(0,0,0));*/
		
		JButton btnNewButton = new JButton("Menu");
		btnNewButton.setBounds(20, 20, 80, 80);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LevelSelection nw = new LevelSelection();
				nw.LevelSelectStart();
				close();
			}
		});
		
		
		
		JBullPenView jbp = new JBullPenView(level.getBullpen(),20,140);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 824, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 801, Short.MAX_VALUE)
		);
		
		contentPane.add(scrollPane);
		scrollPane.setBounds(20, 140, 180*2+35, 180*3+25);
		scrollPane.setViewportView(jbp);
		
			
			
		bs = new BlueStripe(1,1);
		scrollPane.setColumnHeaderView(bs);
		
	     contentPane.add(bs);
		
		bs.add(btnNewButton);
		
		bs.add(moves);
		moves.setText("Moves:0/0");
		moves.setFont(new Font("SansSerif", Font.PLAIN, 30));
		moves.setForeground(Color.WHITE);
		moves.setBounds(140,35, 210, 50);
		this.add(moves);
		
		
		
		
		contentPane.setLayout(gl_contentPane);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelView frame = new LevelView(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
