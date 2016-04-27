package builder.view;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.awt.Toolkit;

import builder.controller.MoveInfoController;
import builder.controller.RedoController;
import builder.controller.SwitchLevelModeController;
import builder.controller.TimerInfoController;
import builder.controller.UndoController;
import builder.model.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

/**
 * this class represent the editor view
 * @author lthoang
 * @author jchen5
 *
 */
public class LevelEditorView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7627078161077363164L;
	private JPanel contentPane;
	KabasujiBuilder kb;
	int levelNum;
	LevelEditor editor;

	JBoardCreatorView jbc;
	JPieceCreatorView jpc;
	JPieceContainerView jcontainer;
	JReleaseColoredNum releaseColoredNum;
	JTextField timer;
	JTextField move;
	JTextField sets;
	JComboBox<String> mode;
	JLabel moveLabel;	
	JLabel timerLabel;
	JPanel panel;
	private JButton btnRedo;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 971, 594);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.controlText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBounds(12, 13, 953, 523);
		contentPane.add(panel);
		panel.setLayout(null);
		init();

	}


	public void setEditor(LevelEditor editor) {
		this.editor = editor;
	}

	/**
	 * remove all the element in the level editor view
	 */
	public void removeshit(){
		panel.removeAll();
	}

	/**
	 * initialize the view
	 */
	public void init() {

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
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRestart.setBounds(672, 6, 89, 25);
		panel.add(btnRestart);

		mode = new JComboBox<String>();
		mode.setBounds(783, 44, 143, 22);
		panel.add(mode);
		mode.setModel(new DefaultComboBoxModel<String>(new String[] {"Puzzle Level", "Lightning Level", "Release Level"}));
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

		jbc = new JBoardCreatorView(editor, this);
		jbc.setBounds(534, 206,407,311);
		panel.add(jbc);

		releaseColoredNum = new JReleaseColoredNum(editor, this);
		releaseColoredNum.setBorder(new LineBorder(new Color(0, 0, 0)));
		releaseColoredNum.setBounds(436, 43, 280, 150);
		if (!editor.getLevelEditorType().equals(LevelEditorState.RELEASE)){
			releaseColoredNum.setEnabled(false);
			for (Component component: releaseColoredNum.getComponents()){
				component.setEnabled(false);
			}
		}
		panel.add(releaseColoredNum);

		jbc.init();
		moveLabel = new JLabel("0");
		moveLabel.setBounds(886, 78, 61, 16);
		if (editor.getLevelEditorType().equals(LevelEditorState.PUZZLE)){
			moveLabel.setText(Integer.toString((((Puzzle) editor).getAllowedMove())));
		}
		panel.add(moveLabel);

		timerLabel = new JLabel("0");
		timerLabel.setBounds(886, 106, 61, 16);
		if (editor.getLevelEditorType().equals(LevelEditorState.LIGHTNING)) {
			timerLabel.setText(Integer.toString((((Lightning) editor).getAllowedTime())));
		}
		panel.add(timerLabel);

		JButton btnUndo = new JButton("Undo");
		btnUndo.setBounds(120, 4, 89, 29);
		btnUndo.addActionListener(new UndoController(this, editor));
		panel.add(btnUndo);

		btnRedo = new JButton("Redo");
		btnRedo.setBounds(218, 4, 89, 29);
		btnRedo.addActionListener(new RedoController(this, editor));
		panel.add(btnRedo);

		JButton btnNewButton = new JButton("Test");
		btnNewButton.setBounds(235, 488, 117, 29);
		btnNewButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				BufferedImage image = new BufferedImage(jbc.getWidth(), jbc.getHeight(), BufferedImage.TYPE_INT_RGB);
				Graphics2D g = image.createGraphics();
				jbc.printAll(g);
				g.dispose();
				try {
					ImageIO.write(image, "jpg", new File("temp/Paint.jpg"));

				} catch (IOException exp) {
					exp.printStackTrace();
				}
				JTestFrame j = new JTestFrame(editor);
				j.setVisible(true);

			}

		});
		panel.add(btnNewButton);




		JButton btnCreateLevel = new JButton("Create Level");
		btnCreateLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if (!editor.createLevelState()){
						JOptionPane.showMessageDialog(contentPane,
								"Level has not been created",
								"Level has not been created",
								JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(contentPane,
								"Level has been created",
								"Level has been created",
								JOptionPane.PLAIN_MESSAGE);
					}
					} catch (Exception eror){
						JOptionPane.showMessageDialog(contentPane,
								"Level has not been created",
								"Level has not been created",
								JOptionPane.WARNING_MESSAGE);
					}

			}
		});
		btnCreateLevel.setBounds(519, 6, 129, 25);
		panel.add(btnCreateLevel);




	}

	/**
	 * update the all the elements in the view
	 */
	public void update(){
		if (editor.getLevelEditorType().equals(LevelEditorState.PUZZLE)){
			move.setText(Integer.toString(((Puzzle) editor).getAllowedMove()));
			moveLabel.setText(Integer.toString((((Puzzle) editor).getAllowedMove())));
			mode.setSelectedItem(0);
		} else if (editor.getLevelEditorType().equals(LevelEditorState.LIGHTNING)){
			timer.setText(Integer.toString(((Lightning) editor).getAllowedTime()));
			timerLabel.setText(Integer.toString((((Lightning) editor).getAllowedTime())));
			mode.setSelectedItem(1);
		} else {
			releaseColoredNum.update();
			mode.setSelectedItem(2);
		}
		jbc.update();
		jcontainer.update();
		jpc.update();

	}

	public JReleaseColoredNum getReleaseColoredNum() {
		return releaseColoredNum;
	}

	public JBoardCreatorView getJbc() {
		return jbc;
	}

	public LevelEditor getEditor() {
		return editor;
	}
}
