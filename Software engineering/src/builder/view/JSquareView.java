package builder.view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import builder.model.*;
import model.*;
/**
 * representing individual square
 * @author lthoang
 *
 */
public class JSquareView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 511586902599635879L;
	Square square;
	/**
	 * whether this square is hint
	 */
	boolean isHint;
	JLabel numSquare = new JLabel();

	public Square getSquare() {
		return square;
	}

	Color cl;
	JPanel topJPanel;
	int size = 30;
	LevelEditor lvle;

	public JSquareView(Square square,Color cl){
		this.square = square;
		this.cl = cl;

		paintSquare();
	}

	public JSquareView(Square square,Color cl, int size){
		this.square = square;
		this.cl = cl;
		this.size = size;
		add(numSquare);
		paintSquare();
	}

	public Color getColor(){
		return cl;
	}

	/**
	 * set the size of the square 
	 * @param size length of the square
	 */
	public void setSize(int size){
		this.size = size;
	}

	public void setColor(Color cl){
		this.cl = cl;
		paintColor();
	}

	public LevelEditor getLvle() {
		return lvle;
	}

	public void setLvle(LevelEditor lvle) {
		this.lvle = lvle;
	}

	/**
	 * update the square 
	 */
	public void paintSquare() {
		paintColor();
		setBounds(square.getColumn() * size, square.getRow() * size, size, size);
		if (isHint){
			setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
		} else {
			setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		}
		numSquare.setBounds(0, 0, size, size);
		
	}


	/**
	 * paint color number
	 * @param num
	 * @param c
	 */
	public void paintColorNum(int num,Color c) {
		if (num != 0){
			numSquare.setText(Integer.toString(num));
			numSquare.setForeground(c);
			
		} else {
			numSquare.setText("");
		}

	}

	/**
	 * paint color of the square
	 */
	public void paintColor(){
		setBackground(cl);
	}

	/**
	 * set the square is hint or not
	 * @param b
	 */
	public void setHint(boolean b) {
		this.isHint = b;
		paintSquare();
	}

	/**
	 * if this square is a hint square
	 * @return true if it is, yeah I know it is stupid
	 */
	public boolean isHint() {
		return isHint;
	}

	
}
