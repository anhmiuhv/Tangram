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
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Button;

public class levelBuilder extends JFrame {

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

	/**
	 * Create the frame.
	 */
	public levelBuilder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 551);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textInactiveText);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("1");
		button.setBackground(SystemColor.textHighlight);
		button.setForeground(Color.BLACK);
		button.setBounds(40, 118, 80, 80);
		contentPane.add(button);
		
		JButton button_1 = new JButton("2");
		button_1.setBackground(SystemColor.textHighlight);
		button_1.setForeground(Color.BLACK);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(160, 118, 80, 80);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("3");
		button_2.setBackground(SystemColor.textHighlight);
		button_2.setForeground(Color.BLACK);
		button_2.setBounds(280, 118, 80, 80);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("4");
		button_3.setBackground(SystemColor.textHighlight);
		button_3.setForeground(Color.BLACK);
		button_3.setBounds(400, 118, 80, 80);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("5");
		button_4.setBackground(SystemColor.textHighlight);
		button_4.setForeground(Color.BLACK);
		button_4.setBounds(520, 118, 80, 80);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("6");
		button_5.setBackground(SystemColor.textHighlight);
		button_5.setForeground(Color.BLACK);
		button_5.setBounds(40, 240, 80, 80);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("7");
		button_6.setBackground(SystemColor.textHighlight);
		button_6.setForeground(Color.BLACK);
		button_6.setBounds(160, 240, 80, 80);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("8");
		button_7.setBackground(SystemColor.textHighlight);
		button_7.setForeground(Color.BLACK);
		button_7.setBounds(280, 240, 80, 80);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("9");
		button_8.setBackground(SystemColor.textHighlight);
		button_8.setForeground(Color.BLACK);
		button_8.setBounds(400, 240, 80, 80);
		contentPane.add(button_8);
		
		JButton btnNewButton = new JButton("10");
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(520, 240, 80, 80);
		contentPane.add(btnNewButton);
		
		JLabel lblKabasuji = new JLabel("KABASUJI");
		lblKabasuji.setForeground(SystemColor.textHighlightText);
		lblKabasuji.setFont(new Font("Broadway Copyist Text Ext", Font.PLAIN, 34));
		lblKabasuji.setHorizontalAlignment(SwingConstants.CENTER);
		lblKabasuji.setBounds(225, 38, 200, 50);
		contentPane.add(lblKabasuji);
		
		JButton button_9 = new JButton("New Level");
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
