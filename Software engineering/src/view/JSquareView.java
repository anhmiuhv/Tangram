package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Square;

public class JSquareView extends JPanel {
	Square square;
	Color cl;
	JPanel topJPanel;
	
	public JSquareView(Square square,Color cl){
		this.square = square;
		this.cl = cl;
		paintSquare();
	}


	//JLabel lblNewLabel = new JLabel("New label");
	//lblNewLabel.setBounds(184, 49, 46, 14);
	//panel.add(lblNewLabel);
	 public void paintSquare() {
		 setBackground(cl);
		// setText("New label");
		// setIcon(new ImageIcon("images\\puzzleIcon.png"));
		 setBounds(square.getColumn()*30,square.getRow()*30,30,30);
		 setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
	}
			

}
