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
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.SystemColor;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;

import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import builder.controller.MoveInfoController;
import builder.controller.SwitchLevelModeController;
import builder.controller.TimerInfoController;
import builder.model.*;
import view.LevelView;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class LevelEditorView extends JFrame {

	private JPanel contentPane;
	KabasujiBuilder kb;
	int levelNum;
	JBoardCreatorView jbc;
	JPieceCreatorView jpc;
	JPieceContainerView jcontainer;
	JTextField timer;
	JTextField move;
	JTextField sets;
	JComboBox mode;
	LevelEditor editor;
	LevelEditor clone;
	public void close(){
		WindowEvent	winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}	
	
	/**
	 * Create the frame.
	 */
	public LevelEditorView(KabasujiBuilder kb, int levelNum) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.kb = kb;
		this.levelNum = levelNum;
		editor = kb.getLevel(levelNum);
		init();
	}
	
	
	public void init() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 971, 564);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.controlText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 953, 523);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnSave = new JButton("Save&Exit");
		btnSave.setBounds(783, 6, 111, 25);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editor.createLevelEditorState();
				editor.getLes().saveState();
				levelBuilder lb = new levelBuilder(new KabasujiBuilder());
				lb.setVisible(true);
				close();
			}
		});
		panel.add(btnSave);
		
		JButton btnRestart = new JButton("Restart");
		btnRestart.setBounds(672, 6, 89, 25);
		panel.add(btnRestart);
		
		mode = new JComboBox();
		mode.setBounds(783, 44, 128, 22);
		panel.add(mode);
		mode.setModel(new DefaultComboBoxModel(new String[] {"Puzzle Level", "Lightning Level", "Release Level"}));
		switch (editor.getLevelEditorType()){
		case LevelEditorState.PUZZLE:
			mode.setSelectedIndex(0);
			break;
		case LevelEditorState.LIGHTNING:
			mode.setSelectedIndex(1);
			break;
		case LevelEditorState.RELEASE:
			mode.setSelectedIndex(2);
			break;
		}
		mode.addActionListener(new SwitchLevelModeController(this, editor, mode));
		
		
		JLabel Type = new JLabel("Type:");
		Type.setBounds(728, 44, 46, 24);
		panel.add(Type);
		
		JLabel label_1 = new JLabel("Move:");
		label_1.setBounds(728, 74, 48, 24);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Time:");
		label_2.setBounds(728, 102, 46, 24);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Set:");
		label_3.setBounds(728, 132, 38, 24);
		panel.add(label_3);
		
		move = new JTextField();
		move.setBounds(783, 72, 89, 24);
		move.setEditable(false);
		if (editor.getLevelEditorType().equals(LevelEditorState.PUZZLE)){
			move.setEditable(true);
			move.addActionListener(new MoveInfoController(editor, move));
		}
		panel.add(move);
		
		timer = new JTextField();
		timer.setEditable(false);
		timer.setBounds(783, 102, 89, 24);
		if (editor.getLevelEditorType().equals(LevelEditorState.LIGHTNING)){
			timer.setEditable(true);
			timer.addActionListener(new TimerInfoController(editor, timer));
		}
		
		panel.add(timer);
		
		JRadioButton radioButton = new JRadioButton("1");
		radioButton.setBounds(761, 131, 46, 25);
		panel.add(radioButton);
		radioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radioButton.setHorizontalAlignment(SwingConstants.CENTER);
		
		JRadioButton radioButton_1 = new JRadioButton("2");
		radioButton_1.setBounds(805, 131, 46, 25);
		panel.add(radioButton_1);
		radioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton radioButton_2 = new JRadioButton("3");
		radioButton_2.setBounds(849, 132, 45, 25);
		panel.add(radioButton_2);
		radioButton_2.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton radioButton_4 = new JRadioButton("5");
		radioButton_4.setBounds(805, 165, 46, 25);
		panel.add(radioButton_4);
		radioButton_4.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton radioButton_5 = new JRadioButton("6");
		radioButton_5.setBounds(849, 165, 45, 25);
		panel.add(radioButton_5);
		radioButton_5.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		
		JButton btnRandomPiece = new JButton("Random Piece");
		btnRandomPiece.setBounds(97, 492, 137, 25);
		panel.add(btnRandomPiece);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				levelBuilder lb = new levelBuilder(new KabasujiBuilder());
				lb.setVisible(true);
				close();
			}
		});
		btnExit.setBounds(28, 6, 80, 25);
		panel.add(btnExit);
		
		JRadioButton radioButton_3 = new JRadioButton("4");
		radioButton_3.setBounds(761, 165, 46, 25);
		panel.add(radioButton_3);
		radioButton_3.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnHint = new JButton("Hint");
		btnHint.setBounds(6, 492, 75, 25);
		panel.add(btnHint);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 44, 427, 234);
		panel.add(scrollPane);
		
		jcontainer = new JPieceContainerView(editor);
		scrollPane.setViewportView(jcontainer);
		
		jpc = new JPieceCreatorView(editor, this);
		jpc.setBounds(6, 290, 329, 195);
		panel.add(jpc);
		
		jbc = new JBoardCreatorView(editor);
		jbc.setBounds(540, 202,407,311);
		panel.add(jbc);
		
		
	}
	
	public void update(){
		if (editor.getLevelEditorType().equals(LevelEditorState.PUZZLE)){
			move.setText(Integer.toString(((Puzzle) editor).getAllowedMove()));
		}
		if (editor.getLevelEditorType().equals(LevelEditorState.LIGHTNING)){
			timer.setText(Integer.toString(((Lightning) editor).getAllowedTime()));
		}
		jbc.update();
		jcontainer.update();
	}
}
