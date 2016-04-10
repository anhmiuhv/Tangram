package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Square;

public class JSquareView extends JPanel {
	Square square;
	Color cl;
	
	public JSquareView(Square square,Color cl){
		this.square = square;
		this.cl = cl;

	}

	class MyPanel extends JPanel {
		  public void paint(Graphics g) {
		    g.setColor(cl);
		    g.fillRect(square.getColumn()*20,square.getRow()*20,20,20);
		  }
		}	
	
}
