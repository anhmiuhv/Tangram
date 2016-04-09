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
		setBounds(100, 100, 756, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("1");
		button.setBounds(40, 40, 80, 80);
		contentPane.add(button);
		
		JButton button_1 = new JButton("2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(160, 40, 80, 80);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("3");
		button_2.setBounds(280, 40, 80, 80);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("4");
		button_3.setBounds(400, 40, 80, 80);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("5");
		button_4.setBounds(520, 40, 80, 80);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("6");
		button_5.setBounds(40, 160, 80, 80);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("7");
		button_6.setBounds(160, 160, 80, 80);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("8");
		button_7.setBounds(280, 160, 80, 80);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("9");
		button_8.setBounds(400, 160, 80, 80);
		contentPane.add(button_8);
		
		JButton btnNewButton = new JButton("10");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(520, 160, 80, 80);
		contentPane.add(btnNewButton);
		
		JLabel lblKabasuji = new JLabel("KABASUJI");
		lblKabasuji.setHorizontalAlignment(SwingConstants.CENTER);
		lblKabasuji.setBounds(218, 0, 200, 50);
		contentPane.add(lblKabasuji);
		
		JButton button_9 = new JButton("+");
		button_9.setBounds(640, 13, 49, 25);
		contentPane.add(button_9);
	}
}
