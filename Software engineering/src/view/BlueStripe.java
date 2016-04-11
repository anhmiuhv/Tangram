package view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BlueStripe extends JPanel {

	//JPanel bs = new JPanel();
	JLabel lvNum = new JLabel();
	JLabel moves = new JLabel();
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
		
	}
	
	
}
