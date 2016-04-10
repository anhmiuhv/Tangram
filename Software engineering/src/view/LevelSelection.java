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
	
	public void close(){
		WindowEvent	winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	/**
	 * Create the frame.
	 */
	public LevelSelection() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
			GroupLayout gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(48)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 565, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(161, Short.MAX_VALUE))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(73)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 467, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(211, Short.MAX_VALUE))
			);
		panel.setLayout(null);
		
		
		//List<String> list = new ArrayList<String>();
		//list.add("hello");
	//	String s = list.get(0);
		
		JLabel lblNewLabel = new JLabel("1");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(94, 145, 30, 30);
		lblNewLabel.setIcon(new ImageIcon("images\\puzzleIcon.png"));
		panel.add(lblNewLabel);
		
		
		//----------------------  Jbutton parameter
		contentPane.setLayout(gl_contentPane);
		int levelButtonLenth=60;
		int levelButtonWidth=60;
		int levelNum =15;
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
			Levels[i].setBounds(100+(40+levelButtonLenth)*nextColumn, 89+(40+levelButtonWidth)*nextRow, levelButtonLenth, levelButtonWidth);	
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
}
