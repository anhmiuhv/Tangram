package builder.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;

import java.awt.FlowLayout;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;

import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import builder.controller.MoveInfoController;
import builder.controller.ReleaseColorController;
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
import javax.swing.border.LineBorder;

/**
 * this class represent the editor view
 * @author lthoang
 *
 */
public class LevelEditorView extends JFrame {

	private JPanel contentPane;
	KabasujiBuilder kb;
	int levelNum;
	JBoardCreatorView jbc;
	JPieceCreatorView jpc;
	JPieceContainerView jcontainer;
	JReleaseColoredNum releaseColoredNum;
	JTextField timer;
	JTextField move;
	JTextField sets;
	JComboBox mode;
	JLabel moveLabel;
	LevelEditor editor;
	JLabel timerLabel;
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
	
	
	public void setEditor(LevelEditor editor) {
		this.editor = editor;
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
		mode.setBounds(783, 44, 143, 22);
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
		
		JLabel lblDelete = new JLabel("Timer");
		lblDelete.setBounds(728, 102, 46, 24);
		panel.add(lblDelete);
		
		move = new JTextField();
		move.setBounds(783, 72, 89, 24);
		move.setEditable(false);
		if (editor.getLevelEditorType().equals(LevelEditorState.PUZZLE)){
			move.setEditable(true);
			move.setText(Integer.toString((((Puzzle) editor).getAllowedMove())));
			move.addActionListener(new MoveInfoController(editor, move,this));
		}
		panel.add(move);
		
		timer = new JTextField();
		timer.setEditable(false);
		timer.setBounds(783, 102, 89, 24);
		if (editor.getLevelEditorType().equals(LevelEditorState.LIGHTNING)){
			timer.setEditable(true);
			timer.setText(Integer.toString((((Lightning) editor).getAllowedTime())));
			timer.addActionListener(new TimerInfoController(editor, timer,this));
		}
		
		panel.add(timer);
		
		
		
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
		
		final JButton btnHint = new JButton("Hint");
		btnHint.setBounds(6, 492, 75, 25);
		btnHint.setOpaque(true);
		btnHint.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btnHint.setBackground(Color.WHITE);
		btnHint.setBorderPainted(false);
		btnHint.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jbc.isHintMode()){
					btnHint.setBackground(Color.WHITE);
					btnHint.setForeground(Color.BLACK);
				} else {
					btnHint.setBackground(new Color(189,100,57));
					btnHint.setForeground(Color.white);
				}
				jbc.setHintMode(!jbc.isHintMode());
			}
			
		});
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
		
		releaseColoredNum = new JReleaseColoredNum(editor, this);
		releaseColoredNum.setBorder(new LineBorder(new Color(0, 0, 0)));
		releaseColoredNum.setBounds(436, 43, 280, 150);
		if (!editor.getLevelEditorType().equals(LevelEditorState.RELEASE)){
			releaseColoredNum.setEnabled(false);
		}
		panel.add(releaseColoredNum);
		
		moveLabel = new JLabel("New label");
		moveLabel.setBounds(886, 78, 61, 16);
		if (editor.getLevelEditorType().equals(LevelEditorState.PUZZLE)){
			moveLabel.setText(Integer.toString((((Puzzle) editor).getAllowedMove())));
		}
		panel.add(moveLabel);
		
		JLabel timerLabel = new JLabel("0");
		timerLabel.setBounds(886, 106, 61, 16);
		if (editor.getLevelEditorType().equals(LevelEditorState.LIGHTNING)) {
			timerLabel.setText(Integer.toString((((Lightning) editor).getAllowedTime())));
		}
		panel.add(timerLabel);
		
		
		
	}
	
	public void update(){
		if (editor.getLevelEditorType().equals(LevelEditorState.PUZZLE)){
			move.setText(Integer.toString(((Puzzle) editor).getAllowedMove()));
			mode.setSelectedIndex(0);
			moveLabel.setText(Integer.toString((((Puzzle) editor).getAllowedMove())));
		} else if (editor.getLevelEditorType().equals(LevelEditorState.LIGHTNING)){
			timer.setText(Integer.toString(((Lightning) editor).getAllowedTime()));
			timerLabel.setText(Integer.toString((((Lightning) editor).getAllowedTime())));
			mode.setSelectedIndex(1);
		} else {
			mode.setSelectedIndex(2);
		}
		jbc.update();
		jcontainer.update();
		jpc.update();
		releaseColoredNum.update();
	}

	
}
