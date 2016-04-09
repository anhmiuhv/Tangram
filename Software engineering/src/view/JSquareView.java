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
		
		g.setColor(Color.BLACK);
		g.drawRect(20,30, 50, 50);
		g.fillRect(10,10, 50, 50);
		System.out.println("fuck");
	}
	

}
