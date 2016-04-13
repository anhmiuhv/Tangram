package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LevelSelectController;
import model.Achievement;
import model.Board;
import model.Bullpen;
import model.Level;
import model.LightningLevel;
import model.Piece;
import model.PuzzleLevel;
import model.ReleaseLevel;
import model.Square;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;

public class LevelSelection extends JFrame {

	private JPanel contentPane;
	Level[] testLevels;

	/**
	 * Launch the application.
	 */

	
	
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
	public LevelSelection(Level[] testLevels) {
		this. testLevels =testLevels;
		setTitle("Kabasuji");
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
		
		
		

		//Level[] testLevels = createTestLevel();
		
		//----------------------  Jbutton parameter
		contentPane.setLayout(gl_contentPane);
		int levelButtonLenth=60;
		int levelButtonWidth=60;
		int levelNum = testLevels.length;
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
			Levels[i].setBounds(100+(40+levelButtonLenth)*nextColumn,(90+levelButtonWidth)*nextRow-50, levelButtonLenth, levelButtonWidth);	
	
			JLabel stayLabel = null;
			if (testLevels[i].getAchievement().getAchievement()==1){
				stayLabel = new JLabel("star");
				stayLabel.setBackground(Color.WHITE);
				stayLabel.setBounds(100+(40+levelButtonLenth)*nextColumn, (90+levelButtonWidth)*nextRow+10, 20, 20);
				stayLabel.setIcon(new ImageIcon("images//onestar.png"));
				panel.add(stayLabel);
			}
			else if (testLevels[i].getAchievement().getAchievement()==2){
				 stayLabel = new JLabel("star");
				stayLabel.setBackground(Color.WHITE);
				stayLabel.setBounds(100+(40+levelButtonLenth)*nextColumn, (90+levelButtonWidth)*nextRow+10, 40, 20);
				stayLabel.setIcon(new ImageIcon("images//twostar.png"));
				panel.add(stayLabel);
			}
			else  if (testLevels[i].getAchievement().getAchievement()==3){
				//System.out.println("s");
				stayLabel = new JLabel("star");
				stayLabel.setBackground(Color.WHITE);
				stayLabel.setBounds(100+(40+levelButtonLenth)*nextColumn, (90+levelButtonWidth)*nextRow+10, 60, 20);
				stayLabel.setIcon(new ImageIcon("images//threestar.png"));
				panel.add(stayLabel);
			}
			else  if (testLevels[i].getAchievement().getAchievement()==0){
			}
			else{
				Levels[i].setIcon(new ImageIcon("images//lockicon.png"));
				Levels[i].setEnabled(false);
			}
			
			
			JLabel lblNewLabel = new JLabel("1");
			lblNewLabel.setBackground(Color.WHITE);
			lblNewLabel.setBounds(100+(40+levelButtonLenth)*nextColumn+15, (90+levelButtonWidth)*nextRow-80, 30, 30);
			lblNewLabel.setIcon(new ImageIcon( getLevelImage( testLevels[i].getlevelTypeNum()) ));
			panel.add(lblNewLabel);
			
			nextColumn++;
		
			
			
			final Level temp = testLevels[i];
			
			panel.add(Levels[i]);

			Levels[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				new LevelSelectController(LevelSelection.this,temp).actionPerformed();
			}
		});
		
		}

		setVisible(true);
	
	}
	

}



