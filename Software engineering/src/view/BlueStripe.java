package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BlueStripe extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6319804935562495047L;

	//JPanel bs = new JPanel();
	JLabel lvNum = new JLabel();

	int type = 1;
	int lvnum = 1;
	public BlueStripe(int type, int lvnum) {
			this.type = type;
			this.lvnum = lvnum;
			
			createBsView();
	}
	public void createBsView(){
		this.setBounds(0, 0, 850, 120);
		this.setBackground(new Color(65,176,250));
		this.setLayout(null);
		lvNum.setText("Level " + lvnum);
		lvNum.setFont(new Font("SansSerif", Font.PLAIN, 50));
		lvNum.setForeground(Color.WHITE);
		lvNum.setBounds(345,35, 230, 50);
		this.add(lvNum);
		
	}
	
}
