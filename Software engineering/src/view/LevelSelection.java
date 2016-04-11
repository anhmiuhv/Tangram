package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Board;
import model.Bullpen;
import model.Level;
import model.Piece;
import model.Square;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;

public class LevelSelection extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelSelection frame = new LevelSelection();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void LevelSelectStart() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelSelection frame = new LevelSelection();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public String getLevelImage(int levelNum){
		if (levelNum==0){
			return "images\\puzzleIcon.png";
		}
		else if (levelNum==1){
			return "images\\lightningIcon.png";
		}
		else{
			return "images\\releaseIcon.png";
		}
	}
	
	public void close(){
		WindowEvent	winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	/**
	 * Create the frame.
	 */
	public LevelSelection() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
			GroupLayout gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(18)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 727, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(29, Short.MAX_VALUE))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(78)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 588, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(85, Short.MAX_VALUE))
			);
		panel.setLayout(null);
		
		
		//List<String> list = new ArrayList<String>();
		//list.add("hello");
	//	String s = list.get(0);
		

		
		
		//----------------------  Jbutton parameter
		contentPane.setLayout(gl_contentPane);
		int levelButtonLenth=60;
		int levelButtonWidth=60;
		int levelNum =20;
		int NumOneRow = 5;
		
		


		//---------------------- 
		
	
		JButton[] Levels = new JButton[levelNum];
		int nextRow=0;	
		int nextColumn=0;
		for (int i=0;i<levelNum;i++){
		
			Levels[i] = new JButton(String.valueOf(i+1));
			
			if (i%NumOneRow == 0){
				nextRow++;
				nextColumn=0;
			}
			Levels[i].setBounds(100+(40+levelButtonLenth)*nextColumn,(80+levelButtonWidth)*nextRow-50, levelButtonLenth, levelButtonWidth);	
			
			JLabel lblNewLabel = new JLabel("1");
			lblNewLabel.setBackground(Color.WHITE);
			lblNewLabel.setBounds(94, 145, 30, 30);
			lblNewLabel.setIcon(new ImageIcon(getLevelImage(1)));
			panel.add(lblNewLabel);
			
			nextColumn++;
			
			
			panel.add(Levels[i]);
			Levels[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LevelView nw = new LevelView();
				nw.LevelPlayStart();
				close();
			
			}
		});
		
		}
		
		
	}
	
	
	
	
	
	
	
	public Level[] createTestLevel(){
		Level[] testLevels = new Level[15];
		for (int i=0;i<15;i++){
			Square bullPenSquare[] = new Square[6]; 
			bullPenSquare[0] = new Square(1,1);
			bullPenSquare[1] = new Square(0,1);
			bullPenSquare[2] = new Square(0,2);
			bullPenSquare[3] = new Square(0,3);
			bullPenSquare[4] = new Square(0,4);
			bullPenSquare[5] = new Square(0,5);		
			
			Piece bullPenPiece = new Piece(0,0,bullPenSquare,bullPenSquare[0],2);
			bullPenPiece.setColor(new Color(0,0,0));
			
			
			Piece[] bullPenPieceArray = new Piece[6];
			bullPenPieceArray[0] = bullPenPiece;
			bullPenPieceArray[1] = bullPenPiece;
			bullPenPieceArray[2] = bullPenPiece;
			bullPenPieceArray[3] = bullPenPiece;
			bullPenPieceArray[4] = bullPenPiece;
			bullPenPieceArray[5] = bullPenPiece;
			
			Bullpen bp = new Bullpen(bullPenPieceArray);
			
			
			
			Square[] s = new Square[144]; 
			for (int i1=0;i1<12;i1++){
				for (int j=0;j<12;j++){
			
				s[i1*12+j] = new Square(i1,j);
				}
			}
			
			Board testBoard = new Board(s);
			
			
			//testLevels[0] = new Level(i,GetLevelTpye(i%3),testBoard,);
		}
		
		return testLevels;
		/*
		public Level(int LevelNumber, String LevelType, Board b, Bullpen p){
			this.LevelNumber = LevelNumber;
			this.LevelType = LevelType;
			this.b = b;
			this.p = p;
		}
		*/
	}
	
	
	
	
	public String GetLevelTpye(int levelNum){
		if(levelNum==0){
			return "puzzle";
		}
		else if(levelNum==1){
			return "lightning";
		}
		else {
			return "release";
		}
	}
	

}



