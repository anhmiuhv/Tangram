package view;

import java.awt.Color;
import java.awt.Font;


import javax.swing.JLabel;

import model.Level;

public class PuzzleLevelView extends LevelView {
	
	JLabel moves = new JLabel();
	
	public PuzzleLevelView(Level level){
		this.level = level;
		
		createPLView();
	}
	
	public void createPLView(){
		bs.add(moves);
		moves.setText("Moves:0/0");
		moves.setFont(new Font("SansSerif", Font.PLAIN, 30));
		moves.setForeground(Color.WHITE);
		moves.setBounds(140,35, 210, 50);
		this.add(moves);
		
	}

}
