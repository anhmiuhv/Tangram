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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 583);
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
		int NumOneRow = 5;
		
		JButton[] Levels = new JButton[levelNum];
		int nextRow = 0;
		int nextColumn = 0;
		
		for(int i = 1;i<levelNum;i++){
			Levels[i] = new JButton(String.valueOf(i));
			if(i%NumOneRow == 0){
				nextRow++;
				nextColumn = 0;
			}
			Levels[i].setBounds(100+(40+levelButtonLenth)*nextColumn, 89+(40+levelButtonWidth)*nextRow, levelButtonLenth, levelButtonWidth);	
			nextColumn++;
			
			contentPane.add(Levels[i]);
			
			Levels[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LevelEditorView lev = new LevelEditorView();
					
					lev.LevelEditorStart();
					
				}
				
			});
			
		}
		
		
		
		
		
		
		
		
		
		
		JLabel lblKabasuji = new JLabel("KABASUJI");
		lblKabasuji.setForeground(SystemColor.textHighlightText);
		lblKabasuji.setFont(new Font("Broadway Copyist Text Ext", Font.PLAIN, 34));
		lblKabasuji.setHorizontalAlignment(SwingConstants.CENTER);
		lblKabasuji.setBounds(225, 38, 200, 50);
		contentPane.add(lblKabasuji);
		
		JButton button_9 = new JButton("New Level");
		button_9.setSelectedIcon(new ImageIcon("C:\\Users\\Bob\\Desktop\\add.png"));
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_9.setBounds(520, 38, 100, 25);
		contentPane.add(button_9);
		
		JButton btnMenu = new JButton("Main Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMenu.setBounds(520, 80, 100, 25);
		contentPane.add(btnMenu);
		
		JButton button_10 = new JButton("Help");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_10.setBounds(27, 38, 63, 25);
		contentPane.add(button_10);
		
		JButton btnNewButton_1 = new JButton("Next");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(548, 412, 97, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(40, 412, 97, 25);
		contentPane.add(btnDelete);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(160, 412, 97, 25);
		contentPane.add(btnEdit);
	}
}
