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
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class LevelView extends JFrame {

	LevelSelection levelselection;
	JLabel moves = new JLabel();
	JLabel stayLabel = null;
	int moveUsed = 0;
	int totalMove = 0;
	
	JLabel timeLeft = new JLabel();
	int tLeft = 0;
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
	public LevelView(Level level, final LevelSelection levelselection) {
		this.levelselection= levelselection;

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



		JButton btnNewButton = new JButton("Menu");
		btnNewButton.setBounds(20, 20, 80, 80);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				levelselection.setVisible(true);
				//LevelSelection nw = new LevelSelection();
				//LoadLevel testlevel = new LoadLevel();
				//Kabasuji newgame = new Kabasuji(LoadLevel.createTestLevel());
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


		
		bs = new BlueStripe(1,level.getLevelNumber()+1);
		scrollPane.setColumnHeaderView(bs);

		contentPane.add(bs);

		bs.add(btnNewButton);

		
		if (level.getAchievement().getAchievement()==1){
			stayLabel = new JLabel("star");
			stayLabel.setBackground(Color.WHITE);
			stayLabel.setBounds(700,35, 20, 20);
			stayLabel.setIcon(new ImageIcon("images//onestar.png"));
			bs.add(stayLabel);
		}
		else if (level.getAchievement().getAchievement()==2){
			stayLabel = new JLabel("star");
			stayLabel.setBackground(Color.WHITE);
			stayLabel.setBounds(700,35, 40, 30);
			stayLabel.setIcon(new ImageIcon("images//twostar.png"));
			bs.add(stayLabel);
		}
		else  if (level.getAchievement().getAchievement()==3){
			//System.out.println("s");
			stayLabel = new JLabel("star");
			stayLabel.setBackground(Color.WHITE);
			stayLabel.setBounds(700,35, 60, 20);
			stayLabel.setIcon(new ImageIcon("images//threestar.png"));
			bs.add(stayLabel);
		}
		
		if(level.getLevelType().equals("puzzle")){
			
			moveUsed = ((PuzzleLevel) level).getUsedMove();
			totalMove = ((PuzzleLevel) level).getAllowedMove();
			
			bs.add(moves);
			moves.setText("Moves: " + moveUsed + "/" + totalMove);
			moves.setFont(new Font("SansSerif", Font.PLAIN, 30));
			moves.setForeground(Color.WHITE);
			moves.setBounds(140,35, 210, 50);
			
			
		}else if(level.getLevelType().equals("lightning")){
			
			bs.add(timeLeft);
			timeLeft.setText("Time left: " + tLeft);
			timeLeft.setForeground(Color.white);
			timeLeft.setFont(new Font("SansSerif", Font.PLAIN, 30));
			timeLeft.setBounds(140,35, 210, 50);
			
		}else if(level.getLevelType().equals("release")){
			
		
			int[] squareNum = ((ReleaseLevel)level).getSquareNum();
			Color[] cl = ((ReleaseLevel)level).getCl();
			for(int i = 0;i<144;i++){
				if(squareNum[i] != 0){
					JLabel ll = new JLabel("" + squareNum[i]);
					ll.setForeground(cl[i]);
					ll.setFont(new Font("SansSerif", Font.PLAIN, 28));
					int x = level.getBoard().getSquare()[i].getColumn();
					int y = level.getBoard().getSquare()[i].getRow();
					ll.setBounds(x*30+6, y*30+2, 30, 30);
					board.add(ll);
					
				}
			}
		}
		board.createSquareView();



		contentPane.setLayout(gl_contentPane);
		setVisible(true);

		/*
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
		 */
	}
}
