package builder.view;


import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import builder.controller.PuzzleController;
import builder.model.LevelEditor;

import javax.swing.ActionMap;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

public class JTestFrame extends JFrame {
	private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
	JPieceContainerView jpc;
	LevelEditor editor;
	JPuzzleView puzzleView;
	public JTestFrame(LevelEditor editor){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.jpc = new JPieceContainerView(editor);
		
		jpc.initializeTest(this);
		this.editor = editor;
		setSize(900, 500);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 6, 429, 423);
		getContentPane().add(scrollPane);
		
		
		scrollPane.setViewportView(jpc);
		
		this.puzzleView = new JPuzzleView(editor.getPieceContainer(), this);
		PuzzleController pController = new PuzzleController(editor.getPieceContainer(), this);
		puzzleView.addMouseMotionListener(pController);
		puzzleView.addMouseListener(pController);
		puzzleView.setBounds(475, 6, 381, 423);
		String key = "Rotate";
		puzzleView.getInputMap(IFW).put(KeyStroke.getKeyStroke(' '), key);
		ActionMap am = puzzleView.getActionMap();
		am.put(key, pController);
		puzzleView.setActionMap(am);
		setFocusable(true);
		puzzleView.setFocusable(true);
		add(puzzleView);
		
		
	}
	public JPuzzleView getPuzzleView() {
		return puzzleView;
	}
	public JPieceContainerView getJpc() {
		return jpc;
	}
	
}
