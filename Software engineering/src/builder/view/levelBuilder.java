package builder.view;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JComboBox;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Button;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

import builder.model.KabasujiBuilder;
import model.Kabasuji;
import view.LevelView;

public class levelBuilder extends JFrame {
	
//	JButton[] levels;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					levelBuilder frame = new levelBuilder();
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
	public levelBuilder() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 931, 617);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textInactiveText);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
//============================================================
		//jbutton
		int levelButtonLenth=60;
		int levelButtonWidth=60;
		int levelNum = 31;
		int NumOneRow = 8;
		
		JButton[] Levels = new JButton[levelNum];
		int nextRow = 0;
		int nextColumn = 0;
		
		for(int i = 0;((i<levelNum)&&(KabasujiBuilder.getNumberOfLevel()>i));i++){
			Levels[i] = new JButton(String.valueOf(i+1));
			if(i%NumOneRow == 0){
				nextRow++;
				nextColumn = 0;
			}
			Levels[i].setBounds(50+(40+levelButtonLenth)*nextColumn, 40+(40+levelButtonWidth)*nextRow, levelButtonLenth, levelButtonWidth);	
			nextColumn++;
			
			contentPane.add(Levels[i]);
			
			Levels[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LevelEditorView lev = new LevelEditorView();
					
					lev.LevelEditorStart();
					close();
					
				}
				
			});
			
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 889, 544);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		
		
		
		
		
		
		
		JLabel lblKabasuji = new JLabel("KABASUJI");
		lblKabasuji.setBounds(353, 26, 110, 50);
		panel.add(lblKabasuji);
		lblKabasuji.setForeground(Color.BLACK);
		lblKabasuji.setFont(new Font("Broadway Copyist Text Ext", Font.PLAIN, 34));
		lblKabasuji.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton button_9 = new JButton("New Level");
		button_9.setBounds(741, 26, 110, 25);
		panel.add(button_9);
		button_9.setSelectedIcon(new ImageIcon("C:\\Users\\Bob\\Desktop\\add.png"));
		
		JButton button_10 = new JButton("Help");
		button_10.setBounds(40, 26, 77, 25);
		panel.add(button_10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(25, 506, 92, 25);
		panel.add(btnDelete);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(154, 506, 77, 25);
		panel.add(btnEdit);
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_9.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				LevelEditorView lev2 = new LevelEditorView();
				lev2.LevelEditorStart();
				close();
			}
		});
		
	}






	public void levelBuilderStart() {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					levelBuilder frame = new levelBuilder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
