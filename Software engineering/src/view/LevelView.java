package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class LevelView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	 public static void main(String[] args){
		 LevelSelectStart();
	 }
	 
	public static void LevelSelectStart() {
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
		
		setTitle("Kabasuji");
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
					.addGap(66)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 620, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(88, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(89)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 499, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(163, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		

		
		btnNewButton.setBounds(164, 347, 89, 23);
		panel.add(btnNewButton);
		
	
		
		int levelButtonLenth=60;
		int levelButtonWidth=60;
		int levelNum =5;
		int NumOneRow = 5;
		
		JButton[] LevelButton = new JButton[levelNum];

		for (int i=0;i<levelNum;i++){
		
		LevelButton[i] = new JButton(String.valueOf(i+1));
		LevelButton[i].setBounds(100+20*i+i*levelButtonLenth, 89, levelButtonLenth, levelButtonWidth);			
		panel.add(LevelButton[i]);
		LevelButton[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LevelSelection nw = new LevelSelection();
				nw.LevelPlayStart();
				close();
			
			}
		});
		
		}
		//fiodshjhaldshl
		
		contentPane.setLayout(gl_contentPane);
	}
}
