package builder.model;

import java.awt.Color;

/**
 * This class represent a numbered color in the release board
 * @author lthoang
 *
 */
public class ColoredNumber implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5759723735362156260L;
	int i;
	Color c;
	int position = -1;
	
	/**
	 * Get the position of the colored number
	 * @return the colored number
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * Set the position of the colored number
	 * @param position of the colored number
	 */
	public void setPosition(int position) {
		this.position = position;
	}


	public ColoredNumber (int i, Color c){
		this.i = i;
		this.c = c;
	}
	
	
	/**
	 * @return change the number to string
	 */
	public String toString(){
		if (c.equals(Color.YELLOW)){
			return "Yellow" + i;	
		} else if (c.equals(Color.PINK)){
			return "Pink"+ i;
		} else if (c.equals(Color.ORANGE)){
			return "Orange" + i;
		}
		return "";
	}

	/**
	 * get the number
	 * @return the number
	 */
	public int getI() {
		return i;
	}

	/**
	 * set the number
	 * @param i the number
	 */
	public void setI(int i) {
		this.i = i;
	}

	/**
	 * get the color
	 * @return the color
	 */
	public Color getC() {
		return c;
	}

	/**
	 * get the color
	 * @param c the color
	 */
	public void setC(Color c) {
		this.c = c;
	}
	
	
}
