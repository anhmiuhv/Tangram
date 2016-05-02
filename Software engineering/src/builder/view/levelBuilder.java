package builder.view;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;

import java.awt.HeadlessException;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import builder.model.KabasujiBuilder;

/**
 * this class represent the editors chooser
 * @author lthoang
 * @author jchen5
 *
 */
public class levelBuilder extends JFrame {
	
//	JButton[] levels;

	/**
	 * 
	 */
	private static final long serialVersionUID = 4096808060275039176L;
	private JPanel contentPane;
	KabasujiBuilder kb; 
	LevelEditorView lvle;
	
	public void close(){
		WindowEvent	winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	
	/**
	 * Create the frame.
	 */
	public levelBuilder(KabasujiBuilder kb) {
		this.kb = kb;
		init();
	}
	
	private void init(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 931, 617);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textInactiveText);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		int levelButtonLenth=60;
		int levelButtonWidth=60;
		int levelNum = this.kb.getNumberOfLevel();
		int NumOneRow = 8;
		
		JButton[] Levels = new JButton[levelNum];
		int nextRow = 0;
		int nextColumn = 0;
		
		for( int i = 0;(i < levelNum);i++){
			Levels[i] = new JButton(String.valueOf(i+1));
			if(i%NumOneRow == 0){
				nextRow++;
				nextColumn = 0;
			}
			Levels[i].setBounds(50+(40+levelButtonLenth)*nextColumn, 40+(40+levelButtonWidth)*nextRow, levelButtonLenth, levelButtonWidth);	
			nextColumn++;
			
			contentPane.add(Levels[i]);
			final int levelNumber = i; 
			Levels[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LevelEditorView lev = new LevelEditorView(kb, levelNumber);
					lev.setVisible(true);
					close();
				}
				
			});
			
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 889, 544);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblKabasuji = new JLabel("KABASUJI");
		lblKabasuji.setBounds(353, 26, 250, 50);
		panel.add(lblKabasuji);
		lblKabasuji.setForeground(Color.BLACK);
		lblKabasuji.setFont(new Font("Broadway Copyist Text Ext", Font.PLAIN, 34));
		lblKabasuji.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton button_9 = new JButton("New Level");
		button_9.setBounds(741, 26, 110, 25);
		panel.add(button_9);
		
		
		
		JButton button_10 = new JButton("Help");
		button_10.setBounds(40, 26, 77, 25);
		panel.add(button_10);
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JOptionPane.showMessageDialog(contentPane, 
								readFile("temp/builderhelp", Charset.defaultCharset()), 
								"Help", 
								JOptionPane.INFORMATION_MESSAGE);
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		button_9.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				int levelNum = kb.addLevelState();
				lvle = new LevelEditorView(kb, levelNum);
				lvle.setVisible(true);
				close();
			}
		});
		
		
	}

	/**
	 * get the level editor view of the app
	 * @return level editor view
	 */
	public LevelEditorView getLvle() {
		return lvle;
	}

	/**
	 * helper method to read text from file
	 * @param path path to file
	 * @param encoding text encoding
	 * @return string from the file
	 * @throws IOException
	 */
	private static String readFile(String path, Charset encoding) 
			  throws IOException 
			{
			  byte[] encoded = Files.readAllBytes(Paths.get(path));
			  return new String(encoded, encoding);
			}

}
