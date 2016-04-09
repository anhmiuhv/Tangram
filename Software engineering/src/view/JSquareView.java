package view;

import java.awt.Color;
import java.awt.Graphics;
import model.Square;

public class JSquareView {
	Square square;
	Color cl;
	
	public JSquareView(Square square,Color cl){
		this.square = square;
		this.cl = cl;
		
	}
	
	public void paint(Graphics g){
		g.setColor(cl);
		g.fillRect(square.getColumn()*50, square.getRow()*50, 50, 50);
	}
	

}
