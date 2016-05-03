package view;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LevelSelectController;
import model.Kabasuji;
import model.Level;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * representing a level selection screen 
 * @author kdai
 * @author jshen3
 * @author xwang111 
 *
 */
public class LevelSelection extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1672688232916609194L;
	private JPanel contentPane;
	public ArrayList<Level> testLevels;

	JButton[] Levels;
	JPanel panel;


	/**
	 * get the images of the icons
	 * @param levelNum
	 * @return
	 */
	public String getLevelImage(int levelNum){
		if (levelNum==0){
			return "images/puzzleIcon.png";

		}
		else if (levelNum==1){
			return "images/lightningIcon.png";

		}
		else{
			return "images/releaseIcon.png";

		}
	}

	/**
	 * close the frame
	 */
	public void close(){
		WindowEvent	winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	/**
	 * Create the frame.
	 */
	public LevelSelection(ArrayList<Level> testLevels) {
		this.testLevels =testLevels;
		setTitle("Kabasuji");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		panel = new JPanel();

		JLabel lblNewLabel_1 = new JLabel("Kabasuji Level Selection");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 36));

		JButton btnNewButton = new JButton("Help");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JOptionPane.showMessageDialog(contentPane, 
							readFile("temp/help", Charset.defaultCharset()), 
							"Help", 
							JOptionPane.INFORMATION_MESSAGE);
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(18)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 727, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(29, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(btnNewButton)
								.addPreferredGap(ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 488, GroupLayout.PREFERRED_SIZE)
								.addGap(107))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap(33, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
												.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
												.addGap(29)))
												.addComponent(panel, GroupLayout.PREFERRED_SIZE, 688, GroupLayout.PREFERRED_SIZE)
												.addGap(52))
				);

		panel.setLayout(null);


		//List<String> list = new ArrayList<String>();
		//list.add("hello");
		//	String s = list.get(0);


		//Level[] testLevels = createTestLevel();

		//----------------------  Jbutton parameter
		contentPane.setLayout(gl_contentPane);


		//---------------------- 


		addlevels();

		setVisible(true);

	}

	/**
	 * display the achivements and level mode and lock
	 */
	public void addlevels(){
		int levelButtonLenth=60;
		int levelButtonWidth=60;
		int levelNum = this.testLevels.size();
		int NumOneRow = 5;

		Levels = new JButton[levelNum];
		int nextRow=0;	
		int nextColumn=0;
		for (int i=0;i<levelNum;i++){

			Levels[i] = new JButton(String.valueOf(i+1));

			if (i%NumOneRow == 0){
				nextRow++;
				nextColumn=0;
			}
			Levels[i].setBounds(100+(40+levelButtonLenth)*nextColumn,(90+levelButtonWidth)*nextRow-50, levelButtonLenth, levelButtonWidth);	

			if(i>0 && testLevels.get(i-1).getAchievement().getAchievement()>0){
				testLevels.get(i).setLocked(false);
			}

			//testLevels.get(i).isLocked() &&
			if( i>0 && testLevels.get(i).isLocked()){
				Levels[i].setIcon(new ImageIcon("images//lockicon.png"));
				Levels[i].setEnabled(false);
			}else{
				JLabel stayLabel = null;
				if (testLevels.get(i).getAchievement().getAchievement()==1){
					stayLabel = new JLabel("star");
					stayLabel.setBackground(Color.WHITE);
					stayLabel.setBounds(100+(40+levelButtonLenth)*nextColumn, (90+levelButtonWidth)*nextRow+10, 20, 20);
					stayLabel.setIcon(new ImageIcon("images//onestar.png"));
					panel.add(stayLabel);
				}
				else if (testLevels.get(i).getAchievement().getAchievement()==2){
					stayLabel = new JLabel("star");
					stayLabel.setBackground(Color.WHITE);
					stayLabel.setBounds(100+(40+levelButtonLenth)*nextColumn, (90+levelButtonWidth)*nextRow+10, 40, 20);
					stayLabel.setIcon(new ImageIcon("images//twostar.png"));
					panel.add(stayLabel);
				}
				else  if (testLevels.get(i).getAchievement().getAchievement()==3){

					stayLabel = new JLabel("star");
					stayLabel.setBackground(Color.WHITE);
					stayLabel.setBounds(100+(40+levelButtonLenth)*nextColumn, (90+levelButtonWidth)*nextRow+10, 60, 20);
					stayLabel.setIcon(new ImageIcon("images//threestar.png"));
					panel.add(stayLabel);
				}
				else  if (testLevels.get(i).getAchievement().getAchievement()==0){
				}
				else{

				}
			}


			JLabel lblNewLabel = new JLabel("1");
			lblNewLabel.setBackground(Color.WHITE);
			lblNewLabel.setBounds(100+(40+levelButtonLenth)*nextColumn+15, (90+levelButtonWidth)*nextRow-80, 30, 30);
			lblNewLabel.setIcon(new ImageIcon( getLevelImage( testLevels.get(i).getlevelTypeNum()) ));
			panel.add(lblNewLabel);

			nextColumn++;



			final Level temp = testLevels.get(i);

			panel.add(Levels[i]);

			Levels[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					new LevelSelectController(LevelSelection.this,temp).actionPerformed();
				}
			});

		}
	}

	/**
	 * reload eveythings
	 */
	public void reloadLevel(){
		testLevels = Kabasuji.loadAll();
		panel.removeAll();

		addlevels();		
	}

	/**
	 * helper method to read text from file
	 * @param path path to file
	 * @param encoding text encoding
	 * @return string from the file
	 * @throws IOException
	 */
	private String readFile(String path, Charset encoding) 
			throws IOException 
	{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
}



