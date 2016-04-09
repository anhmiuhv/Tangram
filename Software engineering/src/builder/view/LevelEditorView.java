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
		
	
	
	

	
	
	
	/**
	 * Create the frame.
	 */
	public LevelEditorView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 564);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.controlText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSave = new JButton("Save&Exit");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.setBounds(757, 13, 114, 25);
		contentPane.add(btnSave);
		
		JButton btnRestart = new JButton("Restart");
		btnRestart.setBounds(666, 13, 79, 25);
		contentPane.add(btnRestart);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Puzzle Level", "Lightning Level", "Release Level"}));
		comboBox.setBounds(686, 65, 104, 22);
		contentPane.add(comboBox);
		
		Label Type = new Label("Type:");
		Type.setBounds(613, 63, 46, 24);
		contentPane.add(Type);
		
		Label label_1 = new Label("Move:");
		label_1.setBounds(613, 93, 70, 24);
		contentPane.add(label_1);
		
		Label label_2 = new Label("Time:");
		label_2.setBounds(613, 123, 70, 24);
		contentPane.add(label_2);
		
		Label label_3 = new Label("Set:");
		label_3.setBounds(613, 153, 38, 24);
		contentPane.add(label_3);
		
		TextField textField = new TextField();
		textField.setBounds(686, 93, 104, 24);
		contentPane.add(textField);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(686, 123, 104, 24);
		contentPane.add(textField_1);
		
		JRadioButton radioButton = new JRadioButton("1");
		radioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radioButton.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton.setBounds(665, 153, 38, 25);
		contentPane.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("2");
		radioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radioButton_1.setBounds(707, 153, 38, 25);
		contentPane.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("3");
		radioButton_2.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radioButton_2.setBounds(749, 153, 38, 25);
		contentPane.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("4");
		radioButton_3.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radioButton_3.setBounds(666, 183, 38, 25);
		contentPane.add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("5");
		radioButton_4.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radioButton_4.setBounds(707, 183, 38, 25);
		contentPane.add(radioButton_4);
		
		JRadioButton radioButton_5 = new JRadioButton("6");
		radioButton_5.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radioButton_5.setBounds(749, 183, 38, 25);
		contentPane.add(radioButton_5);
		
		JButton btnCreatePiecePart = new JButton("Create Piece Part");
		btnCreatePiecePart.setBounds(82, 147, 332, 297);
		contentPane.add(btnCreatePiecePart);
		
		JButton btnCreateBoardPart = new JButton("Create Board Part");
		btnCreateBoardPart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreateBoardPart.setBounds(566, 227, 305, 277);
		contentPane.add(btnCreateBoardPart);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(46, 13, 97, 25);
		contentPane.add(btnExit);
		
		JButton btnHint = new JButton("Hint");
		btnHint.setBounds(126, 479, 97, 25);
		contentPane.add(btnHint);
		
		JButton btnRandomPiece = new JButton("Random Piece");
		btnRandomPiece.setBounds(242, 479, 113, 25);
		contentPane.add(btnRandomPiece);
	}
}
