package builder.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;

import java.awt.FlowLayout;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.SystemColor;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;

import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import view.LevelView;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class LevelEditorView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelEditorView frame = new LevelEditorView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	
	public static void LevelEditorStart() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelEditorView frame = new LevelEditorView();
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
	public LevelEditorView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 971, 564);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.controlText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 906, 491);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnSave = new JButton("Save&Exit");
		btnSave.setBounds(783, 6, 111, 25);
		panel.add(btnSave);
		
		JButton btnRestart = new JButton("Restart");
		btnRestart.setBounds(672, 6, 89, 25);
		panel.add(btnRestart);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(783, 44, 111, 22);
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Puzzle Level", "Lightning Level", "Release Level"}));
		
		Label Type = new Label("Type:");
		Type.setBounds(728, 44, 46, 24);
		panel.add(Type);
		
		Label label_1 = new Label("Move:");
		label_1.setBounds(728, 74, 48, 24);
		panel.add(label_1);
		
		Label label_2 = new Label("Time:");
		label_2.setBounds(728, 102, 46, 24);
		panel.add(label_2);
		
		Label label_3 = new Label("Set:");
		label_3.setBounds(728, 132, 38, 24);
		panel.add(label_3);
		
		TextField textField = new TextField();
		textField.setBounds(783, 72, 24, 24);
		panel.add(textField);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(783, 102, 24, 24);
		panel.add(textField_1);
		
		JRadioButton radioButton = new JRadioButton("1");
		radioButton.setBounds(772, 131, 35, 25);
		panel.add(radioButton);
		radioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radioButton.setHorizontalAlignment(SwingConstants.CENTER);
		
		JRadioButton radioButton_1 = new JRadioButton("2");
		radioButton_1.setBounds(816, 131, 35, 25);
		panel.add(radioButton_1);
		radioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton radioButton_2 = new JRadioButton("3");
		radioButton_2.setBounds(859, 131, 35, 25);
		panel.add(radioButton_2);
		radioButton_2.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton radioButton_4 = new JRadioButton("5");
		radioButton_4.setBounds(816, 165, 35, 25);
		panel.add(radioButton_4);
		radioButton_4.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton radioButton_5 = new JRadioButton("6");
		radioButton_5.setBounds(859, 165, 35, 25);
		panel.add(radioButton_5);
		radioButton_5.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnCreatePiecePart = new JButton("Create Piece Part");
		btnCreatePiecePart.setBounds(65, 94, 360, 329);
		panel.add(btnCreatePiecePart);
		
		JButton btnRandomPiece = new JButton("Random Piece");
		btnRandomPiece.setBounds(237, 453, 137, 25);
		panel.add(btnRandomPiece);
		
		JButton btnCreateBoardPart = new JButton("Create Board Part");
		btnCreateBoardPart.setBounds(652, 234, 242, 223);
		panel.add(btnCreateBoardPart);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				levelBuilder lb = new levelBuilder();
				lb.levelBuilderStart();
				close();
			}
		});
		btnExit.setBounds(28, 6, 80, 25);
		panel.add(btnExit);
		
		JRadioButton radioButton_3 = new JRadioButton("4");
		radioButton_3.setBounds(772, 165, 35, 25);
		panel.add(radioButton_3);
		radioButton_3.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnHint = new JButton("Hint");
		btnHint.setBounds(104, 453, 75, 25);
		panel.add(btnHint);
		btnCreateBoardPart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				levelBuilder lb = new levelBuilder();
				lb.levelBuilderStart();
				close();
			}
		});
	}
}
