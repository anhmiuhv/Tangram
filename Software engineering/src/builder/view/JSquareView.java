package builder.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import builder.model.*;
import model.*;
public class JSquareView extends JPanel {
	Square square;
	Color cl;
	JPanel topJPanel;
	int size = 30;
	
	public JSquareView(Square square,Color cl){
		this.square = square;
		this.cl = cl;
		
		paintSquare();
	}
	
	public JSquareView(Square square,Color cl, int size){
		this.square = square;
		this.cl = cl;
		this.size = size;
		paintSquare();
	}


	public void setSize(int size){
		this.size = size;
	}
	
	public void setColor(Color cl){
		this.cl = cl;
		setBackground(cl);
	}
	
	//JLabel lblNewLabel = new JLabel("New label");
	//lblNewLabel.setBounds(184, 49, 46, 14);
	//panel.add(lblNewLabel);
	 public void paintSquare() {

		 setBackground(cl);
		// setText("New label");
		// setIcon(new ImageIcon("images\\puzzleIcon.png"));
		 setBounds(square.getColumn() * size, square.getRow() * size, size, size);
		 setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
	}
			

}
